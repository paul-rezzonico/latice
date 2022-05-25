package latice.model;

import java.util.ArrayList;
import java.util.Collections;

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

	public ArrayList<Tile> getRack() {
		return rack;
	}

	public ArrayList<Tile> getStack() {
		return stack;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}
	
	public boolean fillRack(){
		Collections.shuffle(stack);
		for (int i = 0; i < 5; i++) {
			if (this.rack.size()<5) {
				this.rack.add(stack.get(i));
				this.stack.remove(i);
			}
	 
		}
		return true;
	}
	
	public boolean changeRack() {
		if (this.rack.size()==5) { 
			for (int i = 5; i>0; i--) {
			
				System.out.println("dfsr");
				if (this.rack.size()!=0) {
					this.stack.add(rack.get(i-1));
					this.rack.remove(i-1);
				}
			}
			return this.fillRack();
		} 
		return false;
	}
			
}


