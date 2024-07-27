package HYR.Tutorial;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class BootstrapDropdowns extends Utils {
	Utils utils = new Utils();

	@BeforeTest
	public void setUp() {
		utils.pageSetUp("chrome");
	}

	@Ignore
	@Test
	public void singleSelectionDD()  {
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		clickMethod("btnDropdownDemo", "id");

		List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu show')]//a"));

		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.toLowerCase().equals("css")) {
				option.click();
				break;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String pageTitle = driver.getTitle();
		System.out.println("CSS page title:" + pageTitle); // Page title is wrong as ad is displayed
	}

	/*
	 * Multi select dropdown Reference :
	 * https://www.jquery-az.com/boots/demo.php?ex=63.0_2
	 */
	@Test(priority = 1)
	public void multiSelectDropdown() {
		String multiDropdownUrl = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
		driver.get(multiDropdownUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement dropDownButton = driver.findElement(By.xpath("//button[contains(@class,'multi')]"));
		clickMethod("//button[contains(@class,'multi')]", "xpath");

		List<WebElement> options = driver
				.findElements(By.xpath("//ul[contains(@class,'multi')]//li[not(contains(@class,'multi'))]/a/label"));

		for (WebElement option : options) {
			String optionText = option.getText();
			WebElement optionChkBox = option.findElement(By.tagName("input"));
			if (optionText.equals("Bootstrap")) {
				option.click();
			}
			if (optionText.equals("Java")) {
				optionChkBox.click();
			}
			if (optionText.equals("CSS")
					&& option.findElement(By.xpath("//li[(contains(@class,'active'))]/a/label//input[@value='CSS']"))
							.isSelected()) {
				option.click();
			}
		}

		List<WebElement> selectedOptions = driver.findElements(By.xpath("//li[contains(@class,'active')]"));
		for (WebElement soption : selectedOptions) {
			System.out.println("Selected Option: " + soption.getText());
		}

		if (Boolean.valueOf((dropDownButton.getAttribute("aria-expanded")))) {
			dropDownButton.click();
		}
	}

	/*
	 * Deselect the selected dropdown options
	 */
	@Test(priority = 2)
	public void assignment1() {
		System.out.println("\nAssignment 1");

		WebElement dropDownButton = driver.findElement(By.xpath("//button[contains(@class,'multi')]"));

		if (!Boolean.valueOf((dropDownButton.getAttribute("aria-expanded")))) {
			dropDownButton.click();
		}

		List<WebElement> selectedOptions = driver.findElements(By.xpath("//li[contains(@class,'active')]"));
		for (WebElement option : selectedOptions) {
			option.click();
		}
		String noneSelected = driver.findElement(By.xpath("//button[contains(@class,'multi')]//span")).getText();
		System.out.println("Options selected: " + noneSelected);

		if (Boolean.valueOf((dropDownButton.getAttribute("aria-expanded")))) {
			dropDownButton.click();
		}
	}

	/*
	 * Assignment 2 : Select any three dropdown options Assignment 4 : Print the
	 * dropdown selected options Assignment 6 : Print the total number of selected
	 * options in the dropdown
	 */
	@Test(priority = 3)
	public void assignment2_4_6()  {
		System.out.println("\nAssignment 2,4 and 6");
		WebElement dropDownButton = driver.findElement(By.xpath("//button[contains(@class,'multi')]"));

		if (!Boolean.valueOf((dropDownButton.getAttribute("aria-expanded")))) {
			dropDownButton.click();
		}
		List<WebElement> options = driver
				.findElements(By.xpath("//ul[contains(@class,'multi')]//li[not(contains(@class,'multi'))]/a/label"));
		for (WebElement option : options) {
			if (option.getText().equals("Angular")) {
				option.click();
			}
			if (option.getText().equals("Python")) {
				option.click();
			}
			if (option.getText().equals("Oracle")) {
				option.click();
			}
		}

		List<WebElement> selectedOptions = driver.findElements(By.xpath("//li[contains(@class,'active')]"));
		System.out.println("\nSelected dropdown options-");

		for (WebElement soption : selectedOptions) {
			System.out.println("Selected Option: " + soption.getText());
		}

		int count = 0;
		for (WebElement selected : selectedOptions) {
			if (selected.isEnabled()) {
				count++;
			}
		}
		System.out.println("Number of selected options: " + count);

		if (Boolean.valueOf((dropDownButton.getAttribute("aria-expanded")))) {
			dropDownButton.click();
		}
	}

	/*
	 * Assignment 3 : Select all dropdown options Assignment 5 : Print the total
	 * number of options available in the dropdown
	 */
	@Test(priority = 4)
	public void assignment3_5()  {
		System.out.println("\nAssignment 3 and 5");
		int count = 0;
		WebElement dropDownButton = driver.findElement(By.xpath("//button[contains(@class,'multi')]"));

		if (Boolean.valueOf((dropDownButton.getAttribute("aria-expanded")))) {
			List<WebElement> options = driver.findElements(By.xpath("//label/input"));
			for (WebElement element : options) {
				if (element.isSelected()) {
					count++;
					continue;
				}
				element.click();
				count++;
			}
			if (count == 11) {
				System.out.println("All options selected");
				System.out.println("Total number of options avaiable in the dropdown: " + count);

			}

			List<WebElement> selectedOptions = driver.findElements(By.xpath("//li[@class='active']//label"));
			for (WebElement option : selectedOptions) {
				System.out.println("Selected Options: " + option.getText());
			}
		}
		
		if (Boolean.valueOf((dropDownButton.getAttribute("aria-expanded")))) {
			dropDownButton.click();
		}
		
	}

	/*
	 * Assignment 7 : Print the options present inside specific group
	 */
	@Test(priority = 5)
	public void assigment7() {
		ArrayList<String> webDevelopmentArray = new ArrayList<String>();
		ArrayList<String> programmingLanguagesArray = new ArrayList<String>();
		ArrayList<String> databasesArray = new ArrayList<String>();

		WebElement dropdownButton = driver.findElement(By.xpath("//button[contains(@class,'multi')]"));

		if (!Boolean.valueOf(dropdownButton.getAttribute("aria-expanded"))) {
			dropdownButton.click();
			System.out.println("Expanded");
		}

		List<WebElement> groupNames = driver.findElements(By.xpath("//li[contains(@class,'multi')]"));
		for (WebElement e : groupNames) {
			if (e.getText().equalsIgnoreCase("Web Development")) {
				System.out.println("\nWeb Development Groups:");
				List<WebElement> webDevgroup = driver
						.findElements(By.xpath("//optgroup[@label='Web Development']//option"));
				for (WebElement el : webDevgroup) {
					webDevelopmentArray.add(el.getText());
				}
				System.out.println(webDevelopmentArray);
			}

			else if (e.getText().equalsIgnoreCase("Programming Languages")) {
				System.out.println("\nProgramming Languages Groups:");
				List<WebElement> programLanguageGroup = driver
						.findElements(By.xpath("//optgroup[@label='Programming Languages']//option"));
				for (WebElement el : programLanguageGroup) {
					programmingLanguagesArray.add(el.getText());
				}
			}

			else if (e.getText().equalsIgnoreCase("Databases")) {
				System.out.println("\nDatabases Groups:");
				List<WebElement> databaseGroup = driver
						.findElements(By.xpath("//optgroup[@label='Databases']//option"));
				for (WebElement el : databaseGroup) {
					databasesArray.add(el.getText());
				}
			}
		}

		if (Boolean.valueOf(dropdownButton.getAttribute("aria-expanded"))) {
			dropdownButton.click();
		}
	}

	@AfterSuite
	public void tearDown() {
		System.out.println("\nTear Down");
		utils.tearDown();
	}
}
