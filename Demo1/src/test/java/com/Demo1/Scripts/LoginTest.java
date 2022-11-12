package com.Demo1.Scripts;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Demo1.Constants.Constants;
import com.Demo1.Pages.LoginPage;
import com.Demo1.Utilities.ExcelRead;

public class LoginTest extends BaseTest {
	LoginPage objlogin;
	  @Test(dataProvider="validUserInvalidPass",priority=1)
	  public void verifyLoginwithvalidusernameinvalidpassword (String email1,String password1) 
	  {
		  objlogin=new LoginPage(driver);
		  objlogin.setEmail(email1);
		  objlogin.setPassword(password1);
		  objlogin.clickSignin();
		  Assert.assertEquals(objlogin.getMessage(),"Login Successfull");
		 
		  
		  
	  } 
	  @Test(dataProvider="invalidUservalidPass",priority=2)
	  public void verifyLoginwithinvalidusernamevalidpassword (String email1,String password1) 
	  {
		  objlogin=new LoginPage(driver);
		  objlogin.setEmail(email1);
		  objlogin.setPassword(password1);
		  objlogin.clickSignin();
		  Assert.assertEquals(objlogin.getMessage(),"Login Successfull");
		
		  
		  
		  
	  } 
	  
	  
	  @Test(dataProvider="validUservalidPass",priority=3)
	  public void verifyLoginwithvalidusernamevalidpassword (String email1,String password1) 
	  {
		  objlogin=new LoginPage(driver);
		  objlogin.setEmail(email1);
		  objlogin.setPassword(password1);
		  objlogin.clickSignin();
		  Assert.assertEquals(objlogin.successMessage(),"Login Successfully");
		
		  
		  
	  } 
	  


  @DataProvider
 public Object[][] validUserInvalidPass() throws Exception  
	    {
	    	Object[][] data=ExcelRead.getDataFromExcel(Constants.LOGINCREDENTIALS, "validusernameinvalidpassword");
	    	return data;
	    }
  @DataProvider
  public Object[]validUservalidPass() throws  Exception
  {
	  Object[][] data=ExcelRead.getDataFromExcel(Constants.LOGINCREDENTIALS, "validusernamevalidpassword");
	return data;
	  
  }
  @DataProvider
  public Object[]invalidUservalidPass() throws  Exception
  {
	  Object[][] data=ExcelRead.getDataFromExcel(Constants.LOGINCREDENTIALS, "invalidUservalidPass");
	return data;
	  
  }
  
}
	  
	


