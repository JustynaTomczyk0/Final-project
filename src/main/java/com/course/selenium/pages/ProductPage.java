package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class ProductPage {

    private final WebDriver driver;

    @FindBy(id = "group_1")
    private WebElement dropdownArrow;

    @FindBy(id = "quantity_wanted")
    WebElement quantityField;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//h1[contains(text(), \"Hummingbird printed sweater\")]"), "product=2&id_product_attribute");
    }

    public void selectSize(String size) {
        Select dropdown = new Select(dropdownArrow);
        dropdown.selectByVisibleText(size);
    }

    public void selectQuantity(int quantity) {
        String quantityString = String.valueOf(quantity);
        quantityField.sendKeys(quantityString);
    }

    public void clearField() {
        quantityField.click();
        quantityField.sendKeys(Keys.CONTROL + "a");
        quantityField.sendKeys(Keys.DELETE);
    }

    public void addToCart() {
        addToCartButton.click();
    }
}

