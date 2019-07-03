package com.ImapTesting.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.Web_Button;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class NewProject_CreateProject extends Baseclass 
{
	

	public ExtentHtmlReporter htmlreporter;
	public ExtentTest Extents;
	
	@FindBy(xpath="//h4[contains(text(),'Create Project')]")
	public WebElement Lbl_CreateProject;
	
	@FindBy(xpath="//button[@ng-click='Project.Cancel()']")
	public WebElement Btn_Cancel;
	
	@FindBy(id="DdlGroup")
	public WebElement DD_Group;
	
	@FindBy(id="DdlProductLine")
	public WebElement ProductLine;
	
	@FindBy(id="saveProject")
	public WebElement Btn_Save;
	
	public NewProject_CreateProject()
	{
		PageFactory.initElements(driver, this);
	}
	
    
	
	/*public String Validate_LblCreateProject()
	{
		String GetElementText=Lbl_CreateProject.getText();
		Reporter.log(GetElementText,true);
		return GetElementText;
	}*/
	
	
	
	public void ClickGroupDropDownBox()
	{
		Actions action = new Actions(driver);
		action.moveToElement(DD_Group).click().build().perform();	
		
		//Web_Button.Button_Click(driver, DD_Group);
	}
	
	public void Validate_GroupDropdown()
	     {
		
		Select dropdown = new Select(DD_Group);
		List<WebElement> allelement = dropdown.getOptions();
		for (WebElement element : allelement )
		{
			 String Dropvalue = element.getText();
			if(Dropvalue.equals("Amol 02.02.01"))
			{
				Reporter.log(Dropvalue,true);
			}	
		}
		}
	
	public boolean Validate_ProductLineStatus()
	{
		//WebElement_Common.IsElementNotEnable(ProductLine);
		boolean ProdLine = ProductLine.isEnabled();
		Reporter.log("The status of ProductLine is disabled then test case is passed else it will be failed :"+ ProdLine,true);
		return ProdLine;	
	}
	
	public boolean Validate_BtnSave()
	{
		boolean SaveBtn= Btn_Save.isEnabled();
		Reporter.log("The Save button of create project pop up should be disabled: "+SaveBtn,true);
		return SaveBtn;
	}
	
	
	public DashboardPage Btn_ClickCancel()
	{
		Web_Button.Button_Click(driver, Btn_Cancel);
		return new DashboardPage();
	}
	
	
	
	
}
