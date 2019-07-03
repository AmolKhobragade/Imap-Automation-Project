package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Bin_Unit extends Baseclass
{
	
	@FindBy(xpath="//div[contains(text(),'Name')]")
	public WebElement Bin_UnitLabel; 
	
	
	public Bin_Unit()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String ValidateBinUnit_NameLabel()
	{
		String LabelBinUnit_Name=Bin_UnitLabel.getText();
		Reporter.log(LabelBinUnit_Name,true);
		return LabelBinUnit_Name;
	}

}
