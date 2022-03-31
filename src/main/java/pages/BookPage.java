package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends ParentPage {
    public BookPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h1[@itemprop='description']")
    private WebElement randomInterestedBookTitle;
    @FindBy(xpath = "//div[@class='page-title category-title']")
    private WebElement randomSectionTitle;
    @FindBy(xpath = "//div[@class='side_left clearfix']//button[@title='Купити']")
    private WebElement buttonAddToBasket;
    @FindBy(xpath = "//button[@class='btn btn-buy gocheckout']")
    private WebElement buttonAddToBasketAgain;

    public boolean checkIsBookTitleIsVisible() { //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        Assert.assertTrue("Book title is not visible", isElementDisplayed(randomInterestedBookTitle));
        return true;
    }

        public boolean checkIsSectionTitleIsVisible () {
            Assert.assertTrue("Section title is visible", isElementDisplayed(randomSectionTitle));
            return true;
        }
    public String checkTitle () {
        String bookTitle = randomInterestedBookTitle.getText();
        logger.info("Title: "+ bookTitle);
        return bookTitle;
    }
    public void AddBookToBasket() {
            buttonAddToBasket.click();
            buttonAddToBasketAgain.click();

        }
}




