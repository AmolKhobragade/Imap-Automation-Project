package com.ImapTesting.testcases;

import java.io.IOException;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.WebElement_Common;
import com.ImapTesting.commonfunction.Web_Page;
import com.ImapTesting.pages.Bin_Project;
import com.ImapTesting.pages.Bin_Unit;
import com.ImapTesting.pages.Dash_MyProject;
import com.ImapTesting.pages.Dash_MyUnit;
import com.ImapTesting.pages.Dash_StandardProject;
import com.ImapTesting.pages.DashboardPage;
import com.ImapTesting.pages.Fav_CompressorData;
import com.ImapTesting.pages.Fav_FilterAPData;
import com.ImapTesting.pages.Fav_FinData;
import com.ImapTesting.pages.Fav_IndoorCoilMicro;
import com.ImapTesting.pages.Fav_IndoorCoilRTPF;
import com.ImapTesting.pages.Fav_IndoorFan;
import com.ImapTesting.pages.Fav_MCTubeData;
import com.ImapTesting.pages.Fav_OutdoorCoilMicro;
import com.ImapTesting.pages.Fav_OutdoorCoilRTPF;
import com.ImapTesting.pages.Fav_OutdoorFan;
import com.ImapTesting.pages.Fav_PipingData;
import com.ImapTesting.pages.Fav_RTPFTubeData;
import com.ImapTesting.pages.Fav_ReturnAPData;
import com.ImapTesting.pages.GD_AccumulatorData;
import com.ImapTesting.pages.GD_AirHandlerData;
import com.ImapTesting.pages.GD_CompressorData;
import com.ImapTesting.pages.GD_FilterAPData;
import com.ImapTesting.pages.GD_FilterDrierData;
import com.ImapTesting.pages.GD_FinData;
import com.ImapTesting.pages.GD_IndoorCoilMCData;
import com.ImapTesting.pages.GD_IndoorCoilRTPFData;
import com.ImapTesting.pages.GD_MCTubeData;
import com.ImapTesting.pages.GD_OutdoorCoilMCData;
import com.ImapTesting.pages.GD_OutdoorCoilRTPFData;
import com.ImapTesting.pages.GD_PacklessCoilData;
import com.ImapTesting.pages.GD_PipingData;
import com.ImapTesting.pages.GD_RTPFTubeData;
import com.ImapTesting.pages.GD_ReturnAPData;
import com.ImapTesting.pages.Loginpage;
import com.ImapTesting.pages.Manage_Users;
import com.ImapTesting.pages.Nav_MyProject_Page;
import com.ImapTesting.pages.Nav_SharedProject_Page;
import com.ImapTesting.pages.Nav_SimReport_Page;
import com.ImapTesting.pages.User_Requests;
import com.ImapTesting.pages.Utilities_Psychrometrics;
import com.ImapTesting.pages.Utilities_RefrigerantProperties;
import com.ImapTesting.utilities.Common_Utilities;
import com.ImapTesting.utilities.Report_HTML;
import com.ImapTesting.utilities.WaitFunction;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TC_Dashboard extends Baseclass
{

	Loginpage login;
	DashboardPage dash;
	Report_HTML report;
	Nav_SharedProject_Page SharedProject_Page;
	Nav_SimReport_Page SimReport_Page;
	Utilities_Psychrometrics Psychrometrics;
	Utilities_RefrigerantProperties RefrigerantProperties;
    Fav_CompressorData CompressorData;	
    Logger log=Logger.getLogger(TC_Dashboard.class);
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports Extents;
	public ExtentTest Extentest;
	public TC_Login L1;
	
	 WebElement_Common Common_Element;
     Nav_MyProject_Page MyProject_Page;
	 Fav_RTPFTubeData RTPFTubeData;
	 Fav_MCTubeData MCTubeData;
	 Fav_FinData FinData;
	 Fav_FilterAPData FilterAPData;
	 Fav_ReturnAPData ReturnAPData;
	 Fav_PipingData PipingData;
	 Fav_OutdoorCoilRTPF OutdoorCoilRTPF;
	 Fav_OutdoorCoilMicro OutdoorCoilMicro;
	 Fav_IndoorCoilRTPF  IndoorCoilRTPF ;
	 Fav_IndoorCoilMicro IndoorCoilMicro;
	 Fav_IndoorFan IndoorFan ;
	 Fav_OutdoorFan OutdoorFan;
	 Bin_Project Bin;
	 Bin_Unit BinUnit;
	 User_Requests Request;
	 Manage_Users mUser;
	 Dash_MyProject MyProject_Dash;
	 Dash_MyUnit MyUnit_Dash;
	 Dash_StandardProject StdPjd;
	 GD_CompressorData GDCompressor;
	 GD_AccumulatorData GDAccumulator;
	 GD_AirHandlerData GDAirHandler;
	 GD_FilterAPData  GDFilterAPData;
	 GD_FilterDrierData GDFilterDrierData;
	 GD_FinData GDFinData;
	 GD_IndoorCoilMCData GDIndoorCoilMCData;
	 GD_IndoorCoilRTPFData GDIndoorCoilMcData;
	 GD_MCTubeData GDMCTubeData;
	 GD_OutdoorCoilMCData GDOutdoorCoilMCData;
	 GD_OutdoorCoilRTPFData GDOutdoorCoilRTPFData;
	 GD_PacklessCoilData GDPacklessCoilData;
	 GD_PipingData GDPipingData;
	 GD_ReturnAPData GDReturnAPData;
	 GD_RTPFTubeData GDRTPFTubeData;
	 
	public WaitFunction WF;
	public Common_Utilities CU;
	
	public TC_Dashboard()
	{
		super();
	}
	
	
	@BeforeClass
	
	public void setup()
	
	{
		initialization();
		login = new Loginpage();
		SharedProject_Page = new Nav_SharedProject_Page();
		SimReport_Page=new Nav_SimReport_Page(); 
		Psychrometrics= new Utilities_Psychrometrics() ;
		RefrigerantProperties = new Utilities_RefrigerantProperties() ;
		CompressorData = new Fav_CompressorData(); 
		RTPFTubeData =new Fav_RTPFTubeData(); 
		MCTubeData= new  Fav_MCTubeData();
		FinData=new Fav_FinData();
		FilterAPData=new Fav_FilterAPData() ;
		ReturnAPData=new Fav_ReturnAPData() ;
		PipingData=new Fav_PipingData() ;
		OutdoorCoilRTPF= new Fav_OutdoorCoilRTPF();
		OutdoorCoilMicro=new Fav_OutdoorCoilMicro();
		IndoorCoilRTPF = new Fav_IndoorCoilRTPF() ;
		IndoorCoilMicro =new Fav_IndoorCoilMicro() ;
		IndoorFan = new Fav_IndoorFan() ;
		OutdoorFan = new Fav_OutdoorFan() ;
		Bin= new  Bin_Project();
		BinUnit=new Bin_Unit ();
		Request=new User_Requests();
		MyProject_Dash= new  Dash_MyProject ();
		MyUnit_Dash=new Dash_MyUnit(); 
		StdPjd = new Dash_StandardProject();
		mUser = new Manage_Users(); 
		GDCompressor=new GD_CompressorData(); 
		GDAccumulator = new GD_AccumulatorData(); 
		GDAirHandler = new GD_AirHandlerData();
		GDFilterAPData = new GD_FilterAPData();
		GDFilterDrierData= new GD_FilterDrierData();
		GDFinData= new GD_FinData(); 
		GDIndoorCoilMCData = new GD_IndoorCoilMCData(); 
		GDIndoorCoilMcData = new GD_IndoorCoilRTPFData();
		GDMCTubeData= new GD_MCTubeData();
		GDOutdoorCoilMCData = new GD_OutdoorCoilMCData();
		GDOutdoorCoilRTPFData= new GD_OutdoorCoilRTPFData(); 
		GDPacklessCoilData = new GD_PacklessCoilData();
		GDPipingData = new GD_PipingData(); 
		GDReturnAPData=new GD_ReturnAPData(); 
		GDRTPFTubeData = new GD_RTPFTubeData(); 
		
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
			  Extentest.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"::Test Case is Skipped",ExtentColor.GREY ));
			  
		  }
		  else if(result.getStatus()==ITestResult.SUCCESS) 
		  {
			  Extentest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"::Test Case is Passed",ExtentColor.GREEN )); 
		  }
		 
		  Extents.flush();
	  }
	
	public void EndReport()
	{
		
		//report.EndReport();
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
	public void VerifyNav_MyProject()
	{
		Extentest=Extents.createTest("VerifyNav_MyProject");
		Common_Utilities.Pageloader();
		dash.Nav_validatemyproject();
	}
	
	@Test(priority=4)
	public void Verify_NavMyProjectPage() 
	{
		Extentest=Extents.createTest("Verify_NavMyProjectPage");
		Common_Utilities.Pageloader();
		Assert.assertEquals(dash.Get_NavMyProject_ManageProjectText(), "Manage Project", "Page is redirecting to the My Project page of side navigational bar");
	}
	
	
	@Test(priority=5)
	public void VerifyNav_Dashboard()
	{
		Extentest=Extents.createTest("VerifyNav_Dashboard");
		Common_Utilities.Pageloader();
		dash.Nav_dashboard();
	}
	
	@Test(priority=6)
	public void Verify_Dash_StandardProjectLabel()
	{
		Extentest=Extents.createTest("Verify_Dash_StandardProjectLabel");
		Common_Utilities.Pageloader();
		Assert.assertEquals(dash.Nav_Dash_StandardProjectLabel(), "STANDARD PROJECTS", "Page redirecting to the dashboard page of side navigational bar");	
	}
	
	@Test(priority=7)
	public void Verify_NavSharedProject()
	{
		Extentest=Extents.createTest("Verify_NavSharedProject");
		dash.Click_Nav_SharedProjects();
		Common_Utilities.Pageloader();
	}
	
	
	@Test(priority=8)
	public void Verify_NavSharedProjectManageProjectLabel()
	{
		Extentest=Extents.createTest("Verify_NavSharedProjectManageProjectLabel");
		WebElement_Common.waitForElementPresent(driver, SharedProject_Page.SharedProject_ManageProjectLabel, Extentest);
		Assert.assertEquals(SharedProject_Page.ValidateSharedProject_ManageProject_Label(), "Manage Project", "Page redirecting to the shared project of side navigational bar");
	}
	
	
	@Test(priority=9)
	public void Verify_SimReports()
	{
		Extentest=Extents.createTest("Verify_SimReports");
		Common_Utilities.Pageloader();
		dash.Click_Nav_SimReport();
	}
	
	
	
	@Test(priority=10)
	public void Verify_NavSimReportLabel()
	{
		Extentest=Extents.createTest("Verify_NavSimReportLabel");
		WebElement_Common.waitForElementPresent(driver, SimReport_Page.Nav_SimReport_PageLabel, Extentest);
		Assert.assertEquals(SimReport_Page.Validate_NavSimReport_SimReportLabel(), "Simulation Reports", "Page redirecting to the SimReport of side navigational bar");
		
	}
	
	@Test(priority=11)
	public void Verify_ClickUtilities()
	{
		Extentest=Extents.createTest("Verify_ClickUtilities");
		Common_Utilities.Pageloader();
		dash.Click_Utilities();
	}
	
	
	@Test(priority=12)
	public void Verify_NavPsychrometricsLabel()
	{
		Extentest=Extents.createTest("Verify_NavPsychrometricsLabel");
		WebElement_Common.waitForElementPresent(driver, Psychrometrics.PsychrometricsPropertiesCalculator_Label, Extentest);
		Assert.assertEquals(Psychrometrics.Validate_Psychrometrics_Label(), "Psychrometrics Properties Calculator", "Page redirecting to the Psychrometrics Properties Calculator page ");
	}
	
	
	@Test(priority=13)
	public void Verify_Utilities_RefPropLabel()
	{
		Extentest=Extents.createTest("Verify_Utilities_RefPropLabel");
		Common_Utilities.Pageloader();
		dash.Click_Utilities_RefrigerantPropertiesCal();
		WebElement_Common.waitForElementPresent(driver, RefrigerantProperties.RefrigerantPropertiesCalculator_Label, Extentest);
		Assert.assertEquals(RefrigerantProperties.RefrigerantPropertiesLabel(), "Refrigerant Properties Calculator", "Page redirecting to the Refrigerant Properties Calculator page ");
	}
	
	
	
	@Test(priority=14)
	public void Verify_ClickFavorite()
	{
		Extentest=Extents.createTest("Verify_ClickFavorite");
		Common_Utilities.Pageloader();
		dash.ValidateNav_Favorite();
	}
	
	@Test(priority=15)
	public void Verify_AddCompDataBtn()
	{
		Extentest=Extents.createTest("Verify_AddCompDataBtn");
		WebElement_Common.waitForElementPresent(driver, CompressorData.FavCompressorData_Btn_AddCompressorData, Extentest);
	    Assert.assertTrue(CompressorData.Validate_AddCompressorDataBtn(), "Add Compressor Data button is dsiplayed from the compressor data page of favorite");
		log.info("Page redirecting to the Compressor Data Page");  
	}
	
	
	@Test(priority=16)
	public void Verify_RTPFTubeData()
	{
		Extentest=Extents.createTest("Verify_RTPFTubeData");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_RTPFTube();
	}
	
	@Test(priority=17)
	public void Verify_AddRTPFTubeDataButton()
	{
		Extentest=Extents.createTest("Verify_AddRTPFTubeDataButton");
		WebElement_Common.waitForElementPresent(driver, RTPFTubeData.FavRTPFTubeData_Btn_AddRtpfTubeData, Extentest);
		Assert.assertTrue(RTPFTubeData.Validate_AddRTPFTubeDataButton(), "Page redirecting to the RTPF Tube Data of Favorite section");
        log.info("Page Redirecting to the RTPF Tube Data of Favorite Section");
	}
	
	
	
	@Test(priority=18)
	public void Verify_MCTubeData()
	{
		Extentest=Extents.createTest("Verify_MCTubeData");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_MCTube();
		
	}
	
	@Test(priority=19)
	public void Verify_AddMCTubeDataButton()
	{
		Extentest=Extents.createTest("Verify_AddMCTubeDataButton");
		WebElement_Common.waitForElementPresent(driver, MCTubeData.FavMCTubeData_AddMicrochannelTubeData, Extentest);
		Assert.assertTrue(MCTubeData.Validate_ADDMCTubeDataButton(), "Page redirecting to the MC Tube Data page and displayed AddMCTubeData Button");
		 log.info("Page redirecting to the MC Tube Data page and displayed AddMCTubeData Button");
	}
	
	
	
	@Test(priority=20)
	public void Verify_FinData()
	{
		Extentest=Extents.createTest("Verify_FinData");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_FinData();
	}
	
	@Test(priority=21)
	public void Verify_AddFinDataButton()
	{
		Extentest=Extents.createTest("Verify_AddFinDataButton");
		WebElement_Common.waitForElementPresent(driver, FinData.FavFindData_Btn_AddFinData, Extentest);
		Assert.assertTrue(FinData.Validate_AddFinDataButton(), "Page redirecting to the Fin Data Page and ADD Fin Data button is displayed");
		 log.info("Page redirecting to the Fin Data Page and ADD Fin Data button is displayed");
		//Common_Element.waitForElementPresent(driver, FinData.FavFindData_Btn_AddFinData, Extentest, "Fin Data");
	}
	

	@Test(priority=22)
	public void Verify_FilterAPData()
	{
		Extentest=Extents.createTest("Verify_FilterAPData");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_FilterAPData();
	}
	
	@Test(priority=23)
	public void Verify_ADDFilterAPDataButton()
	{
		Extentest=Extents.createTest("Verify_ADDFilterAPDataButton");
		WebElement_Common.waitForElementPresent(driver, FilterAPData.FavFilterAPData_Btn_AddFilterApData, Extentest);
		Assert.assertTrue(FilterAPData.Validate_AddFilterAPDataButton(), "Page redirecting to the Add Filter AP Data and ADDFilterAPData Button is displayed");
		//Common_Element.waitForElementPresent(driver, FilterAPData.FavFilterAPData_Btn_AddFilterApData, Extentest, "Filter AP Data");
		 log.info("Page redirecting to the Add Filter AP Data and ADDFilterAPData Button is displayed");
	}
	
	
	
	@Test(priority=24)
	public void Verify_ReturnAPData()
	{
		Extentest=Extents.createTest("Verify_ReturnAPData");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_ReturnAPData();
		
	}
	
	@Test(priority=25)
	public void Verify_ADDReturnAPDataButton()
	{
		Extentest=Extents.createTest("Verify_ADDReturnAPDataButton");
		WebElement_Common.waitForElementPresent(driver,ReturnAPData.FavReturnAPData_Btn_AddReturnAPData, Extentest);
	    Assert.assertTrue(ReturnAPData.Validate_AddReturnAPDataButton(), "Page is redirecting to the Add Return AP Data Page and ADDReturnData button is displayed");
	    log.info("Page is redirecting to the Add Return AP Data Page and ADDReturnData button is displayed");
	}
	
	
	
	@Test(priority=26)
	public void Verify_PipingData()
	{
		Extentest=Extents.createTest("Verify_PipingData");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_PipingData();
		
	}
	
	@Test(priority=27)
	public void Verify_AddPipingDataButton()
	{
		Extentest=Extents.createTest("Verify_AddPipingDataButton");
		WebElement_Common.waitForElementPresent(driver,PipingData.FavPipingData_Btn_AddPipingData, Extentest);
		Assert.assertTrue(PipingData.Validate_AddPipingDataButton(), "Page Redirecting to the Add Piping Data page of Favorite");
		log.info("Page Redirecting to the Add Piping Data page of Favorite");
	}
	
	
	
	
	@Test(priority=28)
	public void Verify_OutdoorCoilRTPF()
	{
		Extentest=Extents.createTest("Verify_OutdoorCoilRTPF");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_OutdoorCoilRTPF();
	}
	
	@Test(priority=29)
	public void Verify_OutdoorCoilRTPFTitle()
	{
		Extentest=Extents.createTest("Verify_OutdoorCoilRTPFTitle");
		WebElement_Common.waitForElementPresent(driver,OutdoorCoilRTPF.FavOutdoorCoilRtpf_Btn_AddOutdoorCoilData, Extentest);
		Assert.assertTrue(OutdoorCoilRTPF.Validate_AddOutdoorCoilRTPFButton(), "Page redirecting to the Outdoor Coil-RTPF ");
		 log.info("Page redirecting to the Outdoor Coil-RTPF");
		//Common_Element.waitForElementPresent(driver,OutdoorCoilRTPF.FavOutdoorCoilRtpf_Btn_AddOutdoorCoilData, Extentest, "Outdoor Coil-RTPF");
	}
	
	
	@Test(priority=30)
	public void Verify_OutdoorCoilMicrochannel()
	{
		Extentest=Extents.createTest("Verify_OutdoorCoilMicrochannel");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_OutdoorCoilMicro();
	}
	
	@Test(priority=31)
	public void Verify_OutdoorCoilMicrochannelButton()
	{
		Extentest=Extents.createTest("Verify_OutdoorCoilMicrochannelTitle");
		WebElement_Common.waitForElementPresent(driver,OutdoorCoilMicro.FavOutdoorCoilMicro_Btn_AddOutdoorCoilData, Extentest);
		Assert.assertTrue(OutdoorCoilMicro.Validate_AddOutdoorCoilMCButton(), "Page redirecting to the OutdoorCoil MC tube data");
		 log.info("Page redirecting to the OutdoorCoil MC tube data");
		
	}
	
	
	
	@Test(priority=32)
	public void Verify_IndoorCoilRtpf()
	{
		Extentest=Extents.createTest("Verify_IndoorCoilRtpf");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_IndoorCoilRTPF();
	}
	
	@Test(priority=33)
	public void Verify_AddIndoorCoilRtpfButton()
	{
		Extentest=Extents.createTest("Verify_AddIndoorCoilRtpfButton");
		WebElement_Common.waitForElementPresent(driver,IndoorCoilRTPF.FavIndoorCoilRTPF_Btn_AddIndoorCoilData, Extentest);
		Assert.assertTrue(IndoorCoilRTPF.Validate_AddIndoorCoilRTPF(), "Page redirecting to the Indoor Coil RTPF Tube Data Page");
		 log.info("Page redirecting to the Indoor Coil RTPF Tube Data Page");
		//Common_Element.waitForElementPresent(driver,IndoorCoilRTPF.FavIndoorCoilRTPF_Btn_AddIndoorCoilData, Extentest, "Indoor Coil-RTPF");
	}
	
	
	@Test(priority=34)
	public void Verify_IndoorCoilMicrochanne()
	{
		Extentest=Extents.createTest("Verify_IndoorCoilMicrochanne");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_IndoorCoilMicro();
	}
	
	@Test(priority=35)
	public void Verify_AddIndoorCoilMicrochannelButton()
	{
		Extentest=Extents.createTest("Verify_AddIndoorCoilMicrochannelButton");
		WebElement_Common.waitForElementPresent(driver,IndoorCoilMicro.FavIndoorCoilMicro_Btn_AddIndoorCoilData, Extentest);
		Assert.assertTrue(IndoorCoilMicro.Validate_AddIndoorCoilMCButton(), "Page redirecting to the Indoor Coil MC Page");
		 log.info("Page redirecting to the Indoor Coil MC Page");
		
	}
	
	
	@Test(priority=36)
	public void Verify_IndoorFan()
	{
		Extentest=Extents.createTest("Verify_IndoorFan");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_IndoorFan();
	}
	
	@Test(priority=37)
	public void Verify_AddIndoorFanDataButton()
	{
		Extentest=Extents.createTest("Verify_AddIndoorFanDataButton");
		WebElement_Common.waitForElementPresent(driver,IndoorFan.FavIndoorFan_Btn_AddIndoorFanData, Extentest);
		Assert.assertTrue(IndoorFan.Validate_AddIndoorFan(), "Page redirecting to the Indoor Fan");
		 log.info("Page redirecting to the Indoor Fan");
		//Common_Element.waitForElementPresent(driver,IndoorFan.FavIndoorFan_Btn_AddIndoorFanData, Extentest, "Indoor Fan");
	}
	
	
	
	@Test(priority=38)
	public void Verify_OutdoorFan()
	{
		Extentest=Extents.createTest("Verify_OutdoorFan");
		Common_Utilities.Pageloader();
		dash.Validate_Fav_OutdoorFan();
	}
	
	@Test(priority=39)
	public void Verify_AddOutdoorFanDataButton()
	{
		Extentest=Extents.createTest("Verify_AddOutdoorFanDataButton");
		WebElement_Common.waitForElementPresent(driver,OutdoorFan.FavOutdoorFan_Btn_AddOutdoorFanData, Extentest);
		Assert.assertTrue(OutdoorFan.Validate_AddOutdoorFan(), "Page is redirecting to the Outdoor Fan");
		log.info("Page is redirecting to the Outdoor Fan");
		
		//Common_Element.waitForElementPresent(driver,OutdoorFan.FavOutdoorFan_Btn_AddOutdoorFanData, Extentest, "Outdoor Fan");
	}
	
	
	@Test(priority=40)
	public void Verify_ClickBinMyProject()
	{
		Extentest=Extents.createTest("Verify_ClickBinMyProject");
		Common_Utilities.Pageloader();
		dash.Validate_Nav_Bin();
	}
	
	@Test(priority=41)
	public void Verify_MyProjectName_BinMyProject()
	{
		Extentest=Extents.createTest("Verify_MyProjectName_BinMyProject");
		WebElement_Common.waitForElementPresent(driver,Bin.BinProject_DeletedDateLabel, Extentest);
		Assert.assertEquals(Bin.ValidateBinProject_DeletedDateLabel(), "Deleted Date", "Page redirecting to the Bin Project and Name field is displayed");
		log.info("Page redirecting to the Bin Project and Name field is displayed");
		
	}
	
	@Test(priority=42)
	public void Verify_ClickBinMyUnit()
	{
		Extentest=Extents.createTest("Verify_ClickBinMyUnit");
		Common_Utilities.Pageloader();
		dash.Validate_BinUnit();
	}
	
	
	@Test(priority=43)
	public void Verify_MyUnitName()
	{
		Extentest=Extents.createTest("Verify_MyUnitName");
		WebElement_Common.waitForElementPresent(driver,BinUnit.Bin_UnitLabel, Extentest);
		Assert.assertEquals(BinUnit.ValidateBinUnit_NameLabel(), "Name", "Page redirecting to the Unit page of Bin and Name label displayed");
		log.info("Page redirecting to the Unit page of Bin and Name label displayed");
	}
	
	
	@Test(priority=44)
	public void VerifyClick_UserRequest()
	{
		Extentest=Extents.createTest("VerifyClick_UserRequest");
		Common_Utilities.Pageloader();
		dash.Validate_Nav_UsersRequest();
	}
	
	@Test(priority=45)
	public void Verify_UserRequestLabel()
	{
		Extentest=Extents.createTest("Verify_UserRequestLabel");
		WebElement_Common.waitForElementPresent(driver,Request.RequestedByLabel, Extentest);
		Assert.assertEquals(Request.Validate_UserRequestLabel(), "Requested By", "Page redirect to the User request page and Requested By label displayed");
		log.info("Page redirect to the User request page and Requested By label displayed");
	}
	
	@Test(priority=46)
	public void VerifyClick_ManageUsers()
	{
		Extentest=Extents.createTest("VerifyClick_ManageUsers");
		Common_Utilities.Pageloader();
		dash.Validate_Nav_ManageUsers();
	}
	
	@Test(priority=47)
	public void Verify_AddUserManageUsers_Button()
	{
		Extentest=Extents.createTest("Verify_AddUserManageUsers_Button");
		Assert.assertTrue(mUser.Validate_ManageUser_AddUserButton(), "Page is redirecting to the Manage Users");
		log.info("Page is redirecting to the Manage Users");

		
	}
	
	@Test(priority=48)
	public void Verify_ClickMyProject()
	{
		Extentest=Extents.createTest("Verify_ClickMyProject");
		Common_Utilities.Pageloader();
		dash.Nav_dashboard();
		Common_Utilities.Pageloader();
		dash.Validate_Dash_MyProjectIcon();
	}
	
	@Test(priority=49)
	public void Verify_CreateProjectBtn_DashMyProject()
	{
		Extentest=Extents.createTest("Verify_CreateProjectBtn_DashMyProject");
		WebElement_Common.waitForElementPresent(driver,MyProject_Dash.CreateProjectButton, Extentest);
		Assert.assertTrue(MyProject_Dash.Validate_Dash_MyProject_CreateProjectButton(), "Create Project button is displayed from my project when clicking on MyProject icon of dashboard page ");
	    log.info("Page redirecting to the My Project page and create project button is displayed");
	}
	
	
	@Test(priority=50)
	public void Verify_ClickMyUnit()
	{
		Extentest=Extents.createTest("Verify_ClickMyUnit");
		Common_Utilities.Pageloader();
		dash.Nav_dashboard();
		Common_Utilities.Pageloader();
		dash.Validate_Dash_MyUnitIcon();
		
	}
	
	@Test(priority=51)
	public void verify_CreateUnitbtn_DashMyproject()
	{
		Extentest=Extents.createTest("verify_CreateUnitbtn_DashMyproject");
		WebElement_Common.waitForElementPresent(driver,MyUnit_Dash.CreateUnitButton, Extentest);
		Assert.assertTrue(MyUnit_Dash.Validate_Dash_MyUnit_CreateUnitButton(), "Create unit is displayed from my unit when click on my unit icon of dashboard");

	}
	
	
	@Test(priority=52)
	public void Verify_ClickStandardProject()
	{
		Extentest=Extents.createTest("Verify_ClickStandardProject");
		Common_Utilities.Pageloader();
		dash.Nav_dashboard();
		Common_Utilities.Pageloader();
		dash.Validate_Dash_StandardProject();
		
	}
	
	
	@Test(priority=53)
	public void Verify_BtnCreateProject_StandardProject()
	{
		Extentest=Extents.createTest("Verify_BtnCreateProject_StandardProject");
		WebElement_Common.waitForElementPresent(driver,StdPjd.BtnCreateProject_StandardProject, Extentest);
		Assert.assertTrue(StdPjd.Validate_Btn_DashStandardProject_CreateProject(),"Create project button of standard project is displayed when click on the standard project icon from the dashboard :");
	}
	
	
	
	
/*	
	
	
	
	
	
	@Test(priority=41)
	public void Verify_ClickGD_CompressorData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_CompressorData");
		dash.Validate_GD_CompressorData();
	}
	
	@Test(priority=42)
	public void Verify_CompressorDataTitle()
	{
		Extentest=Extents.createTest("Verify_CompressorDataTitle");
		String Title=dash.Validate_GD_CompressorTitle();
		Assert.assertEquals(Title, "Compressor Data", "Page redirecting to the compressor page of global database");
	}
	
	@Test(priority=43)
	public void Verify_ClickGD_AirHandler()
	{
		Extentest=Extents.createTest("Verify_ClickGD_AirHandler");
		dash.Validate_GD_AirHandlerData();
	}
	
	@Test(priority=44)
	public void Verify_GD_AirHandlerTitle()
	{
		Extentest=Extents.createTest("Verify_GD_AirHandlerTitle");
		String Title=dash.Validate_GD_AirHandlerTitle();
		Assert.assertEquals(Title, "Air Handler Data", "Page is redirecting to the Air Handler page of Global Database");
	}
	
	@Test(priority=45)
	public void Verify_ClickGD_RTPFTubeData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_RTPFTubeData");
		dash.Validate_GD_RTPFTubeData();
	}
	
	@Test(priority=46)
	public void Verify_GD_RTPFTubeDataTitle()
	{
		Extentest=Extents.createTest("Verify_GD_RTPFTubeDataTitle");
		String Title = dash.Validate_GD_RTPFTubeTitle();
		Assert.assertEquals(Title, "RTPF Tube Data", "Page is redirecting to the RTPFTubeData page of global database" );
	}
	
	
	@Test(priority=47)
	public void Verify_ClickGD_MCTubeData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_MCTubeData");
		dash.Validate_GD_MCTubeData();
	}
	
	@Test(priority=48)
	public void Verify_GD_MCTubeDataTitle()
	{
		Extentest=Extents.createTest("Verify_GD_MCTubeDataTitle");
		String Title = dash.Validate_GD_MCTubeTitle();
		Assert.assertEquals(Title, "MC Tube Data", "Page is redirecting to the MCTubeData of global database");
	}
	
	@Test(priority=49)
	public void Verify_ClickGD_FinData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_FinData");
		dash.Validate_GD_FinData();
	}
	
	@Test(priority=50)
	public void Verify_GD_FinDataTitle()
	{
		Extentest=Extents.createTest("Verify_GD_FinDataTitle");
		String Title = dash.Validate_GD_FinTitle();
		Assert.assertEquals(Title, "Fin Data", "Page redirecting to the FinData of global database");
	}
	
	
	@Test(priority=51)
	public void Verify_ClickGD_FilterAPData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_FilterAPData");
		dash.Validate_GD_FilterAPData();
	}
	
	@Test(priority=52)
	public void Verify_FilterAPDataTitle()
	{
		Extentest=Extents.createTest("Verify_FilterAPDataTitle");
		String Title = dash.Validate_GD_FilterAPTitle();
		Assert.assertEquals(Title, "Filter AP Data", "Page redirecting to the FilterAPData of global database");
	}
	
	@Test(priority=53)
	public void Verify_ClickGD_ReturnAPData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_ReturnAPData");
		dash.Validate_GD_ReturnAPData();
	}
	
	@Test(priority=54)
	public void Verify_ReturnAPDataTitle()
	{
		Extentest=Extents.createTest("Verify_ReturnAPDataTitle");
		String Title = dash.Validate_GD_ReturnAPTitle();
		Assert.assertEquals(Title, "Return AP Data", "page redirecting to the ReturnApData of global database");
	}
	
	@Test(priority=55)
	public void Verify_ClickGD_PipingData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_PipingData");
		dash.Validate_GD_PipingData();
	}
	
	@Test(priority=56)
	public void Verify_GD_PipingDataTitle()
	{
		Extentest=Extents.createTest("Verify_GD_PipingDataTitle");
		String Title = dash.Validate_GD_PipingTitle();
		Assert.assertEquals(Title, "Piping Data", "page is redirecting to the PipingData of global database");
	}
	
	@Test(priority=57)
	public void Verify_ClickGD_OutdoorCoilRTPFData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_OutdoorCoilRTPFData");
		dash.Validate_GD_OutdoorCoilRTPFData();
	}
	
	@Test(priority=58)
	public void Verify_GD_OutdoorCoilRTPFTitle()
	{
		Extentest=Extents.createTest("Verify_GD_OutdoorCoilRTPFTitle");
		String Title = dash.Validate_GD_OutdoorCoilRTPFTitle();
		Assert.assertEquals(Title, "Outdoor Coil RTPF Data", "Page is redirecting to the OutdoorCoilRTPF of global database");
	}
	
	@Test(priority=59)
	public void Verify_ClickGD_OutdoorCoilMCData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_OutdoorCoilMCData");
		dash.Validate_GD_OutdoorCoilMCData();
	}
	
	@Test(priority=60)
	public void Verify_GD_OutdoorCoilMCDataTitle()
	{
		Extentest=Extents.createTest("Verify_GD_OutdoorCoilMCDataTitle");
		String Title = dash.Validate_GD_OutdoorCoilMCTitle();
		Assert.assertEquals(Title, "Outdoor Coil MC Data", "Page redirecting to the OutdoorcoilMC data of global database");
	}
	
	@Test(priority=61)
	public void Verify_ClickGD_IndoorCoilRTPFTubeData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_IndoorCoilRTPFTubeData");
		dash.Validate_GD_IndoorCoilRTPFTubeData();
	}
	
	@Test(priority=62)
	public void Verify_GD_IndoorCoilRTPFTubeDataTitle()
	{
		Extentest=Extents.createTest("Verify_GD_IndoorCoilRTPFTubeDataTitle");
		String Title= dash.Validate_GD_IndoorCoilRTPFTitle();
		Assert.assertEquals(Title, "Indoor Coil RTPF Data", "Page redirecting to the IndoorCoilRTPFTubeData of global database");
	}
	
	@Test(priority=63)
	public void Verify_ClickGD_IndoorCoilMCTubeData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_IndoorCoilMCTubeData");
		dash.Validate_GD_IndoorCoilMCTubeData();
	}
	
	@Test(priority=64)
	public void Verify_IndoorCoilMCTubeDataTitle()
	{
		Extentest=Extents.createTest("Verify_IndoorCoilMCTubeDataTitle");
		String Title = dash.Validate_GD_IndoorCoilMCTitle();
		Assert.assertEquals(Title, "Indoor Coil MC Data", "page redirecting to the IndoorCoilMCData of global database");
	}
	
	@Test(priority=65)
	public void Verify_ClickGD_PacklessCoilData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_PacklessCoilData");
		dash.Validate_GD_PacklessCoilData();
	}
	
	@Test(priority=66)
	public void Verify_GD_PacklessCoilDatatitle()
	{
		Extentest=Extents.createTest("Verify_GD_PacklessCoilDatatitle");
		String Title = dash.Validate_GD_PacklessCoilTitle();
		Assert.assertEquals(Title, "Packless Coil Model", "page redirecting to the packless coil data of global database");
	}
	
	@Test(priority=67)
	public void Verify_ClickGD_AccumulatorData()
	{
		Extentest=Extents.createTest("Verify_ClickGD_AccumulatorData");
		dash.Validate_GD_AccumulatorData();
	}
	
	@Test(priority=68)
	public void Verify_AccumulatorDataTitle()
	{
		Extentest=Extents.createTest("Verify_AccumulatorDataTitle");
		String Title = dash.Validate_GD_AccumulatorTitle();
		Assert.assertEquals(Title, "Accumulator Data", "page redirecting to the Accumulator data of global database");
	}
	
	@Test(priority=69)
	public void Verify_ClickGD_FilterDrier()
	{
		Extentest=Extents.createTest("Verify_ClickGD_FilterDrier");
		dash.Validate_GD_FilterDrierData();
	}
	
	@Test(priority=70)
	public void Verify_GD_FilterDrierTitle()
	{
		Extentest=Extents.createTest("Verify_GD_FilterDrierTitle");
		String Title = dash.Validate_GD_FilterDrierTitle();
		Assert.assertEquals(Title, "Filter Drier Data", "page redirecting to the filter drier of global database");
	}
	
	
		}*/
}
