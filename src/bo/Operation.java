package bo;

import java.io.Serializable;

public class Expression implements Serializable {

	public Expression() {
	}

	private enum Operateur {
		Somme ("+"),
		Difference ("-"),
		Multiplcation ("*"),
		Division ("/");
		Inverser ("inv");
		RacineCarre ("rac");
	}

	public double calcul(double pOperante, String Operateur) throws OperateurException {

		return (pOperante, null, Operateur);
	}

	public double calcul(double pOperante, double dOperante, String Operateur) throws OperateurException {

		double resultat = null;

		switch(Operateur) {
			case this.Operateur.Somme:
				resultat = additionner(pOperante, dOperante);
				break;
			case this.Operateur.Difference:
				resultat = soustraire(pOperante, dOperante);
				break;
			case this.Operateur.Multiplcation:
				resultat = multiplier(pOperante, dOperante);
				break;
			case this.Operateur.Division:
				resultat = diviser(pOperante, dOperante);
				break;
			case this.Operateur.Inverser:
				resultat = inverser(pOperante);
				break;
			case this.Operateur.RacineCarre:
				resultat = racineCarre(pOperante);
				break;
			default:
				throw new OperateurException ("Operateur inconnu");
		}

		return resultat;

	 }

	 private double additionner(double pOperante, double dOperante) {

		return pOperante + dOperante;
	}

	private double additionner(double pOperante, double dOperante) {

		return pOperante - dOperante;
	}

	private double multiplier(double pOperante, double dOperante) {

		return pOperante * dOperante;
	}

	private double diviser(double pOperante, double dOperante) {

		return pOperante / dOperante;
	}

	private double inverser(double pOperante) {

		return 1 / pOperante;
	}

	private double racineCarre(double pOperante) {

		return Math.sqrt(pOperante);
	}


