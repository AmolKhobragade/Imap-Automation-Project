package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_FilterAPData extends Baseclass 
{

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='filterAPDData.LoadSelectedItemData(null)']")
	public WebElement FavFilterAPData_Btn_AddFilterApData;
	
	
	public Fav_FilterAPData()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_AddFilterAPDataButton()
	{
		boolean BtnAddFilterAPData = FavFilterAPData_Btn_AddFilterApData.isDisplayed();
		Reporter.log("The Add RTPF Tube Data Button is displayed"+ BtnAddFilterAPData);
		return BtnAddFilterAPData;
	}
	
}
