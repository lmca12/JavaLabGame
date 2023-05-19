package test;

import combat.Combat;
import loot.Tresor;
import protagonist.Personnage;
import structure.Labyrinthe;
import structure.Piece;

public class TestPartie3_Tresor {

	public static void main(String[] args) {
		
		Labyrinthe etage1 = new Labyrinthe(4,null);
		Piece entree = new Piece("Entrée", true, false);
		Personnage polo = new Personnage("polo", entree, etage1);
		etage1.setPerso(polo);
		Tresor arme1 = new Tresor("arme", polo);
		Tresor armure1 = new Tresor("armure", polo);
		polo.prendreTresor(arme1);
		polo.prendreTresor(armure1);
		if(entree.isMonstre()) {
			Combat combat1 = new Combat(polo, entree.getMob());
			combat1.commencer();
		}

	}

}
