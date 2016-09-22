package com.ideator;


	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
	public class UrlHit {
	WebDriver driver;
	private String baseUrl;
	public UrlHit(WebDriver driver) {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
		 }
		public void detailDriver() {
			// TODO Auto-generated method stub
			driver = new FirefoxDriver();
		     baseUrl = "http://acceptance.ideator.com/";
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		 driver.get(baseUrl + "/sign_in");
		}
	}

