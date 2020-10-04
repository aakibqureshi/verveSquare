package com.vervesquare.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vervesquare.qa.base.TestBase;

public class ConfirmBooking extends TestBase {
	
	Select select;

	@FindBy(xpath = "//input[@id='itineraryBtn']")
	WebElement continueBookingButton;

	@FindBy(xpath = "//input[@id='username']")
	WebElement emailIdText;

	@FindBy(xpath = "//input[@id='LoginContinueBtn_1']")
	WebElement clickOnContinue;

	@FindBy(xpath = "//input[@name='AdultFname1']")
	WebElement passengerFirstName1;

	@FindBy(xpath = "//input[@name='AdultLname1']")
	WebElement passengerLastName1;

	@FindBy(xpath = "//input[@name='AdultFname2']")
	WebElement passengerFirstName2;

	@FindBy(xpath = "//input[@name='AdultLname2']")
	WebElement passengerLastName2;

	@FindBy(xpath ="(//input[@placeholder='Nationality'])[1]")
	WebElement nationalitytextBox;

	@FindBy(xpath = "(//input[@placeholder='Nationality'])[2]")
	WebElement nationalitytextbox;

	@FindBy(xpath = "(//input[@id='mobileNumber'])[1]")
	WebElement mobileNumber1;
	
	@FindBy(xpath = "//input[@id='travellerBtn']")
	WebElement continueButton;
	
	@FindBy(xpath = "//select[@name='AdultTitle1']")
	WebElement title1;
	@FindBy(xpath = "//select[@name='AdultTitle2']")
	WebElement title2;
	
	@FindBy(xpath = "//select[@name='AdultDobDay1']")
	WebElement day1;
	
	@FindBy(xpath = "//select[@name='AdultDobMonth1']")
	WebElement month1;
	
	@FindBy(xpath = "//select[@name='AdultDobYear1']")
	WebElement year1;
	
	@FindBy(xpath = "//select[@name='AdultDobDay2']")
	WebElement day2;
	
	@FindBy(xpath = "//select[@name='AdultDobMonth2']")
	WebElement month2;
	
	@FindBy(xpath = "//select[@name='AdultDobYear2']")
	WebElement year2;
	
	@FindBy(xpath = "//h6[contains(text(),'Enter your credit card details')]")
	WebElement paymentPage;
	
	@FindBy(xpath = "//a[contains(text(),'Net Banking')]")
	WebElement netBankingIcon;
	
	
	@FindBy(xpath = "//span[@class=\"bankLogo truncate kotak_bank\"]")
	WebElement kotakBankLogo;
	
	
	
	
	
	WebDriverWait wait = new WebDriverWait(driver, 10);

	public ConfirmBooking() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnContinue() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		continueBookingButton.click();
	}

	public void fillEmailandContinue(String email) {
		emailIdText.sendKeys(email);
		clickOnContinue.click();
	}

	public void fillTravelersDetailsAndContinue(String FirstName, String lastname, String nationality, String FirstName1, String lastname1, String mobile) {
		wait.until(ExpectedConditions.visibilityOf(title1));
		select = new Select(title1);
		select.selectByValue("Mr");
		passengerFirstName1.sendKeys(FirstName);
		passengerLastName1.sendKeys(lastname);
		select = new Select(day1);
		select.selectByValue("25");
		select = new Select(month1);
		select.selectByValue("12");
		select = new Select(year1);
		select.selectByValue("1993");
		nationalitytextBox.sendKeys(nationality);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-1']")));
		nationalitytextBox.sendKeys(Keys.ENTER);
		select = new Select(title2);
		select.selectByValue("Mr");
		passengerFirstName2.sendKeys(FirstName1);
		passengerLastName2.sendKeys(lastname1);
		select = new Select(day2);
		select.selectByValue("23");
		select = new Select(month2);
		select.selectByValue("11");
		select = new Select(year2);
		select.selectByValue("1992");
		nationalitytextbox.sendKeys(nationality);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ui-id-2']")));
		nationalitytextbox.sendKeys(Keys.ENTER);
		mobileNumber1.sendKeys(mobile);
		continueButton.click();
		
	}
	
	public boolean ClickOnNetBankingandVeriFyKotakBankLogo() {
		wait.until(ExpectedConditions.visibilityOf(paymentPage));
		netBankingIcon.click();
		return kotakBankLogo.isDisplayed();
		
	}

}
