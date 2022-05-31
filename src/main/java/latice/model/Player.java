package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	private final String name;
	private final ArrayList<Tile> rack;
	private final ArrayList<Tile> stack;
	private Integer point;
	
	public Player(String name, ArrayList<Tile> rack, ArrayList<Tile> stack, Integer point) {
		super();
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
	
	public ArrayList<Tile>fillRack(){
		Collections.shuffle(stack);
		if(stack.size()>4) {
			for (int i = 4-rack.size(); i >=0; i--) {
		
					rack.add(stack.get(i));
					stack.remove(i);
	 
			}
		}else {
			for(int j=stack.size()-1;j>=0 ; j--) {
				rack.add(stack.get(j));
				stack.remove(j);
			}
		}
	return rack;
	}
	
	public ArrayList<Tile>clearRack(){
			for (int i = rack.size(); i>0; i--) {
				if (rack.size()!=0) {
					stack.add(rack.get(i-1));
					rack.remove(i-1);
				}}
			return rack;}
	

	public ArrayList<Tile>changeRack(){
		for (int i = 5; i>0; i--) {
			if (rack.size()!=0) {
				stack.add(rack.get(i-1));
				rack.remove(i-1);

			}
		}
		return rack;
	}
	
}


