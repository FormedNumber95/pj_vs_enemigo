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

/**
 * Clase MainApp.
 */
public class MainApp extends Application {
    
    /** El stage. */
    private static Stage stage;
    
    /** El PersonajeJugador. */
    private PersonajeJugador personajeJugador;
    
    /** El enemigo. */
    private Enemigo enemigo;
    
    /**
     * Ejecuta el juego.
     *
     * @param stage el stage
     */
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {
    	//declaracion de variables
        personajeJugador=new PersonajeJugador();
        enemigo=new Enemigo();
        Label lblPersonajeJugador=new Label("PersonajeJugador:	");
        Label lblEnemigo=new Label("Enemigo:			");
        Button btnTirarDado=new Button("Tirar dado");
        //declaracion de contenedores
        VBox vbox=new VBox();
        HBox hPersonajeJugador=new HBox();
        HBox hEnemigo=new HBox();
        //Eventos
        btnTirarDado.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int tirEnemigo;
				int tirPersonajeJugador;
				do {
					tirEnemigo=enemigo.TirarDado();
					tirPersonajeJugador=personajeJugador.TirarDado();
				}while(tirEnemigo==tirPersonajeJugador);
				if(tirEnemigo>tirPersonajeJugador) {
					personajeJugador.reducirVida();
				}
				else {
					enemigo.reducirVida();
				}
				if(Integer.parseInt(enemigo.getPg().getText())==0||
						Integer.parseInt(personajeJugador.getPg().getText())==0) {
					btnTirarDado.setDisable(true);
				}
			}
		});
        //aniadir a los contenedores
        hPersonajeJugador.getChildren().addAll(lblPersonajeJugador,personajeJugador.getPg());
        hEnemigo.getChildren().addAll(lblEnemigo,enemigo.getPg());
        vbox.getChildren().addAll(hPersonajeJugador,hEnemigo,btnTirarDado);
        //aniadir a la escena y visualizar
        Scene scene=new Scene(vbox,250,100);
        stage.setTitle("PersonajeJugador vs Enemigo");
        stage.setScene(scene);
        stage.show();
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
