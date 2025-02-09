package com.ImapTesting.commonfunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ImapTesting.baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebInput_TextBox  extends Baseclass
{
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;

	
	private WebDriver driver;
	private WebElement webEleemnt;
		
	/**
	 * Constructor.
	 *
	 * @param driver the driver
	 * @param webelement the webelement
	 */
	public WebInput_TextBox(WebDriver driver, WebElement webelement, ExtentTest logger) {
		this.driver = driver;
		this.webEleemnt = webelement;
		this.logger= logger;
	}
	
	/**
	 * Check expected watermarked text is displayed.
	 *
	 * @param Field watermarked the user name
	 * 
	 * @return True or False
	 */
	public static boolean watermarkedTextMatch (WebDriver driver,
			                             ExtentTest logger,
			                             WebElement element, 
			                             String expectedWatermarkedText) {
		boolean watermarkedTextMatched = false;
		if(element!= null){
			 String actualWatermarkedText;
			 actualWatermarkedText = WebElement_Common.getElementAttributeValue(driver, logger, element, "placeholder");
			 if (actualWatermarkedText.equals(expectedWatermarkedText)){
	         watermarkedTextMatched = true;
			 logger.log(Status.PASS, "Expected watermarked text "+ actualWatermarkedText +" IS present in the input field.");  
		    }			
		}
		else{
			logger.log(Status.FAIL, "Expected watermarked text is NOT present in the input field");   
		}
		return watermarkedTextMatched;
	}

	/**
	 * Send input text box.
	 *
	 * @param driver the driver
	 * @param webelement the webelement
	 * @param textToEntered the text to entered
	 * @return true, if successful
	 */
	public static boolean SendInputTextBox(WebDriver driver, WebElement webelement, String textToEntered) 
	{	
		boolean exists = false;

		try {
			webelement.sendKeys(textToEntered);
			exists = true;
		} catch (Exception e) {
			// nothing to do.
		}
		return exists;
	}

}
