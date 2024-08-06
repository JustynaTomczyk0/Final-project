package com.course.selenium.helpers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

    private static final String url = "https://prod-course.coderslab.com/index.php?";

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    @Before
    public void setUp(){
        driverThreadLocal.set(new FirefoxDriver());
        WebDriver driver = driverThreadLocal.get();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void tearDown(){
        if(driverThreadLocal.get() != null){
            driverThreadLocal.get().quit();
        }

    }
}
