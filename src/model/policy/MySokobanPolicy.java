package model.policy;

import model.data.elements.*;
import model.data.level.Level;
import model.receivers.move.Direction;
import model.receivers.move.Move;

public class MySokobanPolicy implements Policy {

	private Level level;
	private Player player;
	private Direction direction;

	public MySokobanPolicy(Level level) {
		this.level = level; 
		this.player = level.getPlayer(); 
	}
	
	@Override
	public void execute(Move moveCommand) throws Exception {
		
		this.direction = moveCommand.getDirection();
		
		if (checkIfMovePossible())
		{
			if (checkIfNeedPush())
			{
				push((Box)level.getNext(player.getPosition(), direction),direction);
				moveCommand.move();
			}
			else 
			{
				moveCommand.move();
			}
		}
		level.setStepsCounter(level.getStepsCounter()+1);
	}
	
	private void push(Box box, Direction direction) {
				
		if (!wallCollision(box,direction))
		{
			Move pushCommand = new Move(level,box,direction);
			pushCommand.move();
		}
		
	}
	
	private boolean checkIfMovePossible() {
		if (wallCollision(player,direction))
			return false;

		if (level.getNext(player.getPosition(),direction).getElementType() == ElementType.BOX)
			return checkIfNeedPush();
		
		return true;
	}
	
	private boolean checkIfNeedPush() {
		
		Element potentialBox = level.getNext(player.getPosition(),direction);
		Element potentialFloor = level.getNext(potentialBox.getPosition(),direction);
		
		if (potentialBox.getElementType() == ElementType.BOX) 
		{
			if (potentialFloor.getElementType() == ElementType.FLOOR)
			{
				return true;
			}
			if (potentialFloor.getElementType() == ElementType.TARGET)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean wallCollision(Element worldObject, Direction direction) {
		
		if(level.getNext(worldObject.getPosition(), direction).getElementType() == ElementType.WALL)
		{
			return true;
		}
				
		return false;
	}

}