package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.homepage;

public class hometest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void urlloading() {
        driver.get("https://www.blumebeauty.ca/");
        driver.manage().window().maximize();
    }

    @Test
    public void content() throws IOException, InterruptedException {
        homepage hp = new homepage(driver);
        hp.clickss();
    }
}
