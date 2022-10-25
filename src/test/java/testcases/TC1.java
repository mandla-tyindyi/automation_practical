/**
 * 
 */
package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseClass;

/**
 * @author mandla.tyindyi
 *
 */
public class TC1 extends BaseClass{
	
	@Test
	public static void TestCase1(){
		System.out.println("The path is: "+System.getProperty("user.dir"));
	}

}
