package latice.ihm.view;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import latice.model.Tile;

public class RackFX extends HBox{

	private ArrayList<Tile> rack; 
	private ImageView image;
	
	public RackFX(ArrayList<Tile> list) {
		this.rack = list;
		
		for (Tile tile : list) {
	
			this.image = new ImageView(new Image(getClass().getResourceAsStream("/tiles/" + tile.toString() + ".png")));
			this.image.setPreserveRatio(true);
			this.image.setFitWidth(80);
			this.getChildren().add(image);
			
		}
	}
	
}
