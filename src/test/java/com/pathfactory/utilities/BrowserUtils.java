package com.pathfactory.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static WebElement waitForVisibility(WebElement element, int waitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }



    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elementTexts = new ArrayList<>();
        for (WebElement element : list) {
            if (!element.getText().isEmpty()) {
                elementTexts.add(element.getText());
            }
        }
        return elementTexts;
    }

    public static void selectFromDropdown(WebElement option, String text){
        Select select = new Select(option);
        select.selectByVisibleText(text);
    }
}
