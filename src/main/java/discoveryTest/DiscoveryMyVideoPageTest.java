package discoveryTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import discoveryPage.DiscoveryBaseSetting;
import discoveryPage.DiscoveryMyVideoPage;

public class DiscoveryMyVideoPageTest extends DiscoveryBaseSetting {


	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println("setup");
		driver = getDriver();
	}
	
	@Test
	public void verifyVideosFromMyVideoPage() throws Throwable
	{
		DiscoveryMyVideoPage myVideo = new DiscoveryMyVideoPage(driver);
		myVideo.mouseOverOnMore();
		System.out.println("Mouseover on More...");
		
		myVideo.selectMyVideo();
		System.out.println("Select video from 'VIDEOS YOU MIGHT LIKE' section...");
		
		myVideo.handleMyVideoWindowTab();
		System.out.println("MyVideo window get open in seperate tab...");
		
		myVideo.addTwoVideo();
		System.out.println(" Two videos are added in 'WATCH LATER' section & removed from 'WATCH LATER' section...");
	}
	
	
	
}
