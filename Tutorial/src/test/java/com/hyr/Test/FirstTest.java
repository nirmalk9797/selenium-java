package com.hyr.Test;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
	public void testGoogle() throws ElementNotInteractableException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		try {
			driver.navigate().to("https://www.google.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

			String pageTitle = driver.getTitle();
			System.out.println("Page Title is : " + pageTitle);
			String expectedTitle = "HYR Tutorials - Google Search";

			Assert.assertEquals(pageTitle, expectedTitle, "Title mismatch"); // Hard Assertion - coming from Assert
																				// class

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();

		}
	}

	@Test
	public void testTravel() throws ElementNotInteractableException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.redbus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.id("src")).sendKeys("CHENNAI", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.id("dest")).sendKeys("MUMBAI", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		LocalDate currDate = LocalDate.now();
		System.out.println("Current Date" + currDate.toString());

		LocalDate nextDate = currDate.plusDays(5);
		System.out.println("Next Date" + nextDate.toString());

		driver.findElement(By.xpath("//input[@placeholder='DD/MY']")).click();

		String pageTitle = driver.getTitle();
		System.out.println("Page Title is : " + pageTitle);
		String expectedTitle = "Book bus tickets online with redBus!";
	
//		Assert.assertEquals(pageTitle, expectedTitle);
		driver.quit();
	}

	@Test
	public static void testFacebook() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");

		driver.findElement(By.id("email")).sendKeys("HYttttR Tutorials", Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		SoftAssert softAssert = new SoftAssert();
		
		// Title Assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to Facebook";
		softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
		System.out.println(driver.getTitle());
		
		// URL Assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/login/";
		softAssert.assertNotEquals(actualUrl, expectedUrl, "URL is mismatched");
		System.out.println("Current URL : "+driver.getCurrentUrl());

		// Text Assertion
		String actualText = driver.findElement(By.id("email")).getAttribute("value");
		String expectedText = "";
		softAssert.assertEquals(actualText, expectedText, "Text is mismatched");
		System.out.println("Text assertion complete");
		
		// Border Assertion
		String actualBorder = driver.findElement(By.id("email")).getCssValue("border");
		String expectedBorder = "0.8px solid rgb(240,40,73)";
		softAssert.assertEquals(actualBorder, expectedBorder, "Border is mismatched");
		System.out.println("Border assertion complete");

		// Error message Assertion
		String actualErrorMessage = driver.findElement(By.xpath("(//input[@name='email']/..//div)[2]")).getText();
		String expectEderrorMessage = "1px solid rgb(240,40,73)";
		softAssert.assertEquals(actualErrorMessage, expectEderrorMessage, "Error message is mismatched");
		System.out.println("Error message assertion complete");
		System.out.println("Actual error messgae is : "+actualErrorMessage);

		softAssert.assertAll();
		driver.quit();
		
	}

}
