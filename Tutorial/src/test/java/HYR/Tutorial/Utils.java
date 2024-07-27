package HYR.Tutorial;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	public static WebDriver driver = null;
	public static ChromeOptions options;
	public static By by =null;
	public static WebElement element = null;

	/**
	 * 
	 * @param browser
	 */
	// Setup browser page
	public void pageSetUp(String browser) {
		String downloadPath = System.getProperty("user.dir") + File.separator + "download";
		String testAttachmentPath = System.getProperty("user.dir") + File.separator + "testAttachment";
		File downloadFile = new File(downloadPath);
		File testAttachmentFile = new File(testAttachmentPath);

		if(!downloadFile.exists()) {
			new File(downloadPath).mkdirs();
		}			
		
		if(!testAttachmentFile.exists()) {
			new File(testAttachmentPath).mkdirs();
		}
		
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			System.out.println("Initializing browser for " + browser);
			options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			break;
		case "no_options":
			WebDriverManager.chromedriver().setup();
			System.out.println("Initializing browser with no options");
			options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			break;
		default:
			WebDriverManager.chromedriver().setup();
			System.out.println("Initializing default browser");
			options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			break;
		}
	}

	
	/**
	 * 
	 * @param driver
	 * @param fileName
	 * @throws IOException
	 */
	// Take screenshot of the page
	public void CaptureScreenshots(WebDriver driver, String fileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver; // casting driver to TakeSceenshot instance
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/" + fileName)); // Create a screenshot folder prior and save																			// the screenshot as Image1
	}
	

	/**
	 * 
	 * @param elementIdentifier
	 * @param findBy
	 * @return
	 */
	// Find element
	public WebElement findWebElement(String elementIdentifier, String findBy) {
		switch (findBy.toLowerCase()) {
		case "id":
			by = By.id(elementIdentifier);
			break;

		case "xpath":
			by = By.xpath(elementIdentifier);
			break;
		case "className":
			by = By.className(elementIdentifier);
			break;
		}
		try {
			element = driver.findElement(by);
		} catch (Exception e) {
		}
		return element;
	}
	

	/**
	 * 
	 * @param elementIdentifier
	 * @param findBy
	 */
	public void clickMethod(String elementIdentifier,String findBy) {
		switch (findBy.toLowerCase()) {
		case "id":
			findWebElement(elementIdentifier, findBy).click();
			break;
		case "xpath":
			findWebElement(elementIdentifier, findBy).click();
		default:
			break;
		}
	}
	
	
	/**
	 * 
	 * @param elementIdentifier
	 * @param findBy
	 * @param value
	 */
	
	public void sendKeysMethod(String elementIdentifier, String findBy, String value) {
		findWebElement(elementIdentifier, findBy).sendKeys(value);
	}
	
	public String getTextMethod(String elementIdentifier, String findBy) {
//		String getTextString = findWebElement(elementIdentifier, findBy).getText();
		String getTextString = driver.findElement(By.id("txt1")).getText();
		return getTextString;
	}

	
	
//	public boolean waitForElementToBeDisplayed(String elementIdentifier, String findBy, String timeout) {
//		WebElement el =null;
//		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(timeout));
//		try {
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return el.isDisplayed();
//	}
	
	public void tearDown() {
		driver.quit();
	}

}







