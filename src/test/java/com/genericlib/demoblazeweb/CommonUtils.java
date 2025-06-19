package com.genericlib.demoblazeweb;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtils {

	public void clickOnProduct(String productName, WebDriver driver) {
		for (int i = 0; i < 5; i++) {
			try {
				driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}
	
	public WebElement addToCart(String productName, WebDriver driver) {
		return driver.findElement(By.xpath("//h2[text()='"+productName+"']/following-sibling::div/descendant::a"));
	}
	
	public void alertHandle(WebDriver driver) {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
}
