package latice.model;

public class Box {
	private Symbol symbol;
	private Tile tile;

	public Box(Symbol symbol, Tile tile) {
		this.symbol = symbol;
		this.tile = tile;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
}
