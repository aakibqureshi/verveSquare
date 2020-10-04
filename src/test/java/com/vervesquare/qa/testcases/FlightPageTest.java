package com.vervesquare.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vervesquare.qa.base.TestBase;
import com.vervesquare.qa.pages.ConfirmBooking;
import com.vervesquare.qa.pages.FlightPage;
import com.vervesquare.qa.pages.SelectFlight;

public class FlightPageTest extends TestBase {
	
	FlightPage fpt;
	SelectFlight selectFlight;
	ConfirmBooking conf;
	
	public FlightPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initilization();
		fpt = new FlightPage();
	}
	
	@Test
	public void automateVerveSquareScenario() throws InterruptedException {
		
		fpt.clickOnRoundTrip();
		fpt.setDeparture(prop.getProperty("departure"));
		fpt.setArrival(prop.getProperty("arrival"));
		fpt.setDate();
		fpt.SetAdult("2");
		selectFlight = fpt.clickOnBookFlight();
		conf = selectFlight.clickOnBookButton();
		conf.clickOnContinue();
		conf.fillEmailandContinue(prop.getProperty("email"));
		conf.fillTravelersDetailsAndContinue(prop.getProperty("pessangerName1"), prop.getProperty("pessangerLastName1"), 
				prop.getProperty("nationality"), prop.getProperty("pessangerName2"), 
				prop.getProperty("pessangerLastName2"), prop.getProperty("mobile"));
		Thread.sleep(1000);
		boolean flag = conf.ClickOnNetBankingandVeriFyKotakBankLogo();
		Assert.assertTrue(flag);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
