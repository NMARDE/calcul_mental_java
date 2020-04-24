package bo;

import java.io.Serializable;
import java.sql.Time;

public class Partie implements Serializable {
	
	private int id;
	private int score;
	private Time temps;



	private Utilisateur unUtilisateur;
	private Difficulte niveau;

	public enum Difficulte {
		LEVEL1("Facile"),
		LEVEL2("Normal"),
		LEVEL3("Difficile");

		private String difficulte;

		Difficulte(String difficulte) {
			this.difficulte = difficulte;
		}

		public String getNomDifficulte() {
			return difficulte;
		}
	}

	public Partie(int id, int score, Time temps, Utilisateur unUtilisateur, Difficulte niveau) {
		this.id = id;
		this.score = score;
		this.temps = temps;
		this.unUtilisateur = unUtilisateur;
		this.niveau = niveau;
	}

	public Partie(int id, Difficulte niveau, bo.Utilisateur unUtilisateur) {
		this.id = id;
		this.niveau = niveau;
		this.unUtilisateur = unUtilisateur;
	}

	public Partie() {

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Difficulte getDifficulte() {
		return niveau;
	}

	public void setDifficulte(Difficulte niveau) {
		this.niveau = niveau;
	}

	public bo.Utilisateur getUtilisateur() {
		return unUtilisateur;
	}

	public void setUtilisateur(bo.Utilisateur unUser) {
		this.unUtilisateur = unUser;
	}

	public static Difficulte rechercherDifficulte (String element) {
		Difficulte[] listDifficulte = Difficulte.values();
		Difficulte difficulte = null;

		for (Difficulte uneDifficulte : listDifficulte) {
			if (uneDifficulte.equals(element)) {
				difficulte = uneDifficulte;
				break;
			}
		}

		return difficulte;
	}

}
