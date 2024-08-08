package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class LogInPage {

    @FindBy(id = "field-email")
    WebElement emailField;

    @FindBy(id = "field-password")
    WebElement passwordField;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//h1[contains(text(),\"Log in to your account\")]"), "=authentication&back=my-account");
    }

    public void typeEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void typePassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSignIn() {
        signInButton.click();
    }
}