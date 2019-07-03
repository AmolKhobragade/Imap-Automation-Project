package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_OutdoorCoilRTPF extends Baseclass 
{
	
	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='outdoorCoilFav.LoadSelectedOutdoorCoilData(null)']")
	public WebElement FavOutdoorCoilRtpf_Btn_AddOutdoorCoilData;
	

	public Fav_OutdoorCoilRTPF()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_AddOutdoorCoilRTPFButton()
	{
		boolean AddOutdoorCoilRTPFButton = FavOutdoorCoilRtpf_Btn_AddOutdoorCoilData.isDisplayed();
		Reporter.log("The Add Outdoor Coil RTPF button is displayed"+ AddOutdoorCoilRTPFButton);
		return AddOutdoorCoilRTPFButton;
	}
	
}
