package com.ImapTesting.commonfunction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ImapTesting.baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Web_DropDown extends Baseclass 
{

	private static Select oselect;
	private static boolean status = false;
	private static ExtentTest logger;
	/**
	 * Checks if drop down is visible.
	 *
	 * @param WebDriver
	 *            the driver
	 * @param By
	 *            the by
	 * @return true, if drop down is visible, else false
	 * 
	 * @throws NoSuchElementException
	 * 
	 */
	public static boolean isDropDownVisible(WebDriver driver, By by) {
		WebDriverWait zeroWait = new WebDriverWait(driver, 10);
		ExpectedCondition<org.openqa.selenium.WebElement> c = ExpectedConditions.presenceOfElementLocated(by);
		try {
			zeroWait.until(c);
			// logger.debug("Create New Application button is visible");
			return true;
		} catch (TimeoutException e) {
			// logger.debug("Create New Application button is not visible");
			return false;
		}
	}

	/**
	 * Select element by visible text.
	 *
	 * @param element
	 *            the WebElement reference of DropDown
	 * @param textValue
	 *            the String value to be selected from DropDown
	 * @return returns true if value is selected, false otherwise
	 * 
	 * @throws NoSuchElementException
	 * 
	 * @see {@link Selector}
	 * 
	 * 
	 */
	public static Boolean SelectElementByVisibleText(WebElement element, String textValue) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				oselect = new Select(element);
				oselect.selectByVisibleText(textValue);
				status = true;
				return status;
			} else {
				status = false;
				return status;
			}
		} catch (NoSuchElementException nse) {

			System.out.println("Element not found : " + nse.getMessage());
			return false;
		}

	}

	/**
	 * Select element by value tag in HTML.
	 *
	 * @param element
	 *            the WebElement reference of DropDown
	 * @param textValue
	 *            the String value to be selected from DropDown
	 * @return returns true if value is selected, false otherwise
	 * 
	 * @throws NoSuchElementException
	 * 
	 * @see {@link Selector}
	 */
	public static Boolean SelectElementByValue(WebElement element, String textValue) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				oselect = new Select(element);
				oselect.selectByValue(textValue);
				status = true;
				return status;
			} else {
				status = false;
				return status;
			}
		} catch (NoSuchElementException nse) {

			System.out.println("Element not found : " + nse.getMessage());
			return false;
		}

	}

	/**
	 * Select element by Index of dropdown value.
	 *
	 * @param element
	 *            the WebElement reference of DropDown
	 * @param textIndex
	 *            the {@link Integer} index to be selected from DropDown
	 * @return returns true if value is selected, false otherwise
	 * 
	 * @throws NoSuchElementException
	 * 
	 * @see {@link Selector}
	 */
	public static Boolean SelectElementByIndex(WebElement element, int textIndex) {

		try {
			if (element.isDisplayed() && element.isEnabled()) {
				oselect = new Select(element);
				oselect.selectByIndex(textIndex);
				status = true;
				return status;
			} else {
				status = false;
				return status;
			}
		} catch (NoSuchElementException nse) {

			System.out.println("Element not found : " + nse.getMessage());
			return false;
		}

	}
	
	/*
	 *  String[] exp = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
   WebElement dropdown = driver.findElement(By.xpath("//select[@id='ddladult1']"));    Select select = new Select(dropdown); 
                    java.util.List<WebElement> options = select.getOptions(); 
                     for(WebElement item:options) 
                     {  
                      for (int i=0; i<exp.length; i++){
                          if (item.getText().equals(exp[i])){
                          System.out.println("Matched");
                          }
                        }
                      }  
	 */
	
	
	
	/* The Below method are created by Amol for references */
	
	public static List<String>GetAllDropDownListValue(WebElement Element)
	{
		Select select = new Select(Element);
		List<WebElement>ElementList=select.getOptions();
		List<String>ValueList=new LinkedList<String>();
		for(WebElement Ele:ElementList)
		{
			Log.info(Ele.getText());
			ValueList.add(Ele.getText());
		}
		
		return ValueList;
	}
	
	
	
	
	
	public static List<WebElement> getElementsByTagName(WebElement element,String optionName)
    {
       List<WebElement> listOfElements = element.findElements(By.tagName(optionName));
       if(listOfElements.size()!=0)
          return listOfElements;
       else
    	   return null;
    }
	

	public static boolean verify_Values_In_Dropdown(List<WebElement> listOfElements, String[] strValues)
	{
		boolean bValue=false;
		List<String> list = new ArrayList<String>();
		for (String strValue : strValues) {
			boolean bflag = false;
			for (WebElement element : listOfElements) {
				String elementValue = element.getText();
				if (strValue.equals(elementValue)) {
					bflag= true;
				}
			}
			if (!bflag)
				list.add(strValue);
		}
		if (list.size() > 0) {
			for(String strList : list) {
				System.out.println("Value not present in dropdown: "+strList);
			}
			//Assign false if any of the value not found in dropdown
			bValue = false;
		} else {
			//Assign true if all values found in dropdown
			System.out.println("All value(s) found in dropdown");
			bValue=true;
		}
		return bValue;
	}
	
	/*
	 * This method is creating to print all drop down option
	 */
	
	public static void Verifyalldropdownvalue(WebDriver driver,WebElement element)
	{
		try
		{
		Select select = new Select(element);
		List<WebElement> list=select.getOptions();
		for(WebElement ele:list)
		{
			Reporter.log("Drop down values are : " + ele.getText(),true);
		}
		}
		catch(Exception e)
		{
			logger.log(Status.ERROR, " Failed! -- " + e.getMessage().substring(0, 90));

		}
	}
	
	
	
}
