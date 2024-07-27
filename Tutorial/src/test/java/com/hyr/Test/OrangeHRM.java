package com.hyr.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	SoftAssert soft = new SoftAssert();
	
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void launchApp() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void loginToApplocation() {
		System.out.println("Login into application");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		String pageTitle = driver.getCurrentUrl();
		System.out.println("Current page title is : " + pageTitle);
		System.out.println("Logged into application");

	}

	@Test
	public void myInfo() {
		System.out.println("Getting my info");
		driver.findElement(By.xpath("//a[contains(@href,'viewMyDetails')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String employeeName = driver.findElement(By.xpath("//a[contains(@href,'viewMyDetails')]")).getText();
		System.out.println("My information : " + employeeName);
	}

	@Test
	public void verifyLogin() {
		System.out.println("Verify my details");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[contains((@href),'viewMyDetails')]")).click();
		String actualEmployeeId = driver
				.findElement(By.xpath("//label[normalize-space(text())='Employee Id']/../..//div//input")).getText();
		String expectedEmployeeId = "muser";
		soft.assertEquals(actualEmployeeId, expectedEmployeeId, "Incorrect employeeId");
		System.out.println("Actual : "+actualEmployeeId);
		System.out.println("Expected : "+expectedEmployeeId);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
