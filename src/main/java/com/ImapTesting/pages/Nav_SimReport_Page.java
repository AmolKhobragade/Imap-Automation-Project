package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Nav_SimReport_Page extends Baseclass
{

	@FindBy(xpath="//div[@class='main-content']//strong[contains(text(),'Simulation Reports')]")
	public WebElement Nav_SimReport_PageLabel;
	
	public Nav_SimReport_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String Validate_NavSimReport_SimReportLabel()
	{
		String SimReportLabel=Nav_SimReport_PageLabel.getText();
		Reporter.log(SimReportLabel,true);
		return SimReportLabel;
	}
}
