package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/* This file is to list out common functions.
 * Reuse them across the application.
 * Purpose is to achieve reusability.
 * */
public class CommonLibFunction {

	protected WebDriver driver;
	
	public CommonLibFunction(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void scrollIntoView(By text)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(text);
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		System.out.println(element.getText());
	}
	
	public void mouseOver(By element)
	{
		Actions action = new Actions(driver);
		WebElement more = driver.findElement(element);
		action.moveToElement(more).perform();
	}
	
	public void assertText(String t, String actualTitle)
	{
		Assert.assertEquals(t, actualTitle);
		System.out.println("Assertion is true for: " +t);
	}
	
	public void clickElement(By element)
	{
		
		 driver.findElement(element).click();
	}
	
}
