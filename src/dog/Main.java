package dog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Main {
	public static void main(String[] args) {
		Dog dog = new Dog();
//		XStream xstream = new XStream(new StaxDriver());
//		
//		try {
//			xstream.toXML(dog, new FileOutputStream("Dog.xml"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		XStream xstream = new XStream(new DomDriver());
		try {
			xstream.fromXML(new FileInputStream("Dog.xml"), dog);
			System.out.println(dog);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
