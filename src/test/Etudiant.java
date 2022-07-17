package test;

public class Etudiant {
	private int numEtudiant;
	private String nom;
	private String prenom;
	private Section section;
	private Projet projet;
	
	public Etudiant(int numEtudiant, String nom, String prenom, Section section, Projet projet) {
		super();
		this.numEtudiant = numEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.section = section;
		this.projet = projet;
		System.out.println("+------ Etudiant Cree avec succes ------+\n");
	}

	public int getNumEtudiant() {
		return numEtudiant;
	}

	public void setNumEtudiant(int numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
}
