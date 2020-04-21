package bo;

import java.io.Serializable;

public class Expression implements Serializable {

	public Expression() {
	}

	private enum Langage {
		Somme ("+"),
		Difference ("-"),
		Multiplcation ("*"),
		Division ("/");
		Inverser ("inv");
		RacineCarre ("rac");
	}



	}
