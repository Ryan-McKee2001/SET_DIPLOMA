package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class SelTest {

    public static void main(String[]args) {

        WebDriverManager.chromedriver().setup();

        WebDriver browser = new ChromeDriver();

        browser.navigate().to("http://demo.seleniumeasy.com");

//        System.out.println(browser.getTitle());
//
//
//        WebElement buttonStart =
//                browser.findElement(By.id("btn_basic_example"));
//
//        buttonStart.click();
//
//        List<WebElement> listOfLinks;
//
//        listOfLinks = browser.findElements(By.tagName("a"));
//
//        System.t.println("Total links by page is: " + listOfLinks.size());
//

        WebElement elem = browser.findElement(By.xpath("//a[@id = 'btn_basic_example']"));
        elem.click();
    }
}
