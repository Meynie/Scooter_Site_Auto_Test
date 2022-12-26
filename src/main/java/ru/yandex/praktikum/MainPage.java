package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
}
