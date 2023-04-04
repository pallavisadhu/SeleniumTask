package tests;

import org.testng.annotations.AfterMethod;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ReadConfigs.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	ConfigFileReader cfr;
	
	@BeforeSuite
	public void initialize() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		cfr = new ConfigFileReader();
		driver.get(cfr.getUrl());
		
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Test Started");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Test Exited");
	}
	
	/*@AfterSuite
	public void tearDown() {
		driver.quit();
	}*/

}
