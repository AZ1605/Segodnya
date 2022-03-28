package homePageTests;
import baseTest.BaseTest;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.ScreenshotException;


public class HomePageTest extends BaseTest {
    @Test
    //@ExtendWith({ScreenshotException.class})

    public void SearchOnHomePage() {
        loginPage.openLoginPage();
        homePage.checkSearchOnHomePage();
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
