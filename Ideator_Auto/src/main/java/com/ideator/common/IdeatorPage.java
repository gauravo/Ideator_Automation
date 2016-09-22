package com.ideator.common;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ideator.util.ReflectionUtils;

public abstract class IdeatorPage {
	private WebDriver driver;
	private static final String TEXTBOX = "//input[@name='%s']";

	protected IdeatorPage() {
		super();
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected void setText(WebElement we, String txt) {
		we.clear();
		we.sendKeys(txt);
	}

	protected void setText(By field, String txt) {
		try {
			WebElement element = getDriver().findElement(field);
			element.clear();
			element.sendKeys(txt);
		} catch (NoSuchElementException e) {
			throw new AssertionError("unable to set " + field, e);
		}
	}

	protected void setCheckbox(WebElement we, boolean check) {
		if ((we.isSelected() && !check) || (!we.isSelected() && check)) {
			we.click();
		}
	}

	public String getText(String fieldName) {
		return getDriver().findElement(By.xpath(String.format(TEXTBOX, fieldName))).getAttribute("value");
	}

	public boolean isChecked(WebElement input) {
		return StringUtils.isNotEmpty(input.getAttribute("checked"));
	}
	
    public void selectDropDownText(String fieldname, String value) {
        Select mySelectElm = new Select(getDriver().findElement(
                By.id(fieldname)));
        mySelectElm.selectByVisibleText(value);
    }

    public void acceptAlertIfPresent() {
        try {
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ex) {
            // Alert not present do nothing
        }
    }
    public void setValues(List<List<String>> data, Object obj) {
        for (int count = 0; count < data.size(); count++) {
            String value = data.get(count).get(1);
            String field = data.get(count).get(0);
            ReflectionUtils.sendText(value, obj, field);
        }
    }

    public boolean isElementExist(By locator) {
        try {
            getDriver().findElement(locator);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
    public void dragAndDrop(WebElement sourceElement,
            WebElement destinationElement) {
        try {
            if (sourceElement.isDisplayed() && destinationElement.isDisplayed()) {
                Actions action = new Actions(driver);
                action.dragAndDrop(sourceElement, destinationElement).build()
                        .perform();
            }
        } catch (NoSuchElementException e) {
            throw e;
        }
    }
}
