package test;

public class Projet {
	private int numProjet;
	private String theme;
	
	public Projet(int numProjet, String theme) {
		super();
		this.numProjet = numProjet;
		this.theme = theme;
		System.out.println("+------ Projet Cree avec succes ------+\n");
	}

	public int getNumProjet() {
		return numProjet;
	}

	public void setNumProjet(int numProjet) {
		this.numProjet = numProjet;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
	
}
