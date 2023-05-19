
/**

La classe Piece représente une pièce dans le jeu.
Elle contient des portes qui mènent à d'autres pièces, ainsi qu'un éventuel monstre et trésor.
@author [nom de l'auteur]
@version [numéro de version]
*/
package structure;

import java.io.Serializable;
import java.util.Random;

import loot.Tresor;
import protagonist.Monstre;

public class Piece implements Serializable {
	private String nom;
	private Porte porteNord;
	private Porte porteSud;
	private Porte porteEst;
	private Porte porteOuest;
	private boolean monstre;
	private Monstre mob;
	private Boolean tresor;
	private Tresor loot;
	private Random random = new Random();

	/**
	 * Constructeur de la classe Piece.
	 * 
	 * @param nom     le nom de la pièce.
	 * @param monstre vrai si la pièce contient un monstre, faux sinon.
	 * @param tresor  vrai si la pièce contient un trésor, faux sinon.
	 */
	public Piece(String nom, Boolean monstre, Boolean tresor) {
		this.nom = nom;
		this.setMonstre(monstre);
		this.setTresor(tresor);
	}

	/**
	 * Retourne la porte au nord de la pièce.
	 * 
	 * @return la porte au nord de la pièce.
	 */
	public Porte getPorteNord() {
		return porteNord;
	}

	/**
	 * Retourne la porte au sud de la pièce.
	 * 
	 * @return la porte au sud de la pièce.
	 */
	public Porte getPorteSud() {
		return porteSud;
	}

	/**
	 * Retourne la porte à l'est de la pièce.
	 * 
	 * @return la porte à l'est de la pièce.
	 */
	public Porte getPorteEst() {
		return porteEst;
	}

	/**
	 * Retourne la porte à l'ouest de la pièce.
	 * 
	 * @return la porte à l'ouest de la pièce.
	 */
	public Porte getPorteOuest() {
		return porteOuest;
	}

	/**
	 * Modifie la porte au nord de la pièce.
	 * 
	 * @param porteNord la nouvelle porte au nord de la pièce.
	 */
	public void setPorteNord(Porte porteNord) {
		this.porteNord = porteNord;
	}

	/**
	 * Modifie la porte au sud de la pièce.
	 * 
	 * @param porteSud la nouvelle porte au sud de la pièce.
	 */
	public void setPorteSud(Porte porteSud) {
		this.porteSud = porteSud;
	}

	/**
	 * Modifie la porte à l'est de la pièce.
	 * 
	 * @param porteEst la nouvelle porte à l'est de la pièce.
	 */
	public void setPorteEst(Porte porteEst) {
		this.porteEst = porteEst;
	}

	/**
	 * Modifie la porte à l'ouest de la pièce.
	 * 
	 * @param porteOuest la nouvelle porte à l'ouest de la pièce.
	 */
	public void setPorteOuest(Porte porteOuest) {
		this.porteOuest = porteOuest;
	}

	/**
	 * 
	 * Returns the name of the object.
	 * 
	 * @return a String representing the name of the object.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * 
	 * Retourne une chaîne de caractères représentant la présence des portes dans
	 * l'objet.
	 * 
	 * @return une chaîne de caractères représentant la présence des portes dans
	 *         l'objet, avec le format "- E -" pour la porte est, "- O -" pour la
	 *         porte ouest, "- N -" pour la porte nord et "- S -" pour la porte sud.
	 */
	public String PresencePorte() {
		// TODO Auto-generated method stub
		String porte = "";
		if (this.getPorteEst() != null) {
			porte = porte + "- E -";
		}
		if (this.getPorteOuest() != null) {
			porte = porte + "- O -";
		}
		if (this.getPorteNord() != null) {
			porte = porte + "- N -";
		}
		if (this.getPorteSud() != null) {
			porte = porte + "- S -";
		}

		return porte;
	}

	/**
	 * 
	 * Retourne le monstre présent dans l'objet.
	 * 
	 * @return le monstre présent dans l'objet.
	 */
	public Monstre getMob() {
		return mob;
	}

	/**
	 * 
	 * Vérifie si l'objet est un monstre ou non.
	 * 
	 * @return vrai si l'objet est un monstre, faux sinon.
	 */
	public boolean isMonstre() {
		return monstre;
	}

	/**
	 * 
	 * Définit si l'objet est un monstre ou non.
	 * 
	 * @param monstre valeur booléenne représentant si l'objet est un monstre ou
	 *                non.
	 */
	public void setMonstre(boolean monstre) {
		if (monstre == true) {
			mob = new Monstre();
		}
		this.monstre = monstre;
	}

	/**
	 * 
	 * Retourne si l'objet contient un trésor ou non.
	 * 
	 * @return vrai si l'objet contient un trésor, faux sinon.
	 */
	public Boolean getTresor() {
		return tresor;
	}

	/**
	 * 
	 * Définit si l'objet contient un trésor ou non.
	 * 
	 * @param tresor valeur booléenne représentant si l'objet contient un trésor ou
	 *               non.
	 */
	public void setTresor(Boolean tresor) {
		if (tresor == true) {
			int rand2 = random.nextInt(2) + 1;
			String nature;
			if (rand2 == 1) {
				nature = "armure";
			} else {
				nature = "arme";
			}
			setLoot(new Tresor(nature, null));

		}
		this.tresor = tresor;
	}

	/**
	 * 
	 * Retourne le trésor contenu dans l'objet.
	 * 
	 * @return le trésor contenu dans l'objet.
	 */
	public Tresor getLoot() {
		return loot;
	}

	/**
	 * 
	 * Définit le trésor contenu dans l'objet.
	 * 
	 * @param loot le trésor à définir pour l'objet.
	 */
	public void setLoot(Tresor loot) {
		this.loot = loot;
	}

	/**
	 * 
	 * Supprime la porte nord de l'objet.
	 */
	public void SupprimerPorteNord() {
		this.porteNord = null;
	}

	/**
	 * 
	 * Supprime la porte sud de l'objet.
	 */
	public void SupprimerPorteSud() {
		this.porteSud = null;
	}

	/**
	 * 
	 * Supprime la porte est de l'objet.
	 */
	public void SupprimerPorteEst() {
		this.porteEst = null;
	}

	/**
	 * 
	 * Supprime la porte ouest de l'objet.
	 */
	public void SupprimerPorteOuest() {
		this.porteOuest = null;
	}

}
