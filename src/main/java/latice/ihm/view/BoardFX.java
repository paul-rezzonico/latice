package latice.ihm.view;

import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import latice.model.Board;
import latice.model.Box;
import latice.model.Position;

public class BoardFX extends GridPane{
	
	private String pictureURL;
	private ImageView boxImage;
	
	public BoardFX(Board board) {
		for (Map.Entry<Position, Box> entry : board.getGameBoard().entrySet()) {
			
			if(entry.getValue().getTile() != null) {
				this.pictureURL = "/tiles/" + entry.getValue().getTile().toString() + ".png";
			} else {
				this.pictureURL = "/Shape/" + entry.getValue().getShape().getName() + ".png";
			}
	
			this.boxImage = new ImageView(new Image(getClass().getResourceAsStream(pictureURL)));
			this.boxImage.setPreserveRatio(true);
			this.boxImage.setFitWidth(80);
			this.add(boxImage, entry.getKey().getColumn()-1, entry.getKey().getRow()-1);
			this.setStyle("-fx-grid-lines-visible: true");
		}
	}
	
}
