package HYR.Tutorial;

import java.io.FileOutputStream;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindows {

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");
		options.addArguments("--incognito");

		caps.merge(options);
		driver = new ChromeDriver(options);
	}

	@Ignore
	@Test
	public void handlingNewTab() throws Exception {
		String url = "https://www.salesforce.com/au/";
		driver.get(url);

		driver.findElement(By.xpath("(//a[normalize-space(text())='Start free trial'])[1]")).click();

		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				System.out.println("Window Title: "+driver.getTitle());		
				driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]")).sendKeys("Tom");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]")).sendKeys("Hanks");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				driver.close();
			}
		}
		driver.switchTo().window(parentHandle);
		String parentTitle = driver.getTitle();
		System.out.println("Parent Title: "+parentTitle);
		driver.close();
	}
	
	@Test
	public void newWindowSwitch() {
		driver.get("https://www.salesforce.com/au/");
		System.out.println("Title1: "+driver.getTitle());
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.lambdatest.com/blog/how-to-handle-multiple-windows-in-selenium-webdriver-using-java/");
		System.out.println("Title2: "+driver.getTitle());

	}
}






