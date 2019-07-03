package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_FinData extends Baseclass 
{

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='finData.LoadSelectedItemData(null)']")
	public WebElement FavFindData_Btn_AddFinData;
	
	
	public Fav_FinData()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_AddFinDataButton()
	{
		boolean BtnAddFinDataButton = FavFindData_Btn_AddFinData.isDisplayed();
		Reporter.log("The Add RTPF Tube Data Button is displayed"+ FavFindData_Btn_AddFinData);
		return BtnAddFinDataButton;
	}
	
}
