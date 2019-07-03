package com.ImapTesting.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ImapTesting.baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WaitFunction extends Baseclass
{
    private final static Logger log = LogManager.getLogger(ExpectedConditions.class.getName());

	
	
	public static String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, String elementXPath)
	{
	    if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty())
	    {

	        return "Wrong usage of WaitforElementNotVisible()";
	    }
	    
	    try 
	    {
	        (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By
	                .xpath(elementXPath)));
	        return null;
	    } catch (TimeoutException e) 
	    
	    {
	        return "Wait for loader to disapear";
	    }
	    
	    
	    

	   

	
}
	

	
	public WebElement getWhenVisible(By locator, int timeout)
	
	{

		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element;

		}
	
	
	public static void clickWhenReady(By locator, int timeout) 
	{

		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		element.click();

	}
	
	
	

	public static void clickOn(WebDriver driver, WebElement locator, int timeout)
	 {
	        new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	        locator.click();

	    }
	
	
	public static void VisibleClick(WebDriver driver, WebElement locator, int timeout)
	 {
	        new WebDriverWait(driver,timeout).ignoring(NullPointerException.class).until(ExpectedConditions.elementToBeClickable(locator));
	        locator.click();

	    }
	
	public static void VisibleOnly(WebDriver driver, WebElement locator, int timeout)
	
	    {
	        new WebDriverWait(driver,timeout).ignoring(NullPointerException.class).until(ExpectedConditions.visibilityOf(locator));
	      
	    }
	
	
	
	public boolean isElementPresent(WebElement element) 
	{
		   try 
		   {
		       element.getText();
		       return true;
		       
		      } 
		   catch (NoSuchElementException e)
		   {
		       return false;
		      }
}
	
	
	public void pressKeyEnter(WebElement element)
	{
		element.sendKeys(Keys.ENTER);
		
	}
	
	
	
	public static String getElementText(WebDriver driver, WebElement webelement,ExtentTest Extents) 
	{	
		String elementText = null;

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

		try {
			elementText = webelement.getText();
			Extents.log(Status.PASS, "User get the element text -- "+ elementText);   
		} catch (NoSuchElementException e) {
			Extents.log(Status.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
		}
		return elementText;
	}
	
	
	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(Duration.ofSeconds(5))
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
		public static boolean waitForElementToBeClickable(WebDriver driver, WebElement webElement, ExtentTest logger) throws TimeoutException{
			try {
				//Thread.sleep(5000);
				Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					  //Wait for the condition with timeout 30 seconds
					      .withTimeout(Duration.ofSeconds(5))
					        // poll interval of 1 seconds. 
					      .pollingEvery(Duration.ofMillis(1)) 
					        //ignore the NoSuchElementException
					      .ignoring(NoSuchElementException.class);
				fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));
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
		
		/* This wait function are created by amol for references
		 * */
		
		/*
		 * This is Implicit wait
		 * */
		
		public WaitFunction(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public void setImplicitwait(long timeout,TimeUnit unit)
		{
			log.info("Implicit wait has been set to: "+timeout);
			driver.manage().timeouts().implicitlyWait(timeout, unit);
			
		}
		
		private WebDriverWait getwait(int timeoutinsec,int pollingeverysec)
		{
			WebDriverWait wait = new WebDriverWait(driver,timeoutinsec);
			wait.pollingEvery(Duration.ofMillis(pollingeverysec));
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(ElementNotVisibleException.class);
			wait.ignoring(StaleElementReferenceException.class);
			wait.ignoring(Exception.class);
			return null;
		}
		
		public void waitforelementvisiblewithpollingtime(WebElement element,int timeoutsec,int pollingeverysec )
		{
			log.info("waiting for :"+element.toString()+"for :"+timeoutsec+"Seconds");
			WebDriverWait wait = getwait(timeoutsec,pollingeverysec);
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Element is visible now");
		}
		
		
		public void waitforelementclickable(WebElement element,int timeoutsec)
		{
			log.info("waiting for :"+element.toString()+"for :"+timeoutsec+"Seconds");
			WebDriverWait wait = new WebDriverWait(driver,timeoutsec);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("Element is Clickable now");
		}
		
		public Wait<WebDriver> getfluentwait(int timeoutsec,int pollingeverysec)
		{
			Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(timeoutsec))
			        .pollingEvery(Duration.ofMillis(pollingeverysec)).ignoring(NoSuchElementException.class);
		   return fwait;
		}
		
		public WebElement waitforelement(WebElement element,int timeoutsec,int pollingeverysec )
		{
			Wait<WebDriver> fwait = getfluentwait(timeoutsec,pollingeverysec);
			fwait.until(ExpectedConditions.visibilityOf(element));
			return element;
		}
		
		
	
		
		
		
	}	
