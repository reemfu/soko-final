package model.data.elements;

import java.awt.Point;
import java.io.Serializable;

public class Wall extends Element implements Serializable {
	
	public Wall(Point pos) {	
		super(pos);
	}
	
	@Override
	public ElementType getElementType() {
		return ElementType.WALL;
	}
	
	@Override
	public boolean onTarget() {
		return onTarget;
	}
	
	@Override
	public char getObjChar() {
		return '#';
	}

}