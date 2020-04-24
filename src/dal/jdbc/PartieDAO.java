package dal.jdbc;

import bo.Partie;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.IPartieDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PartieDAO implements IPartieDAO {

	private static final String CREATE_QUERY = "INSERT INTO `Partie`(`score`, `temps`, `difficulte`, `idUser`) VALUES (?,?,?,?)";
	private static final String CREATE_IDUSER_DIF_QUERY = "INSERT INTO `Partie`(`difficulte`, `idUser`) VALUES (?,?)";
	private static final String FIND_ID_QUERY = "SELECT idPartie, score, temps, difficulte, p.idUser, login, password, nomUser FROM `Partie` p, `User` u WHERE `idPartie`= ? AND p.`idUser` = u.`idUser`";
	private static final String UPDATE_QUERY = "UPDATE user SET password = ? WHERE id = ?";
	private static final String SCORE_QUERY = "SELECT COUNT(*) AS Score FROM Expression WHERE idPartie = ? AND resultatAttendu = reponseUser";
	private static final String BETTER_BY_DIFFICULTY_QUERY = "SELECT * FROM `Partie` p, `User` u WHERE p.`idUser` = u.`idUser` ORDER BY difficulte DESC, `score` DESC, `temps` ASC LIMIT 10";


	@Override
	public void create( Partie partie ) {

		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( CREATE_QUERY, Statement.RETURN_GENERATED_KEYS, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setInt( 1, instancierScore(partie.getId()) );
			ps.setTime( 2, partie.getTemps() );
			ps.setString( 3, partie.getNiveau().toString() );
			ps.setInt( 3, partie.getUser().getId() );
			try( ResultSet rs = ps.executeQuery() ) {
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void create( int idUser, String difficulte){
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( CREATE_IDUSER_DIF_QUERY, Statement.RETURN_GENERATED_KEYS, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setInt( 1, idUser );
			ps.setString( 2, difficulte );
			try( ResultSet rs = ps.executeQuery() ) {
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public void update(Partie object) {

	}

	@Override
	public void deleteById(Integer integer) {

	}

	@Override
	public void delete(Partie object) {

	}


	public Partie findById( Integer idPartie ) {
		Partie partie = null;
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( FIND_ID_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setInt( 1, idPartie );
			try( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next()) {
					rs.updateRow();
					partie = instancierPartie(rs);
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return partie;
	}

	@Override
	public Collection<Partie> findAll() {
		return null;
	}


	public Utilisateur update(String idUser)
	{
		Utilisateur user = null;
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( BETTER_BY_DIFFICULTY_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setString( 1, idUser );
			try( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next()) {
					rs.updateRow();
					user = new Utilisateur();
					user.setId(rs.getInt( "idUser" ));
					user.setLogin( rs.getString( "login" ) );
					user.setPassword( rs.getString( "password" ) );
					user.setNom( rs.getString( "nomUser" ) );
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return user;
	}


	public List<Partie> meilleurScore() throws SQLException {
		List<Partie> meilleurPartie = new ArrayList<>();
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( BETTER_BY_DIFFICULTY_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			try( ResultSet rs = ps.executeQuery() ) {

				while ( rs.next()) {

					int idPartie = rs.getInt("idPartie");
					Utilisateur unUtilisateur  = new Utilisateur(rs.getInt("idUser"), rs.getString("login"), rs.getString("password"), rs.getString("nomUser") );
					int score = rs.getInt("score");
					Time temps = rs.getTime("temps");
					Partie.Difficulte uneDiffculte = Partie.Difficulte.valueOf(rs.getString("difficulte"));
					Partie unePartie = new Partie(idPartie, score, temps,  unUtilisateur, uneDiffculte);
					meilleurPartie.add(unePartie);
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return meilleurPartie;
	}

	@Override
	public int instancierScore(Integer idPartie) throws SQLException {

		int score = -1;
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( SCORE_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setInt( 1, idPartie );
			try( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next()) {
					rs.updateRow();
					score = rs.getInt("Score");
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return score;
	}

	private Partie instancierPartie(ResultSet rs) throws SQLException {

		Utilisateur user = new Utilisateur();
		user.setId(rs.getInt("idUser"));
		user.setLogin(rs.getString("login"));
		user.setPassword(rs.getString("password"));
		user.setNom(rs.getString("nomUser"));

		Partie partie = new Partie();
		partie.setId(rs.getInt( "idPartie" ));
		partie.setScore( rs.getInt( "score" ) );
		partie.setTemps( rs.getTime( "temps" ) );
		partie.setNiveau(Partie.rechercherDifficulte( rs.getString( "difficulte" )) );
		partie.setUser(user);

		return partie;
	}
}
