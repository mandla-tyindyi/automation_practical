/**
 * 
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.SignInPage;
import utilities.Constants;

/**
 * @author mandla.tyindyi
 *
 */
public class TC4 extends BaseClass
{

	@Test
	public static void TestCase4() throws InterruptedException
	{
		SignInPage signinpage = new SignInPage();
		
		signinpage.signIn(driver);
		String actualText = signinpage.getTextFromFirstResult(driver);
        Assert.assertEquals(actualText, Constants.SIGN_IN_ASSERTION_TEXT);

	}
}
