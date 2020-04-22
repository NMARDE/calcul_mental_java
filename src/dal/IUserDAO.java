package dal;

import bo.Utilisateur;

import java.sql.SQLException;

public interface IUserDAO extends IDAO<String, Utilisateur> {

	Utilisateur authenticate(String login, String password ) throws SQLException;
}
