package selenium.java.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndPopups {

	public static void main(String[] args) throws Exception {
		//SetUp
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--incognito");
		
		DesiredCapabilities capability = new DesiredCapabilities();
		chromeOptions.merge(capability);
		
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//Get the SUT
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		
		//Simple Alert
		System.out.println("\nSimple Alert\n");

		driver.findElement(By.id("alertBox")).click();
		Alert simple_alert = driver.switchTo().alert();
		String simple_alert_str = driver.switchTo().alert().getText();
		System.out.println("Simple Alert : "+simple_alert_str);
		simple_alert.accept();
		String simple_alert_output = driver.findElement(By.id("output")).getText();
		System.out.println("Simple alert output "+simple_alert_output);
		
		//Confirm Alert
		System.out.println("\nConfirm Alert\n");
		
		driver.findElement(By.id("confirmBox")).click();
		driver.switchTo().alert().dismiss();
		String confirm_dismiss = driver.findElement(By.id("output")).getText();
		System.out.println("Confirm alert dismiss "+confirm_dismiss);
		
		driver.findElement(By.id("confirmBox")).click();
		driver.switchTo().alert().accept();
		String confirm_accept = driver.findElement(By.id("output")).getText();
		System.out.println("Confirm alert accept "+confirm_accept);
		
		
		//Prompt Alert
		System.out.println("\nPrompt Alert\n");
				
		driver.findElement(By.id("promptBox")).click();
		driver.switchTo().alert().dismiss();
		String prompt_message_dismiss = driver.findElement(By.id("output")).getText();
		System.out.println("Prompt alert accept "+prompt_message_dismiss);
			
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.id("promptBox")).click();
		driver.switchTo().alert().sendKeys("Nirmal K");
		driver.switchTo().alert().accept();
		String prompt_message_accept = driver.findElement(By.id("output")).getText();
		System.out.println("Prompt alert accept "+prompt_message_accept);
		
		driver.close();	
	}

}
