package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.WebElement_Common;
import com.ImapTesting.commonfunction.Web_Button;
import com.ImapTesting.commonfunction.Web_Table;
import com.ImapTesting.utilities.Common_Utilities;
import com.ImapTesting.utilities.WaitFunction;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class DashboardPage  extends Baseclass

{
	public ExtentHtmlReporter htmlreporter;
	public ExtentTest Extents;
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//a[@href='#/dashboard']")
	public WebElement Nav_Dashboard;
	
	
	@FindBy(xpath="//label[contains(text(),'Standard PROJECTS')]")
	public WebElement Dash_StandardProject_Label;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/myProjects/']")
	public WebElement Nav_MyProject;
	
	@FindBy(xpath="//table//div[contains(text(),'Project ID')]")
	public WebElement NavMyProjectTable_ProjectIDSortingLink;
	
	@FindBy(xpath="//div[contains(text(),'Manage Project')]")
	public WebElement NavMyProject_ManageProject_Label;
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//a[@href='#/sharedProject']")
	public WebElement Nav_SharedProject;
	
	@FindBy(xpath="//div[contains(text(),'Manage Project')]")
	public WebElement Nav_SharedProject_ManageProject_Label;
	
	
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//a[@href='#/simulationReports/0/0']")
	
	public WebElement Nav_SimReport;
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//span[contains(text(),'Utilities')]")
	
	public WebElement Nav_Utilities;
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//a[@href='#/utilities/refrigerantProperties']")
	
	public WebElement Utilities_RefPropCal;
	
	@FindBy(xpath="//*[contains(text(),'Refrigerant Properties Calculator')]")
	
	public WebElement Utilities_RefrigerantProperties_Label;
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//span[contains(text(),'Favorites')]")
	
	public WebElement Nav_Favorite;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/favRtpfTubeData']")
	
	public WebElement Nav_Fav_RTPFTube;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/mcTubeDataFav']")
	
	public WebElement Nav_Fav_MCTubeData;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/finDataFav']")
	
	public WebElement Nav_Fav_FinData;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/filterAPDDataFav']")
	
	public WebElement Nav_Fav_FilterAPData;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/returnAPDDataFav']")
	
	public WebElement Nav_Fav_ReturnAPData;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/pipingDataFav']")
	
	public WebElement Nav_Fav_PipingData;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/outdoorCoilFav/true']")
	
	public WebElement Nav_Fav_OutdoorCoilRTPF;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/outdoorCoilFavMicro/true']")
	
	public WebElement Nav_Fav_OutdoorCoilMicro;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/indoorCoilFav/true']")
	
	public WebElement Nav_Fav_IndoorcoilRTPF;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/indoorCoilFavMicro/true']")
	
	public WebElement Nav_Fav_IndoorCoilMicro;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/indoorFanFav/true']")
	
	public WebElement Nav_Fav_IndoorFan;
	
	@FindBy(xpath="//ul[@id='favoriteSubmenu']//a[@href='#/outdoorFanFav/true']")
	
	public WebElement Nav_Fav_OutdoorFan;
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//span[contains(text(),'Bin')]")
	
	public WebElement Nav_Bin;
	
	@FindBy(xpath="//table[@id='tblBinProjectList']")
	public WebElement Bin_ProjectTable;
	
	@FindBy(xpath="//ul[@class='sub-menu']//a[@href='#/binn/Unit']")
	
	public WebElement Bin_Unit;
	
	@FindBy(xpath="//table[@id='tblBinUnitList']")
	public WebElement BinUnit_UnitName;
	
	
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//span[contains(text(),'Global Database')]")
	
	public WebElement Nav_GlobalDB_Compr;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/airHandlerData']")
	
	public WebElement GD_AirHandler;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/rtpfTubeData']")
	
	public WebElement GD_RTPFTube;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/mcTubeData']")
	
	public WebElement GD_MCTube;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/finData']")
	
	public WebElement GD_Fin;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/filterAPDData']")
	
	public WebElement GD_FilterAP;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/returnAPDData']")
	
	public WebElement GD_ReturnAP;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/pipingData']")
	
	public WebElement GD_Piping;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/outdoorCoilRTPFData/true']")
	
	public WebElement GD_OutdoorCoilRTPF;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/outdoorCoilMCData/true']")
	
	public WebElement GD_OutdoorCoilMC;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/indoorCoilRTPFData/true']")
	
	public WebElement GD_IndoorCoilRTPF;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/indoorCoilMCData/true']")
	
	public WebElement GD_IndoorCoilMC;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/packlessCoilData']")
	
	public WebElement GD_PacklessCoil;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/accumulatorData']")
	
	public WebElement GD_Accumulator;
	
	@FindBy(xpath="//div[@id='dvLeftNavigation']//a[@href='#/filterDrierData']")
	
	public WebElement GD_FilterDrier;

	
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//span[contains(text(),'User Requests')]")
	
	public WebElement Nav_UserRequest;
	
	@FindBy(xpath="//ul[@class='main-navigation-menu']//span[contains(text(),'Manage Users')]")
	
	public WebElement Nav_ManageUser;
	
	@FindBy(xpath="//div[@class='dash-pan-button']//button[@class='spin circle-dashboard btn-circle allprojects']")
	public WebElement Dash_MyProject;
	
	@FindBy(xpath="//button[@ng-click='Project.addProject()']")
	
	public WebElement DashMyProject_CreateProject;
	
	
	
	@FindBy(xpath="//div[@class='dash-pan-button']//button[@class='spin circle-dashboard btn-circle myunit']")
	public WebElement Dash_MyUnit;
	
	@FindBy(xpath="//button[@ng-click='Unit.addUnit()']")
	public WebElement DashMyUnit_CreateUnit;
	
	@FindBy(xpath="//div[@id='dvBreadCrum']//span[contains(text(),'My Projects')]")
	public WebElement Breadcrumb_MyProject;
	
	
	@FindBy(xpath="//div[@id='effect-5']//a[@ng-click='dashboard.residentialImageclicked()']")
	public WebElement Dash_ResProject;
	
	@FindBy(xpath="//div[@class='dash-pan-button']//button[@class='spin circle-dashboard btn-circle stdproject']")
	public WebElement Dash_StandardProject;
	
	

	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Nav_MyProject_Page  Nav_validatemyproject()
	{
		Web_Button.Button_Click(driver, Nav_MyProject);
		return new Nav_MyProject_Page();
	}
	
	public String Get_NavMyProject_ManageProjectText()
	{
		String GetElementText=NavMyProject_ManageProject_Label.getText();
		Reporter.log(GetElementText,true);
		return GetElementText;
	}
	
	public Nav_Dashboard Nav_dashboard()
	{
		Web_Button.Button_Click(driver, Nav_Dashboard);
		return new Nav_Dashboard();	
	}
	
	public String Nav_Dash_StandardProjectLabel()
	{
		String DSPL = Dash_StandardProject_Label.getText();
		Reporter.log(DSPL,true);
		return DSPL;
	}
	
	public Nav_SharedProject_Page  Click_Nav_SharedProjects()
	{
		Web_Button.Button_Click(driver, Nav_SharedProject);
		return new Nav_SharedProject_Page();
	}
	
	public String Nav_validateSharedprojecttitle()
	{
		return driver.getTitle();
	}
	
	public  Nav_SimReport_Page Click_Nav_SimReport()
	{
		Web_Button.Button_Click(driver, Nav_SimReport);
		return new Nav_SimReport_Page();
	}
	
	public String Nav_SimReportTitle()
	{
		return driver.getTitle();
	}
	
	public Utilities_Psychrometrics Click_Utilities()
	{
		Web_Button.Button_Click(driver,Nav_Utilities );
		return new Utilities_Psychrometrics();
	}
	
	public String Nav_Utilitiestitle()
	{
		return driver.getTitle();
	}
	
	public Utilities_RefrigerantProperties Click_Utilities_RefrigerantPropertiesCal()
	{
		Web_Button.Button_Click(driver,Utilities_RefPropCal);
		return new Utilities_RefrigerantProperties();
	}
	
	public  boolean Utilities_RefrigerantProperties_label()
	{
		return WebElement_Common.isDisplayedByElement(Utilities_RefrigerantProperties_Label);
	}
	
	public  Fav_CompressorData ValidateNav_Favorite()
	{
		Web_Button.Button_Click(driver, Nav_Favorite);
		return new Fav_CompressorData();
		
	}
	
	public String ValidateComp_Title()
	{
		return driver.getTitle();
	}
	
	public Fav_RTPFTubeData Validate_Fav_RTPFTube()
	{
		Web_Button.Button_Click(driver, Nav_Fav_RTPFTube);
		return new Fav_RTPFTubeData();
	}
	
	public String Fav_RTPF()
	{
		return driver.getTitle();
	}
	
	public Fav_MCTubeData Validate_Fav_MCTube()
	{
		Web_Button.Button_Click(driver, Nav_Fav_MCTubeData);
		return new Fav_MCTubeData();
	}
	
	public String Fav_MCTube()
	{
		return driver.getTitle();
	}
	
	public Fav_FinData Validate_Fav_FinData()
	{
		Web_Button.Button_Click(driver, Nav_Fav_FinData);
		return new Fav_FinData();
	}
	
	public String Fav_FinData()
	{
		return driver.getTitle();
	}
	
	public Fav_FilterAPData Validate_Fav_FilterAPData()
	{
		Web_Button.Button_Click(driver, Nav_Fav_FilterAPData);
		return new Fav_FilterAPData();
	}
	
	public String Fav_FilterAPData()
	{
		return driver.getTitle();
	}
	
	public Fav_ReturnAPData Validate_Fav_ReturnAPData()
	{
		Web_Button.Button_Click(driver, Nav_Fav_ReturnAPData);
		return new Fav_ReturnAPData();
	}
	
	public String Fav_ReturnAPData()
	{
		return driver.getTitle();
	}
	
	public Fav_PipingData Validate_Fav_PipingData()
	{
		Web_Button.Button_Click(driver, Nav_Fav_PipingData);
		return new Fav_PipingData();
	}
	
	public String Fav_PipingData()
	{
		return driver.getTitle();
	}
	
	public Fav_OutdoorCoilRTPF Validate_Fav_OutdoorCoilRTPF()
	{
		Web_Button.Button_Click(driver, Nav_Fav_OutdoorCoilRTPF);
		return new Fav_OutdoorCoilRTPF();
	}
	
	public String Fav_OutdoorCoilRTPF()
	{
		return driver.getTitle();
	}
	
	public Fav_OutdoorCoilMicro Validate_Fav_OutdoorCoilMicro()
	{
		Web_Button.Button_Click(driver, Nav_Fav_OutdoorCoilMicro);
		return new Fav_OutdoorCoilMicro();
	}
	
	public String Fav_OutdoorCoilMicro()
	{
		return driver.getTitle();
	}
	
	public Fav_IndoorCoilRTPF Validate_Fav_IndoorCoilRTPF()
	{
		Web_Button.Button_Click(driver, Nav_Fav_IndoorcoilRTPF);
		return new Fav_IndoorCoilRTPF();
	}
	
	public String Fav_IndoorCoilRTPF()
	{
		return driver.getTitle();
	}
	
	public Fav_IndoorCoilMicro Validate_Fav_IndoorCoilMicro()
	{
		Web_Button.Button_Click(driver, Nav_Fav_IndoorCoilMicro);
		return new Fav_IndoorCoilMicro();
	}
	
	public String Fav_IndoorCoilMicro()
	{
		return driver.getTitle();
	}
	
	public Fav_IndoorFan Validate_Fav_IndoorFan()
	{
		Web_Button.Button_Click(driver, Nav_Fav_IndoorFan);
		return new Fav_IndoorFan();
	}
	
	public String Fav_IndoorFan()
	{
		return driver.getTitle();
	}
	
	public Fav_OutdoorFan Validate_Fav_OutdoorFan()
	{
		Web_Button.Button_Click(driver, Nav_Fav_OutdoorFan);
		return new Fav_OutdoorFan();
	}
	
	public String Fav_OutdoorFan()
	{
		return driver.getTitle();
	}
	
	public Bin_Project Validate_Nav_Bin()
	{
		Web_Button.Button_Click(driver, Nav_Bin);
		return new Bin_Project();
	}
	
	public void Validate_Bin_Project_Name()
	{
		Web_Table.SeacrhAndReturnTableElementByName(Bin_ProjectTable, "wwwww");
		
	}
	
	public Bin_Unit Validate_BinUnit()
	{
		Web_Button.Button_Click(driver, Bin_Unit);
		return new Bin_Unit();
	}
	
	public void Validate_BinUnit_MyUnitName()
	{
		Web_Table.SeacrhAndReturnTableElementByName(BinUnit_UnitName, "Test");
	}
	
	
	
	
	
	public GD_CompressorData Validate_GD_CompressorData()
	{
		Web_Button.Button_Click(driver, Nav_GlobalDB_Compr);
		return new GD_CompressorData();
	}
	
	
	public String Validate_GD_CompressorTitle()
	{
		return driver.getTitle();
	}
	

	public GD_AirHandlerData Validate_GD_AirHandlerData()
	{
		Web_Button.Button_Click(driver, GD_AirHandler);
		return new GD_AirHandlerData();
	}
	
	
	public String Validate_GD_AirHandlerTitle()
	{
		return driver.getTitle();
		
	}
	
	public GD_RTPFTubeData Validate_GD_RTPFTubeData()
	{
		Web_Button.Button_Click(driver, GD_RTPFTube);
		return new GD_RTPFTubeData();
	}
	
	
	public String Validate_GD_RTPFTubeTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_MCTubeData Validate_GD_MCTubeData()
	{
		Web_Button.Button_Click(driver, GD_MCTube);
		return new GD_MCTubeData();
	}
	
	
	public String Validate_GD_MCTubeTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_FinData Validate_GD_FinData()
	{
		Web_Button.Button_Click(driver, GD_Fin);
		return new GD_FinData();
	}
	
	
	public String Validate_GD_FinTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_FilterAPData Validate_GD_FilterAPData()
	{
		Web_Button.Button_Click(driver, GD_FilterAP);
		return new GD_FilterAPData();
	}
	
	
	public String Validate_GD_FilterAPTitle()
	{
		return driver.getTitle();
	}

	
	
	public GD_ReturnAPData Validate_GD_ReturnAPData()
	{
		Web_Button.Button_Click(driver, GD_ReturnAP);
		return new GD_ReturnAPData();
	}
	
	
	public String Validate_GD_ReturnAPTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_PipingData Validate_GD_PipingData()
	{
		Web_Button.Button_Click(driver, GD_Piping);
		return new GD_PipingData();
	}
	
	
	public String Validate_GD_PipingTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_OutdoorCoilRTPFData Validate_GD_OutdoorCoilRTPFData()
	{
		Web_Button.Button_Click(driver, GD_OutdoorCoilRTPF);
		return new GD_OutdoorCoilRTPFData();
	}
	
	
	public String Validate_GD_OutdoorCoilRTPFTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_OutdoorCoilMCData Validate_GD_OutdoorCoilMCData()
	{
		Web_Button.Button_Click(driver, GD_OutdoorCoilMC);
		return new GD_OutdoorCoilMCData();
	}
	
	
	public String Validate_GD_OutdoorCoilMCTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_IndoorCoilRTPFData Validate_GD_IndoorCoilRTPFTubeData()
	{
		Web_Button.Button_Click(driver, GD_IndoorCoilRTPF);
		return new GD_IndoorCoilRTPFData();
	}
	
	
	public String Validate_GD_IndoorCoilRTPFTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_IndoorCoilMCData Validate_GD_IndoorCoilMCTubeData()
	{
		Web_Button.Button_Click(driver, GD_IndoorCoilMC);
		return new GD_IndoorCoilMCData();
	}
	
	
	public String Validate_GD_IndoorCoilMCTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_PacklessCoilData Validate_GD_PacklessCoilData()
	{
		Web_Button.Button_Click(driver, GD_PacklessCoil);
		return new GD_PacklessCoilData();
	}
		
	
	public String Validate_GD_PacklessCoilTitle()
	{
		return driver.getTitle();
	}
	
	
	public GD_AccumulatorData Validate_GD_AccumulatorData()
	{
		Web_Button.Button_Click(driver, GD_Accumulator);
		return new GD_AccumulatorData();
	}
		
	
	public String Validate_GD_AccumulatorTitle()
	{
		return driver.getTitle();
	}
	
	
	
	public GD_FilterDrierData Validate_GD_FilterDrierData()
	{
		Web_Button.Button_Click(driver, GD_FilterDrier);
		return new GD_FilterDrierData();
	}
		
	
	public String Validate_GD_FilterDrierTitle()
	{
		return driver.getTitle();
	}
	
	public User_Requests Validate_Nav_UsersRequest()
	{
		Web_Button.Button_Click(driver, Nav_UserRequest);
		return new User_Requests();
	}
	
	public String Validate_Nav_UserRequestTitle()
	{
		return driver.getTitle();
	}
	
	public  Manage_Users Validate_Nav_ManageUsers()
	{
		Web_Button.Button_Click(driver, Nav_ManageUser);
		return new Manage_Users();
	}
	
	public String Validate_Nav_ManageUsersTitle()
	{
		return driver.getTitle();
	}
	
	public Dash_MyProject Validate_Dash_MyProjectIcon()
	{
		Web_Button.Button_Click(driver, Dash_MyProject);
		return new Dash_MyProject();
	}
	
	public boolean Validate_DashMyProject_CreateProjectBtn()
	{
		 return WebElement_Common.isDisplayedByElement(DashMyProject_CreateProject);
	}
	
	public Dash_MyUnit Validate_Dash_MyUnitIcon()
	{
		Web_Button.Button_Click(driver, Dash_MyUnit);
		return new Dash_MyUnit();
	}
	
	public  Dash_StandardProject Validate_Dash_StandardProject()
	{
		Web_Button.Button_Click(driver, Dash_StandardProject);
		return new Dash_StandardProject();
	}
	
	public boolean Validate_DashMyUnit_CreateUnitBtn()
	{
		return WebElement_Common.isDisplayedByElement(DashMyUnit_CreateUnit);
	}
	
	
	
	
}
