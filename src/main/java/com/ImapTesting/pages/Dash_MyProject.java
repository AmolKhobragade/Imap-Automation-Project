package com.ImapTesting.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.Web_Button;

public class Dash_MyProject extends Baseclass
{

	 NewProject_CreateProject Prj= new NewProject_CreateProject();
	 
	 
	@FindBy(xpath="//button[@ng-click='Project.addProject()']")
	public WebElement CreateProjectButton;
	
	@FindBy(id="DdlProductLine")
	public WebElement Drp_ProductLine;
	
	@FindBy(id="projectName")
	private WebElement Txt_Name;
	
	@FindBy(id="toast-container")
	public WebElement CompleteToasterMessage;
	
	@FindBy(xpath="//div[contains(text(),'Duplicate Project Name.')]")
	public WebElement ToastMsg;
	
	public Dash_MyProject()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_Dash_MyProject_CreateProjectButton()
	{
		boolean MyProject_CreateProjectButton= CreateProjectButton.isDisplayed();
		Reporter.log("Create Project Button is Displayed"+ MyProject_CreateProjectButton);
		return MyProject_CreateProjectButton;
	}
	
	
	/*Below Methods are created for
	 * Dashboard>>MyProject>>Create Project
	 */
	
	public void Validate_CreateProjectPopUp()
	{
		//Web_Button.Button_Click(driver, CreateProjectButton);
		Actions action = new Actions(driver);
		action.moveToElement(CreateProjectButton).click().build().perform();
	}
	
	public void Validate_ClickDrpGroup()
	{
		Prj.ClickGroupDropDownBox();
	}
	
	public void Validate_Groupdrp()
	{
		Prj.Validate_GroupDropdown();
	}
	
	public void Validate_ClickDrpProductLine()
	{
		Actions action = new Actions(driver);
		action.moveToElement(Drp_ProductLine).click().build().perform();
	}
	
	public void Validate_DrpProductLine()
	{
		Select Dropval=new Select(Drp_ProductLine);
		List<WebElement> allelement = Dropval.getOptions();
		for(WebElement element : allelement )
		{
			String Dropdownval=element.getText();
			if(Dropdownval.equals("Rooftop Project"))
			{
				Reporter.log(Dropdownval,true);
			}
			
		}
	}
	
	public void Validate_Name_CreateProject( WebDriver driver,String Name)
	{
		Txt_Name.sendKeys(Name);
	}
	
	public void Verify_BtnClickSave()
	{
		Web_Button.Button_Click(driver, Prj.Btn_Save);
		/*Actions action = new Actions(driver);
		action.moveToElement(Prj.Btn_Cancel).click().build().perform();*/
	}
	
	public void CheckCancel()
	{
		Web_Button.Button_Click(driver, Prj.Btn_Cancel);
		/*Actions action = new Actions(driver);
		action.moveToElement(Prj.Btn_Cancel).click().build().perform();
		*/
	}
	
	public String CheckErrorMsg()
	{
		String Msg = CompleteToasterMessage.getText();
		Reporter.log(Msg,true);
		return Msg;
	}
	
		
	}
	
	

