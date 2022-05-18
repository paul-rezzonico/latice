package latice.application;

import java.util.List;
import java.util.Scanner;

import latice.model.Board;
import latice.model.Position;
import latice.model.Tile;

public class Console {

	final int ROWS = 9;
	final int COLUMNS = 9;
	Scanner keyboard = new Scanner(System.in);

	public int ensureInteger() throws NumberFormatException{
		while (true) {
			try {
				return Integer.parseInt(keyboard.nextLine());
			} catch (Exception e) {
				System.out.println("Cela doit être un entier !");
			}
		}
	}
	
	public int ensureIntegerBetween(int minimum, int maximum) {
		while (true) {
			int value = ensureInteger();
			if (minimum <= value && value <= maximum)
				return value;
			else {
				System.out.println("La valeur doit être entre " + minimum + " et " + maximum);
			}
		}
	}
	
	public Tile tileChoice(List<Tile> rack) {
		System.out.println(rack.toString());
		System.out.println("Veuillez choisir la tuile à placer");
		int pos = ensureIntegerBetween(1, 5);
		return rack.get(pos-1);
	}
	
	public Position positionChoice() {
		System.out.println("Ou voulez placer votre tuile ?");
		System.out.println("Ligne : ");
		int row = ensureIntegerBetween(1, 9);
		System.out.println("Colonne : ");
		int col = ensureIntegerBetween(1, 9);
		return new Position(row, col);
	}
	
	public int choice() {
		System.out.println("1:Jouer la pièce gratuite 2:Payer une action suplémentaire 3:Finir son tour");
		System.out.println("Choix : ");
		int val =ensureIntegerBetween(1,3);
		return val;
	}
	public void showBoard(Board board) {
		StringBuilder str = new StringBuilder();
		for (int i = 1; i <= ROWS; i++) {
			for (int j = 1; j <= COLUMNS; j++) {
				Position pos = new Position(i, j);
				Tile tile = board.tileAt(pos);
				if (tile != null) {
					str.append(tile.toString());
				} else if (board.boxAt(pos).getShape() != null) {
					str.append(board.boxAt(pos).toString());
				} else {
					str.append("         ");
				}
				str.append('|');
			}
			str.append("\n");
		}
		System.out.println(str.toString());
	}
}
