/**
 * 
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.GenericPage;
import pages.HomePage;
import utilities.Constants;

/**
 * @author mandla.tyindyi
 *
 */
public class TC6 extends BaseClass
{
	@Test
	public static void TestCase6()
	{
		GenericPage genereicpage = new GenericPage();
		
		genereicpage.navigateToEachCategory(driver, "Women");
		String headerTextOnWomenCategory = genereicpage.getTextFromAnElementInAPage(driver, "Women");
        Assert.assertEquals(headerTextOnWomenCategory, "WOMEN");
        
        genereicpage.navigateToEachCategory(driver, "Dresses");
		String headerTextOnDressesCategory = genereicpage.getTextFromAnElementInAPage(driver, "Dresses");
        Assert.assertEquals(headerTextOnDressesCategory, "DRESSES");
        
        genereicpage.navigateToEachCategory(driver, "T-Shirts");
		String headerTextOnTshirtsCategory = genereicpage.getTextFromAnElementInAPage(driver, "T-Shirts");
        Assert.assertEquals(headerTextOnTshirtsCategory, "T-SHIRTS");
        
        genereicpage.hoverOverMainCategory(driver, "Women");
        genereicpage.hoverOverMainCategory(driver, "Dresses");
        genereicpage.hoverOverMainCategory(driver, "T-Shirts");
        
        genereicpage.hoverOverMainCategoryAndSelectSubcategory(driver, "Women", "Tops");

	}

}