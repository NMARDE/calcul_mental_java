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
		Facile ("Facile"),
		Normal ("Normal"),
		Difficile ("Difficile"),
		;

		private String difficulte;

		Difficulte(String difficulte) {
			this.difficulte = difficulte;
		}

		public String getNomDifficulte() {
			return difficulte;
		}
	}

	public Partie(String id, Difficulte niveau, bo.Utilisateur unUtilisateur) {
		this.id = id;
		this.niveau = niveau;
		this.unUtilisateur = unUtilisateur;
	}

	public Partie() {

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
