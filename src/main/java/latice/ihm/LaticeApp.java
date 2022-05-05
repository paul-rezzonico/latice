package latice.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaticeApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		Parent content = FXMLLoader.load(getClass().getResource("view/LaticeApplication.fxml"));
		root.setCenter(content);
		
		Scene scene = new Scene(root); 
		primaryStage.setScene(scene); 
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
