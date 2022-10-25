package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import utilities.Constants;

public class BaseClass {
	
	public static WebDriver driver;
    String URL = "http://automationpractice.com/";
	
	@BeforeTest
	public void setup(){
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get(URL);
	    driver.manage().window().maximize();     
    }
	
	@AfterTest
	public void teardown(){
		driver.close();
		driver.quit();
	}

}
