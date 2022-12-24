package scootertests;

import org.junit.Test;
import ru.yandex.praktikum.MainPage;

public class CheckDropdownListTest extends TestBase {
    @Test
    public void checkMainPage(){
         new MainPage(driver)
                .openMainPage()
                .closeCookieWindow()
                .scrollMainPageForFAQPage()
                .isHiddenElementDisplayedAfterClick();
    }
}
