package test;

public class Section {
	private int numSection;
	private String nomSection;
	
	public Section(int numSection, String nomSection) {
		super();
		this.numSection = numSection;
		this.nomSection = nomSection;
		System.out.println("+------ Section Cree avec succes ------+\n");
	}

	public int getNumSection() {
		return numSection;
	}

	public void setNumSection(int numSection) {
		this.numSection = numSection;
	}

	public String getNomSection() {
		return nomSection;
	}

	public void setNomSection(String nomSection) {
		this.nomSection = nomSection;
	}
	
	

}
