package homePageTests;
import baseTest.BaseTest;
import org.junit.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void SearchOnHomePage() {
        loginPage.openLoginPage();
       // homePage.checkSearchOnHomePage();
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
        loginPage.clickOnCheckout();

    }

}
