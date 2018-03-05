package com.gallery.intex.testbase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase {

	private static AndroidDriver<MobileElement> driver;  
	//static Properties prop;
	public static Properties prop = new Properties();


	/* @BeforeSuite
  public void createAppiumSession(){


  String osName= System.getProperty("os.name").toLoverCase();

  String nodePath=null;
  String appiumPath=null;

  if(osName.contains("mac")){

  //mac path
  nodePath="/user/local/bn/node";
  appiumPath="/user/local/lib/node_modules/appium/build/lib/main.js";
  }else if(osName.contains("linux")){

  //linux path

  nodePath=System.getenv("HOME") + "/.linuxbrew/bin/node";
  appiumPath=System.getenv("HOME") + "/.linuxbrew/lib/node_modules/appium/buid/lib/main.js";

  }else if(osName.contains("windows")){

  //windows path

  nodePath="C:\\Program Files (x86)\\Appium\\node.exe";
  appiumPath="C:\\Program Files (x86)\\Appium\\node_modules\\appium\\lib\\server\\main.js";

  }

  service=AppiumDriverLocalService.buildService(new AppiumSeviceBuilder()
  .usingDriverExecutable(new File(nodePath))
  .usingPort(4723)
  .withAppiumJS(new File(appiumPath)));

  service.start();
  }

  @AfterSuite

  public void stopAppium(){
  service.stop();
  }
	 */
	public TestBase()throws IOException{
		try{

		FileInputStream ip=new FileInputStream(
	System.getProperty("user.dir")+"\\src\\main\\java\\com\\gallery\\intex\\config\\config.properties");
	prop.load(ip); //FileInputStream(System.getProperty("user.dir")+"\\src\\POM_Config\\config.properties");
	//F:\Eclips-Java\Final Project\com.gallery.intex\\src\\main\\java\\com\\gallery\\intex\\config\\config.properties
	//\\src\\com.gallery.intex.config\\config.properties

		} catch(FileNotFoundException e){

		e.printStackTrace();
		} catch(IOException e){
		e.printStackTrace();
		}
		}
		 
		//prop=new Properties();
	/*	FileInputStream ip=new FileInputStream(
				System.getProperty("F:\\Eclips-Java\\Final Project\\com.gallery.intex\\src\\main\\java\\com\\gallery\\intex\\config\\config.properties"));
		prop.load(ip);
		}
		*/



	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName",prop.getProperty("deviceName"));//Micromax Q4260prop.getProperty("deviceName")
		capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));//"6.0"
		capabilities.setCapability("platformName", prop.getProperty("platformName"));//"Android"
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage",prop.getProperty("appPackage") );//"com.mimedia.intexgallery"
		capabilities.setCapability("appActivity", "com.mimedia.StartupActivity");//"com.mimedia.StartupActivity" com.mimedia.ui.sidebar.SidebarActivity prop.getProperty("appActivity")
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//"http://127.0.0.1:4723/wd/hub" (prop.getProperty("URL")
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(8000);
		//System.getProperty("deviceName")

		

	}
	
       

	@AfterClass
	public void afterClass() {
		driver.quit();

	}
	/*@Test
	public void galleryClick() {
	
	driver.findElement(By.xpath("//android.widget.TextView [contains(@resource-id,'action_bar_sidebar_title') and @text='gallery']")).click();
			//xpath("//android.widget.Button[contains(@resource-id,'digit5') and @text='5']")
	}
	*/

}

