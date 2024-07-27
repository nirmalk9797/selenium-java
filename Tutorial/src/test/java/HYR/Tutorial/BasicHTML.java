package HYR.Tutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import net.bytebuddy.asm.Advice.AllArguments;

public class BasicHTML {
/**
 * @param args
 */
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebElement element;

	DesiredCapabilities caps = new DesiredCapabilities();
	ChromeOptions options = new ChromeOptions();
	
	options.addArguments("--start-maximized");
	options.addArguments("--incognito");
	options.merge(caps);
	
	WebDriver driver = new ChromeDriver(options);
	Actions actions = new Actions(driver);
	driver.manage().window().maximize();
	driver.navigate().to("https://www.hyrtutorials.com/p/basic-controls.html");
	
	
	driver.findElement(By.id("firstName")).sendKeys("DAVID");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	
	driver.findElement(By.id("femalerb")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.findElement(By.id("malerb")).click();

	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.findElement(By.id("englishchbx")).click();
	
	element = driver.findElement(By.xpath("//h2[normalize-space(text())='Total Pageviews']"));
	actions.moveToElement(element).perform();
	
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//	driver.findElement(By.id("email")).sendKeys("david789@gmail.com");
	
	
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//	driver.findElement(By.id("password")).sendKeys("david789");
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	driver.findElement(By.xpath("//button[normalize-space(text())='Register']")).click();
	
	
	String successMessage = driver.findElement(By.xpath("//label[@id='msg']")).getText();
	Assert.assertEquals(successMessage, "Registration is Successful");
	System.out.println(successMessage);
	
	driver.findElement(By.xpath("//label[normalize-space(text())='Registration is Successful']")).isDisplayed();
	driver.quit();
	//Dropdown
	


}
}
