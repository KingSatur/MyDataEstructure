package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	private Stage escenario;
	private Scene escena;
	private VBox vertical;
	private HBox horizontal;
	private ProgressBar barra;
	private ProgressIndicator indicador;
	private Button boton;
	private Concurrencia concurrencia1, concurrencia2;
	private Label label;
	
	
	@Override
	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		iniciarVentana(primaryStage);
	}
	
	public void iniciarVentana(Stage window) {
		escenario = window;
		barra = new ProgressBar();
		indicador = new ProgressIndicator();
//		horizontal = new HBox();
//		horizontal.setAlignment(Pos.CENTER);
//		horizontal.setSpacing(50);
//		horizontal.setId("Contenedor horizontal");
//		horizontal.getChildren().add(indicador);
//		horizontal.getChildren().add(barra);
		Pane panel = new Pane();
		barra.setLayoutX(700);
		barra.setLayoutY(200);
		indicador.setLayoutX(200);
		panel.getChildren().add(indicador);
		panel.getChildren().add(barra);
		escena = new Scene(panel, 900,500);
		escenario.setResizable(false);
		escenario.setScene(escena);
		escenario.show();
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
