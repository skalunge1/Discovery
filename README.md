# Cotents of the file
♣	Introduction
♣	Objective
♣	Installation & Configuration
♣	Instructions to run tests
♣	Reporting

1.	Introduction:
-	This project is to automate ‘https://www.discovery.com/’ .
-	This is a maven project with POM pattern & TestNG framework.

2.	Objective
-	Navigate to Discovery.com
-	Select two videos from recommended for you and add them to favourite list.
-	Go to my videos(https://www.discovery.com/my-videos) page and assert that the videos appear with the correct show title and description.

3.	Installation & Configuration
-	Install JDK 8 or 10, set JAVA_HOME.
-	Install ‘Eclipse’.
-	Create Maven Project.
-	Add selenium dependency, testing dependency & ‘maven-surefire-plugin’.
-	Create testng.xml & add test files to run it.

4.	Instructions to run tests
-	Open DiscoveryBaseSetting.java  
¬	Please download chromedriver.exe for Windows machine.
- Do not download chromedriver file for mac.Run as it is.

-	Right click on project: Run As ‘Maven build’
-	Right click on project: Run As ‘Maven clean’
-	Right click on project: Run As ‘Maven install’
-	Right click on project: Run As ‘Maven test’
-	Right click on testng.xml: Run As ‘TestNG Suite’

5.	Reporting
-	After running testng.xml, check test-output emailable-report.html 
-	emailable-report.html right click & open in browser

