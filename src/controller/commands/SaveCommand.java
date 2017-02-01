package controller.commands;

import model.Model;
import model.receivers.save.SaveLevel;
import model.receivers.save.*;

import java.io.IOException;
import java.util.HashMap;

public class SaveCommand implements Command {

	private HashMap<String,SaveLevel> levelSaverFactory = new HashMap<>();
	private String path = null;
	private String type = null;
	private Model model = null;
	
	public SaveCommand(Model model) {
		this.model = model;
		levelSaverFactory.put("obj", new SaveToObject());
		levelSaverFactory.put("xml", new SaveToXML());
	}
	
	public void setParams(String[] params) throws IOException{
		if(params.length == 1) {
			throw new IOException("error saving a file, please provide valid path");
		}
		this.path = params[1];
		this.type = path.substring(path.lastIndexOf('.')+1);
	}
	
	@Override
	public void execute() throws IOException {
		if(model.getLevel() == null) {
			throw new IOException("please load a level first");
		}

		if (!(type.equals("obj") || type.equals("xml")))
		{
			throw new IOException("bad file name");
		}
		levelSaverFactory.get(type).save(model.getLevel(), path);	
		System.out.println("save successful!");
		throw new IOException("save successful!");
	}

}