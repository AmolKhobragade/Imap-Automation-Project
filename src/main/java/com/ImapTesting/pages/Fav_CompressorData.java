package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Fav_CompressorData extends Baseclass 
{

	@FindBy(xpath="//div[@class='main-content']//button[@ng-click='compressorFav.LoadCompressorData(null)']")
	public WebElement FavCompressorData_Btn_AddCompressorData;
	
	
	public Fav_CompressorData()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean Validate_AddCompressorDataBtn()
	{
		boolean BtnAddCompressor = FavCompressorData_Btn_AddCompressorData.isDisplayed();
		Reporter.log("The Add Compressor Button is displayed"+BtnAddCompressor);
		return BtnAddCompressor;
	}
	
}
