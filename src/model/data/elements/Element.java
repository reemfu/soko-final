package model.data.elements;

import java.awt.Point;
import java.io.Serializable;

//Position class,which holds (x,y) coordinates

public abstract class Element implements Serializable {

	protected Point pos;
	protected boolean onTarget = false;
	
	public Element(Point position) {
		this.pos = position; 
		}
	
	public abstract char getObjChar();
	public abstract boolean onTarget();
	public abstract ElementType getElementType();
	public Point getPosition() {
		return pos;
	}
	
	public void setPosition(Point pos) {
		this.pos = pos;
	}

	public boolean getOnTarget() {
		return onTarget;
	}

	public void setOnTarget(boolean onTarget) {
		this.onTarget = onTarget;
	}

	
}
