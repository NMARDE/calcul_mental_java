package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Partie;
import bo.Expression;
import bo.Utilisateur;
import dal.DAOFactory;
import exception.EndGameException;
import exception.OperateurException;
import exception.UserNotFound;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PartieBean implements Serializable {


    private String FORM_DIFFICULTE = "select-difficulte";
    private String FORM_IDUSER ="idUser";

    private List<Partie> bestScores;
    private ArrayList<Expression> lesExpressions = new ArrayList<>();
    private static final String RESPONSE_USER = "form-response";

     private Partie currentGame;
     private EndGameException exception;

    public PartieBean() {}


    public void loadBestScores() throws UserNotFound, SQLException {

        bestScores = DAOFactory.getPartieDAO().meilleurScore();
        if (bestScores == null)
        {
            throw new UserNotFound( "Pas d'utilisateur");
        }
    }

    public void createPartie( HttpServletRequest request ) {

        HttpSession session = request.getSession(true);
        Utilisateur user = (Utilisateur) session.getAttribute(LoginBean.CURRENT_USER_SESSION_KEY);
        Partie.Difficulte difficulte = Partie.Difficulte.valueOf(request.getParameter(FORM_DIFFICULTE));

        currentGame = new Partie(difficulte, user, lesExpressions);

        for (int i = 0; i < 10; i++)
        {
            Expression uneExpression = new Expression(currentGame);
            try {
                uneExpression.genererExpression();

            } catch (OperateurException e) {
                e.printStackTrace();
            }
            lesExpressions.add(uneExpression);
        }

        session.setAttribute("currentGame", currentGame);
        session.setAttribute("currentExIn", 0);

    }

    public boolean stockerResponseExpression(HttpServletRequest request) throws EndGameException {
        HttpSession session = request.getSession(true);
        session.getAttribute("currentGame");
        String message = "";


        int index = (int) session.getAttribute("currentExIn");

        Expression uneExpression = currentGame.getListExpressions().get(index);
        uneExpression.setReponseUser((Double.parseDouble(RESPONSE_USER)));
        if (index >= 9) {
            DAOFactory.getPartieDAO().create(currentGame);
            exception = new EndGameException("Fin de partie.");
            throw exception;
        } else {
            session.setAttribute("currentExIn", index + 1);
            return true;
        }
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

    public List<Expression> getLesExpressions() {
        return lesExpressions;
    }

    public void setLesExpressions(ArrayList<Expression> lesExpressions) {
        this.lesExpressions = lesExpressions;
    }

    public Partie getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Partie currentGame) {
        this.currentGame = currentGame;
    }



}
