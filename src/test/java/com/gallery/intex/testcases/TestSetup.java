package com.gallery.intex.testcases;

//package serverAutoLaunch;

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import serverAutoLaunch.AppiumServerCmd;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;


public class TestSetup extends AppiumServerCmd {
	
	private static AndroidDriver<MobileElement> driver;  
	
	AppiumServerCmd asc=new AppiumServerCmd();
	
	@BeforeTest
	public void TestSetup()throws IOException,InterruptedException{
		
	asc.startServer();
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName","Micromax Q4260");//Micromax Q4260prop.getProperty("deviceName")
		capabilities.setCapability("platformVersion", "6.0");//"6.0"
		capabilities.setCapability("platformName", "Android");//"Android"
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage","com.mimedia.intexgallery" );//"com.mimedia.intexgallery"
		capabilities.setCapability("appActivity", "com.mimedia.StartupActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		
	}
	
	@AfterTest
	public void EndTest()  throws IOException,InterruptedException{
	driver.quit();
	
	asc.stopServer();
	}
	
	//@Test
	//public void testServer() throws FileNotFoundException
	//{
	//	System.out.println("This is Dummy Test");
	//}
	
}
