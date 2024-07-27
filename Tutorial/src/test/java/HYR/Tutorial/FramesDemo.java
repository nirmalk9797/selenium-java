package HYR.Tutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {
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
	public void framesTest1() throws InterruptedException {
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.75'");

		driver.findElement(By.id("name")).sendKeys("Hello");
		
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		
		WebElement courseElement = driver.findElement(By.id("course"));
		Select courseSelect = new Select(courseElement);
		courseSelect.selectByValue("js");
		
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Hi");

		driver.close();
	}
	
	
	@Ignore
	@Test
	public void framesTest2() throws InterruptedException {
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.75'");
		
		driver.findElement(By.id("name")).sendKeys("Hello");
		
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		Thread.sleep(3000);
		driver.findElement(By.id("firstName")).sendKeys("Hellen");
		driver.findElement(By.id("lastName")).sendKeys("Waltz");
		Thread.sleep(3000);
//		driver.findElement(By.id("femalerb")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(3000);
	
		driver.findElement(By.id("englishchbx")).click();
		driver.findElement(By.id("spanishchbx")).click();
		driver.findElement(By.id("latinchbx")).click();
		driver.findElement(By.id("frenchchbx")).click();

		Thread.sleep(5000);
//		driver.close();	
	}
	
	
	@Test
	public void frameSwitch() {
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

//		((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '0.70'");
		
		WebElement element = driver.findElement(By.id("newTabsBtn"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		driver.findElement(By.className("frmTextBox")).sendKeys("Switch Frames");
//		
//		driver.switchTo().frame(0);
//		
//		Select selectCourse = new Select(element);
//		selectCourse.selectByIndex(0);
		
	}
}
