package com.ideator.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ideator.common.IdeatorPage;


public class LoginPage {

	WebDriver driver;

	@FindBy(id = "user-email")
	WebElement userEmail;

	@FindBy(id = "user-password")
	WebElement userPass;

	@FindBy(xpath = ".//input[@type='submit']")
	WebElement submitButton;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void submitCredential() {
		userEmail.sendKeys("gauravo@cybage.com");
		userPass.sendKeys("cybage@123");
		submitButton.click();
		
	
	}

}