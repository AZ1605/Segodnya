package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(xpath="//input[@name='login[username]']")
    private WebElement inputLogin;
    @FindBy(xpath ="//input[@name='login[password]']")
    private WebElement inputPassWord;
    @FindBy(xpath="//button[@title='Увійти']")
    private WebElement submit;
    @FindBy(xpath="//a[@class='show-modal-login']")
    private WebElement enterButton;
    @FindBy(xpath="//div[@id='login-message-error']")
    private WebElement alertMessage;
    @FindBy(xpath="//ul[@id='interest_products_list_homepage_neu_current']//li[2]")
    private WebElement randonInterestedBook;

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
        public void enterLoginIntoLoginField (String login){
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

    public boolean isAlertIsVisible()  { //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        try {
            return alertMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public HomePage loginWithValidCredits()  {
        openLoginPage();
        clickOnButtonEnter();
        enterLoginIntoLoginField(TestData.VALID_LOGIN);
        enterPasswordIntoPasswordField(TestData.VALID_PASSWORD);
        clickOnButtonSubmit();
        return new HomePage(webDriver);
    }
    }


