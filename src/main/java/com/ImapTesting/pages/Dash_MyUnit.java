package com.ImapTesting.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.Web_Button;
import com.ImapTesting.commonfunction.Web_DropDown;

public class Dash_MyUnit  extends Baseclass
{

	DashboardPage DP= new DashboardPage();
	
	@FindBy(xpath="//button[@ng-click='Unit.addUnit()']")
	public WebElement CreateUnitButton;
	
	@FindBy(xpath="//select[@ng-model='objUnit.ProjectId']")
	public WebElement Drop_Project;
	
	@FindBy(id="txtunitname")
	public WebElement Txt_Unitname;
	
	@FindBy(xpath="//select[@ng-model='objUnit.UnitTypeId']")
	public WebElement Drop_UnitType;
	
	@FindBy(id="DdlConfiguration")
	public WebElement Drop_Config;
	
	@FindBy(id="DdlRefrigerant")
	public WebElement Drop_Refrig;
	
	@FindBy(id="saveUnit")
	public WebElement Btn_save;
	
	@FindBy(xpath="//button[@ng-click='Unit.Cancel()']")
	public WebElement Btn_Cancel;
	
	@FindBy(id="toast-container")
	public static WebElement CompleteToasterMessage1;
	
	@FindBy(xpath="//div[contains(text(),'Duplicate Project Name.')]")
	public WebElement ToastMsg1;
	
	public Dash_MyUnit()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Validate_Icon_MyUnit()
	{
		Web_Button.Button_Click(driver,DP.Dash_MyUnit );
	}
	
	
	public boolean Validate_Dash_MyUnit_CreateUnitButton()
	{
		boolean MyUnit_CreateUnitButton= CreateUnitButton.isDisplayed();
		Reporter.log("Create Unit Button is Displayed"+ MyUnit_CreateUnitButton);
		return MyUnit_CreateUnitButton;
	}
	
	public void Validate_ClickCreateUnit()
	{
		Web_Button.Button_Click(driver,CreateUnitButton );
	}
	
	public void Validate_ProjectList()
	{
		Select Dropval=new Select(Drop_Project);
		List<WebElement> allelement = Dropval.getOptions();
		for(WebElement element : allelement )
		{
			String Dropdownval=element.getText();
			if(Dropdownval.equals("Residential 14 May"))
			{
				Reporter.log(Dropdownval,true);
			}
			
		}
	}
		
	public void Validate_SelectProjectlist()
	{
		Web_DropDown.SelectElementByVisibleText(Drop_Project, "Residential 14 May");
	}
	
	public void Validate_UnitName(WebDriver driver,String Unitname)
	{
		Txt_Unitname.sendKeys(Unitname);
	}
	
	public void Validate_SelectUnitType()
	{
		Web_DropDown.SelectElementByVisibleText(Drop_UnitType, "HP System");
	}
	
	public void Validate_SelectConfig()
	{
		Web_DropDown.SelectElementByVisibleText(Drop_Config, "Single Refrigeration System");
	}
	
	public void Validate_RefrigerantList()
	{
		Web_DropDown.SelectElementByVisibleText(Drop_Refrig, "ammonia");
	}
	
	public void Validate_BtnSave()
	{
		Web_Button.Button_Click(driver, Btn_save);
		/*Actions action = new Actions(driver);
		action.moveToElement(Btn_save).click().build().perform();	*/
	}
	
	public static String CheckErrorMsgMyUnit()
	{
		String Msg = CompleteToasterMessage1.getText();
		Reporter.log(Msg,true);
		return Msg;
	}
	
	public void Validate_BtnCancel()
	{
		Web_Button.Button_Click(driver, Btn_Cancel);
		/*Actions action = new Actions(driver);
		action.moveToElement(Btn_Cancel).click().build().perform();*/
	}
	
}
