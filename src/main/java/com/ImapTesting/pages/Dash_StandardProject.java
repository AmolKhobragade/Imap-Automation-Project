package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Dash_StandardProject extends Baseclass
{

	@FindBy(xpath="//button[@ng-click='Project.addProject()']")
	public WebElement BtnCreateProject_StandardProject;
	
	public Dash_StandardProject()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_Btn_DashStandardProject_CreateProject()
	{
		boolean DashStandardProject_CreateProject=BtnCreateProject_StandardProject.isDisplayed();
		Reporter.log("Create Project button of standard project section is displayed :" + DashStandardProject_CreateProject);
		return DashStandardProject_CreateProject;
	}
	
}
