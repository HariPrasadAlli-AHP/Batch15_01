package com.tutorialNinja01.ninja01;

import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;

	public AddressPage(WebDriver driver, Properties prop) throws Exception {
		this.driver = driver;
		this.prop = prop;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='My Account' and @class='hidden-xs hidden-sm hidden-md']")
	WebElement MyAccountMenu;

	@FindBy(xpath = "//*[text()='Register']")
	WebElement RegisterMenu;

	@FindBy(name = "firstname")
	WebElement FirstNameTextField;

	@FindBy(id = "input-lastname")
	WebElement LastNameTextField;

	@FindBy(name = "email")
	WebElement EmailTextField;

	@FindBy(id = "input-telephone")
	WebElement TelephoneTextField;

	@FindBy(id = "input-password")
	WebElement PasswordTextField;

	@FindBy(id = "input-confirm")
	WebElement ConfirmPasswordTextField;

	@FindBy(name = "agree")
	WebElement CheckBoxOfAgree;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement ContinueButton;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement SuccessMessage;

	public void NavigateToRegistrationPage() {

		MyAccountMenu.click();
		RegisterMenu.click();
	}

	public void EnterRegistrationDetails() {
		
		FirstNameTextField.sendKeys("a");
		wait.until(ExpectedConditions.visibilityOf(LastNameTextField));
		wait.until(ExpectedConditions.elementToBeClickable(LastNameTextField)).sendKeys("a");
		wait.until(ExpectedConditions.visibilityOf(EmailTextField));
		wait.until(ExpectedConditions.elementToBeClickable(EmailTextField)).sendKeys("abc123lkjsssanssddkfn@gmail.com");
		wait.until(ExpectedConditions.visibilityOf(TelephoneTextField));
		wait.until(ExpectedConditions.elementToBeClickable(TelephoneTextField)).sendKeys("1234567890");
		wait.until(ExpectedConditions.visibilityOf(PasswordTextField));
		wait.until(ExpectedConditions.elementToBeClickable(PasswordTextField)).sendKeys("a!@#$%");
		wait.until(ExpectedConditions.visibilityOf(ConfirmPasswordTextField));
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmPasswordTextField)).sendKeys("a!@#$%");
	}

	public void SubmitRegistrationForm() {

		CheckBoxOfAgree.click();
		ContinueButton.click();

	}

	public String isSuccessAccountCreation() {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
			return element.getText().trim(); // Extract and return the text
		} catch (TimeoutException e) {
			return ""; // Return empty string if the element is not found
		}
	}

}
