package test;

import combat.Combat;
import protagonist.Monstre;
import protagonist.Personnage;
import protagonist.Protagonist;
import structure.Labyrinthe;
import structure.Piece;

public class TestPartie2_Combat {
	public static void main(String[] args) {
		Labyrinthe etage1 = new Labyrinthe(4,null);
		Piece entree = new Piece("Entrée", true,false);
		Personnage polo = new Personnage("polo", entree , etage1);
		etage1.setPerso(polo);
		if(entree.isMonstre()) {
			Combat combat1 = new Combat(polo, entree.getMob());
			combat1.commencer();
		}
			
			
		
	}

	

}
