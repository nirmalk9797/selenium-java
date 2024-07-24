package selenium.java.day3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3_Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--incognito");
		cOptions.addArguments("--start-maximized");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		cOptions.merge(caps);
		driver = new ChromeDriver(cOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://letcode.in/frame");
				
//		Actions scroll = new Actions(driver);
		WebElement frame1 = driver.findElement(By.id("firstFr"));
//		scroll.scrollToElement(frame1);
		driver.switchTo().frame(frame1);
		driver.findElement(By.name("fname")).sendKeys("Sam");
		driver.findElement(By.name("lname")).sendKeys("Curran");
	
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.name("googlefcPresent"));
		driver.switchTo().frame(frame2);
		
		driver.findElement(By.name("email")).sendKeys("sam.curran@gmail.com");
		
		driver.close();
	}

}
