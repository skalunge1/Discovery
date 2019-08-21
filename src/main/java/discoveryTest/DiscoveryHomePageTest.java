package discoveryTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import discoveryPage.DiscoveryBaseSetting;
import discoveryPage.DiscoveryHomePage;


public class DiscoveryHomePageTest extends DiscoveryBaseSetting {
	
	private WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		System.out.println("setup");
		driver = getDriver();
	}
	
	@Test
	public void verifyDiscoveryHomePage() throws InterruptedException
	{
		System.out.println("Verify Discovery Home page test...");
		DiscoveryHomePage basePage = new DiscoveryHomePage(driver);
		basePage.verifyDiscoveryHomePage();
		basePage.scrollDiscoveryPageDown();
		basePage.scrollDiscoveryPageUP();
	}

}
