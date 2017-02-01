package model.data.level;

import java.io.IOException;
import java.io.InputStream;

public interface LevelLoader {

	Level loadLevel(InputStream input) throws IOException;
	
}
