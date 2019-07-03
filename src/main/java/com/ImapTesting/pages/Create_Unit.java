package com.ImapTesting.pages;


import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.utilities.Common_Utilities;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Create_Unit extends Baseclass

{
	Dash_MyUnit myunit = new Dash_MyUnit();
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentTest Extents;	
	

	@FindBy(xpath="//button[@ng-click='Unit.addUnit()']")
	public WebElement Btn_createunit;
	
	@FindBy(id="txtAltitude")
	public WebElement Txt_altitude;
	
	@FindBy(id="txtProject")
	public WebElement Txt_product;
	
	@FindBy(id="txtinformation")
	public WebElement Txt_unitinfo;
	
	@FindBy(id="saveUnit")
	public WebElement Btn_saveunit;
	
	public Create_Unit()
	{
		PageFactory.initElements(driver, this);
	}
	
	 String firstxpath  = "//*[@id='tblProjectList']/tbody/tr[";
	 String secondxpath =  "]/td[2]/div/div[1]";

	 public void Validate_ClickMyProject()
	 {
			
	   Log.info("Printing all project list");
	   for(int i=1;i<=10;i++)
		
	 {

	String name =driver.findElement(By.xpath(firstxpath+i+secondxpath)).getText();
	Reporter.log(name,true);
	
	if(name.equalsIgnoreCase("Amol 1.0"))
	{
	  Common_Utilities.Pageloader();
      driver.findElement(By.xpath("//*[@id='tblProjectList']/tbody/tr["+i+"]/td[2]")).click();
	}
	
	}
	    
	}
	
	public void Validate_ClickMyUnitPage()
	{
		myunit.Validate_Dash_MyUnit_CreateUnitButton();
		myunit.Validate_ClickCreateUnit();
	}
	
	public void Validate_Enterunitname()
	{
		myunit.Validate_UnitName(driver, "Testing Unit 1.0");
	}
	
	public void Validate_Unittype()
	{
		myunit.Validate_SelectUnitType();
	}
	
	public void Validate_Selectconfig()
	{
		myunit.Validate_SelectConfig();
	}
	
	public void Validate_RefList()
	{
		myunit.Validate_RefrigerantList();
	}
	
	public CompressorConfig_Page Validate_Btnsave()
	{
		myunit.Validate_BtnSave();
		return new CompressorConfig_Page();
	}
	
	public void Validate_ToastMsg()
	{
		myunit.CheckErrorMsgMyUnit();
		
	}
	public void Validate_Altitude(WebDriver driver,WebElement element,String value)
	
	{
		element.clear();
		element.sendKeys(value);
	}
	public void Validate_Unitinfo(WebDriver driver,WebElement element,String value)
	{
		element.sendKeys(value);
	}
}
