package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_006 {
     
	@Test
	static void VerifyNewsLetterNoOption() {
		WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        driver.get("https://tutorialsninja.com/demo/");

        // Step 2: Start the registration process
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        
        driver.findElement(By.id("input-firstname")).sendKeys("Lakshmi");
        driver.findElement(By.id("input-lastname")).sendKeys("Pothuri");
        
        // Use a unique email
        String email = "test" + System.currentTimeMillis() + "@example.com";
        driver.findElement(By.id("input-email")).sendKeys(email);
        
        driver.findElement(By.id("input-telephone")).sendKeys("123456789");
        driver.findElement(By.id("input-password")).sendKeys("Pothuri");
        driver.findElement(By.id("input-confirm")).sendKeys("Pothuri");
        driver.findElement(By.xpath("//label[normalize-space()='No']")).click();
        driver.findElement(By.xpath("//input[@name='agree']")).click();
       
       
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        
        driver.findElement(By.linkText("Continue")).click();
        
        driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
        
        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());
//        
        driver.close();
        
        
		
		
		
		
		
		

	}

}
