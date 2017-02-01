package model.data.elements;

import java.awt.Point;
import java.io.Serializable;

public class Floor extends Element implements Serializable {
	
	public Floor(Point pos) {	
		super(pos);
	}
	
	@Override
	public ElementType getElementType() {
		return ElementType.FLOOR;
	}
	
	@Override
	public boolean onTarget() {
		return onTarget;
	}
	
	@Override
	public char getObjChar() {
		return ' ';
	}

}
