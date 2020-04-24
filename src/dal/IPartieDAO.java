package dal;

import bo.Partie;

import java.sql.SQLException;
import java.util.List;

public interface IPartieDAO extends IDAO<Integer, Partie> {

    List<Partie> meilleurScore() throws SQLException;

    int instancierScore(Integer idPartie) throws SQLException;

    public Partie create( int idUser, String difficulte);
}
