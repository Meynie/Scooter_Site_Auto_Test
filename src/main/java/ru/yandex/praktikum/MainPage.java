package ru.yandex.praktikum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class MainPage {
    private final WebDriver webDriver;

    //Вопросы о важном
    private By listOfHideEl = By.xpath("//div[@class='Home_FAQ__3uVm4']/div/*"); ////*[@id="root"]/div/div[1]/div[5]/div[2]/div
    //Верхняя кнопка "Заказать"
    private By topOrderButton = By.className("Button_Button__ra12g");
    //Нижняя кнопка "Заказать"
    private By lowerOrderButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button");
    //Кнопка "да все привыкли"
    private By closeCookieWindow = By.className("App_CookieButton__3cvqF");
    //Логтип "Самокат"
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    //Логотип "Яндекс"
    private By yandexLogo = By.className("Header_LogoYandex__3TSOI");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage openMainPage(){
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    public MainPage closeCookieWindow(){
        webDriver.findElement(closeCookieWindow).click();
        return this;
    }

    public FAQPage scrollMainPageForFAQPage (){
        WebElement element = webDriver.findElement(listOfHideEl);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return new FAQPage(webDriver);
    }

    public OrderPage clickTopOrderButton(){
        webDriver.findElement(topOrderButton).click();
        return new OrderPage(webDriver);
    }

    public MainPage scrollMainPageForLowerOrderButton(){
        WebElement element = webDriver.findElement(lowerOrderButton);
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public OrderPage clickLowerButton(){
        webDriver.findElement(lowerOrderButton).click();
        return new OrderPage(webDriver);
    }

    public void clickOnScooterLogo(){
        String correctUrl = "https://qa-scooter.praktikum-services.ru/";
        webDriver.findElement(scooterLogo).click();
        String pageUrl =  webDriver.getCurrentUrl();
        Assert.assertEquals(correctUrl, pageUrl);
    }

    public void clickOnYandexLogo(){
        String correctUrl = "https://dzen.ru/?yredirect=true";
        webDriver.findElement(yandexLogo).click();
        String mainWindowHandle = webDriver.getWindowHandle();
        Set<String> setOfChildWindow = webDriver.getWindowHandles();
        Iterator<String> i1 = setOfChildWindow.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                webDriver.switchTo().window(ChildWindow);
                String pageUrl = webDriver.getCurrentUrl();
                Assert.assertEquals(correctUrl, pageUrl);
            }
        }
    }
}
