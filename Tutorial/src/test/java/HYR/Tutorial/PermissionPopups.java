package HYR.Tutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PermissionPopups {
	WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications"); // Disable notifications
		options.addArguments("disable-geolocation"); // Disable geolocation
		options.addArguments("disable-media-stream"); // Disable media-stream
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
	}

	@Test
	public void showNotification() {
		driver.get("https://web-push-book.gauntface.com/demos/notification-examples/");

	}
}
