package controller;

import bo.Partie;
import model.PartieBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "PartieController", urlPatterns = {"/partie" /*"partie/fin_partie"*/})
public class PartieController extends HttpServlet {

    private static final String PARTIE_JSP = "/WEB-INF/views/partie.jsp";
    private static final String ACCUEIL_JSP = "/WEB-INF/views/accueil.jsp";
    private static final String HOME_URL_PATTERN = "/partie";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher( PARTIE_JSP );
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        Partie partieCourante = (Partie) session.getAttribute("currentGame");
        if(partieCourante == null)
        {
            response.sendRedirect(request.getContextPath() + ACCUEIL_JSP);
        } else {


            doGet(request, response);
        }

    }
}
