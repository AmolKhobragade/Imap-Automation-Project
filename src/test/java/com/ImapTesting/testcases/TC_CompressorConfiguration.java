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
import com.ImapTesting.commonfunction.Javascript_Helper;
import com.ImapTesting.commonfunction.WebElement_Common;
import com.ImapTesting.commonfunction.Web_DropDown;
import com.ImapTesting.commonfunction.Web_Link;
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


public class TC_CompressorConfiguration extends Baseclass
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
	Javascript_Helper Helper;
	
	public TC_CompressorConfiguration()
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
		//Common_Utilities.closebrowser();
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
	
	@Test(priority=1,description="Verifying login to imap")
	
	public void Successfulllogin()
	{
		Extentest=Extents.createTest("Successfulllogin");
		dash=login.Validate_Loginusing_ValidCredential(prop.getProperty("globalid"), prop.getProperty("password"));
	}
	
	
	@Test(priority=2,description="Verifying dashboard title")
	
	public void validatedashboardpage()
	{
		Extentest=Extents.createTest("validatedashboardpage");
		WebElement_Common.waitForElementPresent(driver, dash.Nav_MyProject, Extentest);
		String title = login.CheckDashboardTitle();
		Assert.assertEquals(title, "Dashboard", "Dashboard Page is displayed");		
	}
	
	@Test(priority=3,description="Verifying my project page")
	
	public void clickMyProjectIcon()
	{
		Extentest=Extents.createTest("clickMyProjectIcon");
		Common_Utilities.Pageloader();
		dash.Validate_Dash_MyProjectIcon();
		Common_Utilities.Pageloader();
	}
	
	@Test(priority=4,description="Verifying the my project list")
		public void Verify_ProjectList()
	{
		Extentest=Extents.createTest("Verify_ProjectList");
		Compressor.Validate_ClickMyProject();
	}
	
	@Test(priority=5)
	public void Verify_UnittList()
	{
		Extentest=Extents.createTest("Verify_UnittList");
		//Common_Utilities.Pageloader();
		Compressor.Validate_clickUnitlist();
		//Common_Utilities.Pageloader();
		
		/* If my unit having multiple unit then below commented function 
		 * should be used
		 */
		
		//Compressor.Validate_ClickMyUnit();
	}
	@Test(priority=6)
	public void Verify_AddCompDrop()
	{
		Extentest=Extents.createTest("Verify_AddCompDrop");
		WebElement_Common.waitForElementPresent(driver,Compressor.AddCompressor, Extentest);
		Common_Utilities.Pageloader();
		Compressor.Validate_clickaddcomprebtn();
		Common_Utilities.Pageloader();
		Compressor.Validate_AddCompressordropdown();
	}
	
	@Test(priority=7)
	public void Verify_BtnPerformanceCal()
	{
		Extentest=Extents.createTest("Verify_BtnPerformanceCal");
		Assert.assertFalse(Web_Link.btnverify(driver, Compressor.Txt_Manufacture, Compressor.Txt_Model, Compressor.Btn_Performancecal, true));
		//Assert.assertFalse(Web_Link.btnverify(driver, Compressor.Txt_Manufacture, Compressor.Txt_Model, Compressor.Btn_Save));

	}
	
	@Test(priority=8)
	public void Verify_BtnCompressorSave()
	{
		Extentest=Extents.createTest("Verify_BtnCompressorSave");
		Assert.assertFalse(Web_Link.btnverify(driver, Compressor.Txt_Manufacture, Compressor.Txt_Model, Compressor.Btn_Save, true));
		//Assert.assertFalse(Web_Link.btnverify(driver, Compressor.Txt_Manufacture, Compressor.Txt_Model, Compressor.Btn_Save));

	}
	
	@Test(priority=9)
	public void Verify_BtnCompressorNext()
	{
		Extentest=Extents.createTest("Verify_BtnCompressorNext");
		Assert.assertFalse(Web_Link.btnverify(driver, Compressor.Txt_Manufacture, Compressor.Txt_Model, Compressor.Btn_Next, true));
		//Assert.assertFalse(Web_Link.btnverify(driver, Compressor.Txt_Manufacture, Compressor.Txt_Model, Compressor.Btn_Save));

	}
	
	@Test(priority=10)
	public void Verify_DefaultMassFlowMultiplier()
	{
		Extentest=Extents.createTest("Verify_DefaultMassFlowMultiplier");
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_MassFlowMultiplier), "1", "When the user setting is IP the  Default value of Mass flow multiplier is 1");
	}
	
	@Test(priority=11)
	public void Verify_DefaultPowerMultiplier()
	{
		Extentest=Extents.createTest("Verify_DefaultPowerMultiplier");
		//(Compressor.Txt_PowerMultiplier).sendKeys(Keys.ENTER);
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_PowerMultiplier), "1", "When the user setting is IP the  Default value of Power multiplier is 1");
	}
	
	@Test(priority=12)
	public void Verify_DefaultCurrentMultiplier()
	{
		Extentest=Extents.createTest("Verify_DefaultCurrentMultiplier");
		//(Compressor.Txt_CurrentMultiplier).sendKeys(Keys.ENTER);
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_CurrentMultiplier), "1", "When the user setting is IP the  Default value of Current multiplier is 1");
	}
	

	@Test(priority=13)
	public void Verify_DefaultShellHeatLoss()
	{
		Extentest=Extents.createTest("Verify_DefaultShellHeatLoss");
		//(Compressor.Txt_ShellHeatloss).sendKeys(Keys.ENTER);
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_ShellHeatloss), "0", "When the user setting is IP the  Default value of Shell heat loss is 0");
	}
	
	@Test(priority=14)
	public void Verify_DefaultType()
	{
		Extentest=Extents.createTest("Verify_DefaultType");
		//(Compressor.Txt_ShellHeatloss).sendKeys(Keys.ENTER);
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Type), "Scroll", "When the user setting is IP the  Default value of Type is SCROLL");
	}
	
	@Test(priority=15)
	public void Verify_Manufacture()
	{
		Extentest=Extents.createTest("Verify_Manufacture");
		Assert.assertTrue(WebElement_Common.IselementEmpty(driver, Compressor.Txt_Manufacture), "The manufacture field is not empty");	
	}
	
	@Test(priority=16)
	public void Verify_Model()
	{
		Extentest=Extents.createTest("Verify_Model");
		Assert.assertTrue(WebElement_Common.IselementEmpty(driver, Compressor.Txt_Model),"The model field is not empty");	

	}
	@Test(priority=17)
	public void Verify_DefaultVoltage()
	{
		Extentest=Extents.createTest("Verify_DefaultVoltage");
		//(Compressor.Txt_ShellHeatloss).sendKeys(Keys.ENTER);
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Voltage), "230", "When the user setting is IP the  Default value of Voltage is 230");
	}
	
	@Test(priority=18)
	public void Verify_DropdownPhase()
	{
		Extentest=Extents.createTest("Verify_DropdownPhase");
		//(Compressor.Txt_ShellHeatloss).sendKeys(Keys.ENTER);
	   //Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Voltage), "230", "When the user setting is IP the  Default value of Voltage is 230");
	   Assert.assertEquals(Web_Link.Verify_DefaultDropdownValue(driver, Compressor.Dropdown_Phase), "3", "Default value of Phase dropdown should be 3 ");
	   Web_DropDown.Verifyalldropdownvalue(driver, Compressor.Dropdown_Phase);
	}
	
	@Test(priority=19)
	public void Verify_DropdownRefrigerant()
	{
		Extentest=Extents.createTest("Verify_DropdownRefrigerant");
		//(Compressor.Txt_ShellHeatloss).sendKeys(Keys.ENTER);
	   //Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Voltage), "230", "When the user setting is IP the  Default value of Voltage is 230");
	   Assert.assertEquals(Web_Link.Verify_DefaultDropdownValue(driver, Compressor.Dropdown_Refrigerant), "ammonia", "Default value of Refrigernat  dropdown should be ammonia");
	   Web_DropDown.Verifyalldropdownvalue(driver, Compressor.Dropdown_Refrigerant);
	}
	
	@Test(priority=20)
	public void Verify_LblVoltage()
	{
		Extentest=Extents.createTest("Verify_LblVoltage");
		//Web_Link.SelectUsersetting_IP(driver, Compressor.Btn_Setting, Compressor.RadioBtn_IP,Compressor.RadioBtn_SI, Compressor.Btn_Done);
		//Web_Link.SelectUsersetting_IP(driver, Compressor.Btn_Setting, Compressor.RadioBtn_IP, Compressor.RadioBtn_SI, Compressor.Btn_closeToaster, Compressor.Btn_Done);
		//Compressor.CheckRadioButtonIP(driver, Compressor.Btn_Setting, Compressor.RadioBtn_IP, Compressor.Btn_Done);
		Web_Link.SelectUsersetting_IP(driver, Compressor.Btn_Setting, Compressor.RadioBtn_IP, Compressor.RadioBtn_SI, Compressor.CompleteToasterMessage, Compressor.Btn_closeToaster, Compressor.Btn_Done);
		Assert.assertEquals(WebElement_Common.getElementText(driver, Compressor.Unit_Voltage, Extentest), "VAC");
	}
	
	
	@Test(priority=21,dependsOnMethods = {"Verify_LblVoltage"})
	public void Verify_SatSucTemp()
	{
		Extentest=Extents.createTest("Verify_SatSucTemp");
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_SatSucTemp), "50", "When the user setting is IP the  Default value of Saturation Suction Temp is 50");
	}
	
	
	@Test(priority=22,dependsOnMethods = {"Verify_LblVoltage"})
	public void Verify_SatDisTemp()
	{
		Extentest=Extents.createTest("Verify_SatDisTemp");
		//Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_SatDisTemp), "120", "When the user setting is IP the  Default value of Saturation discharge Temp is 120");
		CompressorConfig_Page.SatDisTemp_IP(driver, Compressor.Txt_SatDisTemp);
	}
	
	@Test(priority=23,dependsOnMethods = {"Verify_LblVoltage"})
	public void Verify_LiqLineSubCool()
	{
		Extentest=Extents.createTest("Verify_LiqLineSubCool");
		//Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_LiqLineSubcool), "15", "When the user setting is IP the  Default value of Liq line sub cool is 15");
		CompressorConfig_Page.LiqLineSubCool_IP(driver, Compressor.Txt_LiqLineSubcool);
	}
	
	@Test(priority=24,dependsOnMethods = {"Verify_LblVoltage"})
	public void Verify_SucLineSubCool()
	{
		Extentest=Extents.createTest("Verify_SucLineSubCool");
		//Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_SucLineSuperheat), "10", "When the user setting is IP the  Default value of Suclinesubcool is 10");
		CompressorConfig_Page.SucLinesuperheat_IP(driver, Compressor.Txt_SucLineSuperheat);
	}
	
	
	
	
	
	@Test(priority=25)
	public void Verify_ExpectedPhaseValue()
	{
		//This test case is created to check the expected drop down list 
		//with the actual using string
		Extentest=Extents.createTest("Verify_ExpectedPhaseValue");
		Compressor.CheckDropActExp(driver, Compressor.Dropdown_Phase);
	}
	
	@Test(priority=26)
	public void Verify_CompressorTypeDropValue()
	{
		Extentest=Extents.createTest("Verify_CompressorTypeDropValue");
		Compressor.CheckCompressorTypeActExp(driver, Compressor.CompressorType);
	}
	
	@Test(priority=27)
	public void Verify_DefaultCompressorTypeDropValue()
	{
		Extentest=Extents.createTest("Verify_DefaultCompressorTypeDropValue");
		Assert.assertEquals(Web_Link.Verify_DefaultDropdownValue(driver, Compressor.CompressorType), "Fixed Speed", "Default value of compressor type dropdown should be Fixed Speed Fan");
	}
	
	@Test(priority=28)
	public void Verify_ListCompressorTypeDropValue()
	{
		Extentest=Extents.createTest("Verify_ListCompressorTypeDropValue");
		Web_DropDown.Verifyalldropdownvalue(driver, Compressor.CompressorType);
	}
	
	@Test(priority=29)
	public void Verify_ExpCompressorTypeDropValue()
	{
		Extentest=Extents.createTest("Verify_ExpCompressorTypeDropValue");
		Compressor.CheckCompressorTypeActExp(driver, Compressor.CompressorType);
	}
	
	@Test(priority=30)
	public void Verify_DefaultCost()
	{
		Extentest=Extents.createTest("Verify_DefaultCost");
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Cost), "0", "When the user setting is IP the  Default value of Cost is 0");
	}
	
	@Test(priority=31)
	public void Verify_LabelCost()
	{
		Extentest=Extents.createTest("Verify_LabelCost");
		//Assert.assertEquals(WebElement_Common.getElementAttributeValue(driver,Extentest, Compressor.Unit_Cost, "$"), "$", "When user setting is IP then unit of cost field should be $");
		Assert.assertEquals(WebElement_Common.getElementText(driver, Compressor.Unit_Cost, Extentest), "$");
		//Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Unit_Cost), "$", "When user setting is IP then unit of cost field should be: ");

	}
	
	
	@Test(priority=32)
	public void Verify_DefaultFrequency()
	{
		Extentest=Extents.createTest("Verify_DefaultFrequency");
		Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Frequency), "60", "When the user setting is IP the  Default value of Frequency is 60");
	}
	
	@Test(priority=33)
	public void Verify_LabelFrequency()
	{
		Extentest=Extents.createTest("Verify_LabelFrequency");
		//Assert.assertEquals(WebElement_Common.getElementAttributeValue(driver,Extentest, Compressor.Unit_Frequency, "Hz"), "Hz", "When user setting is IP then unit of Frequency field should be Hz");
	    Assert.assertEquals(WebElement_Common.getElementText(driver, Compressor.Unit_Frequency, Extentest), "Hz");	
	}
	
	
	@Test(priority=34)
	public void Verify_Units_UserSpecifiedParameters()
	{
		Extentest=Extents.createTest("Verify_Units_UserSpecifiedParameters");
		Compressor.Check_UserSpecifiedParameter_Unit_IP();
	}
	
	
	
	@Test(priority=35)
	public void Verify_UnitIP()
	{
		Extentest=Extents.createTest("Verify_UnitIP");
		//Assert.assertTrue(Web_Link.IsRadioButtonChecked(driver, Compressor.Radio_IP), "By default IP radio button should be checked");
		//Compressor.CheckRadioButton(driver, Compressor.Radio_IP);
	}
	
	
	@Test(priority=36)
	public void Verify_CoefficientUnitIP_FixedSpeedCompressor()
	{
		Extentest=Extents.createTest("Verify_CoefficientUnitIP_FixedSpeedCompressor");
	    //Compressor.Check_CoefficientUnit_FixedCompressor(driver, Compressor.Radio_IP);
		Compressor.CheckcoefficientUnit_FixedSpeed_IP(driver,Compressor.Radio_IP,Compressor.Radio_SI);	
	}
	
	
	@Test(priority=37)
	public void Verify_CoefficientUnitSI_FixedSpeedCompressor()
	{
		Extentest=Extents.createTest("Verify_CoefficientUnitSI_FixedSpeedCompressor");
	    //Compressor.Check_CoefficientUnit_FixedCompressor(driver, Compressor.Radio_IP);
		Compressor.CheckFixedCompressorCoeffUnit_SI(driver,Compressor.Radio_SI,Compressor.Radio_IP);	
	}
	
	
	@Test(priority=37)
	public void Verify_UnitSI()
	{
		Extentest=Extents.createTest("Verify_UnitSI");
		Assert.assertFalse(Web_Link.IsRadioButtonChecked(driver, Compressor.Radio_SI), "By default SI radio button should be unchecked");
	}
	
	
	@Test(priority=38)
	public void Verify_Usersetting_SI()
	{
		Extentest=Extents.createTest("Verify_Usersetting_SI");
		//Web_Link.SelectUsersetting_SI(driver, Compressor.Btn_Setting, Compressor.RadioBtn_IP, Compressor.RadioBtn_SI, Compressor.Btn_Done);
		//Web_Link.SelectUsersetting_SI(driver, Compressor.Btn_Setting, Compressor.RadioBtn_IP, Compressor.RadioBtn_SI, Compressor.Btn_closeToaster, Compressor.Btn_Done);
		 Web_Link.SelectUsersetting_SI(driver, Compressor.Btn_Setting, Compressor.RadioBtn_IP, Compressor.RadioBtn_SI, Compressor.CompleteToasterMessage, Compressor.Btn_closeToaster, Compressor.Btn_Done);
	}
	
	@Test(priority=39,dependsOnMethods = { "Verify_Usersetting_SI" })
	public void Verify_Userspecifiedparameterfields_SI()
	{
        Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_SatSucTemp), "10");
        //Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_SatDisTemp), "48.888888");
        CompressorConfig_Page.CheckSatDisTempSI(driver, Compressor.Txt_SatDisTemp);
        Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_LiqLineSubcool), "8.333333");
        //Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_SucLineSuperheat), "5.555555");
        CompressorConfig_Page.CheckSuctionLinesuperheatSI(driver, Compressor.Txt_SucLineSuperheat);
	}
	
	@Test(priority=40)
	public void VerifyVoltage_SI()
	{
		Extentest=Extents.createTest("VerifyVoltage_SI");
        Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Voltage), "230");
	   // Assert.assertEquals(WebElement_Common.getElementText(driver, Compressor.Unit_Voltage, Extentest), "VAC");
	}
	
	@Test(priority=41)
	public void VerifyCost_SI()
	{
		Extentest=Extents.createTest("VerifyCost_SI");
        Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Cost), "0");
	    Assert.assertEquals(WebElement_Common.getElementText(driver, Compressor.Unit_Cost, Extentest), "$");
	}
	
	@Test(priority=42)
	public void VerifyFrequency_SI()
	{
		Extentest=Extents.createTest("VerifyFrequency_SI");
        Assert.assertEquals(Web_Link.Verify_DefaultTextValue(driver, Compressor.Txt_Frequency), "60");
	    Assert.assertEquals(WebElement_Common.getElementText(driver, Compressor.Unit_Frequency, Extentest), "Hz");
	}
	
	@Test(priority=43)
	public void VerifyUserSpecifiedParameter_SI()
	{
		Extentest=Extents.createTest("VerifyUserSpecifiedParameter_SI");
		Compressor.Check_UserSpecifiedParameter_Unit_SI(driver,Compressor.RadioBtn_SI);

	}
	
	/*
	@Test(priority=43)
	public void Verify_HotTable()
	{
		Extentest=Extents.createTest("Verify_HotTable");
		Compressor.CheckHotTable();
	}*/
}
