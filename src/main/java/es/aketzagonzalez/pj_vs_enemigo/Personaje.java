package es.aketzagonzalez.pj_vs_enemigo;

import javafx.scene.text.Text;

/**
 * Clase Personaje.
 */
public class Personaje {
	
	/** Los puntos de vida */
	private int vida=10;
	
	/**
	 * Tira 1d10.
	 *
	 * @return el valor que ha salido en el d10
	 */
	int TirarDado() {
		return (int)(Math.random()*10)+1;
	}
	
	/**
	 * Reduce en 1 la vida del personaje
	 */
	void reducirVida() {
		this.vida--;
	}
	
	/**
	 * getter de vida 
	 *
	 * @return el Text de los vida del personaje
	 */
	public int getVida() {
		return this.vida;
	}
	
}
