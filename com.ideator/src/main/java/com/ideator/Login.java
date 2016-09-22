package com.ideator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
public class Login {
WebDriver driver;
private String baseUrl;
public Login(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	 }	
public void name() {
		
//	driver.findElement(By.id("user-email")).clear();
	driver.findElement(By.id("user-email")).sendKeys("gauravo@cybage.com");
	driver.findElement(By.id("user-password")).clear();
	driver.findElement(By.id("user-password")).sendKeys("cybage@123");
	driver.findElement(By.name("commit")).click();
	
	}


}


