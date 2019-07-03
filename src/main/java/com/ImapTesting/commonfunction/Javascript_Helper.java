package com.ImapTesting.commonfunction;

import org.openqa.selenium.JavascriptExecutor;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ImapTesting.baseclass.Baseclass;

public class Javascript_Helper extends Baseclass 

{

	private static WebDriver driver;
	
	public Javascript_Helper(WebDriver driver)
	{
		Javascript_Helper.driver=driver;
		Javascript_Helper.driver.hashCode();
	}
	
	public Object executescript(String script)
	{
		JavascriptExecutor exe= (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public static Object executescript(String script, Object...args)
	{
		JavascriptExecutor exe= (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	public static void ScrollToElement(WebElement element)
	{
		executescript("window.scrollTo(argument[0],argument[1])",element.getLocation().x,element.getLocation().y);
		
	}
	
	public void scrolltoelementandclick(WebElement element)
	{
		ScrollToElement(element);
		element.click();
		
	}
	
	public void scrollIntoView(WebElement element)
	{
		executescript("arguments[0].scrollIntoView()",element);
		
	}
	
	public void scrollIntoViewandClick(WebElement element)
	{
		scrollIntoView(element);
		element.click();
	}
	public void scrollDownVertically()
	{
		executescript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void scrollUpVertically()
	{
		executescript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	public void scrollDownBypixel()
	{
		executescript("window.scrollBy(0,1500)");
	}
	
	public void scrollUpBypixel()
	{
		executescript("window.scrollBy(0,-1500)");
	}
	
	public void ZoomInByPercent()
	{
		executescript("document.body.style.zoom='40%'");
	}
	
	public void ZoomInBy100Percent()
	{
		executescript("document.body.style.zoom='100%'");
	}
	
	
	
	
}
