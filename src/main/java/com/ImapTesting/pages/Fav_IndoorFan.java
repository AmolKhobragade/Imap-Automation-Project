package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_IndoorFan extends Baseclass 

{

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='indoorFanFav.CreateIndoorFanFav(null)']")
	public WebElement FavIndoorFan_Btn_AddIndoorFanData;
	
	
	public Fav_IndoorFan()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_AddIndoorFan()
	{
		boolean AddIndoorFanButton = FavIndoorFan_Btn_AddIndoorFanData.isDisplayed();
		Reporter.log("The Add Outdoor Coil MC button is displayed"+ AddIndoorFanButton);
		return AddIndoorFanButton;
	}
	
	
	
}
