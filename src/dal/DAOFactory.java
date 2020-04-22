package dal;

import dal.jdbc.UserDAO;
import util.StringUtil;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	
	private static String mode;
	
	private static String jdbcDriverClass;
	private static String jdbcURL;
	private static String jdbcLogin;
	private static String jdbcPassword;
	
	private DAOFactory() {}
	
	public static IUserDAO getUserDAO() {
		
		IUserDAO dao = null;
		switch ( mode ) {
			case "JDBC" :
				dao = new UserDAO();
				break;
			case "JPA" :
				// dao = new JPAUserDAO();
				break;
		}
		return dao;
	}
	
	/*
	public static IContactDAO getContactDAO() {
		
		return null;
	}
	*/
	/*
	public static IRequestDAO getRequestDAO() {
		
		return null;
	}
	*/

	public static void init( ServletContext servletContext ) throws ClassNotFoundException {
		
		mode = servletContext.getInitParameter( "DAO_MODE" );
		jdbcDriverClass = servletContext.getInitParameter( "JDBC_DRIVER_CLASS" );
		jdbcURL = servletContext.getInitParameter( "JDBC_DB_URL" );
		jdbcLogin = servletContext.getInitParameter( "JDBC_DB_LOGIN" );
		jdbcPassword = servletContext.getInitParameter( "JDBC_DB_PWD" );
		if ( "JDBC".equals( mode ) && !StringUtil.isEmpty( jdbcDriverClass ) ) {
			Class.forName( jdbcDriverClass );
		}
	}
	
	public static Connection getJDBCConnection() throws SQLException {
		return DriverManager.getConnection( jdbcURL, jdbcLogin, jdbcPassword );
	}
}
