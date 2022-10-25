/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Utility;

import utilities.Constants;


/**
 * @author mandla.tyindyi
 *
 */
public class HomePage 
{

	WebDriver driver;
	Utility driverUtil = new Utility();
	
	public void searchOnTheHomePage(WebDriver driver)
	{
		driverUtil.waitForElement(this.searchFieldXpath(), driver);
		driverUtil.enterTextByXpath(this.searchFieldXpath(), driver, Constants.SEARCH_CRITERIA);
		driverUtil.waitForElement(this.searchIconXpath(), driver);
		driverUtil.clickElementByJavascriptExecutor(this.searchIconXpath(), driver);
		driverUtil.clickElementbyXpath(this.searchIconXpath(), driver);
	}
	
	public String getTextFromFirstResult(WebDriver driver)
	{
		driverUtil.waitForElement(this.searchFirstResultXpath(), driver);
		WebElement element =driver.findElement(By.xpath(this.searchFirstResultXpath()));
		String elementText = element.getText();
		
		return elementText;
	}
	
	
	public String searchFieldXpath() 
	{
		return "//input[@id='search_query_top']";
	}
	
	public String searchIconXpath() 
	{
		return "//button[@name='submit_search']";
	}
	
	public String searchFirstResultXpath() 
	{
		return "//ul[@class='product_list grid row']/li[1]";
	}
}
