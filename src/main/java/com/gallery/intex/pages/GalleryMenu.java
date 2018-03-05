package com.gallery.intex.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GalleryMenu {

	AppiumDriver<WebElement> driver; // driver instance variable 

	@AndroidFindBy(xpath=("//android.widget.TextView[@text='photos']"))
	private WebElement photosButton;

	@AndroidFindBy(xpath=("//android.widget.TextView[@text='videos']"))
	private WebElement videosButton;

	@AndroidFindBy(xpath=("//android.widget.TextView[@text='favorites']"))
	private WebElement favoritesButton;

	@AndroidFindBy(xpath=("//android.widget.TextView[@text='folders']"))
	private WebElement folderButton;

	@AndroidFindBy(xpath=("//android.widget.TextView[@text='settings']"))
	private WebElement settingsButton;


	//Constructor

	public GalleryMenu(AppiumDriver<WebElement> driver){
		this.driver=driver; 
		 //This initElements method will create all WebElements
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
	}

		

		public void clickOnPhotosButton(){
			photosButton.click();
		}

		public void clickOnVideosButton(){
			videosButton.click();
		}

		public void clickOnFavoritiesButton(){
			favoritesButton.click();
		}

		public void clickOnFoldersButton(){
			folderButton.click();
		}

		public void clickOnSettingsButton(){
			settingsButton.click();
		}
	}
