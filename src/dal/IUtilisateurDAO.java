package dal;

import bo.Utilisateur;

import java.sql.SQLException;

public interface IUtilisateurDAO extends IDAO<Integer, Utilisateur> {

	Utilisateur authenticate(String login, String password ) throws SQLException;
}
