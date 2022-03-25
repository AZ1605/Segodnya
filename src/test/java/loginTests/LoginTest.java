package loginTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validLoginTest() {
        loginPage.openLoginPage();
        loginPage.clickOnButtonEnter();
        loginPage.enterLoginIntoLoginField("chillywillyshpili@ukr.net");
        loginPage.enterPasswordIntoPasswordField("Hvq53zzz");
        loginPage.clickOnButtonSubmit();
        Assert.assertTrue("UserName is not visible", homePage.isUserNameIsVisible());
    }
        @Test
        public void invalidLoginTest(){
            loginPage.openLoginPage();
            loginPage.clickOnButtonEnter();
            loginPage.enterLoginIntoLoginField("chillywillyshpili@ukr.net1");
            loginPage.enterPasswordIntoPasswordField("Hvq53zzz1");
            loginPage.clickOnButtonSubmit();
            loginPage.isAlertIsVisible();

    }

    }



