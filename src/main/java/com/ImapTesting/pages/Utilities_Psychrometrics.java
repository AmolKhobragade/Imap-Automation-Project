package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Utilities_Psychrometrics extends Baseclass
{

	@FindBy(xpath="//div[@id='utilityContainerDiv']//label[contains(text(),'Psychrometrics Properties Calculator')]")
	public WebElement PsychrometricsPropertiesCalculator_Label;
	
	
	public Utilities_Psychrometrics()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String Validate_Psychrometrics_Label()
	{
		String PsychrometricsCallbl= PsychrometricsPropertiesCalculator_Label.getText();
		Reporter.log(PsychrometricsCallbl,true);
		return PsychrometricsCallbl;
	}
}
