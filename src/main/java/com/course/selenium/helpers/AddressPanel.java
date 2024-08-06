package com.course.selenium.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
public class AddressPanel {

    public final String header;
    public final String content;

    public AddressPanel(WebElement root) {
        WebElement header = root.findElement(By.cssSelector(".address-body >h4"));
        List<WebElement> addressesList = root.findElements(By.cssSelector("address"));

        this.header = header.getText();
       // this.content = addressesList.toString().strip();

        StringBuilder sb = new StringBuilder();


        for (WebElement info : addressesList) {
            String infoText = info.getText().strip();
            if (!infoText.isEmpty()) {
                sb.append(infoText).append(" ");
            }
        }
        content = sb.toString().strip();

    }
}
