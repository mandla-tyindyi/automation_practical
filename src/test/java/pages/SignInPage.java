/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author mandla.tyindyi
 *
 */
public class SignInPage{

	public static String signInLinkXpath() {
		return "//a[contains(text(),'Sign in')]";
	}
	
	public static String emailAddressFieldXpath() {
		return "//input[@id='email']";
	}
	
	public static String passwordFieldXpath() {
		return "//input[@id='passwd']";
	}
	
	public static String loginButtonXpath() {
		return "//button[@id='SubmitLogin']";
	}
	
	public static String myAccountHeaderTextXpath() {
		return "//h1[text()='My account']";
	}
}
