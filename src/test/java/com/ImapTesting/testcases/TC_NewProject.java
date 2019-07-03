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

public class TC_NewProject extends Baseclass
{

	public ExtentHtmlReporter htmlreporter;
	public ExtentReports Extents;
	public ExtentTest Extentest;
	public Logger log=Logger.getLogger(TC_NewProject.class);
	Loginpage login;
	DashboardPage dash;
	New_Project NewProj;
	NewProject_CreateProject CreateProject;
	WaitFunction Wait;
	public TC_NewProject()
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
	
	/* The Below Test Cases are for
	 *  Dashboard>>Residential icon>>Create Project
	 */
	
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
	public void Validate_NewProject_ResProject()
	{
		Extentest=Extents.createTest("Validate_NewProject_ResProject");
		//Wait.waitforelement(NewProj.Dash_ResProject, 5, 1);
		WaitFunction.waitForElementToBeClickable(driver, NewProj.Dash_ResProject, Extentest);
		NewProj.Click_Dash_ResProject();
		
			
	}
	
	/*@Test(priority=4)
	public void Verify_LblCreateProject()
	{
		Extentest=Extents.createTest("Verify_LblCreateProject");
		Common_Utilities.Pageloader();
		Assert.assertEquals(CreateProject.Validate_LblCreateProject(), "Create Project", "Create Project pop up of Residential Project is getting opened and Create Project label is displayed ");
	}
	*/
	
	@Test(priority=4)
	public void ClickGrpDrop()
	{
		Extentest=Extents.createTest("ClickGrpDrop");
		WebElement_Common.waitForElementPresent(driver, CreateProject.DD_Group, Extentest);
		CreateProject.ClickGroupDropDownBox();
	}
	
	@Test(priority=5)
	public void Verify_GroupDropDownList()
	   {
		Extentest=Extents.createTest("Verify_GroupDropDownList");
		CreateProject.Validate_GroupDropdown();
		}
	
	@Test(priority=6)
	public void Verify_DropDownEnableOrNot()
	   {
		Extentest=Extents.createTest("Verify_DropDownEnableOrNot");
		Assert.assertEquals(CreateProject.Validate_ProductLineStatus(), false, "If user click dash product line then the product line of create project should be disable :");
	   }
	
	
	@Test(priority=7)
	public void Verify_SaveBtn()
	{
		Extentest=Extents.createTest("Verify_SaveBtn");
		Assert.assertEquals(CreateProject.Validate_BtnSave(), false, "If user redirect to create project pop up then save button should be disable");
	}
	
	@Test(priority=8)
	public void Verify_BtnClickCancel()
	{
		Extentest=Extents.createTest("Verify_BtnClickCancel");
		CreateProject.Btn_ClickCancel();
	}
	
	/* Below Test Cases for the 
	 *  Residential>>Rooftop Icon>>Create Project
	 */
	
	@Test(priority=9)
	public void Validate_NewProject_RoofProject()
	{
		Extentest=Extents.createTest("Validate_NewProject_ResProject");
		//Wait.waitforelement(NewProj.Dash_ResProject, 5, 1);
		WaitFunction.waitForElementToBeClickable(driver, NewProj.Dash_RoofProject, Extentest);
		NewProj.Click_Dash_RoofProject();		
	}
	
	
	@Test(priority=10)
	public void Roof_ClickGrpDrop()
	{
		Extentest=Extents.createTest("ClickGrpDrop");
		WebElement_Common.waitForElementPresent(driver, CreateProject.DD_Group, Extentest);
		CreateProject.ClickGroupDropDownBox();
	}
	
	@Test(priority=11)
	public void Verify_RoofGroupDropDownList()
	   {
		Extentest=Extents.createTest("Verify_GroupDropDownList");
		CreateProject.Validate_GroupDropdown();
		}
	
	@Test(priority=12)
	public void Verify_RoofDropDownEnableOrNot()
	   {
		Extentest=Extents.createTest("Verify_DropDownEnableOrNot");
		Assert.assertEquals(CreateProject.Validate_ProductLineStatus(), false, "If user click dash product line then the product line of create project should be disable :");
	   }
	
	
	@Test(priority=13)
	public void Verify_RoofSaveBtn()
	{
		Extentest=Extents.createTest("Verify_SaveBtn");
		Assert.assertEquals(CreateProject.Validate_BtnSave(), false, "If user redirect to create project pop up then save button should be disable");
	}
	
	@Test(priority=14)
	public void Verify_RoofBtnClickCancel()
	{
		Extentest=Extents.createTest("Verify_BtnClickCancel");
		CreateProject.Btn_ClickCancel();
	}
	
	/* Below Test Cases for the 
	 *  Residential>>RAC/PAC Icon>>Create Project
	 */
	
	@Test(priority=15)
	public void Validate_NewProject_RACPACProject()
	{
		Extentest=Extents.createTest("Validate_NewProject_ResProject");
		//Wait.waitforelement(NewProj.Dash_ResProject, 5, 1);
		WaitFunction.waitForElementToBeClickable(driver, NewProj.Dash_RACPACProject, Extentest);
		NewProj.Click_Dash_RACPACProject();		
	}
	
	
	@Test(priority=16)
	public void RACPAC_ClickGrpDrop()
	{
		Extentest=Extents.createTest("ClickGrpDrop");
		WebElement_Common.waitForElementPresent(driver, CreateProject.DD_Group, Extentest);
		CreateProject.ClickGroupDropDownBox();
	}
	
	@Test(priority=17)
	public void Verify_RACPACGroupDropDownList()
	   {
		Extentest=Extents.createTest("Verify_GroupDropDownList");
		CreateProject.Validate_GroupDropdown();
		}
	
	@Test(priority=18)
	public void Verify_RACPACDropDownEnableOrNot()
	   {
		Extentest=Extents.createTest("Verify_DropDownEnableOrNot");
		Assert.assertEquals(CreateProject.Validate_ProductLineStatus(), false, "If user click dash product line then the product line of create project should be disable :");
	   }
	
	
	@Test(priority=19)
	public void Verify_RACPACSaveBtn()
	{
		Extentest=Extents.createTest("Verify_SaveBtn");
		Assert.assertEquals(CreateProject.Validate_BtnSave(), false, "If user redirect to create project pop up then save button should be disable");
	}
	
	@Test(priority=20)
	public void Verify_RACPACBtnClickCancel()
	{
		Extentest=Extents.createTest("Verify_BtnClickCancel");
		CreateProject.Btn_ClickCancel();
	}
	
}
