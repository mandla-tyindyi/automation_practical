/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import utilities.Constants;
import utilities.Utility;

/**
 * @author mandla.tyindyi
 *
 */
public class CartPage
{
	
	WebDriver driver;
	Utility driverUtil = new Utility();
	
	public void addItemToShopingCartView(WebDriver driver)
	{
		driverUtil.waitForElement(this.tshirtsTabXpath(), driver);
		driverUtil.clickElementbyXpath(this.tshirtsTabXpath(), driver);
		driverUtil.waitForElement(this.productLinkXpath(), driver);
		driverUtil.scrollToElement(this.productLinkXpath(), driver);
		driverUtil.hoverOverAnElement(driver, this.productLinkXpath());
		driverUtil.clickElementbyXpath(this.addToCartButtonXpath(), driver);
		driverUtil.waitForElement(this.checkoutButtonXpath(), driver);
		driverUtil.clickElementbyXpath(this.checkoutButtonXpath(), driver);
	}
	
	public void increaseQuantity(WebDriver driver) throws InterruptedException
	{
		driverUtil.waitForElement(this.increaseQuantityButtonXpath(), driver);
		driverUtil.clickElementbyXpath(this.increaseQuantityButtonXpath(), driver);
		driverUtil.clickElementByJavascriptExecutor(this.increaseQuantityButtonXpath(), driver);
		Thread.sleep(9000);
	}
	
	public String getCartValue(WebDriver driver, String valueToGet)
	{
		String value = null;
		if(valueToGet == "Quantity"){
			value = driverUtil.getValueFromAnAttribute(driver, this.quantityFieldXpath());
		}
		else if(valueToGet == "Unit Price")
		{
			value = driverUtil.getTextFromAnElement(driver, this.unitPriceXpath());
		}
		else if(valueToGet == "Total Price")
		{
			value = driverUtil.getTextFromAnElement(driver, this.totalPriceXpath());
		}
		
		return value;
		
	}
	
	public double extractPrice(String stringWithPrice)
	{
        String price = stringWithPrice.substring(1);
        double actualPrice = Double.parseDouble(price);
		
		return actualPrice;
		
	}
	
	public double calculateTotal(double unitPrice, double quantity)
	{
		
		return 	unitPrice * quantity;
				
	}

	public String tshirtsTabXpath() 
	{
		return "//div[@class='container']//div[@id='block_top_menu']/ul/li[3]/a";
	}
	
	public String productLinkXpath() 
	{
		return "//a[@class='product_img_link']";
	}
	
	public String addToCartButtonXpath() 
	{
		return "//ul[@class='product_list grid row']/li[1]//div[@class='button-container']/a/span[text()='Add to cart']";
	}
	
	public String closeButtonXpath() 
	{
		return "//span[@class='cross']";
	}
	
	public String checkoutButtonXpath() 
	{
		return "//span[contains(text(),'Proceed to checkout')]";
	}
	
	public String quantityFieldXpath() 
	{
		return "//input[@class='cart_quantity_input form-control grey']";
	}
	
	public String unitPriceXpath() 
	{
		return "//td[@class='cart_unit']//span[@class='price']/span";
	}
	
	public String totalPriceXpath() 
	{
		return "//td[@class='cart_total']/span";
	}
	
	public String increaseQuantityButtonXpath() 
	{
		return "//i[@class='icon-plus']";
	}
}
