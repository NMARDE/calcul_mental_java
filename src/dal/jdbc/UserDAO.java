package dal.jdbc;

import bo.Utilisateur;
import dal.DAOFactory;
import dal.IUserDAO;

import java.sql.*;
import java.util.Collection;

public class UserDAO implements IUserDAO {
	
	private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
	private static final String CREATE_QUERY = "INSERT INTO `User`(`login`, `password`, `nomUser`) VALUES (?,?,?)";
	private static final String FIND_ID_QUERY = "SELECT * FROM user WHERE id = ?";
	
	@Override
	public Utilisateur authenticate(String login, String password ) throws SQLException {
		Utilisateur user = null;
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( AUTHENT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setString( 1, login );
			ps.setString( 2, password );
			try( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next()) {
					rs.updateRow();
					user = new Utilisateur();
					user.setId(rs.getString( "id" ));
					user.setLogin( rs.getString( "login" ) );
					user.setPassword( rs.getString( "password" ) );
					user.setNom( rs.getString( "nom" ) );
				}
			}
		}
		return user;
	}
	
	@Override
	public void create( Utilisateur user ) {

		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( CREATE_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setString( 1, user.getLogin() );
			ps.setString( 2, user.getPassword() );
			ps.setString( 3, user.getNom() );
			try( ResultSet rs = ps.executeQuery() ) {
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}


	@Override
	public void update(Utilisateur object) {

	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public void delete(Utilisateur object) {

	}

	@Override
	public Utilisateur findById( String idUser ) {
		Utilisateur user = null;
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( FIND_ID_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setString( 1, idUser );
			try( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next()) {
					rs.updateRow();
					user = new Utilisateur();
					user.setId(rs.getString( "id" ));
					user.setLogin( rs.getString( "login" ) );
					user.setPassword( rs.getString( "password" ) );
					user.setNom( rs.getString( "nom" ) );
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return user;
	}
	
	@Override
	public Collection<Utilisateur> findAll() {
		return null;
	}
}
