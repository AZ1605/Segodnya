package pages;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


//cодержатся действия для пейджей
public class ParentPage {
    Logger logger = Logger.getLogger(getClass());//передаем во все пейджи логер
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    WebDriverWait webDriverWait2;

    public ParentPage(WebDriver webDriver) { //передаем во все пейджи драйвер
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);//инизиализация элементов ФАЙНД БАЙ для всех страниц
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait2 = new WebDriverWait(webDriver, 2);

    }
    protected void inputTextIntoElement(WebElement webElement, String text) { //метод для ввода текста на все страницы
        try {
            webElement.sendKeys(text);
            logger.info(text + " was inputted");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void ClickOnElement(WebElement webElement) { //метод для клики на кнопки все страницы
        try {
            webElement.click();
            logger.info("Button was clicked");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info("Element is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cant work with element" + e);
        Assert.fail("Cant work with element" + e);
    }


}
