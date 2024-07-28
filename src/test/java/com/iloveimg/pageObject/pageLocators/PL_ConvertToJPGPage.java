package com.iloveimg.pageObject.pageLocators;

public class PL_ConvertToJPGPage {

	public static final String addressButtonPickFiles = "(//a[@id='pickfiles'])[1]";
	
	public static final String addressUploadedFile  = "//div[@class='file file--img file--convertimage file--tojpg tooltip--top tooltip']";
	public static final String addressUploadedFilePercentage  = "(//div[@class='uploading__status__percent__value'])[1]";
	public static final String addressButtonConvertToJPG = "(//button[@id='processTask'])[1]";
	public static final String addressButtonDownloadConvertedImage = "(//a[normalize-space()='Download converted images'])[1]";
}

