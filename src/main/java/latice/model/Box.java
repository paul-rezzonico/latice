package latice.model;

public class Box {
    private Shape shape;
    private Tile tile;

    public Box(Shape symbol, Tile tile) {
        this.shape = symbol;
        this.tile = tile;
    }

    public Shape getSymbol() {
        return shape;
    }

    public void setSymbol(Shape symbol) {
        this.shape = symbol;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

}