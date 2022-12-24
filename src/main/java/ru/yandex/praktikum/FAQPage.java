package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class FAQPage {
    private final WebDriver webDriver;
    //Список со всплывающими строками
    By listOfHideEl = By.xpath("//div[@class='Home_FAQ__3uVm4']/div/*");
    //Список локаторов появляющихся строк
    List<By> listOfLocator = Arrays.asList(By.id("accordion__panel-0"),
                                           By.id("accordion__panel-1"),
                                           By.id("accordion__panel-2"),
                                           By.id("accordion__panel-3"),
                                           By.id("accordion__panel-4"),
                                           By.id("accordion__panel-5"),
                                           By.id("accordion__panel-6"),
                                           By.id("accordion__panel-7"));

    public FAQPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public FAQPage isHiddenElementDisplayedAfterClick(){
        List<WebElement> listOfElements =  webDriver.findElements(listOfHideEl);
        for (int i=0; i < listOfElements.size(); i++){
            listOfElements.get(i).click();
            boolean isDisplayed = webDriver.findElement(listOfLocator.get(i)).isDisplayed();
            new WebDriverWait(webDriver, 3)
                    .until(ExpectedConditions.visibilityOf( webDriver.findElement(listOfLocator.get(i))));
            assertTrue(isDisplayed);
            //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        };
        return this;
    }
}
