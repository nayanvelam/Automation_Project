package test;
import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.jointeampage;

public class jointeamtest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
      
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void urlloading() {
        driver.get("https://www.blumebeauty.ca/join-our-team/");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws AWTException {
        jointeampage jp = new jointeampage(driver);
        jp.setvalues("Nayana", "km", "sample@gmail.com", "9886868686", "address", "abc", "kozhikode", "Manitoba", "D:\\dochhh.pdf", "informations");
        jp.submit();
    }
}
