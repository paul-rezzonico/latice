package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import latice.application.Game;
import latice.model.Player;
import latice.model.Position;
import latice.model.Tile;

public class DnDController {

	
	
	public static void menageSourceDragAndDrop(ImageView source, Integer positionTile) {

		source.setOnDragDetected(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				Dragboard db = source.startDragAndDrop(TransferMode.ANY);
				db.setDragView(source.getImage(), 40, 40);
				ClipboardContent content = new ClipboardContent();
				content.putString(positionTile.toString());
				content.putImage(source.getImage());
				db.setContent(content);

				event.consume();
			}
		});
		
	}

	public static void menageTargetDragAndDrop(ImageView target, Position pos) {

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
				Image image = db.getImage();
				Player player = null;
				
				if(game.getPlayerTurn()) {
					player = game.getPlayer1();
				} else {
					player = game.getPlayer2();
				}
				
				Tile tile = player.getRack().get(positionTile);
				boolean succes = false;
				
				if(player.getPtsFree() || player.getPoint() >= 2) {
					if((game.getBoard().put(pos, tile))) {
						
						player.getRack().set(positionTile, null);
						
						target.setImage(image);
						
						ImageView img = ((ImageView)event.getGestureSource());
						img.setImage(null);
						
						if(!player.getPtsFree()) {
							player.setPoint(player.getPoint()-2);
						} else {
							player.setPtsFree(false);
						}
				
						player.setPoint(game.getBoard().sumpoint(pos, player.getPoint()));
						
						if(game.getPlayerTurn()) {
							game.getPlayFX().getLblPointJ1().setText("Vous avez actuellement " + game.getPlayer1().getPoint() + " points");
						} else {
							game.getPlayFX().getLblPointJ2().setText("Vous avez actuellement " + game.getPlayer2().getPoint() + " points");
						}
						
						succes = true;
						
					}
				}
				event.setDropCompleted(succes);
				
			}
		});
	}
}
