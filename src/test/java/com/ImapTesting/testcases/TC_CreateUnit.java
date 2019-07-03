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
import com.ImapTesting.pages.CompressorConfig_Page;
import com.ImapTesting.pages.Create_Project;
import com.ImapTesting.pages.Create_Unit;
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

public class TC_CreateUnit extends Baseclass
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
	Create_Project createproject;
	Create_Unit createunit;
	CompressorConfig_Page Compressor;
	
	public TC_CreateUnit()
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
		createproject= new Create_Project();
		createunit=new Create_Unit();
		Compressor = new CompressorConfig_Page();
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
	public void Verify_clickresproj()
	{
		Extentest=Extents.createTest("Verify_clickresproj");
		WaitFunction.waitForElementToBeClickable(driver, NewProj.Dash_ResProject, Extentest);
		createproject.Validate_Click_DashResProject();
	}
	@Test(priority=4)
	public void Verify_nameproject()
	{
		Extentest=Extents.createTest("Verify_nameproject");
		createproject.Validate_Create_NewResProject(driver, "Automation Project 1.0");
	}
	@Test(priority=5)
	public void Verify_saveclick()
	{
		Extentest=Extents.createTest("Verify_saveclick");
		WaitFunction.waitForElementPresent(driver, createproject.Btn_Save, Extentest);
		createproject.Validate_BtnClick_Save();
	}
	@Test(priority=6)
	public void VerifyToasterMessage()
	{
		WaitFunction.waitForElementPresent(driver, Click1.CompleteToasterMessage1, Extentest);
		Assert.assertTrue(Click1.CheckErrorMsgMyUnit().contains("Project created successfully."));
		WebElement_Common.waitForElementPresent(driver,Click1.CreateUnitButton, Extentest);
	}
	@Test(priority=7)
	public void Verify_ClickCreateunit()
	{
		Extentest=Extents.createTest("Verify_ClickCreateunit");
		WebElement_Common.waitForElementPresent(driver,Click1.CreateUnitButton, Extentest);
		Common_Utilities.Pageloader();
		Click1.Validate_ClickCreateUnit();
	}
	@Test(priority=8)
	public void Verify_Unitnme()
	{
		Extentest=Extents.createTest("Verify_Unitnme");
		Click1.Validate_UnitName(driver, "Testing Unit 1.0");	
	}
	@Test(priority=9)
	public void Verify_selectunittype()
	{
		Extentest=Extents.createTest("Verify_selectunittype");
		Web_Button.Button_Click(driver, Click1.Drop_UnitType);
        Click1.Validate_SelectUnitType();
        Common_Utilities.Pageloader();
	}
	@Test(priority=10)
	public void Verify_selectconfiguration()
	{
		Extentest=Extents.createTest("Verify_selectconfiguration");
		Web_Button.Button_Click(driver, Click1.Drop_Config);
		Click1.Validate_SelectConfig();
	}
	@Test(priority=11)
	public void Verify_refrigerant()
	{
		Extentest=Extents.createTest("Verify_refrigerant");
		Click1.Validate_RefrigerantList();
	}
	@Test(priority=12)
	public void Verify_Altitude()
	{
		Extentest=Extents.createTest("Verify_Altitude");
		createunit.Validate_Altitude(driver, createunit.Txt_altitude, "10");
	}
	@Test(priority=13)
	public void Verify_UnitInfo()
	{
		Extentest=Extents.createTest("Verify_UnitInfo");
		createunit.Validate_Unitinfo(driver, createunit.Txt_unitinfo, "Automation Testing 1.0");
	}
	@Test(priority=14)
	public void Verify_clicksavebtn()
	{
		Extentest=Extents.createTest("Verify_clicksavebtn");
		WaitFunction.waitForElementPresent(driver, createunit.Btn_saveunit, Extentest);
		createunit.Validate_Btnsave();
	}
	@Test(priority=15)
	public void verify_ToastMsg()
	{
		Extentest=Extents.createTest("verify_ToastMsg");
		WaitFunction.waitForElementPresent(driver, Click1.CompleteToasterMessage1, Extentest);
		Assert.assertTrue(Click1.CheckErrorMsgMyUnit().contains("Unit created successfully."));
		WebElement_Common.waitForElementPresent(driver,Compressor.AddCompressor, Extentest);
	}
	
	
}
