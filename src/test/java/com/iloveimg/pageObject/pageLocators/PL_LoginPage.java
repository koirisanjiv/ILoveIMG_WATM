package com.iloveimg.pageObject.pageLocators;

public class PL_LoginPage {

	public static final String addressButtonLogin = "(//a[normalize-space()='Login'])[1]";
	public static final String addressFieldEmail= "(//input[@id='loginEmail'])[1]";
	public static final String addressFieldPassword = "(//input[@id='inputPasswordAuth'])[1]";
	public static final String addressButtonFinalLogin = "(//button[normalize-space()='Log in'])[1]";
	
	public static final String addressWebsiteLogo = "(//img[@alt='iLoveIMG'])[1]";
}

