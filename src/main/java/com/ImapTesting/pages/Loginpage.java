package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ImapTesting.baseclass.Baseclass;
import com.ImapTesting.commonfunction.WebElement_Common;
import com.ImapTesting.commonfunction.Web_Page;
import com.ImapTesting.utilities.WaitFunction;



public class Loginpage extends Baseclass

{

	@FindBy(xpath="//div[@id='loginBox']//input[@ng-model='LoginData.UserCredentials.UserName']")

	private WebElement txt_Globalid;

	@FindBy(xpath="//input[@ng-model='LoginData.UserCredentials.Password']")
	
	private WebElement txt_Password;
	
	@FindBy(xpath="//button[@ng-click='ImapAccessRequest.Login()']")

	private WebElement btn_Login;
	
	@FindBy(xpath="//div[@id='loginBox']//label[@class='error-msg']")

	public WebElement Errormsg_login; 
	
	@FindBy(xpath="")
	private WebElement Dashboard_label;
	
 WebElement_Common common;
 WaitFunction W1;
	
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage validatelogin(String global_id,String password)
	{
		txt_Globalid.clear();
		txt_Password.clear();
		txt_Globalid.sendKeys(global_id); 
		txt_Password.sendKeys(password);
		btn_Login.click();
		return new DashboardPage();
	}
	
	
	public DashboardPage Validate_Loginusing_ValidCredential(String global_id,String password)
	{
		txt_Globalid.click();
		txt_Password.click();
		txt_Globalid.sendKeys(global_id); 
		txt_Password.sendKeys(password);
		btn_Login.click();
		return new DashboardPage();
	}
	
	public void Invalidgidandpass(String gid,String pwd)
	{
		txt_Globalid.sendKeys(gid);
		txt_Password.sendKeys(pwd);
		btn_Login.click();
		
	}
	
	public void CheckLoginErrorMsg()
	{
		/*String Err = Errormsg_login.getAttribute("value");
		return Err;*/
		Web_Page.searchTextOnWebPage(driver, "The User ID and Password that you provided are not correct.");
		//W1.isElementPresent(Errormsg_login);
	}
	
	
	public String CheckDashboardTitle()
	{
		 return driver.getTitle();
        
		
	}
}
