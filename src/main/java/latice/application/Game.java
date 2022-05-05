package latice.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import latice.model.Color;
import latice.model.Player;
import latice.model.Symbol;
import latice.model.Tile;

public class Game {

	public static void main(String[] args) {
		
		launch();  
	}

	private static void launch() {
		
		ArrayList<Color> colorList = colorListCreation();
		ArrayList<Symbol> symbolList = symbolListCreation();
		ArrayList<Tile> tileList = new ArrayList<>();
		for (Color color : colorList) {
			for (Symbol symbol : symbolList) {
				tileList.add(new Tile(symbol,color));
				tileList.add(new Tile(symbol,color));
			}
		}
		Collections.shuffle(tileList);
		List <Tile> stackJ1 = new ArrayList<>();
		List <Tile> stackJ2 = new ArrayList<>();
		for (int i = 0; i <  tileList.size() ;i++) {
			if (i<36) {
				stackJ1.add(tileList.get(i));
			}else {
				stackJ2.add(tileList.get(i));
			}
		}
		List<Tile> rackJ1 = new ArrayList<>();
		List<Tile> rackJ2 = new ArrayList<>();
		Player player1=new Player("Player1",rackJ1,stackJ1,0);
		Player player2=new Player("Player2",rackJ2,stackJ2,0);
		player1.fillRack();
		player2.fillRack();
	}

	private static ArrayList<Color> colorListCreation() {
		ArrayList<Color> colorList = new ArrayList<>();
		colorList.add(Color.RED);
		colorList.add(Color.BLUE);
		colorList.add(Color.GREEN);
		colorList.add( Color.GREY);
		colorList.add(Color.PINK);
		colorList.add(Color.YELLOW);
		return colorList;
	}
	
	private static ArrayList<Symbol> symbolListCreation() {
		ArrayList<Symbol> symbolList = new ArrayList<>();
		symbolList.add(Symbol.RIAS);
		symbolList.add(Symbol.AKENO);
		symbolList.add(Symbol.ASIA);
		symbolList.add(Symbol.IRINA);
		symbolList.add(Symbol.KONEKO);
		symbolList.add(Symbol.XENOVIA);
		return symbolList;
	}
	
	
}
