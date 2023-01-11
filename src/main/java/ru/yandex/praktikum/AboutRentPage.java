package ru.yandex.praktikum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

import java.util.List;


public class AboutRentPage {
    private final WebDriver webDriver;

    //Заголовок "Про аренду"
    private By headerAboutRent = By.className("Order_Header__BZXOb");
    //Когда привезти самокат
    private By scooterRentalDate =By.xpath("//div[@class='react-datepicker__input-container']/input");
    //Поле выбора срока аренды
    private By rentalPeriod = By.xpath("//div[@class='Dropdown-control']/div[1]");
    //Выпадающий список срока аренды
    private By rentalPeriodChoice = By.xpath("//div[@class='Dropdown-menu']/*");
    //Список цветов самоката
    private By colorChoice = By.xpath("//div[@class='Order_Checkboxes__3lWSI']/label");
    //Комментарий для курьера
    private By commentForTheCourier = By.xpath("//div[@class='Order_Form__17u6u']/div[4]/input");
    //Кнопка "Заказать"
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[2]");
    //Кнопка подтверждения заказа
    private By yesButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[2]");
    //Окно с сообщением об успешном создании заказа
    private By successfulWindow = By.className("Order_Modal__YZ-d3");

    public AboutRentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public AboutRentPage choiceDateOfRent(String rentDate){
        webDriver.findElement(scooterRentalDate).sendKeys(rentDate);
        webDriver.findElement(headerAboutRent).click();
        return this;
    }

    public AboutRentPage choiceRentalPeriod(int period){
        webDriver.findElement(rentalPeriod).click();
        List<WebElement> listOfElements = webDriver.findElements(rentalPeriodChoice);
        listOfElements.get(period).click();
        return this;
    }

    public AboutRentPage choiceScooterColor(int colorNumber){
        List<WebElement> listOfColor = webDriver.findElements(colorChoice);
        listOfColor.get(colorNumber).click();
        return this;
    }

    public AboutRentPage getCommentForTheCourier(String comment){
        webDriver.findElement(commentForTheCourier).sendKeys(comment);
        return this;
    }

    public AboutRentPage fillOutTheRentalForm(String rentDate, int period, int colorNumber, String comment){
        choiceDateOfRent(rentDate);
        choiceRentalPeriod(period);
        choiceScooterColor(colorNumber);
        getCommentForTheCourier(comment);
        return this;
    }

    public AboutRentPage clickOrderButton(){
        webDriver.findElement(orderButton).click();
        return this;
    }

    public AboutRentPage clickOnYesButton(){
        webDriver.findElement(yesButton).click();
        return this;
    }

    public AboutRentPage successfulWindowIsDisplayed(){
        boolean isDisplayed = webDriver.findElement(successfulWindow).isDisplayed();

        Assert.assertTrue(isDisplayed);
        //assertTrue(isDisplayed);
        return this;
    }
}
