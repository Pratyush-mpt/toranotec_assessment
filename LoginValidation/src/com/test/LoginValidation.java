package com.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.LoginPage;
import com.util.excelUtil;
public class LoginValidation {
	private WebDriver driver; 
	@BeforeClass
	public void lunchbrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Files\\chromedriver.exe");
		driver=new ChromeDriver();  
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Lunch my chrome browser");
		
	}
	
	@BeforeMethod
	public void enterURL(){
		driver.navigate().to("https://premier.ctic.com/");  
		driver.manage().window().maximize();  
		System.out.println("Enter URL");
		
	}

		
	@Test(dataProvider="loginCredential")
	public void verifyLogin(String UserName) throws InterruptedException{
		String currenPath = System.getProperty("user.dir");
		System.out.println(currenPath);
		LoginPage login = new LoginPage(driver);
		login.typeUsername(UserName);
		login.typepassword();
		login.clickSubmit();
		Thread.sleep(5000);
	}
	
	@DataProvider()
	private Object[][] loginCredential() throws Exception{		
		
		Object[][] testObjArray = excelUtil.getTableArray(System.getProperty("user.dir")+"\\Files\\employees.xlsx","Sheet1");
        return (testObjArray);
		//return new Object[][]  {{"pratyush@fnf.com"},{"chandan@fnf.com"},{"monica@fnf.com"}} ;
	}
	
	@AfterClass
	public void closeBrowser(){
		driver.quit();
		
	}
}
