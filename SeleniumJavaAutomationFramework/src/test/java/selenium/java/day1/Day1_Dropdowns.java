package selenium.java.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1_Dropdowns {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		
		
		System.out.println("Single selection dropdown\n");

		WebElement singleSelectDropdowns = driver.findElement(By.id("course"));
		Select courseNameDropdown = new Select(singleSelectDropdowns);
		
		List <WebElement> coursesAvailable  = courseNameDropdown.getOptions();
		courseNameDropdown.selectByValue("java");
		Thread.sleep(3000);
		
		courseNameDropdown.selectByIndex(3);
		Thread.sleep(3000);

		courseNameDropdown.selectByVisibleText("Dot Net");
		Thread.sleep(3000);
		
		int i=0;

		for(WebElement e : coursesAvailable) {
			System.out.println("Index "+i+"-"+e.getText());
			i++;
		}
		
		System.out.println("\nSelected option from single selection dropdown");
//		System.out.println(courseNameDropdown.getAllSelectedOptions());
//
//		for(WebElement e1 : courseNameDropdown.getAllSelectedOptions()) {
//			System.out.println(e1);
//		}
		
		System.out.println("\nMultiple selection dropdown\n");

		WebElement multipleSelectionDropdown = driver.findElement(By.id("ide"));
		Select multiSelect = new Select(multipleSelectionDropdown);
		
		List<WebElement> multiOptionList = multiSelect.getOptions();
		
		int j=0;
		
		for(WebElement m : multiOptionList) {
			System.out.println("Index "+j+"-"+m.getText());
			j++;
		}
		
		multiSelect.selectByIndex(2);
		multiSelect.selectByValue("ij");
		multiSelect.selectByVisibleText("NetBeans");
		
		
		
		System.out.println("\nBootstrap Dropdowns\n");
		
		
		driver.close();
	}

}
