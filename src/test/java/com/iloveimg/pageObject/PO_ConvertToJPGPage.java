package com.iloveimg.pageObject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.iloveimg.ReUseAble.PageObject.ReUseAbleElement;
import com.iloveimg.pageObject.pageLocators.PL_ConvertToJPGPage;
import com.iloveimg.projectUtility.UploadFileWithAutoIT;
import com.iloveimg.utilities.CheckElementIsEnabled;
import com.iloveimg.utilities.ClickOnAnyButton;
import com.iloveimg.utilities.NavigateToNewOpenTab;
import com.iloveimg.utilities.SetDataIntoTextInputField;

public class PO_ConvertToJPGPage extends ReUseAbleElement {

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
	public CheckElementIsEnabled checkElementEnableState = new CheckElementIsEnabled();
	public UploadFileWithAutoIT fileUpload = new UploadFileWithAutoIT();

	// HOMEPAGE CONSTRUCTOR CREATION
	public PO_ConvertToJPGPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		jsExecutor = (JavascriptExecutor) driver;
		ruae = new ReUseAbleElement(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		lp = new PO_LoginPage(driver);
		action = new Actions(driver);

	}

	// file upload confirmation
	@FindBy()
	@CacheLookup
	WebElement fileUploaded;

	public boolean isFileUploaded() {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PL_ConvertToJPGPage.addressUploadedFilePercentage)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// TO CONVERT TO JPG
	public PO_ConvertToJPGPage convertToJPG(String uploadFileAddress, String uploadFileName) throws InterruptedException {
		// USE THIS ONLY FOR BACK TO BACK ENTRY
		String[] keyLabels = { "Select image" };
		String[] keyLabelsAddresses = { PL_ConvertToJPGPage.addressButtonPickFiles };
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, keyLabels, keyLabelsAddresses);
		
		Thread.sleep(3000);
		UploadFileWithAutoIT.uploadFileWithAutoIT("autoITApplication.exe",uploadFileAddress,uploadFileName);

		if (isFileUploaded()) {
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Convert to JPG",
					PL_ConvertToJPGPage.addressButtonConvertToJPG);
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath(PL_ConvertToJPGPage.addressButtonDownloadConvertedImage)));
			clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Downlaod Image",
					PL_ConvertToJPGPage.addressButtonDownloadConvertedImage);

		} else {
			logger.warn("File not uploaded");
		}

		softAssert.assertAll();
		return new PO_ConvertToJPGPage(driver);
	}
}
