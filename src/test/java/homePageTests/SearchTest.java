package homePageTests;
import baseTest.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {
    @Test
    public void SearchOnHomePage() {
        loginPage.openLoginPage();
       // homePage.checkSearchOnHomePage();
    }

    @Test
    public void InterestedBookOnHomePage() {
        loginPage.openLoginPage();
        bookPage.chooseRandomBook();
        bookPage.checkIsBookIsVisible();
    }
}