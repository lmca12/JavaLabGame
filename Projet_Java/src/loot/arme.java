package loot;

import java.io.Serializable;

/**
 * 
 * Cette classe représente une arme qui peut être trouvée dans le jeu. Elle
 * hérite de la classe Tresor et implémente Serializable pour permettre la
 * sérialisation des objets.
 */

public class arme extends Tresor implements Serializable {
	/**
	 * Constructeur de la classe Arme qui initialise le nom à "arme".
	 */
	public arme() {
		super("arme", null);
		// TODO Auto-generated constructor stub
	}

}
