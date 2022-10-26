/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;

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
	
	public void reusableSearchOnTheHomePage(WebDriver driver, String textToSearch)
	{
		driverUtil.waitForElement(this.searchFieldXpath(), driver);
		driverUtil.enterTextByXpath(this.searchFieldXpath(), driver, textToSearch);
		driverUtil.waitForElement(this.searchIconXpath(), driver);
		driverUtil.clickElementByJavascriptExecutor(this.searchIconXpath(), driver);
		driverUtil.clickElementbyXpath(this.searchIconXpath(), driver);
	}
	
	public String getTextFromFirstResult(WebDriver driver)
	{
		
		return driverUtil.getTextFromAnElement(driver, this.searchFirstResultXpath());
		
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
