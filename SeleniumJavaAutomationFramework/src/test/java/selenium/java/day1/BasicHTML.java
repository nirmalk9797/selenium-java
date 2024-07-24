package selenium.java.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
	
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicHTML {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--incognito");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		chromeOptions.merge(capabilities);
		
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
		
		//Enter user data
		driver.findElement(By.id("firstName")).sendKeys("Nirmal");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("K");
//		driver.findElement(By.xpath("//input[@id='malerb']")).click();
//		System.out.println((driver.findElement(By.xpath("//input[@id='malerb']")).isSelected())? "Male":"Female");
 
		driver.findElement(By.id("englishchbx")).click();
		driver.findElement(By.id("registerbtn")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Click here to navigate to the home page")).click();
//		driver.close();
	}

}
