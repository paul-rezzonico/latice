package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import latice.application.Game;

public class ChangeRackController implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		Game game = Game.getInstance();
		if(game.getPlayerTurn() && game.getPlayer1().getPtsFree()) {
			game.getPlayer1().changeRack();
			game.endTurn();
		} else if((!game.getPlayerTurn()) && game.getPlayer2().getPtsFree()) {
			game.getPlayer2().changeRack();
			game.endTurn();
		} else {
			AudioClip objection = new AudioClip(getClass().getResource("/music/Objection.mp3").toExternalForm());
			objection.play();
			
			ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/Objection.gif"), 100, 100, true, true));
			
			img.setOnMouseClicked(new ObjectionController());
			
			Alert dialog = new Alert(AlertType.ERROR);
			dialog.setTitle("Changement de rack");
			dialog.setHeaderText(null);
			dialog.setContentText("Vous ne pouvez pas changer de rack après avoir joué");
			dialog.initOwner(((Node)event.getSource()).getScene().getWindow() );
			dialog.setGraphic(img);
			dialog.showAndWait();
		}
	}

}
