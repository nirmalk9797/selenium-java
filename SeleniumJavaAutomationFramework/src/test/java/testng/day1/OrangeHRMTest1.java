package testng.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest1 {
	WebDriver driver;

	@Test
	public void ALaunchApplication() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void BEnterLoginDetails() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin",Keys.ENTER);
	}
		
	@Test
	public void NavigateMyInfo() {
		driver.findElement(By.partialLinkText("viewMyDetails")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void verifyLogin() {
		String loggedInUser = driver.findElement(By.name("firstName")).getText();
		System.out.println("Logged in user: "+loggedInUser);
	}
	
//	@AfterSuite
//	public void tearDown() {
//		driver.close();
//	}
	
}
