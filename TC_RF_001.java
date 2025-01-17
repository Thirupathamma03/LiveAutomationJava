package tutorialsninja.register;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class TC_RF_001 {
	  
	@Test
    
	public void VerifyRegisterwithMandataryFields () {
		
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Lakshmi");
        driver.findElement(By.id("input-lastname")).sendKeys("P");
        driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("123456778");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
         Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
         
         String ExpectedResult="Your Account Has Been Created!";
         
         Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),ExpectedResult);
         
         String ProperdetailsOne="Congratulations! Your new account has been successfully created!";
         String ProperdetailsTwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";
         String ProperdetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
         String ProperdetailsFour="contact us";
         
         String ExpectedDetails=driver.findElement(By.xpath("//div[@id='content']")).getText();
         
         Assert.assertTrue(ExpectedDetails.contains(ProperdetailsOne));
         Assert.assertTrue(ExpectedDetails.contains(ProperdetailsTwo));
         Assert.assertTrue(ExpectedDetails.contains(ProperdetailsThree));
         Assert.assertTrue(ExpectedDetails.contains(ProperdetailsFour));
         
         driver.findElement(By.linkText("Continue")).click();
         
         driver.findElement(By.linkText("Edit your account information")).isDisplayed();
         
         driver.quit();
         
         
        
        
	}
	
	
	public  String generateNewEmail() {
		
		return new Date().toString().replaceAll(" ","").replaceAll("\\:","")+"@gmail.com";
		
	}
}
