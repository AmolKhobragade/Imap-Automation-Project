package com.ImapTesting.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ImapTesting.baseclass.Baseclass;



public class Common_Utilities extends Baseclass

{
   public static long Page_load_timeout = 30;
   public static long Implicit_wait = 10;
   
   
   private static WebDriver jsWaitDriver;
   private static WebDriverWait jsWait;
   private static JavascriptExecutor jsExec;
   
   public static void Pageloader()
   {
 	  WebDriverWait wait = new WebDriverWait(driver,10);
 	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='page_loader']")));
   }
   
   
   
   public Boolean PageloaderDismiss(WebDriver driver,long time,By locator)
   {
	   WebDriverWait wait = new WebDriverWait(driver,time);
	   wait.pollingEvery(Duration.ofSeconds(5));
	   wait.ignoring(NoSuchElementException.class);
	   return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));    
   }
   
   
   public static void PageUrl(String locator,int timeout) 
   {
 	  WebDriverWait wait = new WebDriverWait(driver,timeout);
 	  wait.until(ExpectedConditions.urlToBe(locator));
   }
   
   
   public WebElement waitforElement(WebDriver driver,long time,WebElement element)
   {
	   WebDriverWait wait = new WebDriverWait(driver,time);
	   return wait.until(ExpectedConditions.elementToBeClickable(element));    
   }
   
   
   
   public WebElement waitforElementwithpollinginterval(WebDriver driver,long time,WebElement element)
   {
	   WebDriverWait wait = new WebDriverWait(driver,time);
	   wait.pollingEvery(Duration.ofSeconds(5));
	   wait.ignoring(NoSuchElementException.class);
	   return wait.until(ExpectedConditions.elementToBeClickable(element));    
   }
   
   public Boolean WaitForTextMatch(WebDriver driver,long time,By element,String Value)
   {
	   WebDriverWait wait = new WebDriverWait(driver,time);
	   wait.pollingEvery(Duration.ofSeconds(5));
	   wait.ignoring(NoSuchElementException.class);
	   wait.ignoring(NullPointerException.class);
	   return wait.until(ExpectedConditions.textToBe(element, Value));    
   }
   
   
   
   
 /*  public static String Screenhsot(WebDriver WebDriver,String ScreenshotName) throws IOException
   {
 	String DateName= new SimpleDateFormat(" yyyy-MM-dd  hh-mm-ss").format(new Date());
 	
 	TakesScreenshot TS= (TakesScreenshot)driver;
 	
 	File Source= TS.getScreenshotAs(OutputType.FILE);
 	
 	String Destination = System.getProperty("user.dir")+"/FailedTestScreenhsot/"+ScreenshotName+DateName+".png";
 	
 	File FinalDestination=new File(Destination);
 	FileUtils.copyFile(Source, FinalDestination);
 	return Destination;
  
   }*/
   
   
   public static String getscreenshot(WebDriver WebDriver,String imagename) throws IOException
   {
	   if(imagename.equals(""))
	   {
		   imagename="blank";
	   }
	   File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   String imagelocation = System.getProperty("user.dir")+"/ScreenshotFolder/";
	   Calendar cal = Calendar.getInstance();
	   SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy_hh.mm.ss");
	   String actualimagename=imagelocation+imagename+"_"+formater.format(cal.getTime())+".png"; 
	   File destFile = new File(actualimagename);
	  
	   FileUtils.copyFile(image, destFile);
	   return actualimagename;
   }
   

   public void ThreadSleep(int waittime)
   {
 	  try
 	  {
 		Thread.sleep(waittime);
 		
 	} 
 	  catch (InterruptedException e) 
 	  {
 		
 		e.printStackTrace();
 	}
   }
  
   
 //Get the driver 
   public static void setDriver (WebDriver driver)
   {
       jsWaitDriver = driver;
       jsWait = new WebDriverWait(jsWaitDriver, 10);
       jsExec = (JavascriptExecutor) jsWaitDriver;
   }

   //Wait for JQuery Load
   public static void waitForJQueryLoad()
   {
       //Wait for jQuery to load
       ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) jsWaitDriver)
               .executeScript("return jQuery.active") == 0);

       //Get JQuery is Ready
       boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

       //Wait JQuery until it is Ready!
       if(!jqueryReady)
       {
           System.out.println("JQuery is NOT Ready!");
           //Wait for jQuery to load
           jsWait.until(jQueryLoad);
       } else
       {
           System.out.println("JQuery is Ready!");
       }
   }


   //Wait for Angular Load
   public static void waitForAngularLoad()
   {
       WebDriverWait wait = new WebDriverWait(jsWaitDriver,15);
       JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

       String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

       //Wait for ANGULAR to load
       ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
               .executeScript(angularReadyScript).toString());

       //Get Angular is Ready
       boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());

       //Wait ANGULAR until it is Ready!
       if(!angularReady)
       {
           System.out.println("ANGULAR is NOT Ready!");
           //Wait for Angular to load
           wait.until(angularLoad);
       } 
       else
       {
           System.out.println("ANGULAR is Ready!");
       }
   }

   //Wait Until JS Ready
   public static void waitUntilJSReady()
   
   {
       WebDriverWait wait = new WebDriverWait(jsWaitDriver,15);
       JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

       //Wait for Javascript to load
       ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) jsWaitDriver)
               .executeScript("return document.readyState").toString().equals("complete");

       //Get JS is Ready
       boolean jsReady =  jsExec.executeScript("return document.readyState").toString().equals("complete");

       //Wait Javascript until it is Ready!
       if(!jsReady)
       {
           System.out.println("JS in NOT Ready!");
           //Wait for Javascript to load
           wait.until(jsLoad);
       } 
       else
       {
           System.out.println("JS is Ready!");
       }
   }

   //Wait Until JQuery and JS Ready
   public static void waitUntilJQueryReady()
   {
       JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

       //First check that JQuery is defined on the page. If it is, then wait AJAX
       Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
       if (jQueryDefined == true)
       {
           //Pre Wait for stability (Optional)
           sleep(20);

           //Wait JQuery Load
           waitForJQueryLoad();

           //Wait JS Load
           waitUntilJSReady();

           //Post Wait for stability (Optional)
           sleep(20);
       }  
       else
       {
           System.out.println("jQuery is not defined on this site!");
       }
   }

   //Wait Until Angular and JS Ready
   public static void waitUntilAngularReady()
   {
       JavascriptExecutor jsExec = (JavascriptExecutor) jsWaitDriver;

       //First check that ANGULAR is defined on the page. If it is, then wait ANGULAR
       Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
       if (!angularUnDefined)
       {
           Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
           if(!angularInjectorUnDefined)
           {
               //Pre Wait for stability (Optional)
               sleep(20);

               //Wait Angular Load
               waitForAngularLoad();

               //Wait JS Load
               waitUntilJSReady();

               //Post Wait for stability (Optional)
               sleep(20);
           } 
           else
           {
               System.out.println("Angular injector is not defined on this site!");
           }
       }  
       else 
       {
           System.out.println("Angular is not defined on this site!");
       }
   }

   //Wait Until JQuery Angular and JS is ready
   public static void waitJQueryAngular()
   {
       waitUntilJQueryReady();
       waitUntilAngularReady();
   }

   public static void sleep (Integer seconds)
   {
       long secondsLong = seconds;
       try 
       {
          Thread.sleep(secondsLong);
       } catch (InterruptedException e)
       {
           e.printStackTrace();
       }
   }
   
   public static void closebrowser()
   {
	   driver.quit();
   }
   
  
   public void waitForLoad(WebDriver driver) 
   {
       ExpectedCondition<Boolean> pageLoadCondition = new
               ExpectedCondition<Boolean>() 
       {
                   public Boolean apply(WebDriver driver)
                   {
                       return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                   }
               };
       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(pageLoadCondition);
   }
   
   
   
}
