package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import latice.application.Game;
import latice.ihm.view.BoardFX;
import latice.model.Player;
import latice.model.Position;
import latice.model.Tile;

public class DnDController {

	
	
	public static void menageSourceDragAndDrop(ImageView source, Integer positionTile) {

		source.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				Dragboard db = source.startDragAndDrop(TransferMode.ANY);
				db.setDragView(source.getImage(), 0, 0);
				ClipboardContent content = new ClipboardContent();
				content.putString(positionTile.toString());
				db.setContent(content);

				event.consume();
			}
		});
		
	}

	public static void menageTargetDragAndDrop(HBox target, BoardFX boardFX, Position pos) {

		target.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				if (event.getGestureSource() != target && event.getDragboard().hasString()) {
					event.acceptTransferModes(TransferMode.ANY);
				}
			}
		});

		target.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {

				Game game = Game.getInstance();
				
				Dragboard db = event.getDragboard();
				Integer positionTile = Integer.parseInt(db.getString());
				Player player = null;
				
				if(game.getPlayerTurn()) {
					player = game.getPlayer1();
				} else {
					player = game.getPlayer2();
				}
				
				Tile tile = player.getRack().get(positionTile);
				
				if(game.getBoard().put(pos, tile)) {
					player.setPoint(game.getBoard().sumpoint(pos, player.getPoint()));
					ImageView img = ((ImageView)event.getGestureSource());			
					target.getChildren().clear();
					target.getChildren().add(img);
				}
				
			}
		});
	}
}
