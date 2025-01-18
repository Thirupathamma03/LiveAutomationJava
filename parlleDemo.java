package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;



public class parlleDemo {
	
	WebDriver driver;
	@BeforeClass
	
	void setup() throws InterruptedException{
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
    
	@Test(priority=1)
	void LogoVerify() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
		
	}
	
	@Test(priority=2)
	void TitleVerify() {
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	
	@Test(priority=3)
	void URlVerify() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass
	void teardown() {
		driver.close();
	}
}
