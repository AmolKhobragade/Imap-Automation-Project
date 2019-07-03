package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_ReturnAPData extends Baseclass 
{


	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='returnAPDData.LoadSelectedItemData(null)']")
	public WebElement FavReturnAPData_Btn_AddReturnAPData;

	public Fav_ReturnAPData()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_AddReturnAPDataButton()
	{
		boolean BtnAddReturnAPData = FavReturnAPData_Btn_AddReturnAPData.isDisplayed();
		Reporter.log("The Add RTPF Tube Data Button is displayed"+ BtnAddReturnAPData);
		return BtnAddReturnAPData;
	}
	
	
}
