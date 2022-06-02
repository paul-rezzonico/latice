package latice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import latice.ihm.controller.ExitController;
import latice.ihm.controller.ParametersController;
import latice.ihm.controller.PlayController;
import latice.ihm.view.MenuFX;

public class Latice extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MenuFX menu = new MenuFX();
		Scene scene = new Scene(menu);
		menu.getBtnExit().setOnMouseClicked(new ExitController());
		menu.getBtnGame().setOnMouseClicked(new PlayController(primaryStage, menu));
		menu.getBtnParameters().setOnMouseClicked(new ParametersController(menu));
		
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Logo.png")));
		primaryStage.setTitle("Latice Game DxD edition");
		primaryStage.setFullScreenExitHint("");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
