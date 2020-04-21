package controller;

import model.LoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet( name = "loginController", urlPatterns = {"/login"}, loadOnStartup = 1 )
public class LoginController extends HttpServlet {
	
	public static final String LOGIN_URL_PATTERN = "/login";
	private static final String LOGIN_JSP = "/WEB-INF/views/login.jsp";
	private static final String HOME_URL_PATTERN = "/contacts";
	private static final Logger LOGGER = Logger.getLogger( LoginController.class.getName() );
	
	private int doCount;
	
	@Override
	public void init() throws ServletException {
		doCount = 0;
		ServletContext servletContext = this.getServletContext();
		String dbUrl = servletContext.getInitParameter( "DB_URL" );
		LOGGER.log( Level.INFO, "Initialisation de notre servlet LoginController" );
		LOGGER.log( Level.INFO, "db url est : {0}", dbUrl );
	}
	
	@Override
	public void destroy() {
		LOGGER.log( Level.INFO, "Destruction de notre servlet LoginController" );
	}
	
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		LOGGER.log( Level.INFO, "Dans le doGet {0}", ++doCount );
		LoginBean model = new LoginBean();
		if ( model.isAuthenticated( request ) ) {
			response.sendRedirect( request.getContextPath() + HOME_URL_PATTERN );
		} else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher( LOGIN_JSP );
			dispatcher.forward( request, response );
		}
	}
	
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		LoginBean model = new LoginBean();
		request.setAttribute( "loginBean", model );
		if ( model.authenticate( request ) ) {
			response.sendRedirect( request.getContextPath() + HOME_URL_PATTERN );
		} else {
			doGet( request, response );
		}
	}
}
