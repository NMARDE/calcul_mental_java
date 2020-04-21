package bo;

import java.io.Serializable;

public class User implements Serializable {
	
	private String id;
	private String login;
	private String password;
	private int nbConnections;
	
	public User() {}
	
	public User( String login, String password ) {
		this.login = login;
		this.password = password;
	}
	
	public User( String id, String login, String password, int nbConnections ) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.nbConnections = nbConnections;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId( String id ) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin( String login ) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}
	
	public int getNbConnections() {
		return nbConnections;
	}
	
	public void setNbConnections( int nbConnections ) {
		this.nbConnections = nbConnections;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "User{" );
		sb.append( "id='" ).append( id ).append( '\'' );
		sb.append( ", login='" ).append( login ).append( '\'' );
		sb.append( ", password='" ).append( password ).append( '\'' );
		sb.append( ", nbConnections=" ).append( nbConnections );
		sb.append( '}' );
		return sb.toString();
	}
}
