package combat;

import java.io.Serializable;
import java.util.Random;

import loot.Tresor;
import protagonist.Monstre;
import protagonist.Personnage;
import vue.Clavier;

/**
 * La classe Combat représente un combat entre un personnage et un monstre.
 */
public class Combat implements Serializable {
	private Personnage personnage;
	private Monstre monstre;
	private int tour;
	private Random random;

	/**
	 * Constructeur de la classe Combat.
	 * 
	 * @param personnage le personnage participant au combat
	 * @param monstre    le monstre contre lequel se déroule le combat
	 */
	public Combat(Personnage personnage, Monstre monstre) {
		this.personnage = personnage;
		this.monstre = monstre;
		this.tour = 1;
		this.random = new Random();
	}

	/**
	 * Méthode pour commencer le combat.
	 * 
	 * Le combat se déroule en alternant les tours entre le personnage et le
	 * monstre. Les actions possibles sont l'attaque du personnage et l'attaque du
	 * monstre. Le combat continue jusqu'à ce que la vie du personnage ou du monstre
	 * atteigne 0. Le personnage peut choisir de fuir le combat à tout moment.
	 */
	public void commencer() {
		System.out.println("Un combat débute avec un monstre !");
		personnage.fuire = false;
		while (personnage.getVie() > 0 && monstre.getVie() > 0) {
			System.out.println("Tour " + tour);
			int rand = random.nextInt(2); // génère un nombre aléatoire entre 0 et 1
			if (rand == 1) {
				System.out.println("Le monstre attaque !");
				int degats = monstre.getForce();
				System.out.println(personnage.getNom() + " -" + degats + " de vie");
				personnage.perdreVie(degats);
			} else {
				System.out.println("Le personnage attaque !");
				int degats = personnage.getForce();
				System.out.println("monstre -" + degats + " de vie");
				monstre.perdreVie(degats);
			}

			tour++;
			if (personnage.getVie() > 0 && monstre.getVie() <= 0) {
				personnage.Victoire();
				break;
			} else if (monstre.getVie() > 0 && personnage.getVie() <= 0) {
				System.out.println("Vous êtes mort.");
				break;
			} else {
				personnage.AfficherPossesion();
				System.out.println("Vie personnage : " + personnage.getVie() + "/" + personnage.getVieMax());
				System.out.println("Vie monstre : " + monstre.getVie() + "/" + monstre.getVieMax());
				System.out.println("Que voulez-vous faire ? (1 pour continuer, 2 pour fuir)");
				int choix = Clavier.entrerClavierInt();
				if (choix == 2) {
					System.out.println("Vous fuyez le combat.");
					personnage.setPositionActuelle(personnage.getPositionPrecedente());
					personnage.fuire = true;
					break;
				}
			}
		}

	}
}
