package com.ideator.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaurabhExample {
	WebDriver driver;

	@FindBy(css = ".user__image-small>img")
	WebElement avtar;

	public SaurabhExample(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickAdmin() {
		avtar.click();
		List<WebElement> elementList = driver
				.findElements(By.cssSelector(".user-nav__link"));
		for (WebElement element : elementList) {
			if ((element.getText()).equals("Admin")) {
				element.click();
			}
		}
	}
}
