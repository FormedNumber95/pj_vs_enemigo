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
    
    /** El pj. */
    private PJ pj;
    
    /** El enemigo. */
    private Enemigo enemigo;
    
    /**
     * Codigo.
     *
     * @param stage el stage
     */
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {
    	//declaracion de variables
        pj=new PJ();
        enemigo=new Enemigo();
        Label lblPj=new Label("PJ:		");
        Label lblEnemigo=new Label("Enemigo:	");
        Button btnTirarDado=new Button("Tirar dado");
        //declaracion de contenedores
        VBox vbox=new VBox();
        HBox hPj=new HBox();
        HBox hEnemigo=new HBox();
        //Eventos
        btnTirarDado.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int tirEnemigo;
				int tirPj;
				do {
					tirEnemigo=enemigo.TirarDado();
					tirPj=pj.TirarDado();
				}while(tirEnemigo==tirPj);
				if(tirEnemigo>tirPj) {
					pj.reducirVida();
				}
				else {
					enemigo.reducirVida();
				}
				if(Integer.parseInt(enemigo.getPg().getText())==0||
						Integer.parseInt(pj.getPg().getText())==0) {
					btnTirarDado.setDisable(true);
				}
			}
		});
        //aniadir a los contenedores
        hPj.getChildren().addAll(lblPj,pj.getPg());
        hEnemigo.getChildren().addAll(lblEnemigo,enemigo.getPg());
        vbox.getChildren().addAll(hPj,hEnemigo,btnTirarDado);
        //aniadir a la escena y visualizar
        Scene scene=new Scene(vbox);
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
