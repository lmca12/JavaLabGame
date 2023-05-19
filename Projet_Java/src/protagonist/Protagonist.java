package protagonist;

import java.io.Serializable;

import loot.Tresor;
import loot.arme;
import loot.armure;
import vue.Clavier;

/**
 * 
 * Classe représentant le protagoniste du jeu.
 * 
 * Elle implémente l'interface Serializable pour permettre la sauvegarde et le
 * chargement du personnage.
 */
public class Protagonist implements Serializable {

// Variables d'instance
	private int vie; // La vie actuelle du personnage
	private int vieMax; // La vie maximale du personnage
	private int force; // La force du personnage
	private Tresor MonArmure; // L'armure du personnage
	private Tresor MonArme; // L'arme du personnage

	/**
	 * 
	 * Accesseur pour la vie du personnage.
	 * 
	 * @return la vie actuelle du personnage
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * 
	 * Retourne l'arme équipée par le personnage.
	 * 
	 * @return l'arme équipée par le personnage.
	 */
	public Tresor getMonArme() {
		return MonArme;
	}

	/**
	 * 
	 * Retourne l'armure équipée par le personnage.
	 * 
	 * @return l'armure équipée par le personnage.
	 */
	public Tresor getMonArmure() {
		return MonArmure;
	}

	/**
	 * 
	 * Modifie la vie actuelle du personnage.
	 * 
	 * @param vie la nouvelle vie du personnage.
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}

	/**
	 * 
	 * Cette méthode permet de faire perdre de la vie au protagoniste en fonction
	 * des dégâts infligés par un adversaire
	 * 
	 * Si le protagoniste possède une armure, les dégâts sont d'abord encaissés par
	 * l'armure, en fonction de son niveau de protection
	 * 
	 * Si la résistance de l'armure est supérieure aux dégâts infligés, l'armure
	 * protège le protagoniste et perd en niveaux de protection
	 * 
	 * Si la résistance de l'armure est inférieure ou égale aux dégâts infligés,
	 * l'armure est cassée et le protagoniste perd directement de la vie
	 * 
	 * Si le protagoniste ne possède pas d'armure, il perd directement de la vie
	 * 
	 * @param degatsPersonnage les dégâts infligés par l'adversaire
	 */
	public void perdreVie(int degatsPersonnage) {

		if (MonArmure != null) {
			int resistance = this.getVie() + this.MonArmure.getNiveaux();
			if (resistance - degatsPersonnage > this.getVie()) {
				int degatsArmure = (resistance - degatsPersonnage) - this.getVie();
				this.MonArmure.setNiveaux(degatsArmure);
				System.out
						.println("Votre Armure vous a proteger elle a " + this.MonArmure.getNiveaux() + " protection");
			} else if (resistance - degatsPersonnage <= this.getVie()) {
				this.MonArmure.setNiveaux(0);
				System.out.println("Votre Armure est casser ");
				this.lacherArmure();
				this.setVie(resistance - degatsPersonnage);
			}
		} else {
			this.setVie(vie - degatsPersonnage);
		}

	}

	/**
	 * 
	 * Modifie la valeur maximale de vie du protagoniste.
	 * 
	 * @param vieMax la nouvelle valeur maximale de vie
	 */
	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}

	/**
	 * 
	 * Renvoie la valeur maximale de vie du protagoniste.
	 * 
	 * @return la valeur maximale de vie du protagoniste
	 */
	public int getVieMax() {
		return vieMax;
	}

	/**
	 * 
	 * Augmente la vie du protagoniste de i points et modifie la valeur maximale de
	 * vie en conséquence.
	 * 
	 * @param i le nombre de points à ajouter à la vie du protagoniste
	 */
	public void gagnerVie(int i) {
		setVie(vie + i);
		this.vieMax = vieMax + i;
	}

	/**
	 * 
	 * Régénère la vie du protagoniste au maximum de sa valeur maximale.
	 */
	public void regagnerVieMax() {
		setVie(vieMax);
	}

	/**
	 * 
	 * Cette méthode retourne la force du personnage. Si le personnage possède une
	 * arme, la force retournée est la somme de la force de base du personnage et du
	 * niveau de l'arme. Sinon, la force de base du personnage est retournée.
	 * 
	 * @return La force du personnage.
	 */
	public int getForce() {
		if (MonArme != null) {
			return force + MonArme.getNiveaux();
		} else {
			return force;
		}
	}

	/**
	 * 
	 * Cette méthode permet de modifier la force du personnage.
	 * 
	 * @param force La nouvelle valeur de la force du personnage.
	 */
	public void setForce(int force) {
		this.force = force;
	}

	/**
	 * 
	 * Cette méthode permet au personnage de lâcher son armure. Si le personnage
	 * possède une armure, celle-ci est retirée et son propriétaire est défini comme
	 * null.
	 */
	public void lacherArmure() {
		if (MonArmure != null) {
			MonArmure.setProprietaire(null);
			MonArmure = null;
		}

	}

	/**
	 * 
	 * Cette méthode affiche les objets possédés par le personnage. Si le personnage
	 * possède une armure, la méthode affiche "Armure : Oui" et le nombre de points
	 * de protection fournis par cette armure. Sinon, la méthode affiche "Armure :
	 * Non". Si le personnage possède une arme, la méthode affiche "Arme : Oui" et
	 * les dégâts infligés par cette arme. Sinon, la méthode affiche "Arme : Non".
	 */
	public void AfficherPossesion() {
		String dir = "-------------- Votre stuff --------------\n";
		if (this.MonArmure != null) {
			dir = dir + "Armure : Oui Poin de Protection : " + this.MonArmure.getNiveaux() + "\n";
		} else {
			dir = dir + "Armure : Non \n";
		}
		if (this.MonArme != null) {
			dir = dir + "Arme : Oui Degat : " + this.MonArme.getNiveaux() + "\n";
		} else {
			dir = dir + "Arme : Non \n";
		}
		System.out.println(dir);
	}

	/**
	 * 
	 * Cette méthode permet au personnage de lâcher son arme. Si le personnage
	 * possède une arme, celle-ci est retirée et son propriétaire est défini comme
	 * null.
	 */
	public void lacherArme() {
		if (MonArme != null) {
			MonArme.setProprietaire(null);
			MonArme = null;
		}
	}

	/**
	 * 
	 * Cette méthode permet au personnage de prendre un trésor. Si le trésor est une
	 * arme, la méthode appelle la méthode lacherArme pour retirer l'arme actuelle
	 * du personnage, puis elle définie le personnage comme propriétaire de la
	 * nouvelle arme et stocke cette arme dans la variable MonArme. Si le trésor est
	 * une armure, la méthode appelle la méthode lacherArmure pour retirer l'armure
	 * actuelle du personnage, puis elle définie le personnage comme propriétaire de
	 * la nouvelle armure et stocke cette armure dans la variable MonArmure.
	 * 
	 * @param tresor Le trésor à prendre.
	 */
	public void prendreTresor(Tresor tresor) {
		if (tresor.getNature() == "arme") {
			lacherArme();
			tresor.setProprietaire(this);
			this.MonArme = tresor;
		} else {
			lacherArmure();
			tresor.setProprietaire(this);
			this.MonArmure = tresor;
		}
	}

}
