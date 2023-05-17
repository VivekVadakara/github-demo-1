package base;



import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader  fr;
	public static FileReader  fr1;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		
		if (driver==null) {
			String path = System.getProperty("user.dir");
			 fr = new FileReader (path + "\\\\src\\\\test\\resources\\\\configfiles\\\\config.properties");
			 fr1 = new FileReader (path + "\\\\src\\\\test\\resources\\\\configfiles\\\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
			
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("testurl"));
				
		}
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Teardown successfull");
	
		
	}
}


