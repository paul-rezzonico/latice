package latice.model;

import java.util.Collections;
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
	
	public List<Tile>fillRack(){
		Collections.shuffle(stack);
		for (int i = 0; i < 5; i++) {
			if (rack.size()<5) {
			rack.add(stack.get(i));
			stack.remove(i);
		}
	 
	}
		return rack;
	}
	
	public List<Tile>changeRack(){
		for (int i = 5; i>0; i--) {
			if (rack.size()!=0) {
				stack.add(rack.get(i-1));
				rack.remove(i-1);
			}
		}
		return rack;
	}
			
}


