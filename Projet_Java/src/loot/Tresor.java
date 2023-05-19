package loot;

import java.io.Serializable;
import java.util.Random;

import protagonist.Protagonist;

/**
 * La classe Tresor représente un objet qui peut être possédé par un personnage
 * du jeu. Un trésor a un certain niveau et peut être possédé par un
 * protagoniste. Un trésor peut être de plusieurs natures : arme, armure,
 * potion, etc.
 */
public class Tresor implements Serializable {
	/**
	 * Le niveau du trésor.
	 */
	private int niveaux;
	/**
	 * Le protagoniste qui possède le trésor.
	 */
	private Protagonist proprietaire;
	/**
	 * La nature du trésor.
	 */
	private String nature;

	/**
	 * Constructeur de la classe Tresor. Initialise la nature du trésor avec le
	 * paramètre nature, et le niveau avec un nombre aléatoire entre 1 et 5.
	 * 
	 * @param nature       La nature du trésor.
	 * @param proprietaire Le protagoniste qui possède le trésor.
	 */
	public Tresor(String nature, Protagonist proprietaire) {
		this.nature = nature;
		this.setProprietaire(proprietaire);
		Random random = new Random();
		this.niveaux = random.nextInt(5) + 1;
	}

	/**
	 * Getter pour l'attribut niveaux.
	 * 
	 * @return Le niveau du trésor.
	 */
	public int getNiveaux() {
		return niveaux;
	}

	/**
	 * Setter pour l'attribut niveaux.
	 * 
	 * @param niveaux Le nouveau niveau du trésor.
	 */
	public void setNiveaux(int niveaux) {
		this.niveaux = niveaux;
	}

	/**
	 * Getter pour l'attribut proprietaire.
	 * 
	 * @return Le protagoniste qui possède le trésor.
	 */
	public Protagonist getProprietaire() {
		return proprietaire;
	}

	/**
	 * Setter pour l'attribut proprietaire.
	 * 
	 * @param proprietaire Le nouveau protagoniste qui possède le trésor.
	 */
	public void setProprietaire(Protagonist proprietaire) {
		this.proprietaire = proprietaire;
	}

	/**
	 * Getter pour l'attribut nature.
	 * 
	 * @return La nature du trésor.
	 */
	public String getNature() {
		return nature;
	}

	/**
	 * Setter pour l'attribut nature.
	 * 
	 * @param nature La nouvelle nature du trésor.
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}

	/**
	 * Méthode qui indique si le trésor est pris par un protagoniste ou non.
	 * 
	 * @return "Oui" si le trésor est pris, "Non" sinon.
	 */
	public String estPris() {
		if (this.getProprietaire() != null) {
			return " Oui ";
		} else {
			return " Non ";
		}
	}

	/**
	 * Méthode qui libère le trésor, en le rendant disponible pour être pris par un
	 * autre protagoniste.
	 */
	public void lacher() {
		this.setProprietaire(null);

	}

	/**
	 * 
	 * Supprime la référence au trésor passé en paramètre en la mettant à null.
	 * 
	 * @param tresor le trésor à supprimer
	 */
	public void supprimer(Tresor tresor) {
		tresor = null;
	}

}
