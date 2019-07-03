package com.ImapTesting.commonfunction;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ImapTesting.baseclass.Baseclass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Web_Checkbox  extends Baseclass
{
   
	private WebDriver driver;
	private WebElement element;
	
	public Web_Checkbox() {
		this.driver = driver;
		this.element = element;
	}
	
	public Web_Checkbox(int a) {
		this.driver = driver;
		this.element = element;
	}
	
	//Select Checkbox for webelement.
	public static void Select_The_Checkbox(WebElement element, ExtentTest logger) {
		try {
            if (element.isSelected()) {
            	logger.log(Status.INFO, "Checkbox: " + element + "is already selected");
               //logger.info("Checkbox: " + element + "is already selected");
            } else {
            	// Select the checkbox
            	logger.log(Status.INFO, "Successfully checked the checkbox");
                element.click();
            }
        } catch (Exception e) {
        	//logger.info("Unable to select the checkbox: " + element);
        	logger.log(Status.ERROR, "Unable to select the checkbox: " + element);
        }
		
	}
	
	//Deselect Checkbox for webelement
	public static void DeSelect_The_Checkbox(WebElement element, ExtentTest logger) {
		try {
            if (element.isSelected()) {
                element.click();
                logger.log(Status.INFO, "Checkbox: " + element + " is deselected successfully");
            } else {
            	logger.log(Status.INFO,"Checkbox: "+element+" is already deselected");
            }
        } catch (Exception e) {
        	logger.log(Status.ERROR, "Unable to deselect the checkbox: " + element);
        }
    }	
	
	//Method is used to select the CheckBox with the specified value from multiple CheckBoxes.
	public static void Select_The_CheckBox_from_List(WebElement element, String valueToSelect, Logger logger) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			   System.out.println("Option value "+option.getText());
			        if (valueToSelect.equals(option.getText())) {
			            option.click();
			            logger.info("CheckBox selected from multiple CheckBoxes");
			            break;
			        }
			    }
	}
}
