package com.gallery.intex.testcases;

import java.io.IOException;

import io.appium.java_client.AppiumDriver;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.gallery.intex.pages.GalleryMenu;
import com.gallery.intex.pages.HomePage;
//import com.gallery.intex.pages.Landing_API;
import com.gallery.intex.testbase.TestBase;
//import org.openqa.selenium.support.PageFactory;

public class EnterTheGallery extends TestBase{
	
	AppiumDriver<WebElement> driver; // driver instance variable 
	HomePage homepage;
	GalleryMenu gallerymenu;
	
public EnterTheGallery() throws IOException {
		super();
       //enterthegallery = new PageObjects();
        //PageFactory.initElements(driver, loginPage);

			}


//AppiumDriver<WebElement> driver;
// HomePage homepage;
 //GalleryMenu gallerymenu;
 //Landing_API landing;
 
 
	
  @Test
  public void menuOptions() {
	 
	  //Object for the page
	  System.out.println("HELLO");
	 homepage = new HomePage(driver);
	  //gallerymenu= new GalleryMenu(driver);
	  //homepage.clickOnGalleryButton();
	  
	 // landing=new Landing_API(driver);//initialized HomePage 
	  
	  // homepage.clickOnCameraButton();
	  homepage.clickOnGalleryButton();
	 // homepage.clickOnCameraButton();
	  //gallerymenu=homepage.clickOnGalleryButton();
	 // gallerymenu.clickOnPhotosButton();
	  //landing.clickOnAppButton();
	  
	 // driver.findElement(By.id ("//com.mimedia.intexgallery:id/action_bar_sidebar_title")).click();
  }
}
