package com.selenium.selenium_testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class SeleniumTestingApplicationTests {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver browser = new ChromeDriver();

		browser.navigate().to("C:\\Users\\ryanm\\Downloads\\popupdemo.html");

		String parentWindow = browser.getWindowHandle();

		System.out.println("Title of parent window is before interacting: " + parentWindow);

		WebElement popupLink =
				browser.findElement(By.linkText("Open Popup"));

		popupLink.click();

		Thread.sleep(2000);

		Set<String> allWindows = browser.getWindowHandles();

		for(String currWindow: allWindows) {
			browser.switchTo().window(currWindow);
		}

		System.out.println("Title of child window is: " + browser.getTitle());

		WebElement linkOnPopup =
				browser.findElement(By.linkText("Close Popup"));

		browser.switchTo().window(parentWindow);

		System.out.println("Title of parent window is after interacting: " + browser.getWindowHandle());
	}
}
