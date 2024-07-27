package HYR.Tutorial;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageLoadTimeoutTest extends Utils {
	Utils util = new Utils();

	@BeforeTest
	public void browserSetUp() {
		util.pageSetUp("chrome");
	} 
	
	@Test(priority = 2)
	public void apageLoadtestMethod() {
		driver.get("https://www.hyrtutorials.com/");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test
	public void implicitWaitTest() {
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		util.clickMethod("btn1","id");
		System.out.println("Button is clicked: ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Element displayed: "+driver.findElement(By.id("txt1")).isDisplayed());
		util.sendKeysMethod("txt1", "id","Entering inside textbox1");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
		String textbox1 = util.getTextMethod("txt1", "id");
		String textbox2 = driver.findElement(By.id("txt1")).getText();
		String textbox3 = driver.findElement(By.xpath("//input[@placeholder='Textbox1']")).getText();
		System.out.println("Get text element1: "+textbox1);
		System.out.println("Get text element2: "+textbox2);
		System.out.println("Get text element3: "+textbox3);		
	}
	
	@AfterTest
	public void tearDown() {
		util.tearDown();
	}


}
