package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.Web_Button;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class New_Project extends Baseclass
{
	/*This Page is created for All 4 product line which are displayed 
	 * in the dashboard
	 * Residential/Rooftop/RACPAC/VRF
	 * the below methods are only for redirecting to the create project
	 * after clicking any product line from the dashboard
	 * the below 4 methods are redirecting to the NewProject_CreateProject
	 */

	public ExtentHtmlReporter htmlreporter;
	public ExtentTest Extents;
	
	@FindBy(xpath="//a[@ng-click='dashboard.residentialImageclicked()']")
	public  WebElement Dash_ResProject;
	
	@FindBy(xpath="//a[@ng-click='dashboard.rooftopImageclicked()']")
	public  WebElement Dash_RoofProject;
	
	@FindBy(xpath="//a[@ng-click='dashboard.racpacImageclicked()']")
	public  WebElement Dash_RACPACProject;
	
	//@FindBy(xpath="//a[@ng-click='dashboard.residentialImageclicked()']")
	//public  WebElement Dash_ResProject;
	
	
	public New_Project()
	{
		PageFactory.initElements(driver, this);
	}
	
	public NewProject_CreateProject Click_Dash_ResProject()
	{
		Web_Button.Button_Click(driver, Dash_ResProject);
		return new NewProject_CreateProject();
	}
	
	public NewProject_CreateProject Click_Dash_RoofProject()
	{
		Web_Button.Button_Click(driver, Dash_RoofProject);
		return new NewProject_CreateProject();
	}
	
	public NewProject_CreateProject Click_Dash_RACPACProject()
	{
		Web_Button.Button_Click(driver, Dash_RACPACProject);
		return new NewProject_CreateProject();
	}
	
	
}
