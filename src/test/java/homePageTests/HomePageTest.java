package homePageTests;

import baseTest.BaseTest;
import org.junit.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void SearchOnHomePage() throws InterruptedException {
        loginPage.openLoginPage();
        Thread.sleep(5000);
        loginPage.clickOnPopUp();
        loginPage.clickOnDiscountPopUp();
        homePage.checkSearchOnHomePage();
        bookPage.checkCountOfBooks2();

    }
    @Test
    public void InterestedBookOnHomePage() throws InterruptedException {
        loginPage.openLoginPage();
        Thread.sleep(5000);
        loginPage.clickOnPopUp();
        loginPage.chooseRandomBookOnLoginPage();
        bookPage.checkTitle();
        loginPage.clickOnPopUp();
        bookPage.AddBookToBasket();
    }
    @Test
    public void SelectInCatalogeOnHomePage() throws InterruptedException {
        loginPage.openLoginPage();
        Thread.sleep(5000);
        loginPage.clickOnPopUp();
        loginPage.clickOnDiscountPopUp();
        homePage.chooseRandomItemInFirst();
        homePage.chooseRandomItemInSecond();
    }
    @Test
    public void AddingBookToBasketAndRemove() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.chooseRandomBookOnLoginPage();
        Thread.sleep(1000);
        bookPage.checkTitle();
        bookPage.AddBookToBasket();
        loginPage.clickOnLogo();
        loginPage.clickOnBasket();
        basketPage.deleteFromBasket();
        basketPage.isEmptyMessageIsVisible();
    }

}
