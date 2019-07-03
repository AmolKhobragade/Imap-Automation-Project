package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_IndoorCoilMicro extends Baseclass 
{

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='indoorCoilFavMicro.LoadSelectedIndoorCoilData(null)']")
	public WebElement FavIndoorCoilMicro_Btn_AddIndoorCoilData;
	
	
	
	
	public Fav_IndoorCoilMicro()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_AddIndoorCoilMCButton()
	{
		boolean AddIndoorCoilMCButton = FavIndoorCoilMicro_Btn_AddIndoorCoilData.isDisplayed();
		Reporter.log("The Add Outdoor Coil MC button is displayed"+ AddIndoorCoilMCButton);
		return AddIndoorCoilMCButton;
	}
	
}
