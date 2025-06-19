package com.objectrepo.demoblazeweb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	String productName;
	
	@FindBy(id="login2")
	private WebElement loginLinktext;
	
	@FindBy(id="loginusername")
	private WebElement userNameTextField;
	
	@FindBy(id="loginpassword")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginButton;
	
	@FindBy(id="nameofuser")
	private WebElement NameofUserText;
	
	@FindBy(id="logout2")
	private WebElement logoutLinktext;
	
	@FindBy(xpath="//a[text()='Cart']")
	private WebElement cartLinktext;

	public WebElement getLoginLinktext() {
		return loginLinktext;
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}	
	
	public WebElement getNameofUserText() {
		return NameofUserText;
	}

	public WebElement getLogoutLinktext() {
		return logoutLinktext;
	}

	public WebElement getCartLinktext() {
		return cartLinktext;
	}
	
	

}
