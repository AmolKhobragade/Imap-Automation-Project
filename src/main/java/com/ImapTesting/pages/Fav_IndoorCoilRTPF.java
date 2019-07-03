package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_IndoorCoilRTPF extends Baseclass 
{
	

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='indoorCoilFav.LoadSelectedIndoorCoilData(null)']")
	public WebElement FavIndoorCoilRTPF_Btn_AddIndoorCoilData;
	
	

	public Fav_IndoorCoilRTPF()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_AddIndoorCoilRTPF()
	{
		boolean AddIndoorCoilRTPFButton = FavIndoorCoilRTPF_Btn_AddIndoorCoilData.isDisplayed();
		Reporter.log("The Add Indoor Coil RTPF button is displayed"+ AddIndoorCoilRTPFButton);
		return AddIndoorCoilRTPFButton;
	}
	
}
