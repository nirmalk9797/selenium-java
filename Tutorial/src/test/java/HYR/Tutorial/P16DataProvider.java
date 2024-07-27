package HYR.Tutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class P16DataProvider {

	@Test(dataProvider = "loginData")
	public void P16dataProviderTest(String userName, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		System.out.println("Login into application");

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password, Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String pageTitle = driver.getCurrentUrl();
		System.out.println("Current page title is : " + pageTitle);
		System.out.println("Logged into application");
		driver.quit();
	}

	@DataProvider()
	public Object[][] loginData() {
		Object[][] data = new Object[2][2];
		
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		data[1][0] = "wertyu";
		data[1][1] = "test123";
		
		return data;
	}
//	@AfterTest
//	public void tearDownMethod() {
//		util.tearDown();
//	}
}
