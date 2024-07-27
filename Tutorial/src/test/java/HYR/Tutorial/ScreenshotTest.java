package HYR.Tutorial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotTest extends Utils {
	Utils util = new Utils();

	@BeforeTest
	public void browserSetUp() {
		util.pageSetUp("chrome");
	}

	@Test()
	public void fileType() throws IOException, InterruptedException {
		System.out.println("File Type");
		// Output Type as FILE
		driver.get("https://www.w3schools.com/");
		util.CaptureScreenshots(driver, "image1.jpg");
		Thread.sleep(2000);
	}

	@Test
	public void base64Type() throws IOException, InterruptedException {
		System.out.println("Base 64 Type");

		// Output Type as BASE64
		driver.get("https://mvnrepository.com/artifact/commons-io/commons-io/2.16.1");
		
		TakesScreenshot ts2 = (TakesScreenshot)driver; // casting driver to TakeSceenshot instance
		String base64Code = ts2.getScreenshotAs(OutputType.BASE64);
		
		byte[] byteArray = Base64.getDecoder().decode(base64Code); // Casting base64Code string value to byte array so that we can write into a file
		
		FileOutputStream fos = new FileOutputStream(new File("./Screenshots/image2.jpeg"));
		fos.write(byteArray);
		fos.close();
		Thread.sleep(2000);
	}

	@Test
	public void byteType() throws IOException, InterruptedException {
		System.out.println("Byte Array Type");

		// Output Type as byte array
		driver.get("https://stackoverflow.com/");
		TakesScreenshot ts3 = (TakesScreenshot) driver;
		byte[] ba3 = ts3.getScreenshotAs(OutputType.BYTES);
		FileOutputStream f = new FileOutputStream(new File("./Screenshots/image3.png"));
		f.write(ba3);
		f.close();
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearDown() {
		System.out.println("Tear Down");
		util.tearDown();
	}
}
