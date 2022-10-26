/**
 * 
 */
package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import utilities.Constants;
import utilities.Utility;

/**
 * @author mandla.tyindyi
 *
 */
public class TC3 extends BaseClass
{
	@Test
	public static void TestCase3() throws InterruptedException, IOException
	{
		Utility driverUtil = new Utility();
		String os = System.getProperty("os.name");

		HomePage homepage = new HomePage();
		
		homepage.reusableSearchOnTheHomePage(driver, driverUtil.readFromATextFile(os));
		String actualText = homepage.getTextFromFirstResult(driver);
        Assert.assertTrue(actualText.contains(Constants.SEARCH_CRITERIA));

	}

}
