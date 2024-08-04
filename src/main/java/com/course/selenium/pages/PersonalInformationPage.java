package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class PersonalInformationPage {

    private final WebDriver driver;

    @FindBy(xpath = "//button[@name=\"confirm-addresses\"]")
    WebElement confirmAddressButton;

    @FindBy(xpath = "//button[@name=\"confirmDeliveryOption\"]")
    WebElement confirmDeliveryOptionButton;

    @FindBy(id = "payment-option-1")
    WebElement payByCheckRadioButton;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement agreementButton;

    @FindBy(xpath = "//button[contains(@class,\"btn btn-primary center-block\") and contains(text(),\"Place order\")]")
    WebElement placeOrderButton;


    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.id("checkout-personal-information-step"), "index.php?controller=order");
    }

    public void confirmAddress() {
        confirmAddressButton.click();
    }

    public void confirmDeliveryOption() {
        confirmDeliveryOptionButton.click();
    }

    public void choosePayByCheck() {
        payByCheckRadioButton.click();
    }

    public void agreeToTerms() {
        agreementButton.click();
    }
    public void placeOrder(){
        placeOrderButton.click();
    }
}


