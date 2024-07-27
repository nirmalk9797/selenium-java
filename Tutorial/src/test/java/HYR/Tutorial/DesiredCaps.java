package HYR.Tutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCaps {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		options.merge(caps);
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");

		System.out.println(driver.getTitle());
		driver.quit();
		
		}
}
 