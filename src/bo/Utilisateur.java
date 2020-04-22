package bo;

import java.io.Serializable;

public class Utilisateur implements Serializable {
	
	private String id;
	private String login;
	private String password;
	private String nom;

	public Utilisateur() {

	}

	public Utilisateur( String login, String password, String nom) {
		this.login = login;
		this.password = password;
		this.nom = nom;
	}
	
	public Utilisateur( String id, String login, String password, String nom ) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.nom = nom;
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
	
	public String getNom() {
		return nom;
	}
	
	public void setNom( String nom ) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder( "User{" );
		sb.append( "id='" ).append( id ).append( '\'' );
		sb.append( ", login='" ).append( login ).append( '\'' );
		sb.append( ", password='" ).append( password ).append( '\'' );
		sb.append( ", nom=" ).append( nom );
		sb.append( '}' );
		return sb.toString();
	}
}
