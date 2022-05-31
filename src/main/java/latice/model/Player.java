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
	
	public List<Tile>clearRack(){
			for (int i = rack.size(); i>0; i--) {
				if (rack.size()!=0) {
					stack.add(rack.get(i-1));
					rack.remove(i-1);
			}
		}
		return rack;
	}
			
}


