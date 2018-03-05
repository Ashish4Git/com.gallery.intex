package com.gallery.intex.testbase;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class AppiumRunner {
	
	//public class AppiumStartAndStop {
	 Process p;
	 // Set path of your node.exe file.
	 // Progra~1 represents Program Files folder.
	 String nodePath = "C:/Program Files(x86)/Appium/node.exe";
	 // Set path of your appium.js file.
	 String appiumJSPath = "C:/Program Files(x86)/Appium/node_modules/appium/bin/appium.js";
	 String cmd = nodePath + " " + appiumJSPath;
	 private static AndroidDriver<MobileElement> driver; 

	 // This method Is responsible for starting appium server.
	 public void appiumStart() throws IOException, InterruptedException {
	  // Execute command string to start appium server.
	  p = Runtime.getRuntime().exec(cmd);
	  // Provide wait time of 10 mins to start appium server properly.
	  // If face any error(Could not start a new session...) then Increase
	  // this time to 15 or 20 mins.
	  Thread.sleep(10000);
	  if (p != null) {
	   System.out.println("Appium server Is started now.");
	  }
	 }

	 // This method Is responsible for stopping appium server.
	 public void appiumStop() throws IOException {
	  if (p != null) {
	   p.destroy();
	  }
	  System.out.println("Appium server Is stopped now.");
	 }

	 @BeforeTest
	 public void setUp() throws Exception {
	  // Stop appium server If It Is already running.
	  appiumStop();
	  // Start appium server.
	  appiumStart();
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("deviceName", "MicromaxQ4260");
	  //capabilities.setCapability("browserName", "Android");
	  capabilities.setCapability("platformVersion", "6.0");
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability("appPackage", "com.mimedia.intexgallery");
	  capabilities.setCapability("appActivity", "com.mimedia.StartupActivity");
	  driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 }

	 @Test
	 public void test() {
	  System.out.println("Test OK.");
	 }

	 @AfterTest
	 public void End() throws IOException {
	  driver.quit();
	  // Stop appium server when test Is ended.
	  appiumStop();
	 }
	}

