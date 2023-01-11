package scootertests;

import org.junit.Test;
import ru.yandex.praktikum.MainPage;

public class CheckUrlTest extends TestBase{
    @Test
    public void checkScooterUrl(){
        new MainPage(driver)
                .openMainPage()
                .clickOnScooterLogo();
    }
    @Test
    public void checkYandexUrl(){
        new MainPage(driver)
                .openMainPage()
                .clickOnYandexLogo();
    }
}
