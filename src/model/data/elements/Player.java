package model.data.elements;

import java.awt.Point;
import java.io.Serializable;

public class Player extends Element implements Serializable {
	
	public Player(Point pos) {	
		super(pos);
	}
	
	@Override
	public ElementType getElementType() {
		return ElementType.PLAYER;
	}
	
	@Override
	public boolean onTarget() {
		return onTarget;
	}
	
	@Override
	public char getObjChar() {
		return 'A';
	}

}