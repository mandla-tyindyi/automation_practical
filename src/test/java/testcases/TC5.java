package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SignInPage;
import utilities.Constants;
import pages.CartPage;

public class TC5 extends BaseClass
{
	
	@Test
	public static void TestCase4() throws InterruptedException
	{
		SignInPage signinpage = new SignInPage();
		CartPage cartpage = new CartPage();
		
		signinpage.signIn(driver);
		String actualText1 = signinpage.getTextFromFirstResult(driver);
        Assert.assertEquals(actualText1, Constants.SIGN_IN_ASSERTION_TEXT);
        
        cartpage.addItemToShopingCartView(driver);
        cartpage.increaseQuantity(driver);
        String actualQuantity = cartpage.getCartValue(driver, "Quantity");
        Assert.assertEquals(actualQuantity, "2");
        
        String unitPrice = cartpage.getCartValue(driver, "Unit Price");
        double actualUnitPrice = cartpage.extractPrice(unitPrice);
        
        String totalPrice = cartpage.getCartValue(driver, "Total Price");
        double actualTotalPrice = cartpage.extractPrice(totalPrice);
        
        System.out.println("total: "+actualTotalPrice);
        System.out.println("unit price: "+actualUnitPrice);
        
        Assert.assertEquals(actualTotalPrice, cartpage.calculateTotal(actualUnitPrice, 2));
        
	}

}
