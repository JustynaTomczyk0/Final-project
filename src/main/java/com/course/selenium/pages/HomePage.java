package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class HomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@title=\"Log in to your customer account\"]")
    private WebElement signIn;

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchEngine;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.cssSelector(".logo.img-fluid"),".coderslab");
    }
    public void clickSingIn(){
        signIn.click();
    }
    public void searchingProduct(String product){
        searchEngine.clear();
        searchEngine.sendKeys("Hummingbird Printed Sweater");
        searchEngine.sendKeys(Keys.RETURN);
    }

}
