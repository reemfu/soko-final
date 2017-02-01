package model.receivers.load;

import model.data.level.Level;
import model.data.level.MyXmlLevelLoader;

import java.io.FileInputStream;
import java.io.IOException;

public class LoadXmlLevel implements LoadLevel{

	@Override
	public Level load(String path) throws IOException, IOException {
		MyXmlLevelLoader loader = new MyXmlLevelLoader();
		FileInputStream in = new FileInputStream(path);
		Level level = loader.loadLevel(in);
		in.close();
		return level;
	}
}