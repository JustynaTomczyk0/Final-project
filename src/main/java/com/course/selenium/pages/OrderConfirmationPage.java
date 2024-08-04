package com.course.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class OrderConfirmationPage {

    private final WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//span[contains(text(),\"Order confirmation\")]"), "controller=order-confirmation");
    }

    public void takeScreenshot(WebDriver driver, String filePath) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), Paths.get(filePath));
            System.out.println("Screenshot został zapisany jako " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Screenshot nie został zapisany");
        }
    }
}
