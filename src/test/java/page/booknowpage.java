package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class booknowpage {
    WebDriver driver;

    By firstname = By.xpath("//*[@id='input_2_1_3']");
    By lastname = By.xpath("//*[@id='input_2_1_6']");
    By email = By.xpath("//*[@id='input_2_3']");
    By phone = By.xpath("//*[@id='input_2_4']");
    By service = By.xpath("//*[@id='input_2_11']");
    By date = By.xpath("//*[@id='input_2_9']");
    By details = By.xpath("//*[@id='input_2_8']");
    By submit = By.xpath("//*[@id='gform_submit_button_2']");
    By hh = By.xpath("//*[@id='input_2_10_1']");
    By mm = By.xpath("//*[@id='input_2_10_2']");
    By am = By.xpath("//*[@id='input_2_10_3']");

    public booknowpage(WebDriver driver) {
        this.driver = driver;
    }

    public void setValue(String fname, String lname, String mail, String ph, String serviceText, String dte, String h, String m, String a, String detailss) {
        driver.findElement(firstname).sendKeys(fname);
        driver.findElement(lastname).sendKeys(lname);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(phone).sendKeys(ph);

        // Select service from dropdown
        Select serviceDropdown = new Select(driver.findElement(service));
        serviceDropdown.selectByVisibleText(serviceText);

        // Select AM/PM from dropdown
        Select amDropdown = new Select(driver.findElement(am));
        amDropdown.selectByVisibleText(a);

        driver.findElement(date).sendKeys(dte);
        driver.findElement(hh).sendKeys(h);
        driver.findElement(mm).sendKeys(m);
        driver.findElement(details).sendKeys(detailss);
    }

    public void submit() {
        driver.findElement(submit).click();
    }
}
