package model.data.elements;

import java.awt.Point;
import java.io.Serializable;

public class Box extends Element implements Serializable {
	
	public Box(Point pos) {
		super(pos); 
	}
	
	@Override
	public ElementType getElementType() {
		return ElementType.BOX;
	}
	
	@Override
	public boolean onTarget() {
		return onTarget;
	}
	
	@Override
	public char getObjChar() {
		return '@';
	}
	

}