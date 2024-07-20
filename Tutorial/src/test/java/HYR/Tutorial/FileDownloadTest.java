package HYR.Tutorial;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownloadTest extends Utils {
	Utils utils = new Utils();

	@BeforeTest
	public void setUp() {
		utils.pageSetUp("no_options");
		
		HashMap<String,Object> prefs = new HashMap<String, Object>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("plugins.plugins_disabled", "Chrome PDF Viewer");
		prefs.put("download.prompt_for_download", false);
		
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("download.default_directory");
		driver = new ChromeDriver(options);
	}

	@Test
	public void fileDownloadTest1() {
		DesiredCapabilities dcaps = new DesiredCapabilities();
		
		
		driver.get("https://www.lambdatest.com/selenium-playground/download-file-demo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		utils.findWebElement("//button[text()='Download File']", "xpath").click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@AfterTest
	public void tearDown() {
//	driver.quit();
	}

}
