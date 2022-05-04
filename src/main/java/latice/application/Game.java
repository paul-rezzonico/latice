package latice.application;

import java.util.ArrayList;

import latice.model.Color;
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
			}
		}
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
