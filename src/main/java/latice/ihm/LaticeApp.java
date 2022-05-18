package latice.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;
import latice.ihm.view.Menu;

public class LaticeApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader contentFxmlLoader = new FXMLLoader(getClass().getResource("view/MenuApplication.fxml"));

		//contentFxmlLoader.load()
		Scene scene = new Scene(new Menu());
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Logo.png")));
		primaryStage.setTitle("Latice Game DxD version");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
