package model.data.level;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.data.elements.*;
import model.receivers.move.*;

@SuppressWarnings("serial")
public class Level implements Serializable {

	private ArrayList<ArrayList<Element>> board;
	private ArrayList<Point> solutionPoints = new ArrayList<Point>();
	private Player player = null;
	private int maxHeight;
	private int maxWidth;


	public int getStepsCounter() {
		return stepsCounter;
	}

	public void setStepsCounter(int stepsCounter) {
		this.stepsCounter = stepsCounter;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	private int stepsCounter;
	private int timer;


	public Level() {}
	public Level(ArrayList<ArrayList<Element>> grid) {
		try 
		{			
			this.board = grid;
			Point tempPlayerPosition = getPlayer().getPosition();
			this.setPlayer(new Player(tempPlayerPosition));
			findWidthHeight();
			finalSolPosition();
			this.stepsCounter = 0;
		}
		catch (Exception s) { System.out.println(s.getMessage()); }
	}
	
	public void finalSolPosition() {
		for(int i = 0; i < board.size(); i++) 
			for(int j = 0; j < board.get(i).size(); j++) {
				Element el = board.get(i).get(j);
				if (el.getElementType() == ElementType.TARGET) {
					solutionPoints.add(el.getPosition()); 
					}
			}
	}
	
	public Player getPlayer()
	{
		if (player != null)
		{
			return player;
		}
		for (int i = 0; i < board.size(); i++)
		{
			for (int j = 0; j < board.get(i).size(); j++)
			{
				if (board.get(i).get(j).getElementType() == ElementType.PLAYER)
					return ((Player)board.get(i).get(j));
			}
		}
		return null;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public final ArrayList<ArrayList<Element>> getBoard() {
		return board;
	}
	
	public void setBoard(ArrayList<ArrayList<Element>> board) {
		this.board = board;
	}
	
	public List<Point> getSolutionCoordinates() {
		return solutionPoints;
	}
	
	public void setSolutionCoordinates(ArrayList<Point> solutionCoordinates) {
		this.solutionPoints = solutionCoordinates;
	}
	
	public boolean checkIfWin() {

		for(Point p : solutionPoints) {
			int x = (int)p.getX();
			int y = (int)p.getY();
			if(board.get(x).get(y).getElementType() != ElementType.BOX) {
				return false;
			}
		}
		return true;
	}

	public Element getWorldObject(Point position) {
		return board.get((int)position.getX()).get((int)position.getY());
		}
	
	public Element getNext(Point position, Direction direction) {
				
		int x = (int)position.getX();
		int y = (int)position.getY();
		
		switch (direction) {
		
			case UP:	return 	board.get(x-1).get(y);	
			case DOWN:	return 	board.get(x+1).get(y);				
			case LEFT:	return 	board.get(x).get(y-1);			
			case RIGHT:	return 	board.get(x).get(y+1);
			
			default:	return null;
		} 
	}

	private void findWidthHeight() {
		maxHeight = board.size();
		maxWidth = 0;
		for(int i = 0; i<board.size(); i++) {
			if(board.get(i).size() > maxWidth) maxWidth = board.get(i).size();
		}
	}

	public int getMaxHeight() {return maxHeight;}
	public int getMaxWidth() {return maxWidth;}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
		}
	
	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
		}
}