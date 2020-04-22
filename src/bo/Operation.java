package bo;

import exception.OperateurException;

import java.io.Serializable;

public class Operation implements Serializable {

	public Operation() {
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

	}

	public double calcul(double pOperante, Operateur op) throws OperateurException {

		return calcul(pOperante, 0, op);
	}

	public double calcul(double pOperante, double dOperante, Operateur op) throws OperateurException {

		double resultat = 0;

		switch (op) {
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



