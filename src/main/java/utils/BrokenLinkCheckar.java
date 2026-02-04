package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLinkCheckar {

	public static void checkBrokenLinks(WebDriver driver) {

		// Get all links on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Loop through each link
		for (WebElement linkElement : links) {

			String url = linkElement.getAttribute("href");

			// Skip the empty links
			if (url == null || url.isEmpty()) {
				continue;

			}
			checkLinkStatus(url);

		}
	}

//Method to check HTTP response for url 
	private static void checkLinkStatus(String url) {
		try {
			URL link = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) link.openConnection();

			connection.setConnectTimeout(3000);
			connection.connect();

			int statusCode = connection.getResponseCode();

			if (statusCode >= 400) {
				System.out.println(url + "It is Broken Link");

			} else {
				System.out.println(url + "It is valid link");
			}
		} catch (Exception e) {
			System.out.println(url + "Could not check link error:" + e.getMessage());
		}
	}
}
