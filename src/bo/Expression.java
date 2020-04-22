package bo;

import java.io.Serializable;
import src.exception.ReponseUser;

public class Expression implements Serializable {
	
	private String id;
	private Operation[] tableauOperation;
	private double resultatAttendu;
	private double reponseUser;
	private Partie unePartie;


	public Expression(String id, Partie unePartie) {
		this.id = id;
		this.unePartie = unePartie;
		this.tableauOperation = tableauOperation;
		this.resultatAttendu = resultatAttendu;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Operation[] getTableauOperation() {
		return tableauOperation;
	}

	public void setTableauOperation(Operation[] tableauOperation) {
		this.tableauOperation = tableauOperation;
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

	public Partie getUnePartie() {
		return unePartie;
	}

	public void setUnePartie(Partie unePartie) {
		this.unePartie = unePartie;
	}

	public boolean verifierResultat(String reponseUser) throws ReponseUserException{
		try {
			setReponseUser(Double.valueof(reponseUser));
		} catch (NumberFormatException nfe) {
			throw new ReponseUserException("Ceci n'est pas un nombre")
		}
		return getResultatAttendu() == getReponseUser()

	}
}
