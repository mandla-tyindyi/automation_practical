/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;

import utilities.Constants;
import utilities.Utility;

/**
 * @author mandla.tyindyi
 *
 */
public class SignInPage
{
	
	WebDriver driver;
	Utility driverUtil = new Utility();
	
	public void signIn(WebDriver driver)
	{
		
		driverUtil.waitForElement(this.signInLinkXpath(), driver);
		driverUtil.clickElementbyXpath(this.signInLinkXpath(), driver);
		driverUtil.waitForElement(this.emailAddressFieldXpath(), driver);
		driverUtil.enterTextByXpath(this.emailAddressFieldXpath(), driver, Constants.USERNAME);
		driverUtil.waitForElement(this.passwordFieldXpath(), driver);
		driverUtil.enterTextByXpath(this.passwordFieldXpath(), driver, Constants.PASSWORD);
		driverUtil.waitForElement(this.loginButtonXpath(), driver);
		driverUtil.clickElementByJavascriptExecutor(this.loginButtonXpath(), driver);
		driverUtil.clickElementbyXpath(this.loginButtonXpath(), driver);
		driverUtil.waitForElement(this.myAccountHeaderTextXpath(), driver);
		
	}
	
	public String getTextFromFirstResult(WebDriver driver)
	{
	
		return driverUtil.getTextFromAnElement(driver, this.myAccountHeaderTextXpath());
		
	}

	public String signInLinkXpath() 
	{
		return "//a[contains(text(),'Sign in')]";
	}
	
	public String emailAddressFieldXpath() 
	{
		return "//input[@id='email']";
	}
	
	public String passwordFieldXpath() 
	{
		return "//input[@id='passwd']";
	}
	
	public String loginButtonXpath() 
	{
		return "//button[@id='SubmitLogin']";
	}
	
	public String myAccountHeaderTextXpath() 
	{
		return "//h1[text()='My account']";
	}
}
