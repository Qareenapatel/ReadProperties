package readProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Read_Properties {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Users/patel/eclipse-practiceQA/ReadProperties/src/test/java/readProperties/Config.properties");
		prop.load(ip);
		
		String browsername= prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\patel\\Webdriver\\chromedriver.exe");
             driver = new ChromeDriver();
		}else if(browsername.equals("FF")) {
			driver = new FirefoxDriver();
		}else if(browsername.equals("IE")) {
			driver = new InternetExplorerDriver();
		}else {
			System.out.println("Browser has no value");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("loginbutton_xpath"))).click();
	   
		driver.findElement(By.xpath(prop.getProperty("reactbtn_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("logoutbutton_xpath"))).click();
		
	
		driver.quit();
}
}