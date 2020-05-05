package bo;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;

public class Partie implements Serializable {
	
	private int id;
	private int score;
	private Time temps;
	private ArrayList<Expression> listExpressions;



	private Utilisateur user;
	private Difficulte niveau;

	public enum Difficulte {
		LEVEL1("Level1"),
		LEVEL2("Level2"),
		LEVEL3("Level3");

		private String difficulte;

		Difficulte(String difficulte) {
			this.difficulte = difficulte;
		}

		public String getNomDifficulte() {
			return difficulte;
		}
	}

	public Partie(int id, int score, Time temps, Utilisateur user, Difficulte niveau) {
		this.id = id;
		this.score = score;
		this.temps = temps;
		this.user = user;
		this.niveau = niveau;
	}

	public Partie(int id, Difficulte niveau, Utilisateur user) {
		this.id = id;
		this.niveau = niveau;
		this.user = user;
	}

	public Partie(Difficulte niveau, Utilisateur Utilisateur, ArrayList<Expression> listExpressions) {
		this.niveau = niveau;
		this.user = Utilisateur;
		this.listExpressions = listExpressions;
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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Difficulte getNiveau() {
		return niveau;
	}

	public void setNiveau(Difficulte niveau) {
		this.niveau = niveau;
	}

	public ArrayList<Expression> getListExpressions() {
		return listExpressions;
	}

	public void setListExpressions(ArrayList<Expression> listExpressions) {
		this.listExpressions = listExpressions;
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

	public void setScore() {
		int score = 0;
		ArrayList<Expression> uneListExpressions = getListExpressions();
		for (Expression uneExpression : uneListExpressions ) {
			if (uneExpression.verifierResultat()) {
				score++;
			}
		}
		setScore(score);
	}

}
