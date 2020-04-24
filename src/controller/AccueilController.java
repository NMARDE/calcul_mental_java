package controller;

import exception.UserNotFound;
import model.PartieBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( name = "AccueilController", urlPatterns = {"/accueil"} )
public class AccueilController extends HttpServlet {

    private static final String ACCUEIL_JSP = "/WEB-INF/views/accueil.jsp";
    private static final String HOME_URL_PATTERN = "/accueil";
    private static final String PARTIE_URL_PATTERN = "/partie";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PartieBean model = new PartieBean();
        try {
            model.loadBestScores();
        } catch (UserNotFound userNotFound) {
            userNotFound.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        request.setAttribute("partieBean", model);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher( ACCUEIL_JSP );
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PartieBean partieBean = new PartieBean();

        partieBean.createPartie(request);

        response.sendRedirect(request.getContextPath() + PARTIE_URL_PATTERN);

    }
}
