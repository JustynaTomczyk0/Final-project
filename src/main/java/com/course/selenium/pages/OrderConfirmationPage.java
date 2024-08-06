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
import java.nio.file.StandardCopyOption;

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
            Files.copy(screenshot.toPath(), new File(filePath+"screenshot.png").toPath());
            System.out.println("Screenshot has been saved as " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Screenshot has not been saved");
        }
    }
}
