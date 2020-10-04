package com.vervesquare.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.vervesquare.qa.util.TestUtil;

public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
	
		try {
			FileInputStream input = new FileInputStream("C:\\Users\\1029255\\eclipse-workspace\\verveSquareInterview\\src\\main\\java\\com\\vervesquare\\qa\\config\\config.properties");
			prop =  new Properties();
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initilization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\1029255\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT,TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
		}
	}
	

}
