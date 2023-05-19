package structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import protagonist.Personnage;
import structure.Piece;
import structure.Porte;

/**
 * 
 * Cette classe représente un labyrinthe dans lequel un personnage peut se
 * déplacer.
 * 
 * Le labyrinthe est défini par une grille de pièces.
 * 
 * La pièce d'entrée est également définie pour le labyrinthe.
 * 
 * La classe implémente l'interface Serializable pour permettre la sauvegarde et
 * la restauration de l'objet.
 */
public class Labyrinthe implements Serializable {
	private Piece entree;
	private Piece[][] grille;
	private Personnage perso;

	/**
	 * 
	 * Constructeur de la classe Labyrinthe. Crée une grille de pièces carrée de
	 * taille donnée en paramètre. Le personnage donné en paramètre est également
	 * initialisé pour le labyrinthe.
	 * 
	 * @param taille La taille de la grille de pièces carrée.
	 * @param perso  Le personnage à initialiser pour le labyrinthe.
	 */
	public Labyrinthe(int taille, Personnage perso) {
		grille = new Piece[taille][taille];
		this.setPerso(perso);
	}

	/**
	 * 
	 * Cette méthode permet d'ajouter une pièce à la grille de pièces du labyrinthe
	 * aux coordonnées (x, y).
	 * 
	 * @param x     La coordonnée x où ajouter la pièce dans la grille.
	 * @param y     La coordonnée y où ajouter la pièce dans la grille.
	 * @param piece La pièce à ajouter dans la grille.
	 */
	public void ajouterPiece(int x, int y, Piece piece) {
		grille[x][y] = piece;
	}

	/**
	 * 
	 * Cette méthode permet de définir la pièce d'entrée du labyrinthe en utilisant
	 * les coordonnées (x, y) de la grille.
	 * 
	 * @param x La coordonnée x de la pièce d'entrée dans la grille.
	 * @param y La coordonnée y de la pièce d'entrée dans la grille.
	 */
	public void setEntree(int x, int y) {
		entree = grille[x][y];
	}

	/**
	 * 
	 * Cette méthode permet de récupérer la pièce d'entrée du labyrinthe.
	 * 
	 * @return La pièce d'entrée du labyrinthe.
	 */
	public Piece getEntree() {
		return entree;
	}

	/**
	 * 
	 * Cette méthode permet de récupérer la grille de pièces du labyrinthe.
	 * 
	 * @return La grille de pièces du labyrinthe.
	 */
	public Piece[][] getGrille() {
		return grille;
	}

	/**
	 * 
	 * Cette méthode permet de récupérer la pièce à la position (x, y) dans la
	 * grille de pièces du labyrinthe.
	 * 
	 * @param x La coordonnée x de la pièce dans la grille.
	 * @param y La coordonnée y de la pièce dans la grille.
	 * @return La pièce à la position (x, y) dans la grille de pièces du labyrinthe.
	 */
	public Piece getPiece(int x, int y) {
		return grille[x][y];
	}

	/**
	 * 
	 * Cette méthode permet de modifier la pièce à la position (x, y) dans la grille
	 * de pièces du labyrinthe.
	 * 
	 * @param x     La coordonnée x de la pièce dans la grille.
	 * @param y     La coordonnée y de la pièce dans la grille.
	 * @param piece La nouvelle pièce à mettre à la position (x, y) dans la grille
	 *              de pièces du labyrinthe.
	 */
	public void setPiece(int x, int y, Piece piece) {
		grille[x][y] = piece;
	}

	/**
	 * Ajoute une porte entre deux pièces adjacentes dans la grille du labyrinthe.
	 *
	 * @param x1 la position en abscisse de la première pièce.
	 * @param y1 la position en ordonnée de la première pièce.
	 * @param x2 la position en abscisse de la seconde pièce.
	 * @param y2 la position en ordonnée de la seconde pièce.
	 */
	public void ajouterPorte(int x1, int y1, int x2, int y2) {
		// Création de la porte reliant les deux pièces
		Porte porte = new Porte(grille[x1][y1], grille[x2][y2]);

		// Ajout de la porte dans les listes de portes des pièces adjacentes
		if (x1 == x2 && y1 < y2) { // la porte relie les pièces vers l'est
			grille[x1][y1].setPorteNord(porte);
			grille[x2][y2].setPorteSud(porte);
		} else if (x1 == x2 && y1 > y2) { // la porte relie les pièces vers l'ouest
			grille[x1][y1].setPorteSud(porte);
			grille[x2][y2].setPorteNord(porte);
		} else if (y1 == y2 && x1 < x2) { // la porte relie les pièces vers le sud
			grille[x1][y1].setPorteEst(porte);
			grille[x2][y2].setPorteOuest(porte);
		} else if (y1 == y2 && x1 > x2) { // la porte relie les pièces vers le nord
			grille[x1][y1].setPorteOuest(porte);
			grille[x2][y2].setPorteEst(porte);
		}
	}

	/**
	 * 
	 * Supprime la porte qui relie deux pièces données par leurs coordonnées dans la
	 * grille.
	 * 
	 * @param x1 la coordonnée x de la première pièce
	 * @param y1 la coordonnée y de la première pièce
	 * @param x2 la coordonnée x de la deuxième pièce
	 * @param y2 la coordonnée y de la deuxième pièce
	 */
	public void SupprimerPorte(int x1, int y1, int x2, int y2) {
		if (x1 == x2 && y1 < y2) { // la porte relie les pièces vers l'est
			grille[x1][y1].SupprimerPorteNord();
			grille[x2][y2].SupprimerPorteSud();
		} else if (x1 == x2 && y1 > y2) { // la porte relie les pièces vers l'ouest
			grille[x1][y1].SupprimerPorteSud();
			grille[x2][y2].SupprimerPorteNord();
		} else if (y1 == y2 && x1 < x2) { // la porte relie les pièces vers le sud
			grille[x1][y1].SupprimerPorteEst();
			grille[x2][y2].SupprimerPorteOuest();
		} else if (y1 == y2 && x1 > x2) { // la porte relie les pièces vers le nord
			grille[x1][y1].SupprimerPorteOuest();
			grille[x2][y2].SupprimerPorteEst();
		}
	}

	/**
	 * 
	 * Supprime toutes les portes de la pièce située aux coordonnées x1, y1. Si la
	 * pièce possède une porte à l'est, elle est supprimée ainsi que la porte
	 * correspondante de la pièce à l'est. Si la pièce possède une porte au nord,
	 * elle est supprimée ainsi que la porte correspondante de la pièce au nord. Si
	 * la pièce possède une porte à l'ouest, elle est supprimée ainsi que la porte
	 * correspondante de la pièce à l'ouest. Si la pièce possède une porte au sud,
	 * elle est supprimée ainsi que la porte correspondante de la pièce au sud.
	 * 
	 * @param x1 Coordonnée x de la pièce dont on veut supprimer toutes les portes.
	 * @param y1 Coordonnée y de la pièce dont on veut supprimer toutes les portes.
	 */
	public void SupprimerTouteLesPortes(int x1, int y1) {
		if (grille[x1][y1].getPorteEst() != null) {
			grille[x1][y1].setPorteEst(null);
			grille[x1 + 1][y1].setPorteOuest(null);
		} else if (grille[x1][y1].getPorteNord() != null) {
			grille[x1][y1].setPorteNord(null);
			grille[x1][y1 + 1].setPorteSud(null);
		} else if (grille[x1][y1].getPorteOuest() != null) {
			grille[x1][y1].setPorteOuest(null);
			grille[x1 - 1][y1].setPorteEst(null);
		} else if (grille[x1][y1].getPorteSud() != null) {
			grille[x1][y1].setPorteSud(null);
			grille[x1][y1 - 1].setPorteNord(null);
		}
	}

	/**
	 * 
	 * Retourne le personnage présent dans le labyrinthe.
	 * 
	 * @return le personnage présent dans le labyrinthe
	 */
	public Personnage getPerso() {
		return perso;
	}

	/**
	 * 
	 * Modifie le personnage présent dans le labyrinthe.
	 * 
	 * @param perso le nouveau personnage à placer dans le labyrinthe
	 */
	public void setPerso(Personnage perso) {
		this.perso = perso;
	}

}
