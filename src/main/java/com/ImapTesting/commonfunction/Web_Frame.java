package com.ImapTesting.commonfunction;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ImapTesting.baseclass.Baseclass;

public class Web_Frame extends Baseclass
{

	private WebDriver driver;
	private Logger logger;
	
	public Web_Frame() {
		this.driver = driver;
		this.logger = logger;
	}
	
	//Below is the code snippet to work with switchToFrame using frame id.
	public static void switchToFrame(WebDriver driver, int frameNum, Logger logger) {
		try {
			driver.switchTo().frame(frameNum);
			logger.info("Navigated to frame with id " + frameNum);
		} catch (NoSuchFrameException e) {
			logger.info("Unable to locate frame with id " + frameNum
					+ e.getStackTrace());
		} catch (Exception e) {
			logger.info("Unable to navigate to frame with id " + frameNum
					+ e.getStackTrace());
		}
	}
	
	//Below is the code snippet to work with switchToFrame using frame Name.
	public static void switchToFrame(WebDriver driver, String frame, Logger logger) {
		try {
			driver.switchTo().frame(frame);
			logger.info("Navigated to frame with name " + frame);
		} catch (NoSuchFrameException e) {
			logger.info("Unable to locate frame with id " + frame
					+ e.getStackTrace());
		} catch (Exception e) {
			logger.info("Unable to navigate to frame with id " + frame
					+ e.getStackTrace());
		}
	}
	
	//Below is the code snippet to work with switchToFrame using frame WebElement.
	public static void switchToFrame(WebElement frameElement, WebDriver driver, Logger logger) {
		try {
			if (WebElement_Common.isElementPresent(driver,frameElement)) {
				
				driver.switchTo().frame(frameElement);
				logger.info("Navigated to frame with element "+ frameElement);
			} else {
				logger.info("Unable to navigate to frame with element "+ frameElement);
			}
		} catch (NoSuchFrameException e) {
			logger.info("Unable to locate frame with element " + frameElement + e.getStackTrace());
		} catch (StaleElementReferenceException e) {
			logger.info("Element with " + frameElement + "is not attached to the page document" + e.getStackTrace());
		} catch (Exception e) {
			logger.info("Unable to navigate to frame with element " + frameElement + e.getStackTrace());
		}
	}
	
	//Below is the code snippet to work with multiple frames.
	public static void switchToFrame(WebDriver driver, String ParentFrame, String ChildFrame, Logger logger) {
		try {
			driver.switchTo().frame(ParentFrame).switchTo().frame(ChildFrame);
			logger.info("Navigated to innerframe with id " + ChildFrame
					+ "which is present on frame with id" + ParentFrame);
		} catch (NoSuchFrameException e) {
			logger.info("Unable to locate frame with id " + ParentFrame
					+ " or " + ChildFrame + e.getStackTrace());
		} catch (Exception e) {
			logger.info("Unable to navigate to innerframe with id "
					+ ChildFrame + "which is present on frame with id"
					+ ParentFrame + e.getStackTrace());
		}
	}
	
	//Below is the code snippet to switch back to the default content.
	public static void switchtoDefaultFrame(WebDriver driver, Logger logger) {
		try {
			driver.switchTo().defaultContent();
			logger.info("Navigated back to webpage from frame");
		} catch (Exception e) {
			logger.info("unable to navigate back to main webpage from frame"
							+ e.getStackTrace());
		}
	}
	
}
