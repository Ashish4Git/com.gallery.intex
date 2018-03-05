package com.gallery.intex.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Photos {
	
	AppiumDriver<WebElement> driver; // driver instance variable 

	@AndroidFindBy(id=("//com.mimedia.intexgallery:id/action_bar_sidebar_title"))
	private WebElement photosButton;
	
	
	public Photos(AppiumDriver<WebElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);

		}
	
	


}
