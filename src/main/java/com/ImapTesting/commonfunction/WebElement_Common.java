package com.ImapTesting.commonfunction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.mortbay.log.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebElement_Common extends Baseclass
{

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
	public WebElement_Common(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	/**
	 * Checks if is element present.
	 *
	 * @param driver {@link WebDriver}
	 * @param webelement {@link WebElement}
	 * @return true, if element is present, false otherwise
	 */
	public static boolean isElementPresent(WebDriver driver, WebElement webelement) {	
		boolean exists = false;

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try {
			//webelement.getTagName();
			exists = true;
		} catch (NoSuchElementException e) {
			// nothing to do.
		}
		return exists;
	}
	
	/**
	 * Gets the text for specified webelement.
	 *
	 * @param driver {@link WebDriver}
	 * @param webelement {@link WebElement}
	 * @param logger the logger
	 * @return the webelement text or null(if no text is present for WebElement)
	 * 
	 */
	public static String getElementText(WebDriver driver, WebElement webelement, ExtentTest logger) {	
		String elementText = null;

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try {
			elementText = webelement.getText();
			Reporter.log("The value of the field is  :"+elementText,true);
			logger.log(Status.PASS, "User get the element text -- "+ elementText);   
		} catch (NoSuchElementException e) {
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
		}
		return elementText;
	}
	
	/**
	 * Gets the attribute value for specified attribute of a webelement.
	 *
	 * @param driver {@link WebDriver}
	 * @param logger the logger
	 * @param webelement {@link WebElement}
	 * @param attributeName the attribute name
	 * @return the webelement's attribute value or null(if no attribute value is present for WebElement)
	 */
	public static String getElementAttributeValue(WebDriver driver, ExtentTest logger, WebElement webelement, String attributeName)
	{	
		String elementAttributeValue = null;

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try
		{
			
			elementAttributeValue = webelement.getAttribute(attributeName);
			Reporter.log("The value of the field is :"+elementAttributeValue,true);
			logger.log(Status.PASS, "User get the element attribute value -- "+ elementAttributeValue);   
		} catch (NoSuchElementException e) {
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
		}
		return elementAttributeValue;
	}

	
	/**
	 * Wait for element present.
	 *
	 * @param driver {@link WebDriver}
	 * @param by {@link By}
	 * @param webElement {@link WebElement}
	 * @param timeOutInSeconds the time out in seconds
	 * @return the web element or null(if webelement is not present)
	 */
	public static WebElement waitForElementPresent(WebDriver driver, final By by, WebElement webElement, int timeOutInSeconds) {

        WebElement element; 
        
        try{
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 

            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
            element = (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
            
            return element; //return the element
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null; 
    }
	
/**
 * Wait for an element to disappear before performing any action
 * @param driver
 * @param {@link By.}locator
 * @return
 */
public static boolean waitForElementToDisappear(WebDriver driver, By locator){
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			  //Wait for the condition with timeout 30 seconds
			      .withTimeout(Duration.ofSeconds(60))//(60,TimeUnit.SECONDS) 
			        // poll interval of 1 seconds. 
			      .pollingEvery(Duration.ofSeconds(5)) 
			      .ignoring(Exception.class)
			        //ignore the NoSuchElementException
			      .ignoring(NoSuchElementException.class);
	
		return fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
}
	
	/**
	 * Wait for element present.
	 *
	 * @param driver the driver
	 * @param webElement the web element
	 * @param logger the logger
	 * @return true, if successful
	 * @throws TimeoutException the timeout exception
	 */
	//Method Overload, we are using fluent wait
	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(Duration.ofSeconds(60))
				        // poll interval of 1 seconds. 
				      .pollingEvery(Duration.ofSeconds(1)) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}
	}
	
	/**
	 * Wait for element present.
	 *
	 * @param driver the driver
	 * @param linkText the link text
	 * @param logger the logger
	 * @return true, if successful
	 * @throws TimeoutException the timeout exception
	 */
	public static boolean waitForElementPresent(WebDriver driver, String linkText, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(Duration.ofSeconds(60)) 
				        // poll interval of 1 seconds. 
				     .pollingEvery(Duration.ofSeconds(1)) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
			return true;
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, linkText+" Failed! -- Not Found " +e.getMessage().substring(0, 150));
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, linkText+" Failed! -- Not Found " +e.getMessage().substring(0, 150));
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, linkText+" Failed! -- Not Found " +e.getMessage().substring(0, 150));
			return false;
		}
	}
	
	/**
	 * Static wait.
	 *
	 * @param milliseconds the milliseconds
	 */
	public static void staticWait(int milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			System.out.println("Error doing Hard wait using Thread.sleep()" +e.getMessage());
		}
	}
	
	/**
	 * Wait for element present.
	 *
	 * @param driver the driver
	 * @param webElement the web element
	 * @param logger the logger
	 * @param title the title
	 * @throws TimeoutException the timeout exception
	 */
	// Method Overload, we are using fluent wait - wait for element till expected condition title is present
	public  void waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger, String title) throws TimeoutException{
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(Duration.ofSeconds(60)) 
				        // poll interval of 1 seconds. 
				     .pollingEvery(Duration.ofSeconds(1)) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.titleIs(title));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 150));
		}
	}

	
	//Method Overload, we are using fluent wait
	public static boolean waitForElementPresent(WebDriver driver, List<WebElement> webElement_list, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(Duration.ofSeconds(60)) 
				        // poll interval of 1 seconds. 
				     .pollingEvery(Duration.ofSeconds(1)) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			for (WebElement webElement : webElement_list){
				fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			}
			return true;
		}catch (NullPointerException e) {
			
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
			return false;
		}catch (TimeoutException e) {
			
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
			return false;
		}
	}

	
	/**
	 * Checks if is element present by ele.
	 *
	 * @param by {@link By}
	 * @return true, if element is present by else false
	 */
	public boolean isElementPresentByEle(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * Checks if is element displayed by WebElement.
	 *
	 * @param ele the ele
	 * @return true, if is element displayed by WebElement
	 */
	public static boolean isDisplayedByElement(WebElement ele) {
		boolean eleDisplayed = false;
		try {
			if(ele.isDisplayed()){
				return eleDisplayed = true;
			}
		} catch (NoSuchElementException e) {
			eleDisplayed = false;
		}
		return eleDisplayed;
	}
	
	/**
	 * Checks if is element enabled by WebElement.
	 *
	 * @param ele the ele
	 * @return true, if is element enabled by WebElement
	 */
	public static boolean isElementEnabledByEle(WebElement ele) {
		boolean eleDisplayed = false;
		try 
		{
			if(ele.isEnabled())
			{
				return eleDisplayed = true;
			}
		} 
		catch (NoSuchElementException e)
		{
			eleDisplayed = false;
		}
		return eleDisplayed;
	}
	
	/**
	 * Checks if is element selected by WebElement.
	 *
	 * @param ele the ele
	 * @return true, if is element selected by WebElement
	 */
	public static boolean isElementSelectedByEle(WebElement ele) {
		boolean eleDisplayed = false;
		try {
			if(ele.isSelected()){
				return eleDisplayed = true;
			}
		} catch (NoSuchElementException e) {
			eleDisplayed = false;
		}
		return eleDisplayed;
	}

	/**
	 * Checks if is alert present.
	 *
	 * @return true, if is alert present
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	/**
	 * Close alert and get its text.
	 *
	 * @return the text of Alert
	 */
	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
	
	/**
	 * Wait for text to appear.
	 *
	 * @param newDriver the new driver
	 * @param textToAppear the text to appear
	 * @param element the element
	 * @param logger the logger
	 * @return true, if successful
	 */
	public static boolean waitForTextToAppear(WebDriver newDriver, String textToAppear, WebElement element,ExtentTest logger) 
	{
		boolean textFound = false;
	    try {
			WebDriverWait wait = new WebDriverWait(newDriver,30);
			wait.until(ExpectedConditions.textToBePresentInElement(element, textToAppear));
			textFound = true;
		} catch (Exception e) {
			
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
		}
	    return textFound;
	}


	public static WebElement getChildElement(WebDriver newDriver, 
			WebElement parentElement,
			By by,
			ExtentTest logger) {
		WebElement childEle = null;
		try {
				parentElement.findElement(by);
				return childEle;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return childEle;
	}
	
	
	
	/* This below functions are created by Amol for reference  */
	
	public static String getDateAndTimeAsString(){
		
		/*Date date = new Date();
		long dateTime =  date.getTime()+ date.getDate();
		 return Long.toString(dateTime);*/
		 
		 /*Calendar c = new Calendar();
		//c.add(Calendar.DAY_OF_MONTH, -1);
		Date d = c.getTime();
		 */
		
		DateFormat timestamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String time = "" + timestamp.format(cal.getTime());
		return time;
		
	}
	
	
	public static boolean IsElementEnable(WebElement Element)
	{
		try
		{
			Element.isEnabled();
			Log.info("element is enable..."+Element.getText());
			return true;
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
			return false;
		}
	}
	
	public static boolean IsElementNotEnable(WebElement Element)
	{
		try
		{
			Element.isEnabled();
			Log.info("element is enable..."+Element.getText());
			return false;
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));
			return true;
		}
	}
	
	public static boolean IselementEmpty(WebDriver driver,WebElement element)
	{
		boolean Istextpresent=false;
		
		try
		{
						
			//elementvalue1= element.getText().isEmpty() ? true: false;
			String text = element.getText();
			
			if(Istextpresent=text.isEmpty())
			{
				return true;
			}
			
			 	
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 90));

		}
		
		return Istextpresent;
	}
	
	
	 public static void CloseToasterMessage(WebDriver driver,WebElement closeToast)
	 {
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", closeToast);
	 }
	
	
}
