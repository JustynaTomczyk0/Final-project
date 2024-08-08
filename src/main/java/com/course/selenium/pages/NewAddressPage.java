package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class NewAddressPage {

    @FindBy(css = "#field-alias")
    WebElement aliasField;

    @FindBy(css = "#field-address1")
    WebElement addressField;

    @FindBy(css = "#field-city")
    WebElement cityField;

    @FindBy(css = "#field-postcode")
    WebElement postCodeField;

    @FindBy(css = "#field-phone")
    WebElement phoneNumberField;

    @FindBy(css = ".btn-primary.form-control-submit.float-xs-right")
    WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//h1[contains(text(),\"New address\")]"), "index.php?controller=address");
    }

    public void enterAlias(String alias) {
        aliasField.sendKeys(alias);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void enterCity(String city) {
        cityField.sendKeys(city);
    }
    public void enterPostCode (String postCode){
        postCodeField.sendKeys(postCode);
    }
    public void enterPhoneNumber(String phone){
        phoneNumberField.sendKeys(phone);
    }

    public void clickSave(){
        saveButton.click();
    }
}
