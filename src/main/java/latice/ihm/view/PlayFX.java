package latice.ihm.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;
import latice.application.Game;

public class PlayFX extends BorderPane {

	private BoardFX boardfx;
	private Button btnSkip; 
	private Label lblPointJ1;
	private Label lblPointJ2;
	private HBox rack;
	private Game game;
	
	public PlayFX(Game game) {
		
		this.game = game;
		this.setCenter(new BoardFX(game.getBoard()));
		
		this.rack =  new HBox(40);
		this.rack.getChildren().addAll(new RackFX(game.getPlayer1().getRack()), new RackFX(game.getPlayer2().getRack()));
		this.rack.setAlignment(Pos.CENTER);
		this.rack.setMaxHeight(300);
		this.setBottom(rack);
		
		this.lblPointJ1 = new Label("Point du joueur 1 : " + game.getPlayer1().getPoint());
		this.lblPointJ1.setMaxWidth(200);
		this.lblPointJ1.setAlignment(Pos.CENTER);
		this.lblPointJ1.setTextAlignment(TextAlignment.CENTER);
		this.lblPointJ2 = new Label("Point du joueur 2 : " + game.getPlayer2().getPoint());
		this.lblPointJ2.setMaxWidth(200);
		this.lblPointJ2.setAlignment(Pos.CENTER);
		this.lblPointJ2.setTextAlignment(TextAlignment.CENTER);
		this.setLeft(lblPointJ1);
		this.setRight(lblPointJ2);
		
	}
}
