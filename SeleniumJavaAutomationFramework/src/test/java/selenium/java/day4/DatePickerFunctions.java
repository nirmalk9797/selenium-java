package selenium.java.day4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerFunctions {

	static void selectMonthAndYear(WebDriver driver, String month, String year) {
		while (true) {
			String currentMonth = driver.findElement(By.xpath("//span[contains(@class,'month')]")).getText();
			String currentYear = driver.findElement(By.xpath("//span[contains(@class,'year')]")).getText();
			
			if (currentMonth.equals(month) && currentYear.equals(year))
				break;
			driver.findElement(By.xpath("//span[normalize-space(text())='Next']")).click();
//			driver.findElement(By.xpath("//span[normalize-space(text())='Prev']")).click();
		}
	}

	static void selectDate(WebDriver driver, String requiredDate) {
		List<WebElement> allDates = driver.findElements(By.xpath("//tbody//tr//td//a"));
		for (WebElement date : allDates) {
			if (date.getText().equals(requiredDate)) {
				date.click();
				break;
			}

		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		selectMonthAndYear(driver, "July", "2025");
		selectDate(driver, "29");
	}

}
