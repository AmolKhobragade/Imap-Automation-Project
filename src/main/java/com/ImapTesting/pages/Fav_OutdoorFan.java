package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_OutdoorFan extends Baseclass 
{
	
	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='outdoorFanFav.CreateOutdoorFanFav(null)']")
	public WebElement FavOutdoorFan_Btn_AddOutdoorFanData;
	

	public Fav_OutdoorFan()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_AddOutdoorFan()
	{
		boolean AddOutdoorFanButton = FavOutdoorFan_Btn_AddOutdoorFanData.isDisplayed();
		Reporter.log("The Add Outdoor Coil MC button is displayed"+ AddOutdoorFanButton);
		return AddOutdoorFanButton;
	}
	
}
