package testng.day2;
/*
 * Using testNG listeners
 */

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CaptureScreenshots extends BaseTest{

	@Test(testName = "TestGoogle")
	public void TestGoogle() throws Exception {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium Java", Keys.ENTER);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Selenium Java - Google Search";
		assertEquals(actualTitle, expectedTitle);
		Thread.sleep(5000);
	}

	@Test(testName = "TestFacebook")
	public void TestFacebook() throws Exception {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("INVALID USER", Keys.ENTER);
		Thread.sleep(5000);
		SoftAssert softAssert = new SoftAssert();

		// Title Assertion
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log in to";
		softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismatch");

		// URL Assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "";
		softAssert.assertEquals(actualUrl, expectedUrl, "URL is mismatch");

		// Text Assertion
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "INVALID USER";
		softAssert.assertEquals(actualText, expectedText, "Text mismatch");

		// Error message Assertion
		String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/..//div)[8]")).getText();
		String expectedErrorMessage = "The password that you've entered is incorrect. Forgotten password?";
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch");

		softAssert.assertAll();
	}

	@Test(testName = "TestOrangeHRM")
	public void TestOrangeHRM() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("Admin");
		driver.findElement(By.xpath("(//input)[3]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@class,'name')]")).isDisplayed());
	}
}
