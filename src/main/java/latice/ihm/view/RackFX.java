package latice.ihm.view;

import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import latice.ihm.controller.DnDController;
import latice.model.Tile;

public class RackFX extends HBox{

	private ImageView image;
	
	public RackFX(List<Tile> list) {
		
		this.fillRackFX(list);
		this.setSpacing(12);
		HBox.setMargin(this, new Insets(30, 30, 30, 30));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, null, getInsets())));
		this.setPrefWidth(450);
	}
	
	public void fillRackFX(List<Tile> list) {
		
		int i = 0;

		this.getChildren().clear();
		
		String url;
		
		for (Tile tile : list) {
			
			if(tile != null) {
				url = "/tiles/" + tile.toString() + ".png";
			} else {
				url = "/tiles/Vide.png";
			}
			this.image = new ImageView(new Image(getClass().getResourceAsStream(url)));
			this.image.setPreserveRatio(true);
			this.image.setFitWidth(80);
			DnDController.menageSourceDragAndDrop(image, i);
			this.getChildren().add(image);
			i ++;
		}
	}
	
}
