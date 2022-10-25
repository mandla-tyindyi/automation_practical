/**
 * 
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import utilities.Constants;

/**
 * @author mandla.tyindyi
 *
 */
public class TC1 extends BaseClass
{
	
	@Test
	public static void TestCase1() throws InterruptedException
	{
		HomePage homepage = new HomePage();
		
		homepage.searchOnTheHomePage(driver);
		String expectedText = homepage.getTextFromFirstResult(driver);
        Assert.assertTrue(expectedText.contains(Constants.SEARCH_CRITERIA));
        
		//Assert.assertTrue();
		//Thread.sleep(10000);
		//System.out.println("text is: "+homepage.getTextFromFirstResult(driver));

	}

}
