package com.ImapTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;

public class Utilities_RefrigerantProperties extends Baseclass

{

	@FindBy(xpath="//div[@id='utilityContainerDiv']//label[contains(text(),'Refrigerant Properties Calculator')]")
	public WebElement RefrigerantPropertiesCalculator_Label;
	

	public Utilities_RefrigerantProperties()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String  RefrigerantPropertiesLabel()
	{
		String RefrigerantPropertieslbl=RefrigerantPropertiesCalculator_Label.getText();
		Reporter.log(RefrigerantPropertieslbl,true);
		return RefrigerantPropertieslbl;
	}
	
	
	
	
}
