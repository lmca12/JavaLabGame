package MaitreDonjon;

import structure.Labyrinthe;
import structure.Piece;
import vue.Clavier;

/**
 * 
 * Cette classe représente le maître du donjon, qui est responsable de la
 * création et de la gestion du labyrinthe.
 */
public class MaitreDuDonjon {
	/**
	 * 
	 * Cette méthode permet de créer un labyrinthe avec la taille donnée par
	 * l'utilisateur.
	 * 
	 * @return le labyrinthe créé avec la taille donnée.
	 */
	public Labyrinthe CreeLabyrinth() {
		System.out.print("Donner la taille du labyrinthe :");
		int taille = Clavier.entrerClavierInt();
		Labyrinthe labyrinthe = new Labyrinthe(taille, null);
		return labyrinthe;
	}

	/**
	 * 
	 * Cette méthode permet de créer une nouvelle pièce pour le labyrinthe. Elle
	 * demande le nom de la pièce à l'utilisateur, si la pièce contient un monstre,
	 * et si elle contient un trésor. Si l'utilisateur répond oui pour la présence
	 * d'un monstre ou d'un trésor, alors le booléen correspondant est positionné à
	 * vrai. La méthode crée ensuite une nouvelle pièce avec les informations
	 * obtenues.
	 * 
	 * @return une instance de la classe Piece
	 */
	public Piece CreePiece() {
		boolean MonstreIs = false;
		boolean TresorIs = false;
		int IsMonstre = 0;
		int IsTresor = 0;
		System.out.print("Donner le nom de la piece :");
		String nomPiece = Clavier.entrerClavierString();
		while (IsMonstre != 1 || IsMonstre != 2) {
			System.out.print("la piece a t'elle un monstre :\n (1)OUI 	(2)NON\nChoix: ");
			IsMonstre = Clavier.entrerClavierInt();
			if (IsMonstre == 1) {
				MonstreIs = true;
				break;
			} else if (IsMonstre == 2) {
				break;
			}
		}
		while (IsTresor != 1 || IsTresor != 2) {
			System.out.print("la piece a t'elle un tresor :\n (1)OUI 	(2)NON\nChoix: ");
			IsTresor = Clavier.entrerClavierInt();
			if (IsTresor == 1) {
				TresorIs = true;
				break;
			} else if (IsTresor == 2) {
				break;
			}
		}
		Piece piece = new Piece(nomPiece, MonstreIs, TresorIs);

		return piece;
	}

	/**
	 * 
	 * Ajoute une pièce au labyrinthe à la position spécifiée.
	 * 
	 * @param lab   Le labyrinthe dans lequel ajouter la pièce.
	 * @param piece La pièce à ajouter.
	 */
	public void AjouterPiece(Labyrinthe lab, Piece piece) {
		// TODO Auto-generated method stub
		System.out.print("Donner la position en x de la piece :");
		int coX = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY = Clavier.entrerClavierInt();
		lab.ajouterPiece(coX, coY, piece);
	}

	/**
	 * 
	 * Cette méthode permet d'ajouter une porte reliant deux pièces du labyrinthe.
	 * L'utilisateur doit saisir les coordonnées des deux pièces à relier.
	 * 
	 * @param lab le labyrinthe dans lequel on veut ajouter une porte
	 */
	public void AjouterPorte(Labyrinthe lab) {
		System.out.print("Donner la position en x de la premier piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la premier piece :");
		int coY1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en x de la seconde piece :");
		int coX2 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la seconde piece :");
		int coY2 = Clavier.entrerClavierInt();
		lab.ajouterPorte(coX1, coY1, coX2, coY2);
	}

	/**
	 * 
	 * Cette méthode permet d'ajouter un monstre à une pièce donnée dans le
	 * labyrinthe.
	 * 
	 * @param lab le labyrinthe dans lequel ajouter le monstre.
	 */
	public void AjouterMonstre(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).setMonstre(true);
	}

	/**
	 * 
	 * Cette méthode permet d'ajouter un monstre spécial (avec vie et force
	 * personnalisées) à une pièce du labyrinthe.
	 * 
	 * @param lab le labyrinthe auquel ajouter le monstre.
	 */
	public void AjouterMonstreSpe(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).setMonstre(true);
		System.out.print("Donner la vie du monstre :");
		int VieMonstre = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).getMob().setVie(VieMonstre);
		System.out.print("Donner la force du monstre :");
		int ForceMonstre = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).getMob().setForce(ForceMonstre);
	}

	/**
	 * 
	 * Cette méthode permet d'ajouter un trésor à une pièce du labyrinthe.
	 * L'utilisateur doit saisir les coordonnées de la pièce et les informations sur
	 * le trésor.
	 * 
	 * @param lab le labyrinthe dans lequel ajouter le trésor.
	 */
	public void AjouterTresor(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).setTresor(true);
		System.out.print("Donner la nature du tresor 'Arme' ou 'Armure' :");
		String NatureTresor = Clavier.entrerClavierString();
		lab.getPiece(coX1, coY1).getLoot().setNature(NatureTresor);
		;
		System.out.print(
				"Donner le niveau du tresor(Le niveau corespond a la puissance pour l'arme et a la protection pour l'armure) :");
		int NiveauTresor = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).getLoot().setNiveaux(NiveauTresor);
	}

	/**
	 * 
	 * Cette méthode permet de supprimer un monstre d'une pièce donnée dans le
	 * labyrinthe. L'utilisateur doit saisir les coordonnées de la pièce.
	 * 
	 * @param lab le labyrinthe dans lequel se trouve la pièce.
	 */
	public void SupprimerMonstre(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).getMob().Supprimer(lab.getPiece(coX1, coY1).getMob());
		lab.getPiece(coX1, coY1).setMonstre(false);
	}

	/**
	 * 
	 * Cette méthode permet de supprimer un trésor d'une pièce donnée dans le
	 * labyrinthe. L'utilisateur doit saisir les coordonnées de la pièce.
	 * 
	 * @param lab le labyrinthe dans lequel se trouve la pièce.
	 */
	public void SupprimerTresor(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		lab.getPiece(coX1, coY1).getLoot().supprimer(lab.getPiece(coX1, coY1).getLoot());
		lab.getPiece(coX1, coY1).setTresor(false);
	}

	/**
	 * 
	 * Cette méthode permet de supprimer une porte entre deux pièces du labyrinthe.
	 * L'utilisateur doit saisir les coordonnées des deux pièces.
	 * 
	 * @param lab le labyrinthe dans lequel se trouvent les pièces.
	 */
	public void SupprimerPorte(Labyrinthe lab) {
		System.out.print("Donner la position en x de la premier piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la premier piece :");
		int coY1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en x de la seconde piece :");
		int coX2 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la seconde piece :");
		int coY2 = Clavier.entrerClavierInt();
		lab.SupprimerPorte(coX1, coY1, coX2, coY2);
	}

	/**
	 * 
	 * Cette méthode permet de supprimer une pièce du labyrinthe. L'utilisateur doit
	 * saisir les coordonnées de la pièce.
	 * 
	 * @param lab le labyrinthe dans lequel se trouve la pièce.
	 */
	public void SupprimerPiece(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		lab.SupprimerTouteLesPortes(coX1, coY1);
		lab.setPiece(coX1, coY1, null);
	}

	/**
	 * 
	 * Cette méthode permet de définir la pièce de départ du labyrinthe.
	 * L'utilisateur doit saisir les coordonnées de la pièce.
	 * 
	 * @param lab le labyrinthe dans lequel définir la pièce de départ.
	 */
	public void DefinirPieceDeDepart(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		lab.setEntree(coX1, coY1);

	}

	/**
	 * 
	 * Cette méthode permet d'afficher les informations d'une pièce spécifique dans
	 * le labyrinthe. L'utilisateur doit saisir les coordonnées de la pièce.
	 * 
	 * @param lab le labyrinthe contenant la pièce.
	 */
	public void AfficherPiece(Labyrinthe lab) {
		System.out.print("Donner la position en x de la piece :");
		int coX1 = Clavier.entrerClavierInt();
		System.out.print("Donner la position en y de la piece :");
		int coY1 = Clavier.entrerClavierInt();
		System.out.println("Nom: " + lab.getPiece(coX1, coY1).getNom());
		System.out.println("	Porte nord: " + lab.getPiece(coX1, coY1).getPorteNord());
		System.out.println("	Porte est: " + lab.getPiece(coX1, coY1).getPorteEst());
		System.out.println("	Porte sud: " + lab.getPiece(coX1, coY1).getPorteSud());
		System.out.println("	Porte ouest: " + lab.getPiece(coX1, coY1).getPorteOuest());
		System.out.println("Monstre: " + lab.getPiece(coX1, coY1).isMonstre());
		if (lab.getPiece(coX1, coY1).isMonstre() == true) {
			System.out.println("	Force: " + lab.getPiece(coX1, coY1).getMob().getForce());
			System.out.println("	Vie: " + lab.getPiece(coX1, coY1).getMob().getVie());
		}
		System.out.println("Tresor: " + lab.getPiece(coX1, coY1).getTresor());
		if (lab.getPiece(coX1, coY1).getTresor() == true) {
			System.out.println("	Nature: " + lab.getPiece(coX1, coY1).getLoot().getNature());
			System.out.println("	Puissance: " + lab.getPiece(coX1, coY1).getLoot().getNiveaux());
		}
	}

	/**
	 * 
	 * Cette méthode permet d'afficher toutes les pièces du labyrinthe avec leurs
	 * coordonnées.
	 * 
	 * @param lab le labyrinthe à afficher.
	 */
	public void AfficherPieceLabyrinthe(Labyrinthe lab) {
		Piece[][] grille = lab.getGrille();
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				Piece piece = grille[i][j];
				if (piece != null) {
					System.out.println(piece.getNom() + "            x : " + i + " y : " + j + piece.PresencePorte());
				}
			}
		}

	}
}
