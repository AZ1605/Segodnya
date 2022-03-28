package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;

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
    @FindBy(xpath = "//div[@class='unit__content data-list']//li")
    private WebElement randomBook;


    public boolean checkIsBookTitleIsVisible() { //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        Assert.assertTrue("Book title is not visible", isElementDisplayed(randomInterestedBookTitle));
        return true;
    }

    public BookPage chooseRandomBook() {
        List<WebElement> listings = webDriver.findElements(By.xpath("//div[@class='unit__content data-list']//li"));
        Random r = new Random();
        int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
        listings.get(randomValue).click();
        logger.info("Book was chosen");
        return this;
    }

//    public String isBookIsVisible(long text) {
//        try {
//            return webDriver.findElement(By.xpath("//h1[@itemprop='description']")).isDisplayed();
//        } catch (Exception e) {
//            return false;
//
//        }
//    }
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




