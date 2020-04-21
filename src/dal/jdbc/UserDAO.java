package dal.jdbc;

import bo.User;
import dal.DAOFactory;
import dal.IUserDAO;

import java.sql.*;
import java.util.Collection;

public class UserDAO implements IUserDAO {
	
	private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
	
	@Override
	public User authenticate( String login, String password ) throws SQLException {
		User user = null;
		try ( Connection connection = DAOFactory.getJDBCConnection();
			  PreparedStatement ps = connection.prepareStatement( AUTHENT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE ) ) {
			ps.setString( 1, login );
			ps.setString( 2, password );
			try( ResultSet rs = ps.executeQuery() ) {
				if ( rs.next()) {
					rs.updateRow();
					user = new User();
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
	public void create( User object ) {
		//TODO à faire l'éval
	}
	
	@Override
	public void update( User object ) {
		//TODO à faire l'éval
	}
	
	@Override
	public void deleteById( String s ) {
		//TODO à faire l'éval
	}
	
	@Override
	public void delete( User object ) {
		//TODO à faire l'éval
	}
	
	@Override
	public User findById( String s ) {
		//TODO à faire l'éval
		return null;
	}
	
	@Override
	public Collection<User> findAll() {
		return null;
	}
}
