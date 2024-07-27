package HYR.Tutorial;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TypeCastingTestMethod {
	static WebDriver driver = null;
	static String browserName = null;

	public static void main(String[] args) throws IOException {
		browserName = "Chrome";
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			break;
		}
				
		driver.get("https://www.google.com");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String pageTitle = (String)js.executeScript("return document.title");
		System.out.println("Page title is: "+pageTitle);
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Typecast/Image1.png"));
	
		driver.quit();
	}
}
