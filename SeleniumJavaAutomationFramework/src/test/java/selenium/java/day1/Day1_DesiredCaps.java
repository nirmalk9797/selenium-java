package selenium.java.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1_DesiredCaps {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--incognito");

		DesiredCapabilities capability = new DesiredCapabilities();
		chromeOptions.merge(capability);

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://mvnrepository.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
