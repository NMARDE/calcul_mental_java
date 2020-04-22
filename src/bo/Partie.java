package bo;

import java.io.Serializable;
import java.sql.Time;

public class Partie implements Serializable {
	
	private String id;
	private int score;
	private Time temps;
	private Utilisateur unUtilisateur;
	private Difficulte niveau;

	public enum Difficulte {
		Facile,
		Normal,
		Difficile,
		;
	}

	public Partie(String id, Difficulte niveau, bo.Utilisateur unUtilisateur) {
		this.id = id;
		this.niveau = niveau;
		this.unUtilisateur = unUtilisateur;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Time getTemps() {
		return temps;
	}

	public void setTemps(Time temps) {
		this.temps = temps;
	}

	public Difficulte getNiveau() {
		return niveau;
	}

	public void setNiveau(Difficulte niveau) {
		this.niveau = niveau;
	}

	public bo.Utilisateur getUtilisateur() {
		return unUtilisateur;
	}

	public void setUtilisateur(bo.Utilisateur unUser) {
		this.unUtilisateur = unUser;
	}

}
