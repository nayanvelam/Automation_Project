package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.booknowpage;

public class booknowtest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path to the ChromeDriver executable if not set in system properties
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void urlloading() {
        driver.get("https://www.blumebeauty.ca/contact-us/");
        driver.manage().window().maximize();
    }

    @Test(dependsOnMethods = "urlloading")
    public void contents() {
        booknowpage bp = new booknowpage(driver);
        bp.setValue("nkm", "km", "nkm@gmail.com", "9588484848", "Hair Colour Services", "01/02/2000", "10", "10", "AM", "sample details");
        bp.submit();
    }
}
