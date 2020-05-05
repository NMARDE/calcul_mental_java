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

@WebServlet (name="FinPartieController", urlPatterns = {"/fin_partie"})
public class FinPartieController extends HttpServlet {

    private static final String FIN_JSP = "/WEB-INF/views/fin_partie.jsp";

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
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher( FIN_JSP );
        dispatcher.forward( request, response );
    }
}
