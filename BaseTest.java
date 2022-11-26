package com.banking.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import com.banking.pageobjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginPage;
	Properties prop = new Properties();
//	EdgeOptions options=new EdgeOptions();
	

	@BeforeMethod(alwaysRun=true)
	public void initializeDriver() throws IOException {
		FileInputStream globalDataFile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\java\\main\\com\\banking\\resources\\GlobalData.properties");
		prop.load(globalDataFile);
//		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\Eclipse workspace\\BankingProject\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		launchApplication(prop.getProperty("url"));

	}

	public LoginPage launchApplication(String url) {
		loginPage = new LoginPage(driver);
		loginPage.goToWebsite(url);
		return loginPage;
	}
	
	//To take screenshot
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination= new File(System.getProperty("user.dir")+"\\Screenshots"+testCaseName+".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"\\Screenshots"+testCaseName+".png";
	}

//	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
