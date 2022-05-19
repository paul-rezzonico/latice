package latice.ihm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import latice.ihm.view.MenuFX;

public class LaticeApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene scene = new Scene(new MenuFX(primaryStage));
		
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Logo.png")));
		primaryStage.setTitle("Latice Game DxD edition");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
