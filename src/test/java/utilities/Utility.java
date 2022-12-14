/**
 * 
 */
package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author mandla.tyindyi
 *
 */

public class Utility {
	Random rand;
	 /**
     * Functions to be used in the test 
     */
    public boolean waitForElement(String xPath, WebDriver driver)
    {
        boolean elementFound;
        System.out.println("INFO: Waiting for element: "+xPath);
        try
        {
            elementFound = false;
            while(elementFound != true)
            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                while(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)))!=null)
                {
                    elementFound = true;
                    break;
                }
                
                return elementFound;
            }
        } catch (Exception e)
        {
            elementFound = false;
            System.out.println("ERROR: There was an error while waiting for element: "+xPath);
        }
        
        return elementFound;
    }
    
    
    public boolean scrollToElement(String elementXpath, WebDriver driver)
    {
        try
        {
            WebElement element = driver.findElement(By.xpath(elementXpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            return true;
        }
        catch (Exception e)
        {
            System.err.println("Error scrolling to element - " + elementXpath + " - " + e.getStackTrace());
            return false;
        }

    }
    
    public boolean clickElementbyXpath(String elementXpath, WebDriver driver)
    {
        try
        {
            System.out.println("INFO: Clicking element by Xpath : " + elementXpath);
            waitForElement(elementXpath,driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            WebElement elementToClick = driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            return true;
        }
        catch (Exception e)
        {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            return false;
        }
    }
    
    public boolean clickElementByJavascriptExecutor(String elementXpath, WebDriver driver)
    {
        try
        {
            System.out.println("INFO: Clicking element by Xpath : " + elementXpath);
            WebElement elementToClick = driver.findElement(By.xpath(elementXpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", elementToClick);
            return true;
        }
        catch (Exception e)
        {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            return false;
        }
    }
    
    public boolean enterTextByXpath(String elementXpath, WebDriver driver, String textToEnter)
    {
        try
        {
            waitForElement(elementXpath,driver);
            WebElement elementToTypeIn = driver.findElement(By.xpath(elementXpath));
            elementToTypeIn.sendKeys(Keys.chord(Keys.CONTROL, "a"), textToEnter);

            return true;
        }
        catch (Exception e)
        {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
            return false;
        }
    }
    
    public String getTextFromAnElement(WebDriver driver, String elementXpath)
	{
		waitForElement(elementXpath, driver);
		WebElement element =driver.findElement(By.xpath(elementXpath));
		String elementText = element.getText();
		
		return elementText;
	}
    
    public String getValueFromAnAttribute(WebDriver driver, String elementXpath)
	{
		waitForElement(elementXpath, driver);
		WebElement element =driver.findElement(By.xpath(elementXpath));
		String attributeValue = element.getAttribute("value");
		
		return attributeValue;
	}
    
    
    public void hoverOverAnElement(WebDriver driver, String elementXpath)
	{
    	Actions action = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath(elementXpath));
		action.moveToElement(btn).perform();
	}
    
    public void clearTextFromATextField(WebDriver driver, String elementXpath)
   	{
    	WebElement element = driver.findElement(By.xpath(elementXpath));
    	element.clear();
   	}
    
    public boolean selectRadioButtonUsingElementXpath(String radioButtonXpath, WebDriver driver)
    {
        try
        {
            WebElement radioButton = driver.findElement(By.xpath(radioButtonXpath));
            radioButton.click();
            
        }
        catch (Exception ex)
        {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }
    
    public String readFromATextFile(String os) throws IOException 
    {
    	
    	String fileName = getFilePath(os);
    	File file = new File(fileName);
    	FileReader fr = new FileReader(file);
    	BufferedReader br = new BufferedReader(fr);
    	String line;
    	String results=null;
    	while((line = br.readLine()) != null){
    	    results = line;
    	}
    	
    	br.close();    
        fr.close(); 

    	return results;
    }
    
    public String getFilePath(String os) throws IOException 
    {
    	String userDirectory = System.getProperty("user.dir");
    	String filePath = null;
    	
    	if(os.contains("Linux")) 
    	{
    		filePath = userDirectory+"/src/test/resources/testdata/sourcefile.txt";
    	}
    	else if(os.contains("Windows")) 
    	{
    		filePath = userDirectory+"\\src\\test\\resources\\testdata\\sourcefile.txt";
    	}
    	
    	return filePath;
    }
    
    public String switchToNewWindow(WebDriver driver)
    {
        // get the current window handle
        String parentHandle = driver.getWindowHandle();
        while (parentHandle.equalsIgnoreCase(driver.getWindowHandle()))
        {
            for (String winHandle : driver.getWindowHandles())
            {

                // switch focus of WebDriver to the next found window handle (that's your newly opened window)
                driver.switchTo().window(winHandle);
            }

        }

        return parentHandle;
    }
    
    public void pause(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public String generatePhoneNumber() {
    	Random rand = new Random();

	    int num1, num2, num3, num11;

	    num1 = rand.nextInt (3) + 6;
	    num11= rand.nextInt(9);
	    num2 = rand.nextInt (643) + 100;
	    num3 = rand.nextInt (9000) + 1000;

	   return 0+""+num1+num11+" "+num2+" "+num3;
	   
    }
    
    public void takeScreenShot(WebDriver webdriver,String fileWithPath) throws Exception{
    	try{
    		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(fileWithPath);
            FileUtils.copyFile(SrcFile, DestFile);
    	}catch(Exception e) {
    		System.out.println("Issue is: "+e.getMessage());
    	}

    }
    
    public void getDateTimeStamp() throws Exception{
    	try{
    		 Date date= new Date();
    		 long time = date.getTime();
    		 Timestamp ts = new Timestamp(time);
    		 System.out.println("Current Time Stamp: "+ts);
    	}catch(Exception e) {
    		System.out.println("Issue is: "+e.getMessage());
    	}

    }

}
