package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver webDriver;

    //Поле ввода имени
    private By nameInput = By.xpath("//div[@class='Order_Form__17u6u']/div[1]/input");
    //Поле ввода фамилии
    private By surnameInput = By.xpath("//div[@class='Order_Form__17u6u']/div[2]/input");
    //Поле ввода адреса
    private By addressInput = By.xpath("//div[@class='Order_Form__17u6u']/div[3]/input");
    //Поле ввода телефона
    private By phoneNumberInput = By.xpath("//div[@class='Order_Form__17u6u']/div[5]/input");
    //Поле выбора станции метро
    private By metroStationInput = By.className("select-search__input");
    //Выпадающий список станций метро
    private By metroStationChoice = By.className("select-search__select/*");
    //Кнопка "Далее"
    private final By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderPage enterName(String name){
        webDriver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public OrderPage enterSurname(String surname){
        webDriver.findElement(surnameInput).sendKeys(surname);
        return this;
    }

    public OrderPage enterAddress(String address){
        webDriver.findElement(addressInput).sendKeys(address);
        return this;
    }

    public OrderPage enterMetroStation(String metroStation){
        webDriver.findElement(metroStationInput).sendKeys(metroStation);
        webDriver.findElement(metroStationChoice).click();
        return this;
    }

    public OrderPage enterPhoneNumber(String number){
        webDriver.findElement(phoneNumberInput).sendKeys(number);
        return this;
    }

    public AboutRentPage clickOnNextButton(){
        webDriver.findElement(nextButton).click();
        return new AboutRentPage(webDriver);
    }

    public OrderPage fillingOutTheForm(String name, String surname, String address,
                                       String metroStation, String number){
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        enterMetroStation(metroStation);
        enterPhoneNumber(number);
        return this;
    }
}
