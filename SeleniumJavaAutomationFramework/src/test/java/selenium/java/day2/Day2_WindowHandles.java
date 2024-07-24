package selenium.java.day2;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2_WindowHandles {

	public static void main(String[] args) {

		// SetUp
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null;

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--incognito");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.merge(chromeOptions);

		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
//		driver.get("https://www.lambdatest.com/blog/how-to-handle-multiple-windows-in-selenium-webdriver-using-java/");
		driver.get("https://www.salesforce.com/au/");

		Set<String> windowHandles = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow" + parentWindow);

		driver.findElement(By.xpath("(//a[normalize-space(text())='Start free trial'])[1]")).click();

		for (String handle : windowHandles) {
			System.out.println(handle);
			if (!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				System.out.println("Child title: " + driver.getTitle());

				driver.findElement(By.xpath("//input[contains(@id,'UserFirstName')]")).sendKeys("Nirmal K");
				driver.findElement(By.xpath("//input[contains(@id,'UserLastName')]")).sendKeys("Nirmal K");

				WebElement userTitle = driver.findElement(By.xpath("//select[contains(@id,'UserTitle')]"));
				Select selectTitle = new Select(userTitle);
				selectTitle.selectByVisibleText("Developer / Software Engineer");

				driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]")).click();

				driver.findElement(By.className("header-text")).click();
				String error_message = driver.findElement(By.xpath("//span[@role='alert']")).getText();
				System.out.println("Error Message: " + error_message);

				driver.findElement(By.xpath("//input[contains(@id,'UserEmail')]")).sendKeys("nirmalk9797@gmail.in");

				driver.findElement(By.name("CompanyName")).sendKeys("Salesforce Corp");

				WebElement employeeElements = driver.findElement(By.name("CompanyEmployees"));
				Select employeeSelect = new Select(employeeElements);
				employeeSelect.selectByValue("2500");

				driver.findElement(By.name("UserPhone")).sendKeys("+91-9876543210");

				driver.findElement(By.xpath("(//div[@class='field']//div[contains(@class,'checkbox')])[3]")).click();
				driver.findElement(By.xpath("//button[contains(@name,'free')]")).click();

			}
		}

	}

}
