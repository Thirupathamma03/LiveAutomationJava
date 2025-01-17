package tutorialsninja.register;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo_test {
	
   

	@Test
	static void getalllinks() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String originalWindow = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[@target='_blank'][1]")).click();
		driver.findElement(By.xpath("//a[@target='_blank'][2]")).click();
		driver.findElement(By.xpath("//a[@target='_blank'][3]")).click();
		driver.findElement(By.xpath("//a[@target='_blank'][4]")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		
		for(String tab:tabs) {
			driver.switchTo().window(tab);
			
			String pageTitle=driver.getTitle();
			
			if(pageTitle.equals("OrangeHRM - World's Most Popular Opensource HRIS | Secaucus NJ | Facebook")) {
				String textOnPage=driver.findElement(By.xpath("(//html)[1]")).getText();
				System.out.println(textOnPage);
				driver.close();
				
			}
				
		}
		driver.switchTo().window(originalWindow);
		driver.quit();
		
		
		}
		
		
	}
   


