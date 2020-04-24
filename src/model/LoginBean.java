package model;

import bo.Utilisateur;
import dal.DAOFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

public class LoginBean implements Serializable {
	
	private static final String LOGIN_SUCCESS = "ssylla";
	private static final String PWD_SUCCESS = "test123";
	
	private static final String FORM_FIELD_LOGIN = "form-username";
	private static final String FORM_FIELD_PWD = "form-password";
	public static final String CURRENT_USER_SESSION_KEY = "currentUser";
	
	private String login;
	private String password;
	
	private String message;
	
	public LoginBean() {}
	
	public boolean authenticate( HttpServletRequest request ) {
		login = request.getParameter( FORM_FIELD_LOGIN );
		password = request.getParameter( FORM_FIELD_PWD );
		
		boolean result = false;
		
		try {
			Utilisateur user = DAOFactory.getUserDAO().authenticate( login, password );
			if ( null == user ) {
				message = "Nom de compte ou mot de passe incorrect.";
			} else {
				HttpSession session = request.getSession( true );
				session.setAttribute( CURRENT_USER_SESSION_KEY, user );
				message = "Bienvenue à toi " + LOGIN_SUCCESS;
				result = true;
			}
		} catch ( SQLException e ) {
			message = "Attention, une erreur est survenue lors de l'accès à la base!!! ";
		}
		return result;
	}
	
	public boolean isAuthenticated( HttpServletRequest request ) {
		HttpSession session = request.getSession( true );
		return null != session.getAttribute( CURRENT_USER_SESSION_KEY );
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin( String login ) {
		this.login = login;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage( String message ) {
		this.message = message;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}
}
