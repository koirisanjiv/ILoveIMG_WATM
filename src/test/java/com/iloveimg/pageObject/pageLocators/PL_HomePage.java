package com.iloveimg.pageObject.pageLocators;

public class PL_HomePage {

	
	public static final String addressUserLogo = "(//a[@title='User area access'])[1]";
	public static final String addressButtonLogout = "(//a[normalize-space()='Log Out'])[1]";
	

	//TOOLS ITEMS
	public static final String addressNavigationConvertToJPG = "(//a[normalize-space()='Convert to JPG'])[1]";
	public static final String addressNavigationCompressImage = "(//a[normalize-space()='Compress IMAGE'])[1]";
	public static final String addressNavigationResizeImage = "(//a[normalize-space()='Resize IMAGE'])[1]";
	public static final String addressNavigationCropImage = "(//a[normalize-space()='Crop IMAGE'])[1]";
	public static final String addressNavigationPhotoEditor = "(//a[normalize-space()='Photo editor'])[1]";
	public static final String addressNavigationMoreTools = "(//span[normalize-space()='More tools'])[1]";
	
	
	//TOOLS ITEMS
	public static final String addressToolsItemConvertToJPG = "//div[@class='tools__item']//h3[text()='Convert to JPG']";
	public static final String addressToolsItemCompressImage = "//div[@class='tools__item']//h3[text()='Compress IMAGE']";
	public static final String addressToolsItemResizeImage = "//div[@class='tools__item']//h3[text()='Resize IMAGE']";
	public static final String addressToolsItemCropImage = "//div[@class='tools__item']//h3[text()='Crop IMAGE']";
	public static final String addressToolsItemPhotoEditor = "//div[@class='tools__item']//h3[text()='PhotoEditor IMAGE']";
	
}
