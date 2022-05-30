package latice.ihm.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import latice.ihm.controller.DnDController;
import latice.model.Tile;

public class RackFX extends HBox{

	private ImageView image;
	private int i = 0;
	
	public RackFX(ArrayList<Tile> list) {

		for (Tile tile : list) {
	
			this.image = new ImageView(new Image(getClass().getResourceAsStream("/tiles/" + tile.toString() + ".png")));
			this.image.setPreserveRatio(true);
			this.image.setFitWidth(80);
			DnDController.menageSourceDragAndDrop(image, i);
			this.getChildren().add(image);
			i ++;
		}
		this.setSpacing(10);
		HBox.setMargin(this, new Insets(30, 30, 30, 30));
	}
	
}
