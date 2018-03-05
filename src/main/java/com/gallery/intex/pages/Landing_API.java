package com.gallery.intex.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Landing_API {

	AppiumDriver<WebElement> driver; // driver instance variable 
	//public static Properties prop = new Properties();
	
	
	//Object initialization

	//@AndroidFindBy(xpath=("//android.widget.TextView[@text='gallery']"))
	@AndroidFindBy(xpath = ("prop.getProperty(App_xpath"))
	public WebElement App;

	
	

	//Constructor : Page initialization (Initialize objects in the page)
	public Landing_API(AppiumDriver<WebElement> driver){
		this.driver=driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
		

	}

	public void clickOnAppButton(){
		App.click();
		//PageFactory.initElements(new AppiumFieldDecorator(driver) , GalleryMenu.class);
		//return new GalleryMenu(driver);
	}
	
	




}
