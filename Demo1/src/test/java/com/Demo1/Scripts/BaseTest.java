package com.Demo1.Scripts;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseTest {
	public static Properties prop=null;
	WebDriver driver;
	 public static void testbase() {
	try {
		prop=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources"+"\\Config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}
}
  
  @AfterMethod
  public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException {
		if(iTestResult.getStatus()==iTestResult.FAILURE){
			takeScreenShotOnFailure(iTestResult.getName());
		}
	  }

	  private String takeScreenShotOnFailure(String name) throws IOException {
	String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir") + "\\target" + name +dateName +".png";
	File finalDestination=new File(destination);
	FileUtils.copyFile(source, finalDestination);
	return destination;

		
	}

  @BeforeTest
  public void beforeTest() {
	  //WebDriver driver;
		testbase();
		System.setProperty("webdriver.chrome.driver","E:\\selenium\\drivers\\chromedriver_win32new\\chromedriver.exe");
		  driver=new ChromeDriver();
		  String baseurl=prop.getProperty("baseurl");
			driver.get(baseurl);
  }
  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
