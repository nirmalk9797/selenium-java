package selenium.java.day3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--incognito");
		cOptions.addArguments("--start-maximized");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		cOptions.merge(caps);
		driver = new ChromeDriver(cOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		//File Output type as FILE
		driver.get("https://github.com/nirmalk9797/selenium-java");

		TakesScreenshot ts1 = (TakesScreenshot) driver;
		File fileScreenshot = ts1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fileScreenshot, new File("./Screenshots/Image1.png"));
	
		
		//File Output type as BASE64
		driver.get("https://github.com/nirmalk9797/selenium-java/pulls");

		TakesScreenshot ts2 = (TakesScreenshot)driver;
		String base64 = ts2.getScreenshotAs(OutputType.BASE64);
		byte[] byteArray = Base64.getDecoder().decode(base64);
		FileOutputStream fos1 = new FileOutputStream(new File("./Screenshots/Image2.jpeg"));
		fos1.write(byteArray);
		fos1.close();	
		
		
		//File Output type as 
		driver.get("https://github.com/nirmalk9797/selenium-java/branches");
		
		TakesScreenshot ts3 = (TakesScreenshot)driver;
		byte[] byteValue = ts3.getScreenshotAs(OutputType.BYTES);
		FileOutputStream fos2 = new FileOutputStream(new File("./Screenshots/Image3.png"));
		fos2.write(byteValue);
		fos2.close();
		
		
		
		File path =	new File("./Screenshots");
		File[] files = path.listFiles();
		for(File file:files) {
			System.out.println("Deleted "+file.getName());
			file.delete();
		}
		driver.close();		
	}

}
