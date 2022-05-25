package latice.ihm.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import latice.ihm.controller.ReturnController;

public class Parameters extends VBox{

	private Label lblVolume;
	private Label lblSong;
	private Button btnReturn;
	private Slider sliderVolume;
	
	public Parameters(MenuFX menu) {
		
		this.lblVolume = new Label("Volume");
		this.lblSong = new Label("Changer de son d'ambiance");
		this.btnReturn = new Button("Retour");
		this.btnReturn.setOnMouseClicked(new ReturnController(menu));
		
		this.sliderVolume = new Slider(0, 1, 0.1); 
		
		this.setSpacing(10);
		this.getChildren().addAll(lblSong, lblVolume, btnReturn, sliderVolume);
		
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, getInsets())));
		this.setAlignment(Pos.CENTER);
		this.setMaxSize(500,500);
	}
}
