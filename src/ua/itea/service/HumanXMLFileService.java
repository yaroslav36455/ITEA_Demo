package ua.itea.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import ua.itea.model.Human;

public class HumanXMLFileService extends HumanService {
	private static final String fileName = "Humans.xml";
	
	@Override
	public Human load() {
		Human human = new Human();
		
		XStream xstream = new XStream(new DomDriver());
		try {
			xstream.fromXML(new FileInputStream(fileName), human);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return human;
	}
	
	@Override
	public void save(String name, int health) {
		XStream xstream = new XStream(new StaxDriver());
		
		try {
			xstream.toXML(new Human(name, health), new FileOutputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
