package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Readproperty {

	public static void main(String[] args) throws IOException {
		FileReader fr;
		fr = new FileReader("C:\\Users\\vysha\\eclipse-workspace\\Automation framework12345678\\TestAutomationFramewok\\src\\test\\resources\\configfiles\\config.properties");
		
		Properties p;
		p= new Properties();
		
		p.load(fr);
		
		System.out.println(p.getProperty("browser"));
		System.out.println(p.getProperty("testurl"));

	}

}
