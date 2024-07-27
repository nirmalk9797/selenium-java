package HYR.Tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertMethods {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	DesiredCapabilities dc = new DesiredCapabilities();
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--start-maximized");
	options.addArguments("--incognito");
	options.merge(dc);
	
	WebDriver driver = new ChromeDriver(options);
	
	driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
	
	
	//Simple Alert
	System.out.println("Simple Alert");
	driver.findElement(By.id("alertBox")).click();
	Alert simpleAlert = driver.switchTo().alert();
	System.out.println("Simple alert text message: "+simpleAlert.getText());
	Thread.sleep(3000);
	simpleAlert.accept();
	String simpleAlertOutput = driver.findElement(By.id("output")).getText();
	System.out.println("Simple Alert output: "+simpleAlertOutput);
	Thread.sleep(3000);
	
	
	
	
	//Confirmation Alert - Accept
	System.out.println("Confirm Accept");
	driver.navigate().refresh();
	driver.findElement(By.id("confirmBox")).click();
	Alert confirmAlertAccept = driver.switchTo().alert();
	System.out.println("Confirmation alert text message: "+confirmAlertAccept.getText());
	Thread.sleep(3000);
	confirmAlertAccept.accept();
	String confirmAlertOutput = driver.findElement(By.id("output")).getText();
	System.out.println("Simple Alert output: "+confirmAlertOutput);
	Thread.sleep(3000);

	
	
	
	//Confirmation Alert - Dismiss
	System.out.println("Confirm Dismiss");
	driver.navigate().refresh();
	driver.findElement(By.id("confirmBox")).click();
	Alert confirmAlertDismiss = driver.switchTo().alert();
	System.out.println("Confirmation alert text message: "+confirmAlertDismiss.getText());
	Thread.sleep(3000);
	confirmAlertDismiss.dismiss();
	Thread.sleep(3000);
	String confirmAlertDismissOutput = driver.findElement(By.id("output")).getText();
	System.out.println("Confirmation alert output: "+confirmAlertDismissOutput);
	Thread.sleep(3000);
	
	
	//Prompt Alert
	System.out.println("Prompt Alert");
	driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
	driver.findElement(By.xpath("//p[contains(text(),'Prompt box:')]/..//button")).click();
	Alert promptAlert = driver.switchTo().alert();
	System.out.println("Prompt alert text message: "+promptAlert.getText());
	Thread.sleep(3000);
	promptAlert.sendKeys("David");
	promptAlert.dismiss();
	Thread.sleep(3000);
	String promptAlertAcceptOutput = driver.findElement(By.id("prompt-demo")).getText();
	System.out.println("Prompt alert output: "+promptAlertAcceptOutput);
	Thread.sleep(3000);
	
	
	
	driver.quit();
}
}
