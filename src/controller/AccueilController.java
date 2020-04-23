package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "AccueilController", urlPatterns = {"/accueil"} )
public class AccueilController extends HttpServlet {

    private static final String ACCUEIL_JSP = "/WEB-INF/views/accueil.jsp";
    private static final String HOME_URL_PATTERN = "/accueil";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher( ACCUEIL_JSP );
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
