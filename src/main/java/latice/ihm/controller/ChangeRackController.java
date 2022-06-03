package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import latice.application.Game;
import latice.ihm.view.MenuFX;

public class ChangeRackController implements EventHandler<MouseEvent>{

	private Stage primaryStage;
	
	public ChangeRackController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void handle(MouseEvent event) {
		Game game = Game.getInstance();
		
		if(game.getPlayerTurn() && (game.getPlayer1().getPoint()>=2 || game.getPlayer1().getPtsFree())) {
			
			if(!game.getPlayer1().getPtsFree()) {
				game.getPlayer1().setPoint(game.getPlayer1().getPoint()-2);
				game.getPlayFX().getLblPointJ1().setText("Vous avez actuellement " + game.getPlayer1().getPoint() + " points");
			} 
			
			game.getPlayer1().clearRack();
			game.endTurn();
			
			victory(event, game);
			
		} else if((!game.getPlayerTurn()) && (game.getPlayer2().getPoint()>=2 || game.getPlayer2().getPtsFree())) {
			
			if(!game.getPlayer2().getPtsFree()) {
				game.getPlayer2().setPoint(game.getPlayer2().getPoint()-2);
				game.getPlayFX().getLblPointJ2().setText("Vous avez actuellement " + game.getPlayer2().getPoint() + " points");
			} 
			
			game.getPlayer2().clearRack();
			game.endTurn();
			
			victory(event, game);
			
		} else {
			AudioClip objection = new AudioClip(getClass().getResource("/music/Objection.mp3").toExternalForm());
			objection.play();
		
			ImageView img = new ImageView(new Image(getClass().getResourceAsStream("/Objection.gif"), 100, 100, true, true));
			
			img.setOnMouseClicked(new ObjectionController());
			
			Alert dialog = new Alert(AlertType.ERROR);
			dialog.setTitle("Changement de rack");
			dialog.setHeaderText(null);
			dialog.setContentText("Il vous faut au moins deux points pour pouvoir changer de rack");
			dialog.initOwner(((Node)event.getSource()).getScene().getWindow() );
			dialog.setGraphic(img);
			dialog.showAndWait();
		}
	}
	
	private void victory(MouseEvent event, Game game) {
		if(game.getPlayer1().getStack().isEmpty() || game.getPlayer2().getStack().isEmpty() || game.getTurn() > 20) {
			
			game.getPlayFX().getSong().stop();
			String victorie;
			if(game.isATie()) {
				victorie = "C'est une égalité !";
			} else {
				victorie = game.calculateWinner().getName() + " à gagné, bravo !";
			}
			
			//TODO personnalisé la fenetre ?
			Alert dialog = new Alert(AlertType.INFORMATION);
			dialog.setTitle("Fin de partie !");
			dialog.setHeaderText("La partie est fini !");
			dialog.setContentText(victorie);
			dialog.initOwner(primaryStage.getScene().getWindow() );
			//dialog.setGraphic(img);
			dialog.showAndWait();
			
			MenuFX menu = new MenuFX();
			this.primaryStage.getScene().setRoot(menu);
			menu.getBtnExit().setOnMouseClicked(new ExitController());
			menu.getBtnGame().setOnMouseClicked(new PlayController(primaryStage, menu));
			menu.getBtnParameters().setOnMouseClicked(new ParametersController(menu));
			
		}

	}
}
