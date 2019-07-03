package com.ImapTesting.commonfunction;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.pages.Dash_MyUnit;
import com.ImapTesting.utilities.Common_Utilities;
import com.ImapTesting.utilities.WaitFunction;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Web_Link extends Baseclass 

{

	/** The driver. */
	private WebDriver driver;
	
	/** The web eleemnt. */
	private WebElement webelement;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;

	
	private static ExtentTest Extentest ;
	/**
	 * Instantiates a new web link.
	 *
	 * @param driver the driver
	 * @param webelement the webelement
	 */
	public Web_Link(WebDriver driver, WebElement webelement) {
		this.driver = driver;
		this.webelement = webelement;
	}

	/**
	 * Send click to link.
	 *
	 * @param driver
	 *            {@link WebDriver}
	 * @param webelement
	 *            {@link WebElement}
	 * @return true, if successful, else false
	 */
	public static boolean SendClickToLink(WebDriver driver, WebElement webelement) {
		boolean exists = false;

		try {
			webelement.click();
			exists = true;
		} catch (NoSuchElementException e) {
			// nothing to do.
		}
		return exists;
	}
	
	/**
	 * Gets the all links.
	 *
	 * @param driver the driver
	 * @return the all links
	 */
	public static List<WebElement> getAllLinksByCSSSelector(WebDriver driver, String cssSelector){
		List<WebElement> list= null;
		
		WebElement element=driver.findElement(By.cssSelector("ul[class=sidebar-menu]"));
		list = element.findElements(By.cssSelector(cssSelector));
		return list;
	}

	/**
	 * Send click to link.
	 *
	 * @param driver the driver
	 * @param space the space
	 * @return true, if successful
	 */
	public static boolean SendClickToLink(WebDriver driver, String space) {
		boolean exists = false;
		try {
			if(WebElement_Common.waitForElementPresent(driver, space, logger)){
				driver.findElement(By.linkText(space)).click();
				exists = true;
			}
		} catch (NoSuchElementException e) {
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return exists;
	}
	
	/**
	 * Send click to link.
	 *
	 * @param driver the driver
	 * @param element the element
	 * @param space the space
	 * @return true, if successful
	 */
	public static boolean SendClickToLink(WebDriver driver, WebElement element, String space) {
		boolean exists = false;
		try
		{
			if(WebElement_Common.waitForElementPresent(driver, space, logger))
			{
				if(element!=null)
				{
					element.click();
					exists = true;
				}
			}
		} catch (NoSuchElementException e) {
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return exists;
	}
	
	/*
	 * The below methods are created by amol for reference
	 */
	
	public static boolean CheckElementisEnableorNot1(WebDriver driver,WebElement Emptyfield, WebElement Disablebutton)
	{
		boolean exist = false;
		try
		{
			if(Emptyfield.getAttribute("value").isEmpty())
			{
				if(Emptyfield.getText().isEmpty())
				{
					Disablebutton.isEnabled();
				}
			}
		}
		catch(Exception e)
			{
			
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
			}
		return exist;
		}
	
	
public boolean checkenableordisablevalue(WebDriver driver,WebElement element)
{
	boolean exist = false;
	try
	{
		element.isEnabled();
		Reporter.log("Performance calculator field" + element,true);
		exist=true;
	}
	catch(Exception e)
	{
		logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
		
	}
	return exist;
}

public String CheckFieldvalue(WebDriver driver,WebElement element,String val)
{
	try
	{
		val = element.getAttribute("value");
		Reporter.log(val,true);
	}
	catch(Exception e)
	{
		logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));

	}
	return val;
		
}

/* This method is used for to check the element is enable or not 
 * 
 */
public static boolean btnverify(WebDriver driver,WebElement element1,WebElement element2,WebElement Btn,boolean Txt)
{
	
	try
	{
	if(element1.getAttribute("value").isEmpty() || element2.getAttribute("value").isEmpty())
	{
		Txt = Btn.isEnabled();
		Assert.assertFalse(Txt, "Button is disable");
		Reporter.log("If Status of button is True means button is enable and"
				+ " If button of status is false then button is disable :" + Txt,true);
	}
	}
	catch(Exception e)
	{
		logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
	}
	
	return Txt ;
}

/*
 * This method is used for to check default value of the field 
 * 
 */
public static String Verify_DefaultTextValue(WebDriver driver,WebElement element )
{
	String attributevalue = null;
	
	try
	{
		
		
		attributevalue = element.getAttribute("value");
		Reporter.log("The Default value of field is :" + attributevalue,true);
	}
	catch(Exception e)
	{
		logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
	}
	return attributevalue;
	
	
	
}

/* This method is created for to get default value of drop down menu 
 * 
 */

public static String Verify_DefaultDropdownValue(WebDriver driver,WebElement element )
{
	String dropname = null;
	try
	{
		Select Listvalue=new Select(element);
		dropname = Listvalue.getFirstSelectedOption().getText();
		Reporter.log("The default value of drop down menu is :" + dropname,true);
	}
	catch(Exception e)
	{
		logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));

	}
	return dropname; 
}


public static String Verify_ActExpDropVal(WebDriver driver,WebElement locator)

{
	String PresenceofElement = null;
	try
	{
	Select drop = new Select(locator);
	List<WebElement>alloption = drop.getOptions();
	Reporter.log("The drop down values are :"+ alloption,true);
	
	for(WebElement ele:alloption)
		
	{
		PresenceofElement=ele.getText();
		Reporter.log("The value is available in the drop down box "+ PresenceofElement,true);   
	}
	
	}
	catch(Exception e)
	{
		logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		
	}
	return PresenceofElement;
	}
	



/*
 * This method is for to verify the units of the field 
 * depends on the user setting  (SI or IP)
 */


public static String Verify_UnitsIP(WebDriver driver,WebElement btnsetting,WebElement Checkbox_IP,
                                    WebElement radiobtn_SI,WebElement btndone,WebElement label) 

{
	String labeltext=null;
	try
	{
		
		btnsetting.click();
		
		
		//System.out.println("The status of radio button is :"+ Checkbox_IP);
		Common_Utilities.Pageloader();
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(btndone)).click();
		
		labeltext=label.getText(); 
		Reporter.log("The unit of voltage is :"+labeltext,true);
		}
	
		catch(Exception e)
		{
			
           e.printStackTrace();
		}
		return labeltext;
	}




public static boolean IsRadioButtonChecked(WebDriver driver,WebElement element)
{
	boolean isRadioButtonChecked=false;
	
	isRadioButtonChecked=element.isSelected();
	if(isRadioButtonChecked)
	{
		return true;
	}
	return isRadioButtonChecked;
}


public  static void SelectUsersetting_IP(WebDriver driver,WebElement Usersetting,WebElement Click_IP,WebElement Click_SI,WebElement toastermsg,WebElement closetoast,WebElement Done)
{
	try
	{
		
	Usersetting.click();
	
	Common_Utilities.Pageloader();
	
	/*WebDriverWait wait1=new WebDriverWait(driver,10);
	wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='userSettingPopup']//li[2]/label/div/ins")));

	*/
	
	if((Click_IP.isSelected()))
	{
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Click_IP);
		
		Common_Utilities.Pageloader();*/
	/*	
		WebDriverWait wait1=new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.visibilityOf(toastermsg));
		
		JavascriptExecutor toster1 = (JavascriptExecutor)driver;
		toster1.executeScript("arguments[0].click();", closetoast);
	*/	
		//WaitFunction.waitForElementPresent(driver, Dash_MyUnit.CompleteToasterMessage1, Extentest);
	    //WebElement_Common.CloseToasterMessage(driver, closetoast);
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", Done);
		
	}
	else
	{
		/*JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", Click_SI);
		Common_Utilities.Pageloader();
		
		WebDriverWait wait2=new WebDriverWait(driver,15);
		wait2.until(ExpectedConditions.visibilityOf(toastermsg));
		
		JavascriptExecutor toster2 = (JavascriptExecutor)driver;
		toster2.executeScript("arguments[0].click();", closetoast);*/
		
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", Click_IP);
		
		Common_Utilities.Pageloader();
		
		/*
*/
		
		//WaitFunction.waitForElementPresent(driver, Dash_MyUnit.CompleteToasterMessage1, Extentest);
		//WebElement_Common.CloseToasterMessage(driver, closetoast);
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", Done);
		
		WebDriverWait wait3=new WebDriverWait(driver,15);
		wait3.until(ExpectedConditions.visibilityOf(toastermsg));
		
		JavascriptExecutor toster3 = (JavascriptExecutor)driver;
		toster3.executeScript("arguments[0].click();", closetoast);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}



public  static void SelectUsersetting_SI(WebDriver driver,WebElement Usersetting,WebElement Click_IP,WebElement Click_SI,WebElement toastermsg,WebElement closetoast,WebElement Done)
{
	try
	{
		/*
		WebDriverWait Wt=new WebDriverWait(driver,10);
		Wt.until(ExpectedConditions.invisibilityOf(toastermsg));*/
		
		Usersetting.click();
		
		Common_Utilities.Pageloader();

	if((Click_SI.isSelected()))
	{
		
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", Click_SI);
		//Common_Utilities.Pageloader();
		
		//WebDriverWait wait4=new WebDriverWait(driver,15);
		//wait4.until(ExpectedConditions.visibilityOf(toastermsg));
		
		
		
		//JavascriptExecutor toster4 = (JavascriptExecutor)driver;
		//toster4.executeScript("arguments[0].click();", closetoast);
		
		//WaitFunction.waitForElementPresent(driver, Dash_MyUnit.CompleteToasterMessage1, Extentest);
		//WebElement_Common.CloseToasterMessage(driver, closetoast);
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", Done);
	}
	else
	{
		/*JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click();", Click_IP);
		Common_Utilities.Pageloader();
		
		WebDriverWait wait5=new WebDriverWait(driver,15);
		wait5.until(ExpectedConditions.visibilityOf(toastermsg));
		
		JavascriptExecutor toster5 = (JavascriptExecutor)driver;
		toster5.executeScript("arguments[0].click();", closetoast);
		*/
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", Click_SI);
		
		Common_Utilities.Pageloader();
		
		
		/**/
		//WaitFunction.waitForElementPresent(driver, Dash_MyUnit.CompleteToasterMessage1, Extentest);
		//WebElement_Common.CloseToasterMessage(driver, closetoast);
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", Done);
		
		WebDriverWait wait6=new WebDriverWait(driver,15);
		wait6.until(ExpectedConditions.visibilityOf(toastermsg));
		
		JavascriptExecutor toster6 = (JavascriptExecutor)driver;
		toster6.executeScript("arguments[0].click();", closetoast);
	}
	}
	catch(NoSuchElementException e)
	{
		e.printStackTrace();
	}
	
	}

public  void CloseTosterMessage()
{
	WebElement toastmsg = driver.findElement(By.id("toast-container"));
	WebElement closetoastermsg =driver.findElement(By.xpath("//*[@id='toast-container']/div/div[1]/button"));
	
	if(toastmsg.isDisplayed())
	{
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click();", closetoastermsg);
	}
	else if(!(toastmsg.isDisplayed()))
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		
		JavascriptExecutor Msg = (JavascriptExecutor)driver;
		Msg.executeScript("arguments[0].click();", closetoastermsg);	
	}
	else
	{
		System.out.println("No Toaster Message is displayed");
	}
}





	}











	



	
	

