package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class ShoppingCart {
    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(@class,\"btn btn-primary\") and contains(text(),\"Proceed to checkout\")]")
    WebElement proceedToCheckoutButton;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//*[contains(text(),\"Shopping Cart\")]"), "=cart&action=show");
    }
    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }

}
