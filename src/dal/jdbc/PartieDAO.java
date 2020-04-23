package dal.jdbc;

import bo.Partie;
import bo.Utilisateur;
import dal.DAOFactory;
import dal.IDAO;
import dal.IPartieDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class PartieDAO implements IPartieDAO {

	private static final String CREATE_QUERY = "INSERT INTO `Partie`(`score`, `temps`, `difficulte`, `idUser`) VALUES (?,?,?,?)";
	private static final String FIND_ID_QUERY = "SELECT * FROM user WHERE id = ?";
	private static final String UPDATE_QUERY = "UPDATE user SET password = ? WHERE id = ?";
	private static final String BETTER_BY_DIFFICULTY_QUERY = "SELECT idPartie, score, temps, difficulte, p.idUser, login, password, nomUser FROM `Partie` p, `User` u WHERE `difficulte`= ? AND p.`idUser` = u.`idUser`  ORDER BY `score` DESC, `temps` DESC LIMIT 10";

	@Override
	public void create( Partie partie ) {

		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( CREATE_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setInt( 1, partie.getScore() );
			ps.setTime( 2, partie.getTemps() );
			ps.setString( 3, partie.getDifficulte().getNomDifficulte() );
			ps.setInt( 3, partie.getUtilisateur().getId() );
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
	public void deleteById(String s) {

	}

	@Override
	public void delete(Partie object) {

	}

	@Override
	public Partie findById(String s) {
		return null;
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


	@Override
	public Partie[] meilleurScoreParDifficulte(String difficulte) throws SQLException {
		Partie[] meilleurPartie = {null,null,null,null,null,null,null,null,null,null};
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( UPDATE_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setString( 1, difficulte );
			try( ResultSet rs = ps.executeQuery() ) {
				int i = 0;
				while ( rs.next()) {
					rs.updateRow();

					Utilisateur user = new Utilisateur();
					user.setId(rs.getInt("idUser"));
					user.setLogin(rs.getString("login"));
					user.setPassword(rs.getString("password"));
					user.setNom(rs.getString("nomUser"));

					Partie partie = new Partie();
					partie.setId(rs.getString( "idPartie" ));
					partie.setScore( rs.getInt( "login" ) );
					partie.setTemps( rs.getTime( "password" ) );
					partie.setDifficulte(Partie.rechercherDifficulte( rs.getString( "nomUser" )) );
					partie.setUtilisateur(user);
					meilleurPartie[i] = partie;
					i++;
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return meilleurPartie;
	}
}
