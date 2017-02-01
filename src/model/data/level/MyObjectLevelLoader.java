package model.data.level;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MyObjectLevelLoader implements LevelLoader {
	
	@Override
	public Level loadLevel(InputStream input) throws IOException {
		if (!(input instanceof ObjectInputStream))
			throw new IOException("the input type of ObjectInputStream is not correct");
		try 
		{
			Level newLevel = (Level)(((ObjectInputStream)input).readObject());
			return newLevel;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}