package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_RTPFTubeData extends Baseclass 
{

	
	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='rtpfTubeData.LoadSelectedTubeData(null)']")
	public WebElement FavRTPFTubeData_Btn_AddRtpfTubeData;
	
	public Fav_RTPFTubeData()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_AddRTPFTubeDataButton()
	{
		boolean BtnAddRTPFTubeData = FavRTPFTubeData_Btn_AddRtpfTubeData.isDisplayed();
		Reporter.log("The Add RTPF Tube Data Button is displayed"+ BtnAddRTPFTubeData);
		return BtnAddRTPFTubeData;
	}
	
	
}
