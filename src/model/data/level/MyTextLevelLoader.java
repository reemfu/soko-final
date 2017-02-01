package model.data.level;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import model.data.elements.*;

public class MyTextLevelLoader implements LevelLoader{

	BufferedReader reader;
	
	@Override
	public Level loadLevel(InputStream input) throws IOException  
	{	
		if (!(input instanceof FileInputStream))
			throw new IOException("the input type of FiletInputStream is not correct");
	
		this.reader = new BufferedReader(new InputStreamReader(input));
		ArrayList<ArrayList<Element>> board = new ArrayList<ArrayList<Element>>();
		String line;
		int i = 0;
		while ((line = reader.readLine()) != null) 
		{
			board.add(new ArrayList<Element>());
			for(int j = 0; j < line.length(); j++)
			{
				if (line.charAt(j) == '#')
					board.get(i).add(new Wall(new Point(i,j)));
				if (line.charAt(j) == '@')
					board.get(i).add(new Box(new Point(i,j)));
				if (line.charAt(j) == 'o')
					board.get(i).add(new Target(new Point(i,j)));
				if (line.charAt(j) == ' ')
					board.get(i).add(new Floor(new Point(i,j)));
				if (line.charAt(j) == 'A')
					board.get(i).add(new Player(new Point(i,j)));
			}
			i++;
		}
		reader.close();		
		Level newLevel = new Level(board);
		return newLevel;
	}
}