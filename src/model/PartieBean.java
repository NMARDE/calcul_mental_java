package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import bo.Partie;
import bo.Expression;
import dal.DAOFactory;
import dal.jdbc.PartieDAO;
import exception.UserNotFound;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PartieBean implements Serializable {


    private String FORM_DIFFICULTE = "select-difficulte";
    private String FORM_IDUSER ="idUser";

    private List<Partie> bestScores;
    private List<Expression> lesExpressions;

     private Partie currentGame;

    public PartieBean() {}



    public void loadBestScores() throws UserNotFound, SQLException {
        bestScores = DAOFactory.getPartieDAO().meilleurScore();
        if (bestScores == null)
        {
            throw new UserNotFound( "Pas d'utilisateur");
        }
    }

    public void createPartie( HttpServletRequest request ) {

        String id = request.getParameter(FORM_IDUSER);
        String difficulte = request.getParameter(FORM_DIFFICULTE);


        DAOFactory.getPartieDAO().create(Integer.valueOf(id), difficulte);
        lesExpressions = DAOFactory.getExpressionDAO().



    }


    public String getFORM_DIFFICULTE() {
        return FORM_DIFFICULTE;
    }

    public void setFORM_DIFFICULTE(String FORM_DIFFICULTE) {
        this.FORM_DIFFICULTE = FORM_DIFFICULTE;
    }

    public String getFORM_IDUSER() {
        return FORM_IDUSER;
    }

    public void setFORM_IDUSER(String FORM_IDUSER) {
        this.FORM_IDUSER = FORM_IDUSER;
    }

    public List<Partie> getBestScores() {
        return bestScores;
    }

    public void setBestScores(List<Partie> bestScores) {
        this.bestScores = bestScores;
    }


}
