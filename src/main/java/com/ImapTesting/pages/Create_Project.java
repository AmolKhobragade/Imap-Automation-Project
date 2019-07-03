package com.ImapTesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.Web_Button;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Create_Project extends Baseclass
{
	/* This class is created for project creation 
	 * 
	 * 
	 */
	
	New_Project NewPrj= new New_Project();
	NewProject_CreateProject New_createproject = new NewProject_CreateProject();
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentTest Extents;	
	
	@FindBy(id="projectName")
	public WebElement Txt_ProjectName;
	
	@FindBy(id="saveProject")
	public WebElement Btn_Save;
	
	public Create_Project()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Validate_Click_DashResProject()
	{
		NewPrj.Click_Dash_ResProject();
	}
	
	public void Validate_Create_NewResProject(WebDriver driver,String name)
	{
		Txt_ProjectName.sendKeys(name);
	}
	
	public Create_Unit Validate_BtnClick_Save()
	{
		Web_Button.Button_Click(driver, Btn_Save);
		return new Create_Unit();
	}
	
}
