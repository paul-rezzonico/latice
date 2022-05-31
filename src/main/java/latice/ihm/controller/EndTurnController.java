package latice.ihm.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import latice.application.Game;

public class EndTurnController implements EventHandler<MouseEvent>{

	@Override
	public void handle(MouseEvent event) {
		Game game = Game.getInstance();
		game.endTurn();
		if(game.getPlayer1().getStack().isEmpty() || game.getPlayer2().getStack().isEmpty() || game.getTurn() > 20) {
			//TODO condition de victoire
			
		}
	}
	
}