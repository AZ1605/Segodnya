package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public boolean isUserNameIsVisible() { //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        try {
            return webDriver.findElement(By.xpath("//span[@data-customer='firstname']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public HomePage checkIsUserNameIsVisible() { //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        Assert.assertTrue("UserName is not displayed", isUserNameIsVisible());
        return this;
    }
    public HomePage inputTextIntoSearchOnHomePage(String text) {
        inputTextIntoElement(inputSearch, text);
        return  this;
}
    public void clickOnButtonSearch() {
        ClickOnElement(buttonSearch);
    }
    public void clickOnPopUp() {
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

    }
    public void checkSearchOnHomePage() {
        inputTextIntoSearchOnHomePage("Кинг");
        //clickOnPopUp();
        clickOnButtonSearch();
    }
}





