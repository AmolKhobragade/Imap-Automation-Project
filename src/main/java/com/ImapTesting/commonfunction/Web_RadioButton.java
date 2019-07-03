package com.ImapTesting.commonfunction;

import org.openqa.selenium.WebElement;

import com.ImapTesting.baseclass.Baseclass;

public class Web_RadioButton extends Baseclass

{

	private static Boolean isRadioButtonChecked = false;

	/**
	 * <h1> Checks if radio button is checked </h1><br>
	 *
	 * @param element
	 *            {@link WebElement}
	 * @return true if radio button is checked, otherwise false.
	 */
	public static Boolean isRadioButtonChecked(WebElement element)
	
	{
		isRadioButtonChecked = element.isSelected();

		if (isRadioButtonChecked)
		{
			
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	
	/**
	 * <h1>Select radio button based on the web element name </h1>
	 *<br>
	 * @param element {@link WebElement}
	 * @return 
	 * true if radio button is Selected successfully<br>
	 * false otherwise
	 */
	public static Boolean SelectRadioButton(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			return true;
		} else {
			return false;
		}
	}
	
}
