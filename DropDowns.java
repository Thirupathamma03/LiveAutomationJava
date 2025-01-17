package tutorialsninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDowns {
	@Test
	public void handelWindows() throws InterruptedException
	{
	      
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement country_drop_down = driver.findElement(By.id("country"));
		
		
		Select drop_down=new Select(country_drop_down);
		
		String List1="United States";
		String List2="australia";
		int List3=9;
		
		if(country_drop_down.isDisplayed()) {
			drop_down.selectByVisibleText(List1);
			System.out.println(List1);
			Thread.sleep(2000);
			
			drop_down.selectByValue(List2);
			System.out.println(List2);
			Thread.sleep(2000);
			
			drop_down.selectByIndex(List3);
			System.out.println(List3);
			Thread.sleep(2000);
			
			driver.close();
			
		}
}
}