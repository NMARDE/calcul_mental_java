package bo;

import exception.OperateurException;

import java.io.Serializable;
import java.util.Random;

public class Operation implements Serializable {

	private double pOperante;
	private double dOperante;
	private Operateur operateur;

	public Operation(double pOperante, double dOperante, Operateur operateur) {
		this.pOperante = pOperante;
		this.dOperante = dOperante;
		this.operateur = operateur;
	}

	public Operation(double pOperante, Operateur operateur) {
		this.pOperante = pOperante;
		this.dOperante = 0;
		this.operateur = operateur;
	}


	public double getpOperante() {
		return pOperante;
	}

	public void setpOperante(double pOperante) {
		this.pOperante = pOperante;
	}

	public double getdOperante() {
		return dOperante;
	}

	public void setdOperante(double dOperante) {
		this.dOperante = dOperante;
	}

	public Operateur getOperateur() {
		return operateur;
	}

	public void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}

	public enum Operateur {
		Somme("+"),
		Difference("-"),
		Multiplcation("*"),
		Division("/"),
		Inverser("inv"),
		RacineCarre("rac"),
		;

		private String type;

		Operateur(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public boolean isUnaire() {
			boolean isUnaire = true;
			switch (this) {
				case Inverser:
				case RacineCarre:
					break;
				default:
					isUnaire = false;
					break;
			}

			return isUnaire;
		}

		private static final Operateur[] VALUES = values();
		private static final int SIZE = VALUES.length;
		private static final Random RANDOM = new Random();

		public static Operateur getRandomOperateur()  {
			return VALUES[RANDOM.nextInt(SIZE)];
		}

	}

	public double calcul() throws OperateurException {

		double pOperante = getpOperante();
		double dOperante = getdOperante();
		Operateur operateur = getOperateur();


		double resultat = 0;

		switch (operateur) {
			case Somme:
				resultat = pOperante + dOperante;
				break;
			case Difference:
				resultat = pOperante - dOperante;
				break;
			case Multiplcation:
				resultat = pOperante * dOperante;
				break;
			case Division:
				resultat = pOperante / dOperante;
				break;
			case Inverser:
				resultat = 1 / pOperante;
				break;
			case RacineCarre:
				resultat = Math.sqrt(pOperante);
				break;
			default:
				throw new OperateurException("Operateur inconnu");
		}

		return resultat;

	}
}



