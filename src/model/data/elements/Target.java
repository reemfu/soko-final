
package model.data.elements;

import java.awt.Point;
import java.io.Serializable;

public class Target extends Element implements Serializable {
	
	public Target(Point pos) {	
		super(pos);
	}
	
	@Override
	public ElementType getElementType() {
		return ElementType.TARGET;
	}
	
	@Override
	public boolean onTarget() {
		return onTarget;
	}
	
	@Override
	public char getObjChar() {
		return 'o';
	}

}