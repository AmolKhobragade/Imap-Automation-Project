package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class User_Requests extends Baseclass 
{

	@FindBy(xpath="//div[contains(text(),'Requested By')]")
	public WebElement RequestedByLabel;
	
	public User_Requests()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Validate_UserRequestLabel()
	{
		String Req= RequestedByLabel.getText();
		Reporter.log(Req);
		return Req;
	}
	
	
	
	
}
