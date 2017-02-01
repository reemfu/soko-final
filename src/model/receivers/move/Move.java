package model.receivers.move;

import model.data.elements.*;
import model.data.level.Level;

import java.awt.*;

public class Move {

	protected Level level;
	protected Element elem;
	Direction direction;
	
	public Move(Level level, Element elem, Direction direction) {
		this.level = level;
		this.elem = elem;
		this.direction = direction;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public void move() {

		Point currentPosition = elem.getPosition();
		int x = (int)currentPosition.getX();
		int y = (int)currentPosition.getY();

		boolean onTarget = elem.getOnTarget();

		if (level.getNext(currentPosition,direction).getElementType() == ElementType.TARGET)
			elem.setOnTarget(true);
		if (level.getNext(currentPosition,direction).getElementType() == ElementType.FLOOR)
			elem.setOnTarget(false);

		makeMove(direction);

		if (onTarget) {
			level.getBoard().get(x).set(y, new Target(currentPosition)); 
		}
		if (!onTarget) { 
			level.getBoard().get(x).set(y, new Floor(currentPosition)); 
		}

		
	}
	
	public void makeMove(Direction direction){

		int x = (int)elem.getPosition().getX();
		int y = (int)elem.getPosition().getY();

		switch (direction) {
			case UP: 	level.getBoard().get(x-1).set(y, elem);
			elem.setPosition(new Point(x-1,y));
						break;
						
			case DOWN:	level.getBoard().get(x+1).set(y, elem);
						elem.setPosition(new Point(x+1,y));
						break;	
						
			case LEFT:  level.getBoard().get(x).set(y-1, elem);
						elem.setPosition(new Point(x,y-1));
						break;
						
			case RIGHT:	level.getBoard().get(x).set(y+1, elem);
						elem.setPosition(new Point(x,y+1));
						break;
		}
	}
}