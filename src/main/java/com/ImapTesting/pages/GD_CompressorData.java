package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class GD_CompressorData extends Baseclass
{
	
	

	@FindBy(xpath="//div[@class='main-content']//button[@jci-single-click='compressorData.LoadSelectedItemData(null)']")
	public WebElement GDCompressorData_Btn_AddCompressorData;

	public GD_CompressorData()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Validate_AddCompressorDataBtn()
	{
		boolean GDBtnAddCompressor = GDCompressorData_Btn_AddCompressorData.isDisplayed();
		Reporter.log("The Add Compressor Button is displayed"+GDBtnAddCompressor);
		return GDBtnAddCompressor;
	}
	
	
	
	
	
	
}
