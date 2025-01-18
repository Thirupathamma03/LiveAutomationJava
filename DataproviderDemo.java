package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataproviderDemo {
	
	
	WebDriver driver;
    
	@BeforeClass
	void setup(){
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test (dataProvider="logindata")
	void login(String email,String pwd) {
		driver.get("https://demowebshop.tricentis.com/login");
	    driver.manage().window().maximize();
	    
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		boolean status = driver.findElement(By.xpath("//a[normalize-space()='Log out']")).isDisplayed();
		Assert.assertEquals(status, true);
		
		
		
	}
	
	@AfterClass
	void teardown() {
		driver.close();
	}
	
	
	
	@DataProvider
	Object[][] logindata() 
	{
		
		Object data[][]= 
		{
				{"lthirupathamma3@gmail.com","123456"},
				{"abc@gmail.com","test123"},
				{"xyz@gmail.com","test123"},
				{"123abc@gmai.com","test123"},
				{"thiru@gmail.com","12345"}
				
		};
				
		
	
				
		
		return data ;
	}
	
	
	
	
	
	
	
	
}
