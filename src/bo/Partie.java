package bo;

import java.io.Serializable;

public class Partie implements Serializable {
	
	private String id;
	private int score;
	private dataTime temps;
	private String difficulte;
	private User unUser;

	public Partie(String id, String difficulte, bo.User unUser) {
		this.id = id;
		this.difficulte = difficulte;
		this.unUser = unUser;
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

	public dataTime getTemps() {
		return temps;
	}

	public void setTemps(dataTime temps) {
		this.temps = temps;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public bo.User getUnUser() {
		return unUser;
	}

	public void setUnUser(bo.User unUser) {
		this.unUser = unUser;
	}

}
