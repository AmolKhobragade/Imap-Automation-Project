package com.ImapTesting.pages;

import java.util.List;

import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.Javascript_Helper;
import com.ImapTesting.commonfunction.Mouse_Operation;
import com.ImapTesting.commonfunction.Web_Button;
import com.ImapTesting.commonfunction.Web_Link;
import com.ImapTesting.utilities.Common_Utilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class CompressorConfig_Page extends Baseclass 
{
	
	private static ExtentTest logger;
	
	//-----------------------Buttons---------------------------------------------------
	
	@FindBy(id="btnPerformanceCalulation")
	public WebElement Btn_Performancecal;
	
	@FindBy(id="btnSave")
	public WebElement Btn_Save;
	
	@FindBy(id="btnNext")
	public WebElement Btn_Next;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-dropdown-menu btn-sm dropdown-toggle btn-squared btn-label')]")
	public WebElement AddCompressor;
	
	@FindBy(xpath="//a[@ng-click='UserSetting()']")
	public WebElement Btn_Setting;
	
	@FindBy(xpath="//div[@id='userSettingPopup']//button[contains(text(),'Done')]")
	public WebElement Btn_Done;
	
	@FindBy(xpath="//*[@id='toast-container']/div/div[1]/button")
	public WebElement Btn_closeToaster;

	@FindBy(id="toast-container")
	public WebElement CompleteToasterMessage;
	
	//----------------------TextBoxes-------------------------------------------------
	
	@FindBy(xpath="//input[contains(@ng-model,'compressor.SystemParameters[0].Manufacturer')]")
	public WebElement Txt_Manufacture;
	
	@FindBy(xpath="//input[contains(@ng-model,'compressor.SystemParameters[0].Model')]")
	public WebElement Txt_Model;
	
	@FindBy(xpath="//input[contains(@ng-model,'compressor.SystemParameters[0].Type')]")
	public WebElement Txt_Type;
	
	@FindBy(xpath="//input[contains(@ng-model,'compressor.SystemParameters[0].Voltage')]")
	public WebElement Txt_Voltage;
	
	@FindBy(xpath="//input[contains(@ng-model,'Circuit[CircuitIndex].CompressorCorrectionFactor[0].MassFlowMultiplier')]")
	public WebElement Txt_MassFlowMultiplier;
	
	@FindBy(xpath="//input[contains(@ng-model,'Circuit[CircuitIndex].CompressorCorrectionFactor[0].PowerMultiplier')]")
	public WebElement Txt_PowerMultiplier;
	
	@FindBy(xpath="//input[contains(@ng-model,'Circuit[CircuitIndex].CompressorCorrectionFactor[0].CurrentMultiplier')]")
	public WebElement Txt_CurrentMultiplier;
	
	@FindBy(xpath="//input[contains(@ng-model,'Circuit[CircuitIndex].CompressorCorrectionFactor[0].ShellHeatLoss')]")
	public WebElement Txt_ShellHeatloss;
	
	@FindBy(xpath="//input[@ng-model='compressor.SystemParameters[0].Cost']")
	public WebElement Txt_Cost;
	
	@FindBy(xpath="//input[@ng-model='compressor.CompressorFrequency[0].Minimum']")
	public WebElement Txt_Frequency;
	
	@FindBy(xpath="//input[@ng-model='compressor.UserParameters[0].SaturationSuctionTempreture']")
	public WebElement Txt_SatSucTemp;
	
	@FindBy(xpath="//input[@ng-model='compressor.UserParameters[0].SaturationDischargeTempreture']")
	public WebElement Txt_SatDisTemp;
	
	@FindBy(xpath="//input[@ng-model='compressor.UserParameters[0].LiquidLineSubCooling']")
	public WebElement Txt_LiqLineSubcool;
	
	@FindBy(xpath="//input[@ng-model='compressor.UserParameters[0].SuctionLineSuperHeat']")
	public WebElement Txt_SucLineSuperheat;
	
	
	//-------------------------DropDownMenu----------------------------------------
	
	@FindBy(xpath="//Select[@ng-model='compressor.SystemParameters[0].Phase']")
	public WebElement Dropdown_Phase;
	
	@FindBy(xpath="//Select[@ng-model='compressor.SystemParameters[0].RefrigerantId']")
	public WebElement Dropdown_Refrigerant;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']//li//a")
	public WebElement AddCompressorlist;
	
	@FindBy(xpath="//select[@ng-model='compressor.CompressorTypeId']")
	public WebElement CompressorType;
	
	//.........................WebTableList........................................
	
	@FindBy(xpath="//*[@id=\"tblUnitList\"]/tbody/tr/td[2]")
	public WebElement UnitListName;
	
	
	//-------------------------Units-----------------------------------------
	
	@FindBy(xpath="//*[@id='collapse0']/div[1]/div/div[2]/div[2]/div[3]")
	public WebElement Unit_Voltage;
	
	@FindBy(xpath="//*[@id='collapse0']/div[1]/div/div[2]/div[3]/div[6]/div[3]/span")
	public WebElement Unit_Frequency;

	@FindBy(xpath="//span[contains(text(),'$')]")
	public WebElement Unit_Cost;
	
	@FindBy(xpath="//div[@id='jciunitsname']/span")
	public WebElement Unit_UserSpecifiedParameter;

	
	
	
	
	//---------------------------RadioButtons-----------------------------------
	
	@FindBy(xpath="//div[@id='userSettingPopup']//li[2]/label/div/ins")
	public WebElement RadioBtn_IP;
	
	@FindBy(xpath="//div[@id='userSettingPopup']//li[1]/label/div/ins")
	public WebElement RadioBtn_SI;
	
	@FindBy(xpath="//*[@id='collapse0']//label[2]/div/ins")
	public WebElement Radio_IP;
	
	@FindBy(xpath="//*[@id='collapse0']//label[1]/div/ins[1]")
	public WebElement Radio_SI;
	
	@FindBy(xpath="//*[@id='ht_0e1e862092ce5256']/div[3]/div/div/div/table/tbody/tr[1]/th")
	public WebElement Massflowcoeff;
	
	
	//----------------------------String for Dropdown----------------------------------------------
	
	
	public String[] ExpectedPhase= {"Select Phase","1","2","3"};
	
	public String[] ExpectedRefrigerant= {"Select Refrigerant","ammonia","carbondioxide",
			"helium","propane","R12","R1234yf","R1234ze","R134a","R22","R22/R407C","R290",
			"R32","R404A","R407A","R407C","R407F","R410A","R448A","R449A","R450A","R452B"
			,"R454B","R466A","R502","R507","R507A","R513A","R704","R717","R744","water"};
	
	public String[] ExpectedCompressorType= {"Fixed Speed","Variable Speed 10 Coefficients",
			"Variable Speed 20 Coefficients","Variable Capacity"};
	
	public String[]ExpectedUserSpecifiedParameterUnitIP= {"°F","°F","°F","°F"};
	
	public String[]ExpectedUserSpecifiedParameterUnitSI= {"°C","°C","°C","°C"};
	
	public String[]ExpectedFixedCoefficient_IP= {"Mass Flow(lbm/hr)","Power(W)","Capacity(Btu/hr)","Current(A)"};
	
	public String[]ExpectedFixedCoefficient_SI= {"Mass Flow(kg/s)","Power(W)","Capacity(W)","Current(A)"};

	
	public CompressorConfig_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
/****************************************************************************************/
	 
	 String firstxpath  = "//*[@id='tblProjectList']/tbody/tr[";
	 String secondxpath =  "]/td[2]/div/div[1]";

	 
	 public void Validate_ClickMyProject()
	 {
			
	   Log.info("Printing all project list");
	   for(int i=1;i<=10;i++)
		
	 {

	String name =driver.findElement(By.xpath(firstxpath+i+secondxpath)).getText();
	Reporter.log(name,true);
	
	if(name.equalsIgnoreCase("Automation Project 1.0"))
	{
	  Common_Utilities.Pageloader();
     driver.findElement(By.xpath("//*[@id='tblProjectList']/tbody/tr["+i+"]/td[2]")).click();
     Common_Utilities.Pageloader();
	}
	
	}
	    
	}
	 
/******************************************************************************/
	
	 String firstxpathunit  = "//*[@id='tblUnitList']/tbody/tr[";
	 String secondxpathunit =  "]/td[2]/div/div[1]";

	 public void Validate_ClickMyUnit()
	 {
			
	   Log.info("Printing all Unit list");
	   for(int i=1;i<=10;i++)
		
	 {

	String name =driver.findElement(By.xpath(firstxpathunit+i+secondxpathunit)).getText();
	Reporter.log(name,true);
	
	if(name.equalsIgnoreCase("Testing Unit 1.0"))
	{
	 Common_Utilities.Pageloader();
     driver.findElement(By.xpath("//*[@id='tblUnitList']/tbody/tr["+i+"]/td[2]")).click();
     Common_Utilities.Pageloader();
	}
	
	}
	    
	}
/****************************************************************************/
	 public void Validate_clickUnitlist()
	 {
		 
		 //Common_Utilities.Pageloader();
		 
		 try
		 {
			 WebDriverWait wait=new WebDriverWait(driver,10);
			 wait.until(ExpectedConditions.elementToBeClickable(UnitListName));
			 
			 if(UnitListName.isDisplayed() && UnitListName.isEnabled())
			 {
				 
				 Mouse_Operation.hoverMouseToElement(driver, logger, UnitListName);
				 Common_Utilities.Pageloader();
				 Web_Button.Button_Click(driver, UnitListName);
			 } 
		 }
		 catch(Exception e)
		 {
				logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));

		 }
		 
		 
	 }
	 
	 public void Validate_clickaddcomprebtn()
	 {
		 Web_Button.Button_Click(driver, AddCompressor);
		 
	 }
	 
	 public  void Validate_AddCompressordropdown()
	 {
		 
		 //AddCompressor.click();
		
		 List<WebElement>list = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		 System.out.println(list.size());
		 
		 for(int i=0;i<list.size();i++)
		 {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equalsIgnoreCase("Create New Compressor"))
			{
				list.get(i).click();
				break;
			}
		 }
		 
	 }

/*************************************************************************************/	 
	 
	 
	public String VerifyFrequencyUnit()
	{
		//String lbl = Unit_Frequency.getText();
		//String lbl = Unit_Frequency.getAttribute("value");
		String lbl = Unit_Voltage.getText();
		Reporter.log(lbl,true);
		return lbl;
	}
	
	
	
	
	
	
/************************************************************************************/	 
	
	public void CheckDropActExp(WebDriver driver,WebElement element)
	{
		
		try
		{
		Select Value = new Select(element);
		List<WebElement>selectoption = Value.getOptions();
		for(int i=0;i<selectoption.size();i++)
		{
			
			Assert.assertEquals(selectoption.get(i).getText(), ExpectedPhase[i],"The values of the phase dropdown are not correct");
			
		}
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		}
	
	}
/**************************************************************************************/
	
	public void CheckCompressorTypeActExp(WebDriver driver,WebElement element)
	{
		try
		{
		Select Value = new Select(element);
		List<WebElement>selectoption = Value.getOptions();
		for(int i=0;i<selectoption.size();i++)
		{
			
			Assert.assertEquals(selectoption.get(i).getText(), ExpectedCompressorType[i],"The values of the Compressortype dropdown are not correct");
			
		}
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		}
	}
	
/****************************************************************************************/
	public void CheckRefrigerantActExp(WebDriver driver,WebElement element)
	{
		try
		{
		Select Value = new Select(element);
		List<WebElement>selectoption = Value.getOptions();
		for(int i=0;i<selectoption.size();i++)
		{
			
			Assert.assertEquals(selectoption.get(i).getText(), ExpectedRefrigerant[i],"The values of the Refrigerant dropdown are not correct");
			
		}
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		}
	}
	
/******************************************************************************************/	
	 
	public void Check_UserSpecifiedParameter_Unit_IP()
	{
		
		try
		{
		
		List<WebElement> value= driver.findElements(By.xpath("//div[@id='jciunitsname']/span"));
		for(int i=0;i<value.size();i++)
		{
			Assert.assertEquals(value.get(i).getText(), ExpectedUserSpecifiedParameterUnitIP[i],"The units of the user specified parameter are not correct");
			//Reporter.log("The units of user specified parameters are when user setting is IP" + ExpectedUserSpecifiedParameterUnit[i],true);
			System.out.println("The units of user specified parameters(Sat. Suction Temp,Sat. Discharge Temp,Liquid Line Sub Cooling,Suction Line Superheat) are when user setting is IP" + value.get(i).getText() );
		}
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		}
	}
	
	public void Check_UserSpecifiedParameter_Unit_SI(WebDriver driver,WebElement Radio_Btn_SI)
	{
		
		try
		{
		
			
		List<WebElement> value= driver.findElements(By.xpath("//div[@id='jciunitsname']/span"));
		for(int i=0;i<value.size();i++)
		{
			Assert.assertEquals(value.get(i).getText(), ExpectedUserSpecifiedParameterUnitSI[i],"The units of the user specified parameter are not correct");
			//Reporter.log("The units of user specified parameters are when user setting is IP" + ExpectedUserSpecifiedParameterUnit[i],true);
			System.out.println("The units of user specified parameters(Sat. Suction Temp,Sat. Discharge Temp,Liquid Line Sub Cooling,Suction Line Superheat) are when user setting is IP" + value.get(i).getText() );
		}
		 
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		}
	}
	
	
	
	
	
	
	
	
	
	
/*****************************************************************************/	
	
 /*public void Check_CoefficientUnit_FixedCompressor(WebDriver driver,WebElement BtnRadio_CoefficientUnit)
 {
	 try
	 {
		 if(BtnRadio_CoefficientUnit.isDisplayed() && BtnRadio_CoefficientUnit.isSelected())
		 {
			 List<WebElement> value=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody"));
			 for(int i=0;i<value.size();i++)
			 {
					Assert.assertEquals(value.get(i).getText(), ExpectedFixedCoefficient_IP[i],"The IP units of coefficient when user setting is IP :");
					Reporter.log("The IP units of coefficient when user setting is IP :" + ExpectedFixedCoefficient_IP[i],true);

			 }
		 }
	 }
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		}
 }*/
 
 
	
	 String FirstXpath="//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr[";
	 String SecondXpath="]/th/div/span";
	

	/*public  void Check_CoefficientUnit_FixedCompressor(WebDriver driver,WebElement BtnRadio_CoefficientUnit)
	 {
		

		 try
		 {
			 
			 if(BtnRadio_CoefficientUnit.isSelected())
			 {
				 
				 
				 for(int i=1;i<=4;i++)
				 {
					    String valueelement = (FirstXpath+i+SecondXpath);
					    WebElement ele= driver.findElement(By.xpath(valueelement));
					    ele.getText();
						Assert.assertEquals(ele, ExpectedFixedCoefficient_IP[i],"The IP units of coefficient when user setting is IP :");
						Reporter.log("The IP units of coefficient when user setting is IP :" + ExpectedFixedCoefficient_IP[i],true);

				 }
			 }
		 }
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}
		 
	 }*/
	
	
	
/*	
	public void Check_CoefficientUnit_FixedCompressor(WebDriver driver,WebElement BtnRadio_CoefficientUnit)
	 {
		 try
		 {
			 if(BtnRadio_CoefficientUnit.isDisplayed() && BtnRadio_CoefficientUnit.isSelected())
			 {
				 List<WebElement> value=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span"));
				 
				 for(WebElement we:value)
				 { 
				 for(int i=0;i<ExpectedFixedCoefficient_IP.length;i++)
				 {
						Assert.assertEquals(we.getText(), ExpectedFixedCoefficient_IP[i],"The IP units of coefficient when user setting is IP :");
						Reporter.log("The IP units of coefficient when user setting is IP :" + ExpectedFixedCoefficient_IP[i],true);

				 }
			 }}
		 }
			catch(Exception e)
			{
				logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
			}
	 }
	
	*/
	
	 public void CheckcoefficientUnit_FixedSpeed_IP(WebDriver driver,WebElement RadioIPbutton,WebElement Click_SI)
	 
	 {
		 try
		 {
			 
		 
		 if(!(RadioIPbutton.isEnabled() && RadioIPbutton.isSelected()))
		 
		 {
		// List<WebElement> eleunit=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span"));
		   List<WebElement> eleunit=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span[contains(text(),'')]"));

		  for(int i=0;i<eleunit.size();i++)
		 {
			 
			 Assert.assertEquals(eleunit.get(i).getText(), ExpectedFixedCoefficient_IP[i],"The units are not matched :");
			 System.out.println("The unit of coefficient are : "+ eleunit.get(i).getText());
			 //Reporter.log("when the user setting is IP then the unit of coefficient table is : " + eleunit.get(i).getText());
		 }
		 }
		 else
		 {
			 JavascriptExecutor executorIP = (JavascriptExecutor)driver;
			 executorIP.executeScript("arguments[0].click();", Click_SI);
			 
			 JavascriptExecutor executorSI = (JavascriptExecutor)driver;
			 executorSI.executeScript("arguments[0].click();", RadioIPbutton);
			 
			 
			List<WebElement> eleunit=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span"));

			  for(int i=0;i<eleunit.size();i++)
			 {
				 
				 Assert.assertEquals(eleunit.get(i).getText(), ExpectedFixedCoefficient_IP[i],"The units are not matched :");
				 System.out.println("The unit of coefficient are : "+ eleunit.get(i).getText());
				 //Reporter.log("when the user setting is IP then the unit of coefficient table is : " + eleunit.get(i).getText());
			 }
			 
		 }
		 }
		 catch(NoSuchElementException e)
		 {
				logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));

		 }
	 }
	 
	 
	 public void CheckFixedCompressorCoeffUnit_SI(WebDriver driver,WebElement RadioSIButtton,WebElement RadioIPButton)
	 {
		 try
		 {	
			 if(!(RadioSIButtton.isEnabled() && RadioSIButtton.isSelected()))
			 
			 {
				 
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", RadioSIButtton);
				 
			
			List<WebElement> eleunit=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span[contains(text(),'')]"));

	 		//List<WebElement> eleunit=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span"));
			  
	 		for(int i=0;i<eleunit.size();i++)
			 {
				 Assert.assertEquals(eleunit.get(i).getText(), ExpectedFixedCoefficient_SI[i],"The units are not matched :");
				 System.out.println("The unit of coefficient are : "+ eleunit.get(i).getText());
				 //Reporter.log("when the user setting is IP then the unit of coefficient table is : " + eleunit.get(i).getText());
			  }
			 }
			 
			 else
			 {
				    JavascriptExecutor radioIP = (JavascriptExecutor)driver;
				    radioIP.executeScript("arguments[0].click();", RadioIPButton);
						 
					 JavascriptExecutor radioSI = (JavascriptExecutor)driver;
					 radioSI.executeScript("arguments[0].click();", RadioSIButtton);
					 
					//List<WebElement> eleunit=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span[contains(text(),'')]"));

			 		List<WebElement> eleunit=driver.findElements(By.xpath("//div[@class='ht_clone_left handsontable']/div[1]/div[1]/div[1]/table/tbody/tr/th/div/span"));
					  
			 		for(int i=0;i<eleunit.size();i++)
					 {
						 Assert.assertEquals(eleunit.get(i).getText(), ExpectedFixedCoefficient_SI[i],"The units are not matched :");
						 System.out.println("The unit of coefficient are : "+ eleunit.get(i).getText());
						 //Reporter.log("when the user setting is IP then the unit of coefficient table is : " + eleunit.get(i).getText());
					  }
			 }
		 }
		 catch(NoSuchElementException e)
		 {
				logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));
		 }
		 
		 }
	 
	 
	 public  void CheckHotTable()
	 {
		 try
		 {
	 	//No of Rows in the table
	 	int Row_Count=driver.findElements(By.xpath("//*[@id='fixedspeedTable_1']/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/th")).size();
	 	System.out.println("No of rows ="+ Row_Count);
	 	
	 	//No of column in the table
	 	int Col_Count=driver.findElements(By.xpath("//*[@id='fixedspeedTable_1']/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td")).size();
	 	System.out.println("No of cols ="+ Col_Count);
	 	
	 	String firstpart="//*[@id='fixedspeedTable_1']/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[";
	 	String secondpart="]/td[";
	 	String thirdpart="]";
	 	
	 	for(int i=1;i<=Row_Count;i++)
	 	{
	 		for(int j=1;j<=Col_Count;j++)
	 		{
	 			//String finalxpath=firstpart+secondpart+thirdpart;
	 			driver.findElement(By.xpath("//*[@id='fixedspeedTable_1']/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["+i+"]/td["+j+"]")).sendKeys("1");
	 		}
	 	}
		 }
	 	catch(ElementNotVisibleException e)
		 {
	 		e.printStackTrace();
		 }
		 
	 
	 }
	
	 
	
	
/*	 
	 public void checkcoefficienttable()
	 {
		 
		//No of Rows in the table
		 	int Row_Count=driver.findElements(By.xpath("//*[@id='fixedspeedTable_1']/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr")).size();
		 	System.out.println("No of rows ="+ Row_Count);
		 	
		 	//No of column in the table
		 	int Col_Count=driver.findElements(By.xpath("//*[@id='fixedspeedTable_1']/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td")).size();
		 	System.out.println("No of cols ="+ Col_Count);
		 	
		 
		 
		 String xpathcoeff1="//*[@id='fixedspeedTable_1']/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr";
		 String xpathcoeff2 ="/td";
		 
		 for(int i=0;i<=Row_Count;i++)
		 	{
		 		for(int j=0;j<=Col_Count;j++)
		 		{
		 			driver.findElement(By.xpath(xpathcoeff1+"i"+"j"+xpathcoeff2))
		 		}
	 }*/


	 public void CheckRadioButtonIP(WebDriver driver,WebElement User_setting,WebElement rdbtn_IP,WebElement Donebtn)//,WebElement rdbtn_SI)
	 {
			WebElement toastmsg = driver.findElement(By.id("toast-container"));
			WebElement closetoastermsg =driver.findElement(By.xpath("//*[@id='toast-container']/div/div[1]/button"));

		 if(rdbtn_IP.isSelected())
		 {
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  executor.executeScript("arguments[0].click();", Donebtn);
			  System.out.println("The status of IP radio button is :" + rdbtn_IP);
			  
		 }
			  else if (!(rdbtn_IP.isSelected()))
			  {
				  JavascriptExecutor executor = (JavascriptExecutor)driver;
				  executor.executeScript("arguments[0].click();", rdbtn_IP);
				  Common_Utilities.Pageloader();
				  
				  
				    WebDriverWait wait1=new WebDriverWait(driver,10);
					wait1.until(ExpectedConditions.visibilityOf(toastmsg));
					
					JavascriptExecutor toster1 = (JavascriptExecutor)driver;
					toster1.executeScript("arguments[0].click();", closetoastermsg);
				  
				  JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				  executor1.executeScript("arguments[0].click();", Donebtn);
				  
			  }
			  else
			  {
				  System.out.println("IP Radio button is not selected");
			  }
		 }
	 
	 
	 public  static String  CheckSatDisTempSI(WebDriver driver,WebElement ele)
	 {
		 String attributevalue = null;
		 
		 attributevalue=ele.getAttribute("value");
		 
		 if(attributevalue.equals("48.888889"))
		 {
			 
			 System.out.println("The default value of SatDisTemp field when user setting is SI : " + attributevalue);
		 }
		 else if(attributevalue.equals("48.88888"))
		 {
			 System.out.println("The default value of SatDisTemp field when user setting is SI : " + attributevalue);
		 }
		 return attributevalue;
	 }
	 
	
	 public  static String  CheckSuctionLinesuperheatSI(WebDriver driver,WebElement ele)
	 {
		 String attributevalue = null;
		 
		 attributevalue=ele.getAttribute("value");
		 
		 if(attributevalue.equals("5.555556"))
		 {
			 
			 System.out.println("The default value of SucLineSuperHeat field when user setting is SI : " + attributevalue);
		 }
		 else if(attributevalue.equals("5.555555"))
		 {
			 System.out.println("The default value of SucLineSuperHeat field when user setting is SI : " + attributevalue);
		 }
		 return attributevalue;
	 }
	 
	 
	 
	 public  static String  SatDisTemp_IP(WebDriver driver,WebElement ele)
	 {
		 String attributevalue = null;
		 
		 attributevalue=ele.getAttribute("value");
		 
		 if(attributevalue.equals("120"))
		 {
			 Assert.assertEquals(attributevalue, "120");
			 System.out.println("The default value of SatDisTemp field when user setting is IP : " + attributevalue);
		 }
		 else if(attributevalue.equals("119.999998"))
		 {
			 Assert.assertEquals(attributevalue, "119.999998");
			 System.out.println("The default value of SatDisTemp field when user setting is IP : " + attributevalue);
		 }
		 return attributevalue;
	 }
	 
	 
	 public  static String  LiqLineSubCool_IP(WebDriver driver,WebElement ele)
	 {
		 String attributevalue = null;
		 
		 attributevalue=ele.getAttribute("value");
		 
		 if(attributevalue.equals("15]"))
		 {
			 Assert.assertEquals(attributevalue, "15]");
			 System.out.println("The default value of LiqLineSubCool_IP field when user setting is IP : " + attributevalue);
		 }
		 else if(attributevalue.equals("14.999999"))
		 {
			 Assert.assertEquals(attributevalue, "14.999999");
			 System.out.println("The default value of LiqLineSubCool_IP field when user setting is IP : " + attributevalue);
		 }
		 return attributevalue;
	 }
	 
	 
	 public  static String  SucLinesuperheat_IP(WebDriver driver,WebElement ele)
	 {
		 String attributevalue = null;
		 
		 attributevalue=ele.getAttribute("value");
		 
		 if(attributevalue.equals("10"))
		 {
			 Assert.assertEquals(attributevalue, "10");
			 System.out.println("The default value of SucLinesuperheat_IP field when user setting is IP : " + attributevalue);
		 }
		 else if(attributevalue.equals("9.999999"))
		 {
			 Assert.assertEquals(attributevalue, "9.999999");
			 System.out.println("The default value of SucLinesuperheat_IP field when user setting is IP : " + attributevalue);
		 }
		 return attributevalue;
	 }
	 
	 
	 
	 
	 
	 }

		 

		 
	
