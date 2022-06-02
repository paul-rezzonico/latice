package latice.model;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	private final String name;
	private final ArrayList<Tile> rack;
	private final ArrayList<Tile> stack;
	private Integer point;
	private Boolean ptsFree;
	
	public Player(String name, ArrayList<Tile> stack, Integer point) {
		
		this.name = name;
		
		this.rack = new ArrayList<Tile>();
		rack.add(null);
		rack.add(null);
		rack.add(null);
		rack.add(null);
		rack.add(null);
		
		this.stack = stack;
		this.point = point;
	}
	
	public int sizeRack() {
		int size = 0;
		for (int i = 0; i < this.rack.size(); i++) {
			
			if(this.rack.get(i) != null) {
				size ++;
			}
		}
		return size;
	}
	
    public void fillRack() {
        
    	Collections.shuffle(this.stack);
    	
        for (int i = 0; i<rack.size(); i++) {
        	
        	if(this.rack.get(i) == null && this.stack.size()>0) {
        		this.rack.set(i, this.stack.get(0));
        		this.stack.remove(0);
        	}  
        }
    }

    public void clearRack(){
    	
        for (int i = 0; i<this.rack.size(); i++) {
        	if (this.rack.get(i)!= null){
        		this.stack.add(this.rack.get(i));
        		this.rack.set(i, null);
        	}
        }
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

	public Boolean getPtsFree() {
		return ptsFree;
	}

	public void setPtsFree(Boolean ptsFree) {
		this.ptsFree = ptsFree;
	}

}
	



