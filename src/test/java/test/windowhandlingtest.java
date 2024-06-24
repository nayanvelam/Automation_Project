package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.windowhandlingpage;

public class windowhandlingtest {

	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
				
	}
	@BeforeMethod
	public void urlloading()
	{
		driver.get("https://www.blumebeauty.ca/");
		driver.manage().window().maximize();
	}
	@Test
	public void test()
	{
		windowhandlingpage wp=new windowhandlingpage(driver);
		wp.mousehover();
		wp.windowhandling();
	}
}
