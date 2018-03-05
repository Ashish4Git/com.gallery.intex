package com.gallery.intex.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HomePage {

	AppiumDriver<WebElement> driver; // driver instance variable 
	//public static Properties prop = new Properties();
	
	
	//Object initialization

	//@AndroidFindBy(xpath=("//android.widget.TextView[@text='gallery']"))
	@AndroidFindBy(xpath = ("prop.getProperty(gallery_id)"))
	private WebElement gallery;

	
	@AndroidFindBy(id=("prop.getProperty(camera_id)"))
	private WebElement camera;

	//com.mimedia.intexgallery:id/action_camera

	//Constructor : Page initialization (Initialize objects in the page)
	public HomePage(AppiumDriver<WebElement> driver){
		this.driver=driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
		

	}

	public void clickOnGalleryButton(){
		gallery.click();
		//PageFactory.initElements(new AppiumFieldDecorator(driver) , GalleryMenu.class);
		//return new GalleryMenu(driver);
	}
	
	public void clickOnCameraButton(){
		camera.click();
		//PageFactory.initElements(new AppiumFieldDecorator(driver) , Camera.class);
	}



}