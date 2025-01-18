package tutorialsninja.register;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.time.Duration;

	public class TC_Rf_003 {

	    public static void VerifyRegistration() {
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	        try {
	            // Step 1: Navigate to the website
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
	            driver.findElement(By.name("newsletter")).click();
	            driver.findElement(By.name("agree")).click();
	            driver.findElement(By.xpath("//input[@value='Continue']")).click();

	            // Step 3: Wait for the success message
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            WebElement successMessage = wait.until(
	                ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")
	                )
	            );

	            // Step 4: Assert the success message
	            String expectedMessage = "Congratulations! Your new account has been success";
	            String actualMessage = successMessage.getText();

	            if (actualMessage.contains(expectedMessage)) {
	                System.out.println("Assertion passed: Success message is displayed correctly.");
	            } else {
	                System.out.println("Assertion failed: Expected message not found.");
	            }
	        } catch (Exception e) {
	            System.out.println("Test failed: " + e.getMessage());
	        } finally {
	            // Step 5: Clean up
	            driver.quit();
	        }
	    }

	    public static void main(String[] args) {
	        VerifyRegistration();
	    }
	}

