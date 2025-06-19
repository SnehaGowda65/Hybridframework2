package com.testscripts.demoblazeweb;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.demoblazeweb.Base;
import com.listeners.demoblazeweb.EventList;
import com.objectrepo.demoblazeweb.HomePage;

@Listeners(EventList.class)
public class AddToCart extends Base {

	@Test
	public void addToCartPageTest() {
		hp=PageFactory.initElements(driver, HomePage.class);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		String pd = "Nokia lumia 1520";
		cu.clickOnProduct(pd, driver);
		try {
			cu.addToCart(pd, driver);
			test.pass("click on product passed");
		}catch (Exception e) {
			test.fail("click on product failed");
			Assert.assertTrue(false);
		}	
		wait.until(ExpectedConditions.elementToBeClickable(cu.addToCart(pd, driver)));
		cu.addToCart(pd, driver).click();
		wait.until(ExpectedConditions.alertIsPresent());
		cu.alertHandle(driver);
		try{
			hp.getCartLinktext().click();
			test.pass("successfully add the product to the cart");
		}catch (Exception e) {
			Assert.assertTrue(false);
			test.fail("failed to add the product to the cart");
		}
		
		
	}
}
