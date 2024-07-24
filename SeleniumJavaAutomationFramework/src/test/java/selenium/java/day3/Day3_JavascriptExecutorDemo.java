package selenium.java.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3_JavascriptExecutorDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =null;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--incognito");
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		options.merge(desiredCapabilities);
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://stackoverflow.com/users/login?ssrc=head&returnurl=https%3a%2f%2fstackoverflow.com%2f");
		
		//Highlight element using JavascriptExecutor interface
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("document.getElementById('email').style.border='2px solid red';");
		js1.executeScript("document.getElementById('email').style.background='yellow';");
				
		TakesScreenshot ts1 = (TakesScreenshot)driver;
		File highlightElement = ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(highlightElement,new File("./Screenshots/HighlightElement1.jpeg"));
		
			
		//Highlight element using WebDriver interface
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement emailElement = driver.findElement(By.id("email"));
		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].style.border='2px solid blue'",emailElement);
		js2.executeScript("arguments[0].style.background='red'",emailElement);
		
		TakesScreenshot ts2 = (TakesScreenshot)driver;
		File webElementHighlight = ts2.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(webElementHighlight, new File("./Screenshots/HighlightElement2.png"));
		
		driver.close();
	}

}
