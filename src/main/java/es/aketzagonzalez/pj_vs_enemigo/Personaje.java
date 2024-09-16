package es.aketzagonzalez.pj_vs_enemigo;

import javafx.scene.text.Text;

/**
 * Clase Personaje.
 */
public class Personaje {
	
	/** El texto de los pg. */
	private Text pg=new Text("10");
	
	/**
	 * Tira 1d10.
	 *
	 * @return el valor que ha salido en el d10
	 */
	int TirarDado() {
		return (int)(Math.random()*10)+1;
	}
	
	/**
	 * Reduce en 1 los pg del personaje
	 */
	void reducirVida() {
		this.pg.setText(""+(Integer.parseInt(pg.getText())-1));
	}
	
	/**
	 * getter de pg 
	 *
	 * @return el Text de los pg del personaje
	 */
	public Text getPg() {
		return pg;
	}
	
}
