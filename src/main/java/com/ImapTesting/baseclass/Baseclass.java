package com.ImapTesting.baseclass;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ImapTesting.commonfunction.Web_Page;
import com.ImapTesting.utilities.Common_Utilities;

public class Baseclass 

{
	public static  WebDriver driver;
	public static Properties prop;

	
    /* public void getbrowser(String browser)
     {
    	 if(System.getProperty("os.name").contains("Window"))
    	 {
    		 if(browser.equalsIgnoreCase("chrome"))
    		 {
    			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
    			 driver = new ChromeDriver(); 
    		 }
    	 }
     }
     */
     public  Baseclass()
     
     {
    	 try
            {
         prop = new Properties();
         FileInputStream ip = new FileInputStream("C:/Users/ckhobra/Desktop/Imap_Automation_Framework/Imap/src/main/java/com/ImapTesting/config/config.properties");
    	 prop.load(ip);
        } 
    	 catch(FileNotFoundException e)
    	 {
    		 e.printStackTrace();
    	
    	 }
    	 catch(IOException e)
    	 {
    		 e.printStackTrace();
    	 }
    	 
    	 }
     
     public static void initialization()
     {
    	String browsername = prop.getProperty("browser");
    	
    	if(browsername.equalsIgnoreCase("chrome"));
    	{
    		//System.setProperty("webdriver.chrome.driver","C:/ChromeSelenium/chromedriver.exe");
    		//System.getProperty("user.dir")+"/Drivers/chromedriver.exe
    		
    		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
    		driver = new ChromeDriver();
    	}
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	Web_Page.waitForPageLoad(driver);
    	Web_Page.waitForJSandJQueryToLoad(driver);
    	
    	
    	
    	
    	
    	//Common_Utilities.waitJQueryAngular();
    	
    	driver.manage().timeouts().pageLoadTimeout(Common_Utilities.Page_load_timeout, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(Common_Utilities.Implicit_wait, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    	
     }
     
}
