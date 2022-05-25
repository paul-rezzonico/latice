package latice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
	private final String name;
	private final ArrayList<Tile> rack;
	private final ArrayList<Tile> stack;
	private Integer point;
	
	public Player(String name, ArrayList<Tile> rack, ArrayList<Tile> stack, Integer point) {
		this.name = name;
		this.rack = rack;
		this.stack = stack;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public List<Tile> getRack() {
		return rack;
	}

	public List<Tile> getStack() {
		return stack;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}
	
	public ArrayList<Tile> fillRack(){
		Collections.shuffle(stack);
		for (int i = 0; i < 5; i++) {
			if (this.rack.size()<5) {
				this.rack.add(stack.get(i));
				this.stack.remove(i);
			}
	 
		}
		return this.rack;
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


