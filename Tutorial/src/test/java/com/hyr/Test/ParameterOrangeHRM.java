package com.hyr.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterOrangeHRM {
	WebDriver driver;
	SoftAssert soft = new SoftAssert();

	//browserName in @Parameter and value passed inside the method, browserName can be same or different
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		default:
			System.out.println("Incorrect browser");		
			break;
		}
		driver.manage().window().maximize();

	}

	@Parameters("url")
	@Test
	public void launchApp(String webUrl) {
		driver.navigate().to(webUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Parameters({"userName","password"})
	@Test
	public void enterLoginDetails(String userName,String password) {
		System.out.println("Enter login details");
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password, Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}


	@Test
	public void verifyMyInfo() {
		System.out.println("Verify my details");
		driver.findElement(By.xpath("//a[contains((@href),'viewMyDetails')]")).click();
		boolean actualEmployeeId = driver.findElement(By.xpath("//label[normalize-space(text())='Employee Id']/../..//div//input")).isDisplayed();
		assertTrue(actualEmployeeId);
	}
	
	@Test
	public void verifyLogin() {
		System.out.println("Verify Login details");
		driver.findElement(By.xpath("//span[contains(@class,'userdropdown')]")).click();
		String actualMyDetails = driver.findElement(By.xpath("//ul[@role='menu']//a[normalize-space(text())='About']"))
				.getText();
		String expectedMyDetails = "About";
		soft.assertEquals(actualMyDetails, expectedMyDetails, "Mismatch in user verification");
		System.out.println("My details: "+actualMyDetails);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
