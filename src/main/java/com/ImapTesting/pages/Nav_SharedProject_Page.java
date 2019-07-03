package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Nav_SharedProject_Page extends Baseclass
{

	@FindBy(xpath="//table[@id='tblProjectList']//div[contains(text(),'Manage Project')]")
	public WebElement SharedProject_ManageProjectLabel;
	
	public Nav_SharedProject_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String ValidateSharedProject_ManageProject_Label()
	{
		String LabelSharedProject_ManageProject=SharedProject_ManageProjectLabel.getText();
		Reporter.log(LabelSharedProject_ManageProject,true);
		return LabelSharedProject_ManageProject;
	}
	
}
