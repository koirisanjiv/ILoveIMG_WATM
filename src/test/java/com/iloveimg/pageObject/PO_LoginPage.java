package com.iloveimg.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.iloveimg.ReUseAble.PageObject.ReUseAbleElement;
import com.iloveimg.pageObject.pageLocators.PL_LoginPage;
import com.iloveimg.utilities.ClickOnAnyButton;
import com.iloveimg.utilities.NavigateToNewOpenTab;
import com.iloveimg.utilities.SetDataIntoTextInputField;

public class PO_LoginPage extends ReUseAbleElement {
	
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();
	
	public SetDataIntoTextInputField setDataIntoTextInputField = new SetDataIntoTextInputField();
	public NavigateToNewOpenTab navigateToNewTab = new NavigateToNewOpenTab();
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();
	
	
	
	public  PO_LoginPage(WebDriver driver)
	{   super(driver);
	    this.driver = driver;
	    jsExecutor  = (JavascriptExecutor)driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait (driver, Duration.ofSeconds(30));
		action = new Actions(driver);
	}
	

		
	//FOR USER LOGIN
	public PO_HomePage Login(String userEmail,String userPassword) throws InterruptedException {
		try {
			logger.info("Method called Login");
			
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Login", PL_LoginPage.addressButtonLogin);
			setDataIntoTextInputField.callMeToFillDataIntoTextInputFieldWithNameAndXpathAndValue(driver, "Email", PL_LoginPage.addressFieldEmail, userEmail);
			setDataIntoTextInputField.callMeToFillDataIntoTextInputFieldWithNameAndXpathAndValue(driver, "Password", PL_LoginPage.addressFieldPassword, userPassword);
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Login", PL_LoginPage.addressButtonFinalLogin);
			
			try {
				WebElement websiteLogo = driver.findElement(By.xpath(PL_LoginPage.addressWebsiteLogo));
				wait.until(ExpectedConditions.elementToBeClickable(websiteLogo));
				Thread.sleep(500);
				if(websiteLogo.isDisplayed()) {
					softAssert.assertTrue(true);
					logger.info("...LOGIN DONE...");
				} else {
					softAssert.assertTrue(false);
					logger.info("!!!LOGIN FAILED!!!");
				}
			}catch(Exception e) {
				logger.info("Login exception message: "+e.getMessage());
			}
		}catch(Exception e) {}
		
		softAssert.assertAll();
		return new PO_HomePage(driver);
	}
	
}
