package protagonist;

import java.io.Serializable;

import structure.Piece;

/**
 * La classe Monstre représente un ennemi dans le jeu. Elle hérite de la classe
 * Protagonist et implémente l'interface Serializable.
 */
public class Monstre extends Protagonist implements Serializable {
	/**
	 * La pièce dans laquelle le monstre se trouve.
	 */
	private Piece piece;

	/**
	 * Construit un nouveau monstre avec une vie de 5, une force de 1 et une vie
	 * maximale de 5.
	 */
	public Monstre() {
		super();
		this.setVie(5);
		this.setForce(1);
		this.setVieMax(5);
	}

	/**
	 * Supprime un monstre en le mettant à null.
	 *
	 * @param monstre le monstre à supprimer
	 */
	public void Supprimer(Monstre monstre) {
		monstre = null;
	}

}
