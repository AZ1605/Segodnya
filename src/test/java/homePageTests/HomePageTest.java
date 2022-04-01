package homePageTests;
import baseTest.BaseTest;
import org.junit.Test;

import java.awt.*;

public class HomePageTest extends BaseTest {
    @Test
    public void SearchOnHomePage() throws AWTException {
        loginPage.openLoginPage();
        loginPage.clickOnAlert();
        loginPage.clickOnAlert2();
    }

    @Test
    public void InterestedBookOnHomePage() {
        loginPage.openLoginPage();
        loginPage.chooseRandomBookOnLoginPage();
        bookPage.checkTitle();
        bookPage.AddBookToBasket();
    }
    @Test
    public void SelectInCatalogeOnHomePage() {
        loginPage.openLoginPage();
        homePage.chooseRandomItemInFirst();
        homePage.chooseRandomItemInSecond();
    }
    @Test
    public void InterestedBookOnHomePage2() {
        loginPage.openLoginPage();
        loginPage.chooseRandomBookOnLoginPage();
        bookPage.checkTitle();
        bookPage.AddBookToBasket();
        loginPage.clickOnLogo();
        loginPage.clickOnBasket();
        //loginPage.clickOnCheckout();
        basketPage.deleteFromBasket();
        basketPage.isEmptyMessageIsVisible("Кошик порожній");
        //loginPage.clickOnAlert();

    }

}
