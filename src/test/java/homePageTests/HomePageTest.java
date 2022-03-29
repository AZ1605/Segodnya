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
        bookPage.chooseRandomBook();
        bookPage.checkTitle();
        bookPage.AddBookToBasket();
    }
    @Test
    public void SelectInCatalogeOnHomePage() {
        loginPage.openLoginPage();
        homePage.chooseRandomItemInMenu();
//        homePage.chooseRandomItemInSecondMenu();
//        bookPage.checkIsSectionTitleIsVisible();

    }
    @Test
    public void InterestedBookOnHomePage2() {
        loginPage.openLoginPage();
        bookPage.chooseRandomBook();
        bookPage.checkTitle();
        bookPage.AddBookToBasket();
    }

}
