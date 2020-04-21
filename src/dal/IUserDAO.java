package dal;

import bo.User;

import java.sql.SQLException;

public interface IUserDAO extends IDAO<String, User> {
	
	User authenticate( String login, String password ) throws SQLException;
}
