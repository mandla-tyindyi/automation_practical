/**
 * 
 */
package testcases;

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
public class TC2 extends BaseClass
{
	@Test
	public static void TestCase2()
	{
		HomePage homepage = new HomePage();
		Utility driverUtil = new Utility();
		
		String[] searchCriteriaArray = Constants.SEARCH_CRITERIA_STRING.split(",");
		
		for(String value:searchCriteriaArray) 
		{
			homepage.reusableSearchOnTheHomePage(driver, value);
			String actualText = homepage.getTextFromFirstResult(driver);
			Assert.assertTrue(actualText.contains(value));
			driverUtil.pause();
			driverUtil.clearTextFromATextField(driver, homepage.searchFieldXpath());
			
	    }

	}


}
