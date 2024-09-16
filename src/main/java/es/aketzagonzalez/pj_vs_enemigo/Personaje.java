package es.aketzagonzalez.pj_vs_enemigo;

import javafx.scene.text.Text;

/**
 * Clase Personaje.
 */
public class Personaje {
	
	/** El texto de los vida. */
	private Text vida=new Text("10");
	
	/**
	 * Tira 1d10.
	 *
	 * @return el valor que ha salido en el d10
	 */
	int TirarDado() {
		return (int)(Math.random()*10)+1;
	}
	
	/**
	 * Reduce en 1 los vida del personaje
	 */
	void reducirVida() {
		this.vida.setText(""+(Integer.parseInt(vida.getText())-1));
	}
	
	/**
	 * getter de vida 
	 *
	 * @return el Text de los vida del personaje
	 */
	public Text getVida() {
		return vida;
	}
	
}
