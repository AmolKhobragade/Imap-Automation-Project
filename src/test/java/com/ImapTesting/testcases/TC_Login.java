package com.ImapTesting.testcases;

import java.io.IOException;
import java.util.Locale;

import org.apache.log4j.Logger;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.WebElement_Common;
import com.ImapTesting.pages.DashboardPage;

import com.ImapTesting.pages.Loginpage;

import com.ImapTesting.utilities.Common_Utilities;
import com.ImapTesting.utilities.Report_HTML;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_Login extends Baseclass

{
	Loginpage login;
	DashboardPage dash;
	Report_HTML report;
	Logger log=Logger.getLogger(TC_Dashboard.class);
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports Extents;
	public ExtentTest Extentest;
	
	public TC_Login()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
		login = new Loginpage();
		 
	}
	
	@AfterClass
	public void QuitBrowser()
	{
		//Common_Utilities.closebrowser();
	}
	
	@BeforeTest
	public void setExtentReport()
	{
		//report.SetExtent();
		
		
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
		
		
		
		
		/*htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ImapTestReport.html");
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
		htmlreporter.config().setEncoding("utf-8");*/
		
		
	}
	
	
	/*@AfterTest
	public void EndReport()
	{
		
		report.EndReport();
	}*/
	
	
	@AfterMethod
	 public void teardown(ITestResult result) throws IOException
	  {
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			  Extentest.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+":Test Case is Failed", ExtentColor.RED) );
			  Extentest.log(Status.FAIL, "Test Case is Failed" + result.getThrowable());
			  String Screenshotpath=Common_Utilities.getscreenshot(driver,result.getName());
			  Extentest.log(Status.FAIL,"Screenshot of Bug : " + Extentest.addScreenCaptureFromPath(Screenshotpath));
		  }
		  else if (result.getStatus()==ITestResult.SKIP)
		  {
			  Extentest.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+":Test Case is Skipped",ExtentColor.GREY ));
			  
		  }
		  else if(result.getStatus()==ITestResult.SUCCESS) 
		  {
			  Extentest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+":Test Case is Passed",ExtentColor.GREEN )); 
		  }
		  
		  Extents.flush();
		  
	  }
	
	

	@Test(priority=1)
	public void testloginusinginvaliddata() //throws InterruptedException
	{
		Extentest=Extents.createTest("testloginusinginvaliddata");
		login.Invalidgidandpass("abc", "123");
		WebElement_Common.waitForElementPresent(driver, login.Errormsg_login, Extentest);
		login.CheckLoginErrorMsg();
		//Assert.assertEquals(login.CheckLoginErrorMsg(), "The User ID and Password that you provided are not correct.");
		
	}
	
	
	/*@Test(priority=2)
	public void landingpageafterlogin() //throws InterruptedException
	{
		Extentest=Extents.createTest("landingpageafterlogin");
		dash=login.validatelogin(prop.getProperty("globalid"), prop.getProperty("password"));
		//Thread.sleep(5000);
	}*/
	
	/*@Test(priority=3)
	public void validatedashboardtitle() //throws InterruptedException
	{
		Extentest=Extents.createTest("validatedashboardtitle");
		WebElement_Common.waitForElementPresent(driver, dash.Nav_MyProject, Extentest);
		String title = login.CheckDashboardTitle();
		Assert.assertEquals(title, "Dashboard", "Dashboard Page is displayed");
		//Thread.sleep(5000);
	}*/
	
	
	
}
