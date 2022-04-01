package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
public class HomePage extends  ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//input[@id='search']")
    private WebElement inputSearch;
    @FindBy(xpath = "//button[@id='search_mini_form_submit']")
    private WebElement buttonSearch;
    @FindBy(xpath = "//button[@class=sub-dialog-btn allow_btn")
    private WebElement popUpYes;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked parent-menu']//li")
    private List<WebElement> upperMenu;
    @FindBy(xpath = "//ul[@class='menu-first-level']//li//a")
    private List<WebElement> randomValueInSecondMenu;
    @FindBy(xpath = "//span[@data-customer='firstname']")
    private WebElement userName;
    public boolean isUserNameIsVisible() { //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        try {
            return webDriver.findElement(By.xpath("//span[@data-customer='firstname']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public HomePage checkIsUserNameIsVisible(String userName) {//метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        Assert.assertTrue("UserName is not displayed", isUserNameIsVisible());
        logger.info(userName + " was displayed");
        return this;
    }

    public HomePage inputTextIntoSearchOnHomePage(String text) {
        webDriverWait.until(ExpectedConditions.visibilityOf(inputSearch));
        inputTextIntoElement(inputSearch, text);
        return this;
    }

    public void clickOnButtonSearch() {
        ClickOnElement(buttonSearch);
    }

  public void checkSearchOnHomePage() {
       inputTextIntoSearchOnHomePage("Кинг");
       clickOnButtonSearch();
  }


    public HomePage chooseRandomItemInFirst() {
        clickOnRandomItem(upperMenu);
        logger.info("Random Item was clicked in first menu");
        return this;
    }
    public HomePage chooseRandomItemInSecond() {
        clickOnRandomItem(randomValueInSecondMenu);
        logger.info("Random Item was clicked in first menu");
        return this;
    }
}





