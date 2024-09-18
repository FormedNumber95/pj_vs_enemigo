package es.aketzagonzalez.pj_vs_enemigo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * Clase MainApp.
 */
public class MainApp extends Application {
    
    /** El stage. */
    @SuppressWarnings("unused")
	private static Stage stage;
    
    /** El Personaje Jugador. */
    private PersonajeJugador personajeJugador;
    
    /** El enemigo. */
    private Enemigo enemigo;
    
    /**
     * Ejecuta el juego. Crea es stage y los personajes y hace la ventana.
     * La ventana tiene un boton el cual hace que se tiren los dados.
     *
     * @param stage el stage
     */
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {
    	//declaracion de variables
        personajeJugador=new PersonajeJugador();
        enemigo=new Enemigo();
        Label lblPersonajeJugador=new Label("Personaje Jugador:	");
        Label lblEnemigo=new Label("Enemigo:			");
        Text textoVidaPersonajeJugador=new Text(personajeJugador.getVida()+"");
        Text textoVidaEnemigo=new Text(enemigo.getVida()+"");
        Button btnTirarDado=new Button("Tirar dado");
        //declaracion de contenedores
        VBox vbox=new VBox();
        HBox hPersonajeJugador=new HBox();
        HBox hEnemigo=new HBox();
        //Eventos
        btnTirarDado.setOnAction(e -> EventoTirarDado(textoVidaPersonajeJugador,textoVidaEnemigo,btnTirarDado));
        //aniadir a los contenedores
        hPersonajeJugador.getChildren().addAll(lblPersonajeJugador,
        		textoVidaPersonajeJugador);
        hEnemigo.getChildren().addAll(lblEnemigo,textoVidaEnemigo);
        vbox.getChildren().addAll(hPersonajeJugador,hEnemigo,btnTirarDado);
        //aniadir a la escena y visualizar
        Scene scene=new Scene(vbox,250,100);
        stage.setTitle("Personaje Jugador vs Enemigo");
        stage.setScene(scene);
        stage.show();
    }

	/**
	 * Evento que tira los dados y repite la tirada mientras salga el mismo 
	 * resultado en ambos, luego compara cual es mas grande y el que tenga el 
	 * menor numero en la tirada pierde un punto de vida
	 *
	 * @param textoVidaPersonajeJugador El texto de la vida personaje jugador
	 * @param textoVidaEnemigo El texto de lavida enemigo
	 * @param btnTirarDado El boton que tira el dado
	 */
	private void EventoTirarDado(Text textoVidaPersonajeJugador, Text textoVidaEnemigo, Button btnTirarDado) {
		int tiradaEnemigo;
		int tiradaPersonajeJugador;
		do {
			tiradaEnemigo=enemigo.TirarDado();
			tiradaPersonajeJugador=personajeJugador.TirarDado();
		}while(tiradaEnemigo==tiradaPersonajeJugador);
		if(tiradaEnemigo>tiradaPersonajeJugador) {
			personajeJugador.reducirVida();
			textoVidaPersonajeJugador.setText(
					personajeJugador.getVida()+"");
		}
		else {
			enemigo.reducirVida();
			textoVidaEnemigo.setText(enemigo.getVida()+"");
		}
		if(enemigo.getVida()==0||personajeJugador.getVida()==0){
			btnTirarDado.setDisable(true);
		}
	}

	/**
	 * Donde se ejecuta el codigo.
	 *
	 * @param args los argumentos que recibe la main, vacio
	 */
	public static void main(String[] args) {
        launch(args);
    }
	

}
