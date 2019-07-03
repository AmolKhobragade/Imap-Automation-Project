package com.ImapTesting.testcases;

import java.io.IOException;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.WebElement_Common;
import com.ImapTesting.commonfunction.Web_Button;
import com.ImapTesting.pages.Dash_MyProject;
import com.ImapTesting.pages.Dash_MyUnit;
import com.ImapTesting.pages.DashboardPage;
import com.ImapTesting.pages.Loginpage;
import com.ImapTesting.pages.NewProject_CreateProject;
import com.ImapTesting.pages.New_Project;
import com.ImapTesting.utilities.Common_Utilities;
import com.ImapTesting.utilities.WaitFunction;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_MyUnit_CreateUnit extends Baseclass
{
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports Extents;
	public ExtentTest Extentest;
	public Logger log=Logger.getLogger(TC_MyUnit_CreateUnit.class);
	Loginpage login;
	DashboardPage dash;
	New_Project NewProj;
	NewProject_CreateProject CreateProject;
	WaitFunction Wait;
	TC_Dashboard DashPage;
	Dash_MyProject MyPoject;
	TC_NewProject NewPrj;
	Dash_MyProject MyProject_Dash;
	NewProject_CreateProject ProjClick;
	Dash_MyUnit Click1;
	
	public TC_MyUnit_CreateUnit()
	{
		super();
	}
	
	@BeforeClass
	public void setup()
	{
		initialization();
		login = new Loginpage();
		NewProj=new New_Project();
		CreateProject=new NewProject_CreateProject();
		MyProject_Dash = new Dash_MyProject();
		ProjClick=new NewProject_CreateProject();
		Click1=new Dash_MyUnit();
	}
	
	@AfterClass
	public void QuitBrowser()
	{
		Common_Utilities.closebrowser();
	}
	
	@BeforeTest
	public void setExtentReport()
	{
		//report.SetExtent();
	
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/ImapTestReport.html");
		//htmlreporter.setAppendExisting(false);
		Extents=new ExtentReports();
		Extents.attachReporter(htmlreporter);
		Extents.getClass();
		//Extents.createTest(getClass().getSimpleName());
		Locale.setDefault(Locale.ENGLISH);
		Extents.setSystemInfo("Host Name", "Window");
		Extents.setSystemInfo("Global id", "ckhobra");
		Extents.setSystemInfo("Environment", "Automation Testing");
		Extents.setSystemInfo("Project Name", "Imap");
		Extents.setSystemInfo("Imap_Version", "10.1.12.0");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setDocumentTitle("Imap Testing Report");
		htmlreporter.config().setEncoding("utf-8");
		
	}
	
	@AfterMethod
	 public void teardown(ITestResult result) throws IOException
	  {
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			  Extentest.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+"::Test Case is Failed", ExtentColor.RED) );
			  Extentest.log(Status.FAIL, "Test Case is Failed"+result.getThrowable());
			  String Screenshotpath=Common_Utilities.getscreenshot(driver,result.getName());
			  Extentest.log(Status.FAIL,"Screenshot of Bug :-"+Extentest.addScreenCaptureFromPath(Screenshotpath));
		  }
		  else if (result.getStatus()==ITestResult.SKIP)
		  {
			  Extentest.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"::Test Case is Skipped",ExtentColor.BROWN ));
			  
		  }
		  else if(result.getStatus()==ITestResult.SUCCESS) 
		  {
			  Extentest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"::Test Case is Passed",ExtentColor.GREEN )); 
		  }
		 
		  Extents.flush();
	  }
	
	@Test(priority=1)
	public void Successfulllogin()
	{
		Extentest=Extents.createTest("Successfulllogin");
		dash=login.Validate_Loginusing_ValidCredential(prop.getProperty("globalid"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void validatedashboardpage()
	{
		Extentest=Extents.createTest("validatedashboardpage");
		WebElement_Common.waitForElementPresent(driver, dash.Nav_MyProject, Extentest);
		String title = login.CheckDashboardTitle();
		Assert.assertEquals(title, "Dashboard", "Dashboard Page is displayed");		
	}
	
	@Test(priority=3)
	public void Verify_clickMyunit()
	{
		Extentest=Extents.createTest("Verify_clickMyunit");
		Common_Utilities.Pageloader();
		Click1.Validate_Icon_MyUnit();
		Common_Utilities.Pageloader();

	}
	@Test(priority=4)
	public void Verify_Btn_ClickCreateUnit()
	{
		Extentest=Extents.createTest("Verify_Btn_ClickCreateUnit");
		WebElement_Common.waitForElementPresent(driver,Click1.CreateUnitButton, Extentest);
		Common_Utilities.Pageloader();
		Click1.Validate_ClickCreateUnit();
		
	}
	@Test(priority=5)
	public void Verify_ProjectDropDownList()
	{
		Extentest=Extents.createTest("Verify_ProjectDropDownList");
		Click1.Validate_SelectProjectlist();
		Common_Utilities.Pageloader();
	}
	@Test(priority=6)
	public void Verify_EnterUnitName()
	{
		Extentest=Extents.createTest("Verify_EnterUnitName");
		Click1.Validate_UnitName(driver, "HP");
	}
	@Test(priority=7)
	public void Verify_SelectUnitType()
	{
		Extentest=Extents.createTest("Verify_SelectUnitType");
		Web_Button.Button_Click(driver, Click1.Drop_UnitType);
        Click1.Validate_SelectUnitType();
        Common_Utilities.Pageloader();
       
	}
	@Test(priority=8)
	public void Verify_SelectConfig()	
	{
		Extentest=Extents.createTest("Verify_SelectConfig");
		Web_Button.Button_Click(driver, Click1.Drop_Config);
		Click1.Validate_SelectConfig();
	}
	@Test(priority=9)
	public void Verify_SelectRefrigerant()
	{
		Extentest=Extents.createTest("Verify_SelectRefrigerant");
		Click1.Validate_RefrigerantList();
	}
	@Test(priority=10)
	public void Verify_CheckToaster()
	{
		Extentest=Extents.createTest("Verify_CheckToaster");
		Click1.Validate_BtnSave();
		Common_Utilities.Pageloader();
		Assert.assertTrue(Click1.CheckErrorMsgMyUnit().contains("Duplicate Unit Name."));

	}
	@Test(priority=11)
	public void Verify_BtnClickCancel()
	{
		Extentest=Extents.createTest("Verify_BtnClickCancel");
		Click1.Validate_BtnCancel();
	}
	
}
