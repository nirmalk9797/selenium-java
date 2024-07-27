package HYR.Tutorial;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com");
		Thread.sleep(5000);
		
		Set<String> brokenLinkUrls = new HashSet<String>();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Size: " + links.size());

		for (WebElement link : links) {
			String linkURL = link.getAttribute("href");
			URL url = new URL(linkURL);

			URLConnection urlConnection = url.openConnection();

			HttpURLConnection httpURLConection = (HttpURLConnection) urlConnection;
			httpURLConection.setConnectTimeout(10000);
			httpURLConection.connect();

			if (httpURLConection.getResponseCode() != 200) {
				System.out.println(linkURL+" - "+httpURLConection.getResponseMessage());
				brokenLinkUrls.add(linkURL);
			}
			httpURLConection.disconnect();
		}

//		for (String brokenLink : brokenLinkUrls) {
//			System.out.println(brokenLink);
//		}
		driver.quit();
	}

}
