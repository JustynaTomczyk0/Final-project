package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class LayerCard {

    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,\"btn btn-primary\") and contains(text(),\"Proceed to checkout\")]")
    WebElement ptcButton;

    public LayerCard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector("#myModalLabel"), "controller=product#/2-size-m");
    }

    public void ptc() {
        ptcButton.click();
    }
}

