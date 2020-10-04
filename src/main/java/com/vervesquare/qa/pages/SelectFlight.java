package com.vervesquare.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vervesquare.qa.base.TestBase;

public class SelectFlight  extends TestBase{

	WebDriverWait wait = new WebDriverWait(driver, 30);
	@FindBy(xpath="//p[@xpath='1']")
	WebElement departFlight;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[12]/div[2]/div[1]/div[1]/div[29]/div[1]/div[2]/div[2]/div[5]/p[1]")
	WebElement arrivalFlight;
	
	
	@FindBy(xpath="//body/div[@id='root']/div[1]/main[1]/div[1]/div[1]/div[2]/div[2]/div[7]/div[1]/div[2]/button[1]")
	WebElement bookButton;
	
	public SelectFlight(){
		PageFactory.initElements(driver, this);
	}
	
	public void selectDepartFlight() {
		departFlight.click();
	}
	
	public void selectArrivalFlight() {
		arrivalFlight.click();
	}
	
	public ConfirmBooking clickOnBookButton() {
		wait.until(ExpectedConditions.elementToBeClickable(bookButton));
		bookButton.click();
		return new ConfirmBooking();
	}
	
}
