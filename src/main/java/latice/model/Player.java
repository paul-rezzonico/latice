package latice.model;

import java.util.List;

public class Player {
	private String name;
	private List<Tile> rack;
	private List<Tile> stack;
	private Integer point;
	
	public Player(String name, List<Tile> rack, List<Tile> stack, Integer point) {
		super();
		this.name = name;
		this.rack = rack;
		this.stack = stack;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tile> getRack() {
		return rack;
	}

	public void setRack(List<Tile> rack) {
		this.rack = rack;
	}

	public List<Tile> getStack() {
		return stack;
	}

	public void setStack(List<Tile> stack) {
		this.stack = stack;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}
	

}
