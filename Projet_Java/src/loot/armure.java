package loot;

import java.io.Serializable;

/**
 * La classe armure représente un type de trésor qui peut être obtenu dans le
 * jeu. Elle hérite de la classe Tresor. Elle est utilisée pour fournir une
 * protection supplémentaire au personnage.
 */

public class armure extends Tresor implements Serializable {
	/**
	 * Constructeur de la classe armure qui utilise le constructeur de la classe
	 * Tresor pour initialiser son nom et sa description.
	 */
	public armure() {
		super("armure", null);
		// TODO Auto-generated constructor stub
	}

}
