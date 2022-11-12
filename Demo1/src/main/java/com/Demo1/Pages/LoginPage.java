package com.Demo1.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginPage {
WebDriver driver;
	
	
	
	@FindBy(xpath="//input[@name='userName']") 
	WebElement email;
    @FindBy(xpath="//input[@name='password']")
	WebElement password;
	@FindBy(xpath="//input[@name='submit']")
	WebElement signin;
	
	@FindBy(xpath="//h3['Login Succesfully']")
	WebElement successMessage;
	@FindBy(xpath="//span['Enter your userName and password correct']")
	WebElement message;

	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	
	public void setEmail(String email1)
	{
		email.sendKeys(email1);
	}
	
	public void setPassword(String password1)
	{
		password.sendKeys(password1);
	}
	public void clickSignin()
	{
		signin.click();
	}





	public String getMessage() {
		// TODO Auto-generated method stub
		return message.getText();
	}
	public String successMessage()
	{
		return successMessage.getText();
	}
}
