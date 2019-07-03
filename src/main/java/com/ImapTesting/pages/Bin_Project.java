package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Bin_Project extends Baseclass
{
	@FindBy(xpath="//div[contains(text(),'Deleted Date')]")
	public WebElement BinProject_DeletedDateLabel;
	
	
	
	
	
	
	
	
	public Bin_Project()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String ValidateBinProject_DeletedDateLabel()
	{
		String LabelBinProject_DeletedDate=BinProject_DeletedDateLabel.getText();
		Reporter.log(LabelBinProject_DeletedDate,true);
		return LabelBinProject_DeletedDate;
	}

}
