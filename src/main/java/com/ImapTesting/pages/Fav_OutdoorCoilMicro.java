package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_OutdoorCoilMicro extends Baseclass 
{

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='outdoorCoilFavMicro.LoadSelectedOutdoorCoilData(null)']")
	public WebElement FavOutdoorCoilMicro_Btn_AddOutdoorCoilData;
	
	
	
	public Fav_OutdoorCoilMicro()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_AddOutdoorCoilMCButton()
	{
		boolean AddOutdoorCoilMCButton = FavOutdoorCoilMicro_Btn_AddOutdoorCoilData.isDisplayed();
		Reporter.log("The Add Outdoor Coil MC button is displayed"+ AddOutdoorCoilMCButton);
		return AddOutdoorCoilMCButton;
	}
	
	
}
