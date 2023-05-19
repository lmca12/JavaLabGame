package protagonist;

import java.io.Serializable;

import combat.Combat;
import structure.Labyrinthe;
import structure.Piece;
import structure.Save;
import vue.Clavier;

/**
 * La classe Personnage représente le joueur dans le jeu. Elle hérite de la
 * classe Protagonist et implémente l'interface Serializable.
 */
public class Personnage extends Protagonist implements Serializable {

	/**
	 * Le nom du personnage.
	 */
	private String nom;

	/**
	 * La pièce dans laquelle le personnage se trouve actuellement.
	 */
	private Piece positionActuelle;

	/**
	 * La pièce dans laquelle le personnage se trouvait précédemment.
	 */
	private Piece positionPrecedente;

	/**
	 * Indique si le personnage est en train de fuir.
	 */
	public boolean fuire;

	/**
	 * Le labyrinthe dans lequel évolue le personnage.
	 */
	private Labyrinthe lab;

	/**
	 * Construit un nouveau personnage avec un nom, une position actuelle et un
	 * labyrinthe.
	 *
	 * @param nom              le nom du personnage
	 * @param positionActuelle la position actuelle du personnage
	 * @param lab              le labyrinthe dans lequel évolue le personnage
	 */
	public Personnage(String nom, Piece positionActuelle, Labyrinthe lab) {
		super();
		this.nom = nom;
		this.positionActuelle = positionActuelle;
		this.setPositionPrecedente(positionActuelle);
		this.setVie(10);
		this.setVieMax(10);
		this.setForce(1);
		this.setLab(lab);
	}

	/**
	 * Retourne le nom du personnage.
	 *
	 * @return le nom du personnage
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne la pièce dans laquelle se trouve actuellement le personnage.
	 *
	 * @return la pièce actuelle du personnage
	 */
	public Piece getPositionActuelle() {
		return positionActuelle;
	}

	/**
	 * Définit la pièce dans laquelle se trouve actuellement le personnage.
	 *
	 * @param positionActuelle la nouvelle position actuelle du personnage
	 */
	public void setPositionActuelle(Piece positionActuelle) {
		this.positionActuelle = positionActuelle;
	}

	/**
	 * 
	 * Cette méthode permet au personnage de se déplacer dans le labyrinthe. Elle
	 * affiche les options de déplacement et demande au joueur la direction
	 * souhaitée. Si la pièce actuelle du personnage contient un monstre, la méthode
	 * appelle un combat contre le monstre. Si la pièce actuelle du personnage
	 * contient un trésor, la méthode demande au joueur s'il veut le prendre ou non.
	 * Si le joueur décide de quitter le labyrinthe, la méthode sauvegarde l'état
	 * actuel du labyrinthe et quitte le jeu.
	 */
	public void seDeplacer() {
		String direction;
		do {
			if (positionActuelle.isMonstre() == true && this.fuire == false) {
				Combat combat1 = new Combat(this, positionActuelle.getMob());
				combat1.commencer();
				fuire = false;
				System.out.println("Vous êtes maintenant dans la pièce " + positionActuelle.getNom());
			}
			if (positionActuelle.getTresor() == true) {
				System.out.println("Il y a un tresor dans cette piece ces une "
						+ this.getPositionActuelle().getLoot().getNature() + " de niveaux "
						+ this.getPositionActuelle().getLoot().getNiveaux() + " veux tu le prendre ?");
				this.AfficherPossesion();
				System.out.println("1 pour oui et 2 pour non");
				int choix = Clavier.entrerClavierInt();
				if (choix == 1) {
					this.prendreTresor(this.getPositionActuelle().getLoot());
					this.AfficherPossesion();
					positionActuelle.setTresor(false);
				} else if (choix == 2) {
					this.getPositionActuelle().getLoot().setProprietaire(null);
					this.AfficherPossesion();
				}
			}
			if (this.getVie() <= 0) {
				break;
			}
			System.out.print("Dans quelle direction souhaitez-vous aller (" + this.positionActuelle.PresencePorte()
					+ ") ? Si vous souhaitez quitter entree Q  ");
			direction = Clavier.entrerClavierString();
			switch (direction.toUpperCase()) {
			case "N":
				if (positionActuelle.getPorteNord() != null) {
					setPositionPrecedente(positionActuelle);
					positionActuelle = positionActuelle.getPorteNord().getAutrePiece(positionActuelle);
					System.out.println("Vous êtes maintenant dans la pièce " + positionActuelle.getNom());
				} else {
					System.out.println("Il n'y a pas de porte au nord !");
				}
				break;
			case "S":
				if (positionActuelle.getPorteSud() != null) {
					setPositionPrecedente(positionActuelle);
					positionActuelle = positionActuelle.getPorteSud().getAutrePiece(positionActuelle);
					System.out.println("Vous êtes maintenant dans la pièce " + positionActuelle.getNom());
				} else {
					System.out.println("Il n'y a pas de porte au sud !");
				}
				break;
			case "E":
				if (positionActuelle.getPorteEst() != null) {
					setPositionPrecedente(positionActuelle);
					positionActuelle = positionActuelle.getPorteEst().getAutrePiece(positionActuelle);
					System.out.println("Vous êtes maintenant dans la pièce " + positionActuelle.getNom());
				} else {
					System.out.println("Il n'y a pas de porte à l'est !");
				}
				break;
			case "O":
				if (positionActuelle.getPorteOuest() != null) {
					setPositionPrecedente(positionActuelle);
					positionActuelle = positionActuelle.getPorteOuest().getAutrePiece(positionActuelle);
					System.out.println("Vous êtes maintenant dans la pièce " + positionActuelle.getNom());
				} else {
					System.out.println("Il n'y a pas de porte à l'ouest !");
				}
				break;
			case "Q":
				System.out.print("Merci de donner un nom a votre sauvegarde :");
				String NomFile = Clavier.entrerClavierString();
				System.out.println("Merci et a bientôt !");
				Save.sauvegarderLabyrinthe(lab, NomFile);
				break;
			default:
				System.out.println("Je n'ai pas compris votre choix...");
			}
		} while (!direction.equalsIgnoreCase("Q"));

	}

	/**
	 * 
	 * Retourne la pièce précédente dans laquelle le personnage se trouvait.
	 * 
	 * @return la pièce précédente
	 */
	public Piece getPositionPrecedente() {
		return positionPrecedente;
	}

	/**
	 * 
	 * Modifie la pièce précédente dans laquelle le personnage se trouvait.
	 * 
	 * @param positionPrecedente la nouvelle pièce précédente
	 */
	public void setPositionPrecedente(Piece positionPrecedente) {
		this.positionPrecedente = positionPrecedente;
	}

	/**
	 * 
	 * Méthode appelée lorsque le joueur gagne la partie. Le joueur regagne sa vie
	 * maximale, gagne 1 point de vie, la pièce actuelle devient un trésor et le
	 * joueur en devient le propriétaire.
	 */
	public void Victoire() {
		this.regagnerVieMax();
		this.gagnerVie(1);
		System.out.println("Victoire ! Vous avez gagné 1 point de vie. Elle est maintenant de " + this.getVie() + ".");
		this.getPositionActuelle().setMonstre(false);
		this.getPositionActuelle().setTresor(true);
		this.getPositionActuelle().getLoot().setProprietaire(this);
	}

	/**
	 * 
	 * Méthode appelée lorsque le joueur perd la partie.
	 */
	public void defait() {
		// Non implémentée pour le moment.
	}

	/**
	 * 
	 * Retourne le labyrinthe dans lequel se trouve le joueur.
	 * 
	 * @return le labyrinthe
	 */
	public Labyrinthe getLab() {
		return lab;
	}

	/**
	 * 
	 * Modifie le labyrinthe dans lequel se trouve le joueur.
	 * 
	 * @param lab le nouveau labyrinthe
	 */
	public void setLab(Labyrinthe lab) {
		this.lab = lab;
	}

}
