package structure;

import java.io.Serializable;

import structure.Piece;

/**
 * 
 * La classe Porte représente une porte reliant deux objets Piece.
 * 
 * Elle implémente l'interface Serializable pour permettre la sérialisation de
 * ses objets.
 */
public class Porte implements Serializable {
	private Piece piece1; // la première pièce reliée par la porte.
	private Piece piece2; // la deuxième pièce reliée par la porte.

	/**
	 * 
	 * Constructeur de la classe Porte.
	 * 
	 * @param piece1 la première pièce reliée par la porte.
	 * @param piece2 la deuxième pièce reliée par la porte.
	 */
	public Porte(Piece piece1, Piece piece2) {
		this.piece1 = piece1;
		this.piece2 = piece2;
	}

	/**
	 * 
	 * Retourne la pièce reliée à la porte qui est différente de celle fournie en
	 * argument.
	 * 
	 * @param piece la pièce dont on souhaite obtenir la pièce reliée.
	 * @return la pièce reliée à la porte qui est différente de celle fournie en
	 *         argument, ou null si la pièce fournie en argument ne correspond à
	 *         aucune des deux pièces reliées par la porte.
	 */
	public Piece getAutrePiece(Piece piece) {
		if (piece == piece1) {
			return piece2;
		} else if (piece == piece2) {
			return piece1;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * Supprime la porte passée en argument.
	 * 
	 * @param porte la porte à supprimer.
	 */
	public void supprimer(Porte porte) {
		porte = null;
	}
}