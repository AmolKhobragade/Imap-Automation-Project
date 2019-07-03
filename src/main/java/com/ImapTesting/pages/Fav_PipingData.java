package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_PipingData extends Baseclass 
{


	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='pipingData.LoadSelectedItemData(null)']")
	public WebElement FavPipingData_Btn_AddPipingData;

	
	
	public Fav_PipingData()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_AddPipingDataButton()
	{
		boolean AddPipingDataButton = FavPipingData_Btn_AddPipingData.isDisplayed();
		Reporter.log("The Add Piping Data button is displayed"+ AddPipingDataButton);
		return AddPipingDataButton;
	}
	
	
}
