package scootertests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.MainPage;

@RunWith(Parameterized.class)
public class ScooterOrderTest extends TestBase {
    private final String surnameInput;
    private final String nameInput;
    private final String addressInput;
    private final String metroStation;
    private final String numberInput;
    private final String rentDate;
    private final int rentalPeriod;
    private final int colorChoice;
    private final String comment;

    public ScooterOrderTest(String nameInput,
                            String surnameInput,
                            String addressInput,
                            String metroStation,
                            String numberInput,
                            String rentDate,
                            int rentalPeriod,
                            int colorChoice,
                            String comment) {
        this.nameInput = nameInput;
        this.surnameInput = surnameInput;
        this.addressInput = addressInput;
        this.metroStation = metroStation;
        this.numberInput = numberInput;
        this.rentDate = rentDate;
        this.rentalPeriod = rentalPeriod;
        this.colorChoice = colorChoice;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getUserData() {
        return new Object[][]{
                {"Иван", "Иванов", "ул.Колобкова, д.88", "Красносельская", "89995553535",
                        "30.12.2022", 1, 1, "Позвонить перед доставкой"},
                {"Наталья", "Пирожкова", "ул.Сушанская, д.21а", "Технопарк", "89912228134",
                        "02.01.2023", 0, 0, "Оставить у подъезда"},
        };
    }

    @Test
    public void scooterOrderCheckWithTopButton(){
        new MainPage(driver)
                .openMainPage()
                .clickTopOrderButton()
                .fillingOutTheForm(nameInput, surnameInput, addressInput, metroStation, numberInput)
                .clickOnNextButton()
                .fillOutTheRentalForm(rentDate, rentalPeriod, colorChoice, comment)
                .clickOrderButton()
                .clickOnYesButton();
    }

    @Test
    public void scooterOrderCheckWithLowerButton(){
        new MainPage(driver)
                .openMainPage()
                .scrollMainPageForLowerOrderButton()
                .clickLowerButton()
                .fillingOutTheForm(nameInput, surnameInput, addressInput, metroStation, numberInput)
                .clickOnNextButton()
                .fillOutTheRentalForm(rentDate, rentalPeriod, colorChoice, comment)
                .clickOrderButton()
                .clickOnYesButton();
    }
}
