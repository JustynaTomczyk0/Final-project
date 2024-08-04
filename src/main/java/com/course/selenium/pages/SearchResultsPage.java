package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class SearchResultsPage {
    private final WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater')]")
    WebElement productName;


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//span[contains(text(),\"Search results\")]"),"search&s=Hummingbird+Printed+Sweater");
    }

    public void chooseProduct(){
        productName.click();

    }
}
