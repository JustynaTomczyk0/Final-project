package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@title=\"Log in to your customer account\"]")
    private WebElement signIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector(".logo.img-fluid"),"mystore-testlab.coderslab.pl");
    }
    public void clickSingIn(){
        signIn.click();
    }

}
