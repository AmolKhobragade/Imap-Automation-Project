package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_MCTubeData extends Baseclass 
{

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='mcTubeData.LoadSelectedTubeData(null)']")
	public WebElement FavMCTubeData_AddMicrochannelTubeData; 
	
	
	public Fav_MCTubeData()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_ADDMCTubeDataButton()
	{
		boolean BtnMCTubeData=FavMCTubeData_AddMicrochannelTubeData.isDisplayed();
		Reporter.log("Page is redirecting to the MC Tube Data of Favorite and Add MC Tube Data Button is displayed"+ BtnMCTubeData);
		return BtnMCTubeData;
		
	}
	
}
