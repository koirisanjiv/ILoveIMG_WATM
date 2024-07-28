package com.iloveimg.pageObject;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.iloveimg.ReUseAble.PageObject.ReUseAbleElement;
import com.iloveimg.pageObject.pageLocators.PL_HomePage;
import com.iloveimg.pageObject.pageLocators.PL_ConvertToJPGPage;
import com.iloveimg.utilities.ClickOnAnyButton;
import com.iloveimg.utilities.NavigateToNewOpenTab;
import com.iloveimg.utilities.SetDataIntoTextInputField;

public class PO_HomePage extends ReUseAbleElement {

	// CONSTRUCTOR DECLARATION
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(getClass());
	public JavascriptExecutor jsExecutor;
	public ReUseAbleElement ruae;
	public WebDriverWait wait;
	public PO_LoginPage lp;
	public Actions action;
	public SoftAssert softAssert = new SoftAssert();

	public SetDataIntoTextInputField setDataIntoTextInputField = new SetDataIntoTextInputField();
	public NavigateToNewOpenTab navigateToNewTab = new NavigateToNewOpenTab();
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();

	// HOMEPAGE CONSTRUCTOR CREATION
	public PO_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}
	
	//User logo
	@FindBy(xpath = PL_HomePage.addressUserLogo)
	@CacheLookup
	WebElement userLogo;
		
	// =========START========ACTION METHODS FOR HOME PAGE OBJECTS=============//

	// TO LOGOUT
	public PO_LoginPage UserLogout() throws InterruptedException {
		logger.info("Method called: Logout");
		try {
			Thread.sleep(2000);
			action.moveToElement(userLogo).build().perform();
			Thread.sleep(1000);
			WebElement btnLogout = driver.findElement(By.xpath(PL_HomePage.addressButtonLogout));
			action.moveToElement(btnLogout).build().perform();
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Logout",
					
					PL_HomePage.addressButtonLogout);
			Thread.sleep(5000);
			if (driver.getPageSource().contains("Your online photo editor is here and forever free!")) {
				softAssert.assertTrue(true);
				logger.info("... LOGOUT DONE ...");
			} else {
				softAssert.assertTrue(false);
				logger.info("!!! LOGOUT FAILEED !!!");
			}
		} catch (Exception e) {
			logger.info("Logout Exception: " + e.getMessage());
			softAssert.assertTrue(false, "After logout it lookin for [Choose an account] text");
		}
		softAssert.assertAll();
		return new PO_LoginPage(driver);
	}

	// TO CHECK THE MENUS
	public PO_HomePage checkNavigarionTab() throws InterruptedException {

		// USE THIS ONLY FOR BACK TO BACK ENTRY
		String[] tabNames = { "Compress Image", "Resize Image", "Crop Image", "Convert to JPG", "More tools" };
		String[] navigationTabs = { PL_HomePage.addressNavigationCompressImage, PL_HomePage.addressNavigationResizeImage,
				PL_HomePage.addressNavigationCropImage, PL_HomePage.addressNavigationConvertToJPG, PL_HomePage.addressNavigationPhotoEditor, PL_HomePage.addressNavigationMoreTools };
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, tabNames, navigationTabs);

		return new PO_HomePage(driver);
	}
}
