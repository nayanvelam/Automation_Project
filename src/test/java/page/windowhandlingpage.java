package page;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class windowhandlingpage {

	WebDriver driver;
	By service=By.xpath("//*[@id=\"menu-main-menu-1\"]/li[2]/a");
	By facebook=By.xpath("//*[@id=\"elementor-library-2\"]/div/section/div/div/div/div[2]/div/div/span[1]/a");
	
	public windowhandlingpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void mousehover()
	{
		WebElement hover=driver.findElement(service);
		Actions act=new Actions(driver);
		act.moveToElement(hover).perform();		
		WebElement clicks = driver.findElement(service);
        clicks.click();
        
        JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(facebook));
	}
	public void windowhandling()
	{
		String parentwindow=driver.getWindowHandle();
		System.out.println("Parent Window Title ;"+driver.getTitle());
		driver.findElement(facebook).click();
		
		Set<String>allwindowhandle=driver.getWindowHandles();
		for(String handle:allwindowhandle)
		{
			System.out.println(handle);
			if(!handle.equals(parentwindow))
			{
				driver.switchTo().window(handle);
				//driver.findElement(By.xpath("//*[@id=\"login_popup_cta_form\"]/div/div[3]/div/label/div/div")).sendKeys("abc@gmail.com");
				//driver.findElement(By.xpath("//*[@id=\"login_popup_cta_form\"]/div/div[4]/div")).sendKeys("sample");
				//driver.findElement(By.xpath("//*[@id=\"login_popup_cta_form\"]/div/div[5]/div/div")).click();
				driver.close();
			}
			driver.switchTo().window(parentwindow);
		}
	}
}
