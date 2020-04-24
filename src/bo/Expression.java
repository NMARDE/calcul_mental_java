package bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import exception.OperateurException;
import exception.ReponseUserException;

public class Expression implements Serializable {
	
	private int id;
	private ArrayList<String> listOperation = new ArrayList<String>();
	private double resultatAttendu;
	private double reponseUser;
	private Partie unePartie;


	public Expression(int id, Partie unePartie) {
		this.id = id;
		this.unePartie = unePartie;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getListOperation() {
		return listOperation;
	}

	public void setListOperation(ArrayList<String> listOperation) {
		this.listOperation = listOperation;
	}

	public double getResultatAttendu() {
		return resultatAttendu;
	}

	public void setResultatAttendu(double resultatAttendu) {
		this.resultatAttendu = resultatAttendu;
	}

	public double getReponseUser() {
		return reponseUser;
	}

	public void setReponseUser(double reponseUser) {
		this.reponseUser = reponseUser;
	}

	public Partie getPartie() {
		return unePartie;
	}

	public void setPartie(Partie unePartie) {
		this.unePartie = unePartie;
	}

	public boolean verifierResultat(String reponseUser) throws ReponseUserException {
		try {
			setReponseUser(Double.parseDouble(reponseUser));
		} catch (NumberFormatException nfe) {
			throw new ReponseUserException("Ceci n'est pas un nombre");
		}
		return getResultatAttendu() == getReponseUser();

	}

	/**
	 * Permet de calculer le résultat attendus
	 * @throws OperateurException
	 */

	public void calculerResultat() throws OperateurException {

		ArrayList<String> listOperation = getListOperation();
		Stack<Double> stack = new Stack<>();
		Operation.Operateur operateur = null;

		for (String element: listOperation) {
			try {
				stack.push(Double.parseDouble(element));
			} catch (NumberFormatException nfe) {
				operateur = rechercherType(element);

				if (operateur.isUnaire()) {
					Operation operation = new Operation(stack.pop(), operateur);
					stack.push(operation.calcul());
				} else {
					Operation operation = new Operation(stack.pop(), stack.pop(), operateur);
					stack.push(operation.calcul());
				}
			}
		}

		setResultatAttendu(stack.pop());
	}

	private Operation.Operateur rechercherType (String element) {
		Operation.Operateur[] listOperateurs = Operation.Operateur.values();
		Operation.Operateur operateur = null;

		for (Operation.Operateur unOperateur : listOperateurs) {
			if (unOperateur.equals(element)) {
				operateur = unOperateur;
				break;
			}
		}

		return operateur;
	}


	/**
	 *  Permet de générer l'expression en fonction de la difficulté
	 * 	(Facile = 1 opérateur, Moyens = 2 opérateurs, Difficile = 3 opérateurs)
	 * @throws OperateurException
	 */

	public void genererExpression() throws OperateurException {

		Partie unePartie = getPartie();
		Partie.Difficulte difficulte = unePartie.getDifficulte();
		ArrayList<String> listOperation = new ArrayList<>();

		listOperation.add(genererNombre());

		switch(difficulte) {
			case LEVEL3:
				listOperation.addAll(genererPartieExpression());
			case LEVEL2:
				listOperation.addAll(genererPartieExpression());
			case LEVEL1:
				listOperation.addAll(genererPartieExpression());
				break;
			default:
				throw new OperateurException("Opérateur non existant");
		}

		setListOperation(listOperation);
		calculerResultat();
	}

	/**
	 * Génère une opération
	 * @return
	 */
	private ArrayList<String> genererPartieExpression() {
		Operation.Operateur Operateur;
		ArrayList<String> listOperation = new ArrayList<>();

		Operateur = Operation.Operateur.getRandomOperateur();
		if (!Operateur.isUnaire()) {
			listOperation.add(genererNombre());
		}
		listOperation.add(Operateur.getType());

		return listOperation;
	}

	/**
	 * Génère un nombre entre 0 et 20 compris
	 * @return
	 */
	private String genererNombre() {
		 return String.valueOf(Math.random()*20);
	}

	/**
	 * Permet d'afficher l'expression en espaçant chaques éléments
	 * @return
	 */
	public String afficherExpression() {

		StringBuilder retour = new StringBuilder();
		for (String element: listOperation) {
			retour.append(element);
			retour.append(" ");
		}

		return retour.toString();

	}


}
