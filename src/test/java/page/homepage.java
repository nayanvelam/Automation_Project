package page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homepage {

    WebDriver driver;
    By logo = By.xpath("//*[@id=\"qodef-page-header-inner\"]/div/div[1]/a/img");
    By service = By.xpath("//*[@id=\"menu-main-menu-1\"]/li[2]/a");
    By Menu = By.xpath("//*[@id=\"menu-main-menu-1\"]/li[3]/a");
    By gallary = By.xpath("//*[@id=\"menu-main-menu-1\"]/li[4]/a");
    By home = By.xpath("//*[@id=\"menu-main-menu-1\"]/li[1]/a");
    By learnmore = By.xpath("//*[@id=\"slick-slide00\"]/div/div/div/section/div[2]/div[1]/div/div[4]/div/div");
    By scrolldown = By.xpath("//*[@id=\"elementor-library-2\"]/div/section/div/div/div/div[2]/div/div/span[2]/a");
    By facebook = By.xpath("//*[@id=\"elementor-library-2\"]/div/section/div/div/div/div[2]/div/div/span[1]/a");
    By arrow = By.xpath("//*[@id=\"qodef-page-inner\"]/div/section[7]/div/div/div/div[2]/div/div/div/div/div[1]/div[1]/div[1]");
    By call = By.xpath("//*[@id=\"slick-slide00\"]/div/div/div/section/div[2]/div[1]/div/div[5]/div/div/a");

    public homepage(WebDriver driver) {
        this.driver = driver;
    }

        public void clickss() throws IOException, InterruptedException {
        System.out.println("Clicking on logo");
        driver.findElement(logo).click();
        boolean s = driver.findElement(logo).isDisplayed();
        if (s) {
            System.out.println("Logo Present");
        } else {
            System.out.println("Logo not present");
        }

        System.out.println("Clicking on service");
        driver.findElement(service).click();
        System.out.println("Clicking on Menu");
        driver.findElement(Menu).click();
        System.out.println("Clicking on gallery");
        driver.findElement(gallary).click();
        System.out.println("Clicking on home");
        driver.findElement(home).click();

        System.out.println("Clicking on call");
        driver.findElement(call).click();

        // Explicit wait for the alert to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increase the wait time to 20 seconds

        try {
            System.out.println("Waiting for alert to be present");
            Alert jsconfirm = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert is present");

            String actual1 = jsconfirm.getText();
            String expected1 = "https://www.blumebeauty.ca wants to open this application.";
            if (actual1.equals(expected1)) {
                System.out.println("pass(confirm)");
            } else {
                System.out.println("fail");
            }

            // To cancel the alert
            jsconfirm.dismiss();
        } catch (Exception e) {
            System.out.println("Alert not found: " + e.getMessage());
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(scrolldown));
        driver.findElement(arrow).click();
        WebElement w = driver.findElement(facebook);
        File src = w.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("./screenshot//facebook2.png"));
    }
}
