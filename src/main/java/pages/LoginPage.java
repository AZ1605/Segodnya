package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@name='login[username]']")
    private WebElement inputLogin;
    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement inputPassWord;
    @FindBy(xpath = "//button[@title='Увійти']")
    private WebElement submit;
    @FindBy(xpath = "//a[@class='show-modal-login']")
    private WebElement enterButton;
    @FindBy(xpath = "//div[@id='login-message-error']")
    private WebElement alertMessage;
    @FindBy(xpath = "//ul[@id='interest_products_list_homepage_neu_current']//li")
    private List<WebElement> randomInterestedBook;
    @FindBy(xpath = "//div[@class='wrap-logo']")
    private WebElement logoItem;
    @FindBy(xpath = "//div[@class='cart-top']")
    private WebElement basket;
    @FindBy(xpath = "//button[@class='close popup_cart_close']")
    private WebElement alert;
    @FindBy(xpath = "//div[@class='name']")
    private WebElement randomInterestedBookTitleOnHomepage;
    @FindBy(xpath = "//button[@class='close popup_cart_close']")
    private WebElement discountPopUp;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        try {
            webDriver.get("https://www.yakaboo.ua/");
            logger.info("Login page was opened");

        } catch (Exception e) {
            logger.error("Cant open login page" + e);//выводит в консоль и в файл
            Assert.fail("Cant open login page" + e);//выводит сообщение в отчеты
        }
    }

    public void clickOnButtonEnter() {
        ClickOnElement(enterButton);
    }

    public void enterLoginIntoLoginField(String login) {
        inputTextIntoElement(inputLogin, login);
    }

    public void enterPasswordIntoPasswordField(String password) {
        inputTextIntoElement(inputPassWord, password);
    }

    public void clickOnButtonSubmit() {
        ClickOnElement(submit);
    }

    public void printErrorAndStopTest(Exception e) { //method for exeptions
        logger.error("Cant work with element" + e);
        Assert.fail("Cant work with element" + e);
    }

    public HomePage loginWithValidCredits() {
        openLoginPage();
        clickOnButtonEnter();
        enterLoginIntoLoginField(TestData.VALID_LOGIN);
        enterPasswordIntoPasswordField(TestData.VALID_PASSWORD);
        clickOnButtonSubmit();
        return new HomePage(webDriver);
    }

    public LoginPage chooseRandomBookOnLoginPage() {
        clickOnRandomItem(randomInterestedBook);
        logger.info("Random Book was choosen");
        return this;
    }

    public LoginPage clickOnLogo() {
        logoItem.click();
        logger.info("Logo was clicked");
        return this;
    }

    public LoginPage clickOnBasket() {
        basket.click();
        logger.info("Basket was clicked");
        return this;
    }

    public LoginPage clickOnPopUp() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        WebElement buttonOk = webDriver.findElement(By.xpath("//*[@class=\"grv-dialog-host\"]")).getShadowRoot()
                .findElement(By.cssSelector("div > div > div.buttons-wrapper > button.sub-dialog-btn.allow_btn"));
        webDriverWait.until(ExpectedConditions.visibilityOf(buttonOk));
        buttonOk.click();
        return this;
    }

    public boolean checkIsAlertIsVisible() {
        Assert.assertFalse("Alert is not displayed", alertMessage.isDisplayed());
        logger.info("Alert was displayed");
        return false;
    }
    public void clickOnDiscountPopUp() {
        webDriverWait.until(ExpectedConditions.visibilityOf(discountPopUp));
        ClickOnElement(discountPopUp);
    }
}
