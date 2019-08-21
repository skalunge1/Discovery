package discoveryPage;

import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
 

public class DiscoveryBaseSetting {
	
 public WebDriver driver;
 static String driverPath = "";
 static String chromeFileName="";
 
 	
	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver() {
		
			driver = initChromeDriver();
			
	}

	private static WebDriver initChromeDriver() {
		
		WebDriver driver = null;
		
		try {
		System.out.println("Launching google chrome with new profile..");
		
		//Setting up the driver path and driver file name for different OS
		if(detectOS()== OSType.Windows) {
			driverPath="";
			chromeFileName="chromedriver.exe";
		}else {
			driverPath="";
			chromeFileName="chromedriver";
		}
		System.setProperty("webdriver.chrome.driver", driverPath
				+ chromeFileName);
		
		//See if chrome drive exist 
		File file = new File(driverPath + chromeFileName);

        if (file.exists()) {
        	System.out.println("Driver exists. Checking if dirver can be executed");
        	if (file.canExecute()) {
        		System.out.println("Driver is executable");
        	}else {
        		boolean bval = file.setExecutable(true, false);
        		System.out.println("set the execute permission: "+ bval);
        	}
        } else {
            System.out.println("Driver file cannot exists. Please copy the file in root folder of the program");
        }

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.discovery.com/");
		
		}catch(Exception e) {
			e.getMessage();
		}
		return driver;
	}
	

	
	
	@BeforeClass
	public void initializeTestBaseSetup() {
		System.out.println("initializeTestBaseSetup");
		try {
			setDriver();

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	public enum OSType {
		Windows, MacOS, Linux, Other
	};

	public static OSType detectOS() {
		
		OSType detectedOS;

		/**
		 * detect the operating system from the os.name System property and cache the
		 * result
		 * 
		 * @returns - the operating system detected
		 */

		String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
			detectedOS = OSType.MacOS;
		} else if (OS.indexOf("win") >= 0) {
			detectedOS = OSType.Windows;
		} else if (OS.indexOf("nux") >= 0) {
			detectedOS = OSType.Linux;
		} else {
			detectedOS = OSType.Other;
		}

		return detectedOS;
	}

}
