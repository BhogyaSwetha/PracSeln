package com.selenium.test;

import org.testng.annotations.Test;

import com.flyaway.pages.ReadProp;
import com.flyaway.pages.LoginClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestLogin {
	
	
	WebDriver driver;
	LoginClass login;
  @Test(dataProvider = "LoginData")
  public void TestLogin(String strUN, String strPWD, String expResult) {
		String loginstatus = login.Login(driver, strUN, strPWD);
		Assert.assertEquals( loginstatus, expResult);
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mbhogyas\\install\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Added");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  @DataProvider
  public String[][] LoginData() {
    return new String[][] {
      new String[] { "user@user.com","user","Login Pass" },
      
    };
  }
  @BeforeClass
  public void beforeClass() {
	  
	  login = new LoginClass();
  }

  @AfterClass
  public void afterClass() {
  }

}
