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
public class GenericPage 
{

	WebDriver driver;
	Utility driverUtil = new Utility();
	
	public void navigateToEachCategory(WebDriver driver, String category)
	{
		if(category == "Women"){
			driverUtil.waitForElement(this.womenTabXpath(), driver);
			driverUtil.clickElementbyXpath(this.womenTabXpath(), driver);
		}
		else if(category == "Dresses")
		{
			driverUtil.waitForElement(this.dressesTabXpath(), driver);
			driverUtil.clickElementbyXpath(this.dressesTabXpath(), driver);
		}
		else if(category == "T-Shirts")
		{
			driverUtil.waitForElement(this.tshirtsTabXpath(), driver);
			driverUtil.clickElementbyXpath(this.tshirtsTabXpath(), driver);
		}
		
	}
	
	public String getTextFromAnElementInAPage(WebDriver driver, String category)
	{
		String value = null;
		if(category == "Women"){
			value = driverUtil.getTextFromAnElement(driver, this.womentCategoryXpath());
		}
		else if(category == "Dresses")
		{
			value = driverUtil.getTextFromAnElement(driver, this.dressesCategoryXpath());
		}
		else if(category == "T-Shirts")
		{
			value = driverUtil.getTextFromAnElement(driver, this.tShirtsCategoryXpath());
		}
		
		return value;
	}
	
	public String getTextFromAnElement(WebDriver driver, String elementXpath)
	{		
		return driverUtil.getTextFromAnElement(driver, elementXpath);
	}
	
	public void hoverOverMainCategoryAndSelectSubcategory(WebDriver driver, String category, String subcategory)
	{
		
		hoverOverMainCategory(driver, category);
		driverUtil.clickElementbyXpath(this.subCategoriesGenericXpath(subcategory), driver);
			
	}
	
	public void hoverOverMainCategory(WebDriver driver, String category)
	{
		
		driverUtil.waitForElement(this.categoriesGenericXpath(category), driver);
		driverUtil.hoverOverAnElement(driver, this.categoriesGenericXpath(category));
			
	}
	
	public String categoriesGenericXpath(String category) 
	{
		return "//div[text()='Categories']/../ul/li/a[text()='"+category+"']";
	}
	
	public String subCategoriesGenericXpath(String subcategory) 
	{
		return "//div[text()='Categories']/../ul/li/ul/li/a[text()='"+subcategory+"']";
	}
	
	public String tshirtsTabXpath() 
	{
		return "//div[@class='container']//div[@id='block_top_menu']/ul/li[3]/a";
	}
	
	public String dressesTabXpath() 
	{
		return "//div[@class='container']//div[@id='block_top_menu']/ul/li[2]/a";
	}
	
	public String womenTabXpath() 
	{
		return "//div[@class='container']//div[@id='block_top_menu']/ul/li[1]/a";
	}
	
	public String womentCategoryXpath() 
	{
		return "//h2[contains(text(),'Women')]";
	}
	
	public String dressesCategoryXpath() 
	{
		return "//h2[contains(text(),'Dresses')]";
	}
	
	public String tShirtsCategoryXpath() 
	{
		return "//h1//span[contains(text(),'T-shirts')]";
	}
	
	public String topsLandingPageXpath() 
	{
		return "//h1//span[contains(text(),'Tops')]";
	}
	
	public String searchFirstResultXpath() 
	{
		return "//ul[@class='product_list grid row']/li[1]";
	}
	
}
