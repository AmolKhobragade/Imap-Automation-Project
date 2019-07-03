package com.ImapTesting.commonfunction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Web_Alerts extends Baseclass
{

	/*
	 * This Method are created by amol for references
	 * Below methods are for validating the toaster message
	 * Type of Toaster Message 
	 * Success
	 * Error
	 * Warning 
	 * Info
	 */
	
	
	
	/** The driver. */
	private WebDriver driver = null;
	
	/** The webelement. */
	private WebElement webelement = null;
	
	/** The accept next alert. */
	private boolean acceptNextAlert = true;
	
	/** The time out in seconds. */
	int timeOutInSeconds = 30;
	
	/** The logger. */
	public static ExtentTest logger = null;
	
	/**
	 * Constructor.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public Web_Alerts(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	
	
	public static String validate_ToasterMessage(WebDriver driver,WebElement Element,ExtentTest logger)
	{
		String ElementMsg=null;
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try 
		{
			ElementMsg = Element.getText();
			Reporter.log(ElementMsg,true);
			logger.log(Status.PASS, "User get the element text -- "+ ElementMsg);   
		} 
		catch (NoSuchElementException e) 
		{
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
		}
		
		return ElementMsg;
	}
	
	
}
