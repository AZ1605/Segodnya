package homePageTests;

import baseTest.BaseTest;
import org.junit.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void SearchOnHomePage()  {
        loginPage.openLoginPage();
        loginPage.clickOnAlert();
        loginPage.clickOnDiscountPopUp();
    }
    @Test
    public void InterestedBookOnHomePage() {
        loginPage.openLoginPage();
        loginPage.chooseRandomBookOnLoginPage();
        bookPage.checkTitle();
        loginPage.clickOnDiscountPopUp();
        bookPage.AddBookToBasket();
    }
    @Test
    public void SelectInCatalogeOnHomePage() {
        loginPage.openLoginPage();
        homePage.chooseRandomItemInFirst();
        homePage.chooseRandomItemInSecond();
    }
    @Test
    public void AddingBookToBasketAndRemove() {
        loginPage.openLoginPage();
        loginPage.chooseRandomBookOnLoginPage();
        bookPage.checkTitle();
        bookPage.AddBookToBasket();
        loginPage.clickOnLogo();
        loginPage.clickOnBasket();
        basketPage.deleteFromBasket();
        basketPage.isEmptyMessageIsVisible();
        //loginPage.clickOnAlert();

    }

}
