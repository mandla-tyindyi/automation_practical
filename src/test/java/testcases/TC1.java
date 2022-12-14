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
		String actualText = homepage.getTextFromFirstResult(driver);
        Assert.assertTrue(actualText.contains(Constants.SEARCH_CRITERIA));

	}

}
