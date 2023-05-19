/**

Cette classe représente le jeu principal qui permet de jouer soit en tant que personnage ou en tant que maître du donjon.
Le joueur peut rejoindre une partie existante ou en créer une nouvelle.
*/
package test;

import java.io.File;

import MaitreDonjon.MaitreDuDonjon;
import protagonist.Personnage;
import structure.Labyrinthe;
import structure.Piece;
import structure.Save;
import vue.Clavier;

public class Game {
	/**
	 * 
	 * La méthode principale du programme.
	 * 
	 * @param args les arguments de la ligne de commande.
	 */
	public static void main(String[] args) {
		boolean game = false;
		while (game == false) {
			boolean choix = false;
			int role = 0;
			while (choix == false) {

				System.out.println("------------- Bien le bonjour bienvenue dans le jeu -------------");
				System.out.println("\nQuelle role voulez-vous joué ?\n");
				System.out.println(
						"------------- (1)Personnage ------------- (2)Maitre de donjon ------------ (3)quitter ------------");
				System.out.print("Role : ");
				role = Clavier.entrerClavierInt();
				if (role == 1 || role == 2 || role == 3) {
					choix = true;
				} else {
					System.out.println("Merci de choisir en role entre le 1 et le 2");
				}
			}

			if (role == 1) {

				int ChoixPartie = 0;
				boolean partie = false;
				while (partie == false) {
					System.out.println("------------- Faite votre choix entre les différents option -------------");
					System.out.println(
							"------------- (1)Rejoindre Partie ------------- (2)Nouvel partie par défaut ------------");
					System.out.print("Role : ");
					ChoixPartie = Clavier.entrerClavierInt();
					if (ChoixPartie == 2) {
						partie = true;
					} else if (ChoixPartie == 1) {
						int nbr = Save.NbrSauvegardes();
						if (nbr <= 0) {
							System.out.print("Vous n'avez pas de sauvegard");
						} else {
							partie = true;
						}
					} else {
						System.out.println("Merci de faire un choix entre le 1 et le 2");
					}
				}
				if (ChoixPartie == 1) {

					String ChoixSave;
					boolean save = false;
					while (save == false) {
						System.out.println("------------- Faite votre choix entre les différents save -------------");
						Save.afficherSauvegardes();
						System.out.print("Save name : ");
						ChoixSave = Clavier.entrerClavierString();
						if (ChoixSave != null && Save.SauvgardeExiste(ChoixSave)) {
							Labyrinthe lab = Save.chargerLabyrinthe(ChoixSave);
							if (lab.getPerso() != null) {
								System.out.println("Vous est dans la " + lab.getPerso().getPositionActuelle().getNom());
								lab.getPerso().AfficherPossesion();
								lab.getPerso().seDeplacer();
							} else {
								System.out.print("Quel sera le nom de votre personnage ? ");
								String nomPersonnage = Clavier.entrerClavierString();
								Personnage perso = new Personnage(nomPersonnage, lab.getEntree(), lab);
								lab.setPerso(perso);
								System.out.println("Vous est dans la " + lab.getPerso().getPositionActuelle().getNom());
								lab.getPerso().AfficherPossesion();
								lab.getPerso().seDeplacer();
							}
							save = true;
						} else {
							System.out.println("Il n'existe pas de labyrinthe");
						}
					}

				} else {
					System.out.print("Quel sera le nom de votre personnage ? ");
					String nomPersonnage = Clavier.entrerClavierString();
					Labyrinthe lab = new Labyrinthe(7, null);
					// Création des pièces
					Piece piece1 = new Piece("Pièce 1", false, false);
					Piece piece2 = new Piece("Pièce 2", true, false);
					Piece piece3 = new Piece("Pièce 3", true, false);
					Piece piece4 = new Piece("Pièce 4", true, false);
					Piece piece5 = new Piece("Pièce 5", true, false);
					Piece piece6 = new Piece("Pièce 6", true, false);
					Piece piece7 = new Piece("Pièce 7", true, false);
					Piece piece8 = new Piece("Pièce 8", true, false);
					Piece piece9 = new Piece("Pièce 9", true, false);
					Piece piece10 = new Piece("Pièce 10", true, false);
					// Ajout des pieces
					lab.ajouterPiece(0, 0, piece1);
					lab.ajouterPiece(0, 1, piece2);
					lab.ajouterPiece(0, 2, piece3);
					lab.ajouterPiece(1, 1, piece4);
					lab.ajouterPiece(1, 0, piece5);
					lab.ajouterPiece(2, 2, piece6);
					lab.ajouterPiece(2, 1, piece7);
					lab.ajouterPiece(3, 2, piece8);

					// Ajout des portes
					lab.ajouterPorte(0, 0, 0, 1);
					lab.ajouterPorte(0, 1, 1, 1);
					lab.ajouterPorte(0, 2, 0, 1);
					lab.ajouterPorte(0, 0, 1, 0);
					lab.ajouterPorte(2, 2, 2, 1);
					lab.ajouterPorte(2, 2, 3, 2);
					lab.ajouterPorte(1, 1, 2, 1);

					// Définition de l'entrée du labyrinthe
					lab.setEntree(0, 0);
					Personnage perso = new Personnage(nomPersonnage, lab.getEntree(), lab);
					lab.setPerso(perso);
					perso.seDeplacer();
				}
			} else if (role == 2) {
				MaitreDuDonjon mat = new MaitreDuDonjon();
				Labyrinthe lab = null;
				String nomPartie = null;
				if (Save.NbrSauvegardes() <= 0) {
					System.out.println("Il n'existe pas encore de labyrinthe vouler vous en créé un ?");
					System.out.println("(1)OUI (4)NON");
				} else {
					Save.afficherSauvegardes();
					System.out.println("Voici les différentes labyrinthes existantes");
					System.out.println("(2)Modifier un labyrinthe (3)Cree un nouveau labyrinthe (4)Retour");
				}
				System.out.print("Reponse :");
				int ChoixMD = Clavier.entrerClavierInt();
				if (ChoixMD == 1 || ChoixMD == 3) {
					lab = mat.CreeLabyrinth();
				} else if (ChoixMD == 2) {
					System.out.print("Donner le nom de la partie :");
					nomPartie = Clavier.entrerClavierString();
					lab = Save.chargerLabyrinthe(nomPartie);

				}
				int Action;
				if (lab != null) {
					do {
						System.out.println("Voici les différentes option:");
						System.out.print("============ Labyrinthe	\r\n" + "	(1)Supprimer	(2)Set Spawn\r\n"
								+ "============ Piece		\r\n"
								+ "	(3)Créé 	(4)Supprimer	(5)Afficher Une Piece	(6)Afficher Toute Les Pieces\r\n"
								+ "============ Porte\r\n" + "	(7)Créé 	(8)Supprimer\r\n"
								+ "============ Monstre\r\n" + "	(9)Créé 	(10)Supprimer\r\n"
								+ "============ Tresor\r\n" + "	(11)Créé 	(12)Supprimer\r\n" + "============ Save\r\n"
								+ "	(13)Sauvgarder La Partie\r\n" + "============ Quitter\r\n"
								+ "	(14)Quitter Sans Sauvgarder\r\n" + "Choix:");
						Action = Clavier.entrerClavierInt();
						switch (Action) {
						case 1:
							lab = null;
							if (nomPartie != null) {
								File fichier = new File("./src/save/" + nomPartie);
								fichier.delete();
							}
							Action = 14;
							break;
						case 2:
							mat.DefinirPieceDeDepart(lab);
							break;
						case 3:
							Piece piece = mat.CreePiece();
							mat.AjouterPiece(lab, piece);
							break;
						case 4:
							mat.SupprimerPiece(lab);
							break;
						case 5:
							mat.AfficherPiece(lab);
							break;
						case 6:
							mat.AfficherPieceLabyrinthe(lab);
							break;
						case 7:
							mat.AjouterPorte(lab);
							break;
						case 8:
							mat.SupprimerPorte(lab);
							break;
						case 9:
							System.out.println("Quelle Type de monstre voulez-vous créé:");
							System.out.println("(1)Defaut (2)Personnalisé");
							int TypeMonstre = Clavier.entrerClavierInt();
							if (TypeMonstre == 1 || TypeMonstre == 2) {
								if (TypeMonstre == 1) {
									mat.AjouterMonstre(lab);
								} else {
									mat.AjouterMonstreSpe(lab);
								}
							}
							break;
						case 10:
							mat.SupprimerMonstre(lab);
							break;
						case 11:
							mat.AjouterTresor(lab);
							break;
						case 12:
							mat.SupprimerTresor(lab);
							break;
						case 13:
							Save.afficherSauvegardes();
							System.out.print("Merci de donner un nom a votre sauvegarde :");
							String NomFile = Clavier.entrerClavierString();
							Save.sauvegarderLabyrinthe(lab, NomFile);
							Action = 14;
							break;
						case 14:

							break;

						default:
							break;
						}
					} while (Action != 14);

				}
			} else if (role == 3) {
				game = true;
			}
		}
	}

}
