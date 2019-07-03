package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Manage_Users extends Baseclass
{

	@FindBy(xpath="//button[@ng-click='UserModule.AddUserPopup();']")
	public WebElement ManageUser_AddUserButton;
	
	
	public Manage_Users()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_ManageUser_AddUserButton()
	{
		boolean BtnAddUser=ManageUser_AddUserButton.isDisplayed();
		Reporter.log("Add User Button Displayed"+ BtnAddUser);
		return BtnAddUser;
	}
	
	
}
