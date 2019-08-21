package discoveryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonLibFunction;

/*
 * Thread.sleep just for user to notice the event.
 * User lands on Discovery.com home page
 * Scroll down and Up and perform assertion
 * */
public class DiscoveryHomePage {
	protected WebDriver driver;
	CommonLibFunction common;

	By DiscoveryText = By.xpath("//*[@id=\"mod-header-1\"]/div/div[1]/div");
	By scrollDown = By.linkText("Careers at Discovery"); 
	By careerDiscoveryText = By.xpath("//*[@id=\"mod-footer-1\"]/div/div/div/ul/li[8]/a");

	public DiscoveryHomePage(WebDriver driver)
	{
		this.driver = driver;
		common = new CommonLibFunction(this.driver);
	}

	public void verifyDiscoveryHomePage()
	{
		try {
			String title = driver.getTitle();
			System.out.println("Page Title is : "+title);
			(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(DiscoveryText));
		}catch(Exception e) {
			e.printStackTrace();
		} 

	}

	public void scrollDiscoveryPageDown() {
		try {
			Thread.sleep(3000);
			common.scrollIntoView(careerDiscoveryText);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}


	}

	public void scrollDiscoveryPageUP(){
		try {
			Thread.sleep(3000);
			common.scrollIntoView(DiscoveryText);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
