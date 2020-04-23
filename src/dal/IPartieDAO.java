package dal;

import bo.Partie;

import java.sql.SQLException;

public interface IPartieDAO extends IDAO<String, Partie> {

	//Utilisateur authenticate(String login, String password ) throws SQLException;

    Partie[] meilleurScoreParDifficulte(String Difficulte) throws SQLException;
}
