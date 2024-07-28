package com.iloveimg.testCases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.iloveimg.ReUseAble.PageObject.ReUseAbleElement;
import com.iloveimg.pageObject.PO_HomePage;
import com.iloveimg.pageObject.PO_ConvertToJPGPage;
import com.iloveimg.pageObject.PO_LoginPage;
import com.iloveimg.pageObject.pageLocators.PL_HomePage;
import com.iloveimg.utilities.ClickOnAnyButton;

public class TC_ConvertToJPG extends BaseClass {
	// HOME PAGE CONSTRUCTOR
	public TC_ConvertToJPG() {
		super();
	}

	// CONSTRUCTOR DECLARATION
	public PO_LoginPage lp; // lp = LOGIN PAGE
	public PO_HomePage hp; // hp = HOME PAGE
	public Faker faker = new Faker();
	public PO_ConvertToJPGPage po_convertToJpg; // MAIN USER LABLES PAGE
	public ClickOnAnyButton clickOnAnyButton = new ClickOnAnyButton();

	//VARIABLES
	String uploadFileAddress = "C:\\Users\\koiri\\Downloads\\LeonardoAI";
    String uploadFileName = "मेरे घर राम आये हैं";

	// TO DELETE EMAILS
	@Test(priority = 1)
	public void test_ConvertImageToJPG() throws Throwable {
		po_convertToJpg = callMeBeforePerformAnyAction();
		po_convertToJpg.convertToJPG(uploadFileAddress,uploadFileName);
	}

	// CALL ME IN EVERY @TEST METHODS EXCEPT LOGIN AND LOGOUT
	public PO_ConvertToJPGPage callMeBeforePerformAnyAction() throws InterruptedException {
		// TO ACCESS ANY ELEMENT IT CHECK IT IS COME BACK ON THE HOME PAGE FIRST
		hp = new PO_HomePage(driver);
		clickOnAnyButton.callMeToClickOnAnyButtonWithNameAndXpath(driver, "Convert to JPG", PL_HomePage.addressToolsItemConvertToJPG);
		Thread.sleep(4000);
		return new PO_ConvertToJPGPage(driver);
	}

}
