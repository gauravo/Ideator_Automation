package com.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ideator.page.LoginPage;

public class AcceptanceTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Runtime.getRuntime().exec(
				"C://Users//gauravo//Desktop//Ideator//AuthencationHandler.exe");
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C://Users//gauravo//Desktop//Ideator//AuthencationHandler.exe");
		driver.get("http://ucsdtest.ideator.com");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	// Login page test case.
	public void ExecuteWithoutLogin() {
	/*	LoginPage loginPage = new LoginPage(driver);
		loginPage.submitCredential();*/

		driver.findElement(By.xpath("//a[contains(text(),'Create new idea')]"))
				.click();
		driver.findElement(By.id("idea_name")).clear();
		driver.findElement(By.id("idea_name")).sendKeys("Selenium Test");
		driver.findElement(By.xpath(".//*[@id='new_idea']/div[3]/div/select"));
		driver.findElement(By.cssSelector("option.ng-binding.ng-scope"))
				.click();
		driver.findElement(By.id("location")).clear();
		WebElement element = driver.findElement(By.id("location"));
		element.sendKeys("Pune");
		driver.findElement(By.xpath("html/body/div[3]/div[1]")).click();
		driver.findElement(By.id("idea_description")).clear();
		driver.findElement(By.id("idea_description")).sendKeys(
				"Selenium Test pitch");
		driver.findElement(By.name("commit")).click();
		WebElement signupsection = driver.findElement(By
				.xpath(".//*[@id='ngdialog2']/div[2]/div[1]/div[2]"));
		if (signupsection.isDisplayed()) {
			System.out.println("Signup is present");
		} else {
			System.out.println("Signup is missing");
		}
		driver.close();
	}

	@Test(priority = 2)
	// Login page test case.
	public void ExecuteWithLogin() {
		WebElement a = driver.findElement(By
				.xpath("//a[contains(text(),'Login')]"));
		a.click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitCredential();
		if (driver.findElement(By.cssSelector(".user-nav__action__icon"))
				.isDisplayed()) {
			System.out.println("Login Pass.");
		} else {
			System.out.println("Login fail. Please enter correct Login");
		}
		driver.close();
	}

	@Test(priority = 3)
	// Idea creation
	public void IdeaCreation() {
		WebElement a = driver.findElement(By
				.xpath("//a[contains(text(),'Login')]"));
		a.click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitCredential();
		WebElement Idea = driver.findElement(By
				.xpath("//a[contains(text(),'Create new idea')]"));
		Idea.click();
		driver.findElement(By.id("idea_name")).clear();
		driver.findElement(By.id("idea_name")).sendKeys("Selenium Test");
		driver.findElement(By.xpath(".//*[@id='new_idea']/div[3]/div/select"));
		driver.findElement(By.cssSelector("option.ng-binding.ng-scope"))
				.click();
		driver.findElement(By.id("location")).clear();
		WebElement element = driver.findElement(By.id("location"));
		element.sendKeys("Pune, Maharashtra, India");
		Select select = new Select(element);
		select.selectByIndex(0);
		driver.findElement(By.id("idea_description")).clear();
		driver.findElement(By.id("idea_description")).sendKeys(
				"Selenium Test pitch");
		driver.findElement(By.name("commit")).click();
		driver.findElement(
				By.xpath(".//*[@id='ngdialog2']/div[2]/div[1]/div[2]/div/div/div"))
				.click();
		driver.findElement(By.xpath("//a[contains(text(),'My Ideas')]"))
				.click();
		WebElement LoadMore = driver.findElement(By
				.xpath("//a[contains(text(),'Load More')]"));
		if (LoadMore.isDisplayed()) {
			LoadMore.click();
		}
		WebElement gaurav = driver.findElement(By
				.xpath("//a[contains(text(),'Selenium Test')]"));
		gaurav.click();
		driver.close();
		System.out.println("Idea creation successfully done");
	}

	@Test(priority = 4)
	// Invite team member
	public void InviteTeamMember() {
		WebElement a = driver.findElement(By
				.xpath("//a[contains(text(),'Login')]"));
		a.click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitCredential();
		WebElement Idea = driver.findElement(By
				.xpath("//a[contains(text(),'Create new idea')]"));
		Idea.click();
		driver.findElement(By.id("idea_name")).clear();
		driver.findElement(By.id("idea_name")).sendKeys("Invite team member");
		driver.findElement(By.xpath(".//*[@id='new_idea']/div[3]/div/select"));
		driver.findElement(By.cssSelector("option.ng-binding.ng-scope"))
				.click();
		driver.findElement(By.id("location")).clear();
		WebElement element = driver.findElement(By.id("location"));
		element.sendKeys("Pune, Maharashtra, India");
		Select select = new Select(element);
		select.selectByIndex(0);
		driver.findElement(By.id("idea_description")).clear();
		driver.findElement(By.id("idea_description")).sendKeys(
				"Selenium Test pitch");
		driver.findElement(By.name("commit")).click();
		/*
		 * driver.findElement(By.id("idea_tagline")).clear();
		 * driver.findElement(
		 * By.id("idea_tagline")).sendKeys("Its my regression");
		 * driver.findElement(By.id("idea_description")).clear();
		 * driver.findElement(By.id("idea_description")).sendKeys("test");
		 * driver.findElement(By.name("commit")).click();
		 */

		driver.findElement(
				By.xpath(".//*[@id='ngdialog2']/div[2]/div[1]/div[2]/div/div/div"))
				.click();
		driver.findElement(By.xpath("//a[contains(text(),'My Ideas')]"))
				.click();
		WebElement gaurav1 = driver.findElement(By
				.xpath("//a[contains(text(),'Invite team member')]"));
		gaurav1.click();
		driver.findElement(By.linkText("Invite new team members")).click();
		driver.findElement(
				By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/div[2]/form/div[1]/div/tags-input/div/div/input"))
				.sendKeys("ochanig@mailinator.com");
		driver.findElement(By.xpath(".//*[@id='invitations_personal_message']"))
				.sendKeys("Test");

		driver.findElement(By.xpath(".//*[@id='invitation_role_investor']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='ngdialog1']/div[2]/div[1]/div[2]/form/div[5]/input"))
				.click();
		driver.findElement(By.cssSelector(".ng-modal-close")).click();
		String oldTab = driver.getWindowHandle();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		driver.get("https://www.mailinator.com/");
		WebElement sendInvite = driver.findElement(By
				.xpath(".//*[@id='inboxfield']"));
		sendInvite.sendKeys("ochanig");
		driver.findElement(By.cssSelector(".btn.btn-dark")).click();
		driver.findElement(By.cssSelector(".btn.btn-dark")).click();
		List<WebElement> mails = driver.findElements(By
				.xpath("//div[2]/div[5]/div"));
		for (WebElement mail : mails) {
			if (mail.getText().contains(
					"You have been invited to join an idea on Ideator")) {
				mail.click();
				driver.close();
				System.out.println("Invite team member is successful.");

			}
		}
	}
}
