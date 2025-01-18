package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {
     
	@Test
	 static void VerifyRegistringAccountwithoutfillfields() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        String firstName_feildVerify="First Name must be between 1 and 32 characters!";
        String SecondName_feildVerify="Last Name must be between 1 and 32 characters!";
        String Email_feildVerify="E-Mail Address does not appear to be valid!";
        String Telephone_feildVerify="Telephone must be between 3 and 32 characters!";
        String Password_feildVerify="Password must be between 4 and 20 characters!";
        
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")), firstName_feildVerify);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")),SecondName_feildVerify);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")),Email_feildVerify);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")), Telephone_feildVerify);
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")),Password_feildVerify);
        
        driver.close();
        
        

        
        
	}

}
