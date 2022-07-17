package test;

import java.util.*;

public class Application {

	public static void main(String[] args) {
		ArrayList<Section> listeSection = new ArrayList<Section>();
		ArrayList<Projet> listeProjet = new ArrayList<Projet>();
		ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>();

		int choix, numSection, numProjet, numEtudiant;
		String nomSection, theme, nom, prenom;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1. Creer une section");
			System.out.println("2. Creer un projet");
			System.out.println("3. Creer un etudiant");
			System.out.println("4. Lister les sections");
			System.out.println("5. Lister les projets");
			System.out.println("6. Lister les etudiants");
			System.out.println("7. Afficher les etudiants d'une section donnee");
			System.out.println("8. Afficher les etudiants qui travaillent dans un projet donnee");
			System.out.println(
					"9. Afficher pour chaque projet les etudiants qui y travaillent et leurs sections respectives");
			System.out.println("10. Sortie");
			System.out.println("Votre choix");
			choix = sc.nextInt();
			sc.nextLine();

			switch (choix) {
				case 1:
					System.out.println("+--------------Creation d'une section----------------+");
					System.out.println("Numero section ?");
					numSection = sc.nextInt();
					sc.nextLine();
					System.out.println("Nom section ?");
					nomSection = sc.nextLine();

					Section section = new Section(numSection, nomSection);
					listeSection.add(section);
					break;

				case 2:
					System.out.println("+--------------Creation d'un projet----------------+");
					System.out.println("Numero projet ?");
					numProjet = sc.nextInt();
					sc.nextLine();
					System.out.println("Theme ?");
					theme = sc.nextLine();

					Projet projet = new Projet(numProjet, theme);
					listeProjet.add(projet);
					break;

				case 3:
					if (listeSection.isEmpty() || listeProjet.isEmpty()) {
						if (listeSection.isEmpty()) {
							System.out.println(
									"-- Il n'y a aucune section existante.--\nCreer d'abord une section au moins");
						} else {
							System.out
									.println("-- Il n'y a aucun projet existant.--\nCreer d'abord un projet au moins");
						}
					} else {
						System.out.println("+--------------Creation d'un etudiant----------------+");
						System.out.println("Numero etudiant ?");
						numEtudiant = sc.nextInt();
						sc.nextLine();
						System.out.println("Nom ?");
						nom = sc.nextLine();
						System.out.println("Prenom ?");
						prenom = sc.nextLine();

						section = null;
						while (section == null) {
							System.out.println("+----------Section de l'etudiant---------+");
							System.out.println("Numero de section de cet etudiant ?");
							numSection = sc.nextInt();
							sc.nextLine();
							for (Section s : listeSection) {
								if (s.getNumSection() == numSection) {
									section = s;
									System.out.println("+------------------------------------+");
									break;
								}
							}
							if (section == null) {
								System.out.println("Ce numero de section n'existe pas !");
								System.out.println("+--------------Liste des sections existantes----------------+");
								for (Section s : listeSection) {
									System.out.println("Numero section: " + s.getNumSection());
									System.out.println("Nom section: " + s.getNomSection());
									System.out.println();
								}
							}
						}

						projet = null;
						while (projet == null) {
							System.out.println("+----------Projet de l'etudiant---------+");
							System.out.println("Numero de projet de cet etudiant ?");
							numProjet = sc.nextInt();
							sc.nextLine();
							for (Projet p : listeProjet) {
								if (p.getNumProjet() == numProjet) {
									projet = p;
									System.out.println("+------------------------------------+");
									break;
								}
							}
							if (projet == null) {
								System.out.println("Ce numero de projet n'existe pas !");
								System.out.println("+--------------Liste des projets existants----------------+");
								for (Projet p : listeProjet) {
									System.out.println("Numero projet: " + p.getNumProjet());
									System.out.println("Theme: " + p.getTheme());
									System.out.println();
								}
							}
						}

						if (section != null && projet != null) {
							Etudiant etudiant = new Etudiant(numEtudiant, nom, prenom, section, projet);
							listeEtudiant.add(etudiant);
						}
					}
					break;

				case 4:
					if (listeSection.isEmpty()) {
						System.out.println("------- Il n'y a pas de section -------");
					} else {
						System.out.println("+--------------Liste des sections----------------+");
						for (Section s : listeSection) {
							System.out.println("Numero section: " + s.getNumSection());
							System.out.println("Nom section: " + s.getNomSection());
							System.out.println();

						}
						System.out.println("+------------------------------------+");
					}
					break;

				case 5:
					if (listeProjet.isEmpty()) {
						System.out.println("------- Il n'y a pas de projet -------");
					} else {
						System.out.println("+--------------Liste des projets----------------+");
						for (Projet p : listeProjet) {
							System.out.println("Numero projet: " + p.getNumProjet());
							System.out.println("Theme: " + p.getTheme());
							System.out.println();
						}
						System.out.println("+------------------------------------+");
					}
					break;

				case 6:
					if (listeEtudiant.isEmpty()) {
						System.out.println("------- Il n'y a pas d'etudiant -------");
					} else {
						System.out.println("+--------------Liste des etudiants----------------+");

						for (Etudiant e : listeEtudiant) {
							System.out.println("Numero etudiant: " + e.getNumEtudiant());
							System.out.println("Nom: " + e.getNom());
							System.out.println("Prenom: " + e.getPrenom());

							System.out.println("Numero section: " + e.getSection().getNumSection());
							System.out.println("Nom section: " + e.getSection().getNumSection());
							System.out.println("Numero projet: " + e.getProjet().getNumProjet());
							System.out.println("Theme: " + e.getProjet().getTheme());
							System.out.println();

						}
						System.out.println("+------------------------------------+");
					}
					break;

				case 7:
					if (listeSection.isEmpty()) {
						System.out
								.println("-- Il n'y a aucune section existante.--\nCreer d'abord une section au moins");
					} else {
						int numSectionE = 0;
						boolean mauvaiseReponse = true;

						while (mauvaiseReponse) {
							System.out.println("Numero de la section ?");
							numSection = sc.nextInt();
							sc.nextLine();

							for (Section s : listeSection) {
								if (s.getNumSection() == numSection) {
									numSectionE = numSection;
									mauvaiseReponse = false;
									break;
								}
							}
							if (mauvaiseReponse) {
								System.out.println("Numero section inexistant !");
							}
						}

						for (Etudiant e : listeEtudiant) {
							if (e.getSection().getNumSection() == numSectionE) {
								System.out.println("+------------------------------------+");

								System.out.println("Numero etudiant: " + e.getNumEtudiant());
								System.out.println("Nom: " + e.getNom());
								System.out.println("Prenom: " + e.getPrenom());

								System.out.println("Numero projet: " + e.getProjet().getNumProjet());
								System.out.println("Theme: " + e.getProjet().getTheme());
							}
						}
						System.out.println("+------------------------------------+");
					}
					break;

				case 8:
					if (listeProjet.isEmpty()) {
						System.out.println("-- Il n'y a aucun projet existant.--\nCreer d'abord un projet au moins");
					} else {
						int numProjetE = 0;
						boolean mauvaiseReponse = true;

						while (mauvaiseReponse) {
							System.out.println("Numero du projet ?");
							numProjet = sc.nextInt();
							sc.nextLine();

							for (Projet p : listeProjet) {
								if (p.getNumProjet() == numProjet) {
									numProjetE = numProjet;
									mauvaiseReponse = false;
									break;
								}
							}
							if (mauvaiseReponse) {
								System.out.println("Numero projet inexistant !");
							}
						}

						for (Etudiant e : listeEtudiant) {
							if (e.getProjet().getNumProjet() == numProjetE) {
								System.out.println("+------------------------------------+");

								System.out.println("Numero etudiant: " + e.getNumEtudiant());
								System.out.println("Nom: " + e.getNom());
								System.out.println("Prenom: " + e.getPrenom());

								System.out.println("Numero section: " + e.getSection().getNumSection());
								System.out.println("Nom section: " + e.getSection().getNumSection());
							}
						}
						System.out.println("+------------------------------------+");
					}
					break;

				case 9:
					if (listeProjet.isEmpty()) {
						System.out.println("-- Il n'y a aucun projet existant.--\nCreer d'abord un projet au moins");
					} else {
						for (Projet p : listeProjet) {
							System.out.println("+----------- Projet: " + p.getTheme() + " -----------+");
							for (Etudiant e : listeEtudiant) {
								if (p.getNumProjet() == e.getProjet().getNumProjet()) {
									System.out.println("+------------------------------------+");

									System.out.println("Numero etudiant: " + e.getNumEtudiant());
									System.out.println("Nom: " + e.getNom());
									System.out.println("Prenom: " + e.getPrenom());

									System.out.println("Numero section: " + e.getSection().getNumSection());
									System.out.println("Nom section: " + e.getSection().getNumSection());
								}
							}
							System.out.println("+------------------------------------+");
						}
					}
					break;

				case 10:
					System.out.println("Fin du programme !");
					break;

				default:
					System.out.println("Choix impossible !!!");
					break;
			}

		} while (choix != 10);
	}

}
