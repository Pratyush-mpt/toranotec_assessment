package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	By username_txt = By.id("LoginUserName");
	By password_txt = By.id("LoginPassword");
	By submit_btn = By.xpath("//*[@id='Id-page-host']/div/div[1]/div[1]/div/div[2]/div/div/div/div/div[1]/form/div[6]/div/button");
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
		
	public void typeUsername(String username)
	{
		driver.findElement(username_txt).sendKeys(username);
	}
	public void typepassword()
	{
		driver.findElement(password_txt).sendKeys("Pswd2019");
	}
	public void clickSubmit()
	{
		driver.findElement(submit_btn).click();
	}
}
