package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class AccountPage {
    private final WebDriver driver;

    @FindBy(css = "#addresses-link")
    WebElement addressButton;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//h1[contains(text(),\"Your account\")]"), "/index.php?controller=my-account");
    }

    public void clickAddresses(){
        addressButton.click();
    }


}
