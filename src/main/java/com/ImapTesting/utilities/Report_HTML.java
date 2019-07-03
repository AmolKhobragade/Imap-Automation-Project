package com.ImapTesting.utilities;


import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat; 
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ImapTesting.baseclass.Baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report_HTML extends Baseclass

{

	//public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports Extents;
	public ExtentTest Extentest;
	
	public ITestResult result;
	
	/*public void HTMLReport()
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		Extents = new ExtentReports(System.getProperty("user.dir")+"/Reports/"+formater.format(calendar.getTime())+".html",false);
        
	}
	*/

     //@BeforeTest	
	public void SetExtent()
	{
		/*Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+formater.format(calendar.getTime())+"ImapTestReport.html");
		Extents=new ExtentReports();*/
		//Extentest.getModel().setStartTime(getTime(result.getStartMillis()));
		//Extentest.getModel().setEndTime(getTime(result.getStartMillis()));
		
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/ImapTestReport.html");
		Extents=new ExtentReports();
		Extents.attachReporter(htmlreporter);
		Extents.getClass();
		//Extentest=
		//Extents.createTest(getClass().getSimpleName());
		Locale.setDefault(Locale.ENGLISH);
		Extents.setSystemInfo("Host Name", "Window");
		Extents.setSystemInfo("Global id", "ckhobra");
		Extents.setSystemInfo("Environment", "Automation Testing");
		Extents.setSystemInfo("Project Name", "Imap");
		Extents.setSystemInfo("Imap_Version", "8.8.9");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setDocumentTitle("Imap Testing Report");
		htmlreporter.config().setEncoding("utf-8");
		
	}	
	
	public Date getTime(long millis)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
	
	 //@AfterTest
		public void EndReport()
		{
		   
			Extents.flush();
			
			
		}
	
	   

	   public void aftermethod(ITestResult result) throws IOException
	   {
		   teardown(result);
	   }
	   
	   
	  
	   public void beforeMethod(Method result)
	   {
		   Extentest=Extents.createTest(result.getName());
		   Extentest.log(Status.INFO,result.getName()+"Test Case is starting");
	   }
	   
	   
	 
	
	 
	  public void teardown(ITestResult result) throws IOException
	  {
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			  Extentest.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"::Test Case is Failed", ExtentColor.BROWN) );
			  Extentest.log(Status.FAIL, "Test Case is Failed"+result.getThrowable());
			  String Screenshotpath=Common_Utilities.getscreenshot(driver,result.getName());
			  Extentest.log(Status.FAIL,"Screenshot of Bug :-"+Extentest.addScreenCaptureFromPath(Screenshotpath));
		  }
		  else if (result.getStatus()==ITestResult.SKIP)
		  {
			  Extentest.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"::Test Case is Skipped",ExtentColor.GREY ));
			  
		  }
		  else if(result.getStatus()==ITestResult.SUCCESS) 
		  {
			  Extentest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"::Test Case is Passed",ExtentColor.GREEN )); 
		  }
	
	
		 
		
	}
	  
	 
	  
	  
	  
	  
	  
	}
	

