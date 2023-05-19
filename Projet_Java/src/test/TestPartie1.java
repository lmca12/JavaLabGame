package test;

import java.util.ArrayList;
import java.util.Scanner;

import protagonist.Personnage;
import structure.Labyrinthe;
import structure.Piece;
import structure.Porte;
import vue.Clavier;

public class TestPartie1 {

	public static void main(String[] args) {
		// Création du labyrinthe
        Labyrinthe labyrinthe = new Labyrinthe(4,null);
        
     // Création des pièces
        Piece piece1 = new Piece("Pièce 1",false,false);
        Piece piece2 = new Piece("Pièce 2",true,false);
        Piece piece3 = new Piece("Pièce 3",true,false);
        Piece piece4 = new Piece("Pièce 4",true,false);
        Piece piece5 = new Piece("Pièce 5",true,false);
        Piece piece6 = new Piece("Pièce 6",true,false);
        Piece piece7 = new Piece("Pièce 7",true,false);
        Piece piece8 = new Piece("Pièce 8",true,false);
        Piece piece9 = new Piece("Pièce 9",true,false);
        Piece piece10 = new Piece("Pièce 10",true,false);
     // Ajout des pieces
        labyrinthe.ajouterPiece(0, 0, piece1);
        labyrinthe.ajouterPiece(0, 1, piece2);
        labyrinthe.ajouterPiece(0, 2, piece3);
        labyrinthe.ajouterPiece(1, 1, piece4);
        labyrinthe.ajouterPiece(1, 0, piece5);
        labyrinthe.ajouterPiece(2, 2, piece6);
        labyrinthe.ajouterPiece(2, 1, piece7);
        labyrinthe.ajouterPiece(3, 2, piece8);
        
     // Ajout des portes
        labyrinthe.ajouterPorte(0, 0, 0, 1);
        labyrinthe.ajouterPorte(0, 1, 1, 1);
        labyrinthe.ajouterPorte(0, 2, 0, 1);
        labyrinthe.ajouterPorte(0, 0, 1, 0);
        labyrinthe.ajouterPorte(2, 2, 2, 1);
        labyrinthe.ajouterPorte(2, 2, 3, 2);
        labyrinthe.ajouterPorte(1, 1, 2, 1);
        
     // Définition de l'entrée du labyrinthe
        labyrinthe.setEntree(0, 0);

        // Création du personnage
        System.out.print("Quel est votre nom ? ");
        String nomPersonnage = Clavier.entrerClavierString();
        Personnage personnage = new Personnage(nomPersonnage, labyrinthe.getEntree(),labyrinthe);
        labyrinthe.setPerso(personnage);

        // Déplacement du personnage
        personnage.seDeplacer();
        
        //top E left N right S and down O
        
	}
}
