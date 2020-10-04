package com.vervesquare.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vervesquare.qa.base.TestBase;
import com.vervesquare.qa.util.TestUtil;

public class FlightPage extends TestBase {
	TestUtil tu;
	WebDriverWait wait = new WebDriverWait(driver, 10);
	@FindBy(xpath="//span[contains(text(),'Flights')]")
	WebElement flightTabButton;
	
	@FindBy(id="RoundTrip")
	WebElement roundTrip;
	
	@FindBy(id="FromTag")
	WebElement from;
	
	@FindBy(name="destination")
	WebElement destination;
	
	@FindBy(id="Adults")
	WebElement adult;

	@FindBy(id="SearchBtn")
	WebElement bookFlightButton;
	
	
	public FlightPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickOnRoundTrip() {
		roundTrip.click();
	}
	
	public void setDeparture(String DepartureLocation){
		from.sendKeys(DepartureLocation);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-1']")));
		from.sendKeys(Keys.ENTER);
	}
	
	public void setArrival(String ArrivalLocation) {
		destination.sendKeys(ArrivalLocation);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-2']")));
		destination.sendKeys(Keys.ENTER);
	}
	
	public void setDate() {
		
		try {
		tu = new TestUtil();
		int departureDate = tu.setDate5DaysFromToday();
		int arrivalDate = tu.setDate6DaysFromToday();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-month='9']//a[contains(text(),'"+departureDate+"')]")));
		driver.findElement(By.xpath("//td[@data-month='9']//a[contains(text(),'"+departureDate+"')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-month='9']//a[contains(text(),'"+arrivalDate+"')]")));
		driver.findElement(By.xpath("//td[@data-month='9']//a[contains(text(),'"+arrivalDate+"')]")).click();
		}catch(StaleElementReferenceException se) {
			driver.navigate().refresh();
			int departureDate = tu.setDate5DaysFromToday();
			int arrivalDate = tu.setDate6DaysFromToday();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-month='9']//a[contains(text(),'"+departureDate+"')]")));
			driver.findElement(By.xpath("//td[@data-month='9']//a[contains(text(),'"+departureDate+"')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-month='9']//a[contains(text(),'"+arrivalDate+"')]")));
			driver.findElement(By.xpath("//td[@data-month='9']//a[contains(text(),'"+arrivalDate+"')]")).click();
			
		}
	}
	
	public void SetAdult(String adultCount) {
		Select select = new Select(adult);
		select.selectByValue(adultCount);
	}
	
	public SelectFlight clickOnBookFlight() {
		bookFlightButton.click();
		return new SelectFlight();
		
	}

}
