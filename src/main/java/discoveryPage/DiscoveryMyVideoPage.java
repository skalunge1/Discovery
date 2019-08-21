package discoveryPage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonLibFunction;

/*
 * Thread.sleep just for user to notice the event.
 * User goto Video You might like section.
 * Select two video and add the 'WATCH LATER' section & perform assertion on it.
 * User removes added video.
 * */
public class DiscoveryMyVideoPage {

	protected WebDriver driver;


	By moreText = By.xpath("//span[contains(text(), 'More')]");
	By dropdownSubMenu = By.xpath("//*[@id=\"mod-header-1\"]/div/div[9]/div/div/ul[1]/li");
	By MyVideoOption = By.xpath("//*[@id=\"mod-header-1\"]/div/div[9]/div/div/ul[1]/li[2]/a");

	//Second video from WATCH LATER SECTION

	By mouseOverSecondVideoYouLike = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[2]/section[1]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[2]");
	By linkAddToWatchLater2 = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[2]/section[1]/div/div/div[1]/div[1]/div[2]/div/div[1]/div[2]/div/a/div/button/i");
	By watchLaterText2 = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[1]/section[3]/div/h2");

	By videoTitle2 = By.xpath("//div[@class = \"overlayLower overlayInner__overlayLower\"]/h4/div");
	By videoDescription2 = By.xpath("//div[@class = \"overlayInner__overlayDescription description\"]");
	By contactScroll2 = By.xpath("//div[@class = \"thumbnailTile__titleLineClamp\"]");

	//Second video from WATCH LATER SECTION 
	By watchLaterTitle2 = By.xpath("//h2[contains(text(), 'Watch Later')]");

	By secondVideoBlock = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[1]/section[3]/div/div/div/div[1]/div/div/div/div[1]/div[2]");
	By watchLaterSecondAddedVideoTitle = By.xpath("//h4[@class = \"overlayInner__title\"]/div[contains(text(), 'Start Up or Die Trying')]");
	By watchLaterSecondAddedVideoDesc = By.cssSelector(".overlayInner__overlayDescription.description");
	By removeSecondAddedWatchLaterVideo = By.xpath("//span[contains(text(), 'Remove from Watch Later')]");

	//First video from WATCH LATER SECTION
	By videosYouLikeText = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[2]/section[1]/h2/div[1]");
	By mouseOverVideoYouLike = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[2]/section[1]/div/div/div[1]/div[1]/div[1]/div/div[1]/div[2]");
	By linkAddToWatchLater = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[2]/section[1]/div/div/div[1]/div[1]/div[1]/div/div[1]/div[2]/div/a/div/button/i");
	By watchLaterText = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[1]/section[3]/div/h2");
	By videoTitle = By.xpath("//div[@class = \"overlayLower overlayInner__overlayLower\"]/h4/div");
	By videoDescription = By.xpath("//div[@class = \"overlayInner__overlayDescription description\"]");
	By contactScroll = By.xpath("//div[@class = \"thumbnailTile__titleLineClamp\"]");

	//First video from WATCH LATER SECTION 
	By watchLaterTitle = By.xpath("//h2[contains(text(), 'Watch Later')]");
	By firstVideoBlock = By.xpath("//*[@id=\"react-root\"]/div/div[1]/div[3]/main/div/div[1]/section[3]/div/div/div/div[1]/div/div/div/div[1]/div[2]");
	By watchLaterFirstAddedVideoTitle = By.xpath("//h4[@class = \"overlayInner__title\"]/div[contains(text(), 'Declassified Breakthrough')]");
	By watchLaterFirstAddedVideoDesc = By.cssSelector(".overlayInner__overlayDescription.description");
	By removeAddedWatchLaterVideo = By.xpath("//span[contains(text(), 'Remove from Watch Later')]");


	// Add two video section
	By allRecommendedVideo = By.cssSelector(".content.carousel__content.thumbnailCarousel__content");
	By listOfRecommendedVideo = By.cssSelector(".carousel-tile-wrapper.carousel__tileWrapper");


	String watchlater= "WATCH LATER";
	CommonLibFunction common;

	public DiscoveryMyVideoPage(WebDriver driver)
	{
		this.driver = driver;
		common = new CommonLibFunction(this.driver);
	}

	public void mouseOverOnMore() throws InterruptedException
	{
		//Mouseover on submit button
		/*Actions action = new Actions(driver);
		WebElement more = driver.findElement(moreText);
		action.moveToElement(more).perform();*/

		common.mouseOver(moreText);
		Thread.sleep(3000);
		

	}

	public void selectMyVideo()
	{
		try {
			WebElement select = driver.findElement(dropdownSubMenu);
			List<WebElement> options = select.findElements(MyVideoOption);
			System.out.println("Dropdown options : "+options);
			for (WebElement option : options) {

				if("My Videos".equals(option.getText()))
					option.click();   
				Thread.sleep(3000);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void handleMyVideoWindowTab()
	{
		try {
			String parentWindowHandle = driver.getWindowHandle();
			System.out.println("Parent window's handle -> " + parentWindowHandle);

			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void addFirstRecommendedVideo()
	{
		try {
			common.scrollIntoView(videosYouLikeText);
			Thread.sleep(3000);

			common.mouseOver(mouseOverVideoYouLike);
			Thread.sleep(3000);
			driver.findElement(linkAddToWatchLater).click();
			common.scrollIntoView(watchLaterText);
			String watchLaterText = driver.findElement(watchLaterTitle).getText();
			common.assertText(watchLaterText,watchlater);

			Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void verifyFirstRecommendedVideo()
	{
		try {
			common.mouseOver(firstVideoBlock);
			Thread.sleep(4000);

			String firstVideoTitleBeforeAdding = driver.findElement(videoTitle).getText();
			String firstAddedVideoTitle = driver.findElement(watchLaterFirstAddedVideoTitle).getText();
			common.assertText(firstAddedVideoTitle,firstVideoTitleBeforeAdding);
			

			String firstVideoDescriptionBeforeAdding  = driver.findElement(videoDescription).getText();
			System.out.println(firstVideoDescriptionBeforeAdding);

			String firstAddedVideoDescription = driver.findElement(watchLaterFirstAddedVideoDesc).getText();
			System.out.println(firstAddedVideoDescription);
			common.assertText(firstAddedVideoDescription,firstVideoDescriptionBeforeAdding);

			common.clickElement(removeAddedWatchLaterVideo);
			System.out.println("First added video got removed from 'WATCH LATER' section successfully!!");

			common.scrollIntoView(videosYouLikeText);
			Thread.sleep(4000);
		}catch(Exception e){
			e.printStackTrace();
		}


	}

	public void addSecondRecommendedVideo()
	{
		try {
			common.scrollIntoView(videosYouLikeText);
			Thread.sleep(3000);

			common.mouseOver(mouseOverSecondVideoYouLike);
			Thread.sleep(3000);
			driver.findElement(linkAddToWatchLater2).click();
			common.scrollIntoView(watchLaterText);
			Thread.sleep(4000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySecondRecommendedVideo()
	{
		try {
			common.mouseOver(secondVideoBlock);
			Thread.sleep(4000);

			String secondVideoTitleBeforeAdding = driver.findElement(videoTitle2).getText();
			String secondAddedVideoTitle = driver.findElement(watchLaterSecondAddedVideoTitle).getText();
			common.assertText(secondAddedVideoTitle,secondVideoTitleBeforeAdding);

			String secondVideoDescriptionBeforeAdding  = driver.findElement(videoDescription2).getText();
			System.out.println(secondVideoDescriptionBeforeAdding);

			String secondAddedVideoDescription = driver.findElement(watchLaterSecondAddedVideoDesc).getText();
			System.out.println(secondAddedVideoDescription);
			common.assertText(secondAddedVideoDescription,secondVideoDescriptionBeforeAdding);

			common.clickElement(removeSecondAddedWatchLaterVideo);
			System.out.println("Second added video got removed from 'WATCH LATER' section successfully!!");

			common.scrollIntoView(videosYouLikeText);
			Thread.sleep(4000);
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

	public void addTwoVideo()
	{
		WebElement select = driver.findElement(allRecommendedVideo);
		List<WebElement> options = select.findElements(listOfRecommendedVideo);
		System.out.println("List options from 'VIDEOS YOU MIGHT LIKE' : "+options);
		int listSize = options.size();
		System.out.println("Recommended video total number : "+listSize);


		try {
			addFirstRecommendedVideo();
			verifyFirstRecommendedVideo();
			addSecondRecommendedVideo();
			verifySecondRecommendedVideo();

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
