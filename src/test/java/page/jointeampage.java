package page;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class jointeampage {
    WebDriver driver;

    By hairstyle = By.xpath("//*[@id=\"qodef-page-content\"]/div/div/div/section/div/div/div/section/div/div/div/section[1]/div/div/div/div[5]/div/div/div[1]");
    By apprentice = By.xpath("//*[@id=\"qodef-page-content\"]/div/div/div/section/div/div/div/section/div/div/div/section[1]/div/div/div/div[5]/div/div/div[2]");    
    By technician = By.xpath("//*[@id=\"qodef-page-content\"]/div/div/div/section/div/div/div/section/div/div/div/section[1]/div/div/div/div[5]/div/div/div[3]");

    By firstname = By.xpath("//*[@id=\"input_1_1_3\"]");
    By lastname = By.xpath("//*[@id=\"input_1_1_6\"]");
    By email = By.xpath("//*[@id=\"input_1_7\"]");
    By phone = By.xpath("//*[@id=\"input_1_8\"]");
    By address = By.xpath("//*[@id=\"input_1_13_1\"]");

    By city = By.xpath("//*[@id=\"input_1_13_3\"]");
    By postalcode = By.xpath("//*[@id=\"input_1_13_5\"]");
    By province = By.xpath("//*[@id=\"input_1_13_4\"]");
    By information = By.xpath("//*[@id=\"input_1_12\"]");
    By file = By.xpath("//*[@id=\"input_1_10\"]");
    By submit = By.xpath("//*[@id=\"gform_submit_button_1\"]");
    
    public jointeampage(WebDriver driver) {
        this.driver = driver;
    }

    public void test() throws AWTException {
        driver.findElement(By.xpath("//*[@id=\"input_1_10\"]")).click();
        fileupload("D:\\dochhh.pdf");
    }

    public void fileupload(String p) throws AWTException {
        // to copy path to clipboard
        StringSelection s = new StringSelection(p);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

        // to paste in system window
        Robot robot = new Robot();
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public void setvalues(String fname, String lname, String mail, String ph, String addrs, String City, String Postal, String Province, String filee, String info) throws AWTException {
        driver.findElement(firstname).sendKeys(fname);
        driver.findElement(lastname).sendKeys(lname);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(phone).sendKeys(ph);
        driver.findElement(address).sendKeys(addrs);
        driver.findElement(city).sendKeys(City);
        driver.findElement(postalcode).sendKeys(Postal);

        Select dropdown = new Select(driver.findElement(province));
        dropdown.selectByVisibleText(Province);

        fileupload(filee);

        driver.findElement(information).sendKeys(info);
        // file input is already handled by fileupload, so you don't need this line
        // driver.findElement(file).sendKeys(filee);
    }

    public void submit() {
        driver.findElement(submit).click();
        System.out.println("Data addedd successfully");
    }
}
