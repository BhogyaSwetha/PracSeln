package com.flyaway.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginClass {

	//	Weblements

	By username = By.name("email_id");
	By password = By.name("pwd");
	By login = By.tagName("button");
	By logout = By.linkText("Logout");


	

	public String Login(WebDriver  driver, String strUN, String strPwd) {
		
		String BaseURL = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/main/resources/config.properties"));
			BaseURL = prop.getProperty("DEV.URL");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		driver.get(BaseURL+"/login");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(username).sendKeys(strUN);
		driver.findElement(password).sendKeys(strPwd);
		driver.findElement(login).click();
		String retLogin = "Login Pass";

		try {
			driver.findElement(logout);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Logout link not found");
			retLogin = "Login Fail";


		}

		return retLogin;


	}


	public void clearUserName(WebDriver driver) {
		driver.findElement(username).clear();

	}


	public void getUserName(WebDriver driver) {
		driver.findElement(username).getText();

	}

	public void Logout(WebDriver driver) {
		driver.findElement(logout).click();

	}


}
