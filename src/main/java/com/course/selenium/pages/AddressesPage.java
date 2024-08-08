package com.course.selenium.pages;

import com.course.selenium.helpers.AddressPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.course.selenium.helpers.Helpers.waitForPageLoaded;

public class AddressesPage {

    @FindBy(xpath = "//span[contains(text(),\"Create new address\")]")
    WebElement createNewAccountButton;

    @FindBy(css = ".address-body")
    private List<WebElement> yourAddresses;

    public AddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitForPageLoaded(driver, By.xpath("//h1[contains(text(),\"Your addresses\")]"), "index.php?controller=addresses");
    }

    public void createNewAddress(){
        createNewAccountButton.click();
    }
    public Map<String, String> getAddressesByAlias() {
        Map<String, String> addressesByAlias = new HashMap<>();
        for (WebElement address : yourAddresses) {
            AddressPanel addressPanel = new AddressPanel(address);
            addressesByAlias.put(addressPanel.header, addressPanel.content);
        }
        return addressesByAlias;
    }
}
