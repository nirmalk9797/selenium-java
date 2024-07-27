package HYR.Tutorial;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesFunctionality {
	WebDriver driver;
	String url = "https://www.hyrtutorials.com/p/window-handles-practice.html";

	@BeforeTest
	public void beforeTestMethod() {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions opts = new ChromeOptions();

		opts.addArguments("--start-maximized");
		opts.addArguments("--incognito");
		caps.merge(opts);
		driver = new ChromeDriver(opts);

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}

	@Ignore
	@Test
	public void windowHandles() throws Exception {
		driver.findElement(By.id("newWindowBtn")).click();
		Thread.sleep(3000);

		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentWindowHandle);

		Set<String> windowHandles = driver.getWindowHandles();
		// System.out.println("Child Windows: "+windowHandles);

		for (String handle : windowHandles) {
			System.out.println("Child windows: " + handle);

			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				driver.findElement(By.id("firstName")).sendKeys("First Name");
				Thread.sleep(5000);
				String EnteredName = driver.findElement(By.id("firstName")).getText();
				System.out.println("Name: " + EnteredName);
				driver.close(); // Closes the child window or active window only
			}
		}

		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.id("name")).sendKeys("4567890");
		Thread.sleep(5000);

		driver.quit();
	}

	@Test
	public void newTab() {
		driver.get(url);

		WebElement element = driver.findElement(By.id("newTabBtn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		driver.findElement(By.id("newTabBtn")).click();

		Set<String> handles = driver.getWindowHandles();
		String parentHandle = driver.getWindowHandle();

		for (String handle : handles) {
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				boolean elementDisplayed = driver.findElement(By.xpath("//h1[normalize-space(text())='AlertsDemo']"))
						.isDisplayed();

				assertEquals(elementDisplayed, true);

				driver.findElement(By.id("alertBox")).click();
				driver.switchTo().alert().accept();
				driver.close();
			}
		}
	}
}