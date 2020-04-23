package dal;

import bo.Partie;

import java.sql.SQLException;

public interface IPartieDAO extends IDAO<Integer, Partie> {

    Partie[] meilleurScoreParDifficulte(String difficulte) throws SQLException;

    int instancierScore(Integer idPartie) throws SQLException;

    public void create( int idUser, String difficulte);
}
