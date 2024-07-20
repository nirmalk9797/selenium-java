package HYR.Tutorial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdowns {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Duration duration = Duration.ofSeconds(2);

		
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
//	driver.wait();
//	WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[normalize-space(text())='Course Name:']/parent::label/parent::div//select)[1]")));
//	el.isDisplayed();

		WebElement courseNameElement = driver.findElement(By.id("course"));

//	Need to convert web element reference to dropdown reference
		Select courseNameDropdown = new Select(courseNameElement);
		courseNameDropdown.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		courseNameDropdown.selectByValue("python");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(3000);

		courseNameDropdown.selectByVisibleText("Javascript");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Thread.sleep(3000);

		driver.findElement(
				By.xpath("(//b[normalize-space(text())='Course Name:']/parent::label/parent::div//select)[1]")).click();

		// Multi-select
//	driver.navigate().to("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

		WebElement ideMultiSelectElement = driver.findElement(By.id("ide"));

		Select ideMultiSelectDropdown = new Select(ideMultiSelectElement);
		ideMultiSelectDropdown.selectByIndex(1);
		Thread.sleep(3000);

		ideMultiSelectDropdown.selectByValue("ec");
		Thread.sleep(3000);

		ideMultiSelectDropdown.deselectAll();
		Thread.sleep(3000);
		
		ideMultiSelectDropdown.selectByVisibleText("NetBeans");
		Thread.sleep(3000);

		ideMultiSelectDropdown.selectByVisibleText("Visual Studio");
		Thread.sleep(3000);

		
		ideMultiSelectDropdown.deselectByIndex(1);
		Thread.sleep(3000);

		ideMultiSelectDropdown.deselectByValue("ec");
		Thread.sleep(3000);

		ideMultiSelectDropdown.deselectByVisibleText("NetBeans");
		Thread.sleep(3000);

		
		// Getting course list form dropdown
		List<WebElement> coursesAvailable = courseNameDropdown.getOptions();
		System.out.println("Courses available");
		for (WebElement course : coursesAvailable) {
			System.out.println(course.getText());
		}

		// Getting course list form dropdown
		List<WebElement> ideAvailable = ideMultiSelectDropdown.getAllSelectedOptions();
		System.out.println("IDE selected");
		for (WebElement ide : ideAvailable) {
			System.out.println(ide.getText());
		}
		
		System.out.println();
		System.out.println("Selected Options::");
		System.out.println(courseNameDropdown.getFirstSelectedOption().getText());

		System.out.println("Selected IDE Options::");
		System.out.println(ideMultiSelectDropdown.getFirstSelectedOption().getText());
		
		
		driver.quit();
	}
}
