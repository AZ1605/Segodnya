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
    @FindBy(xpath = "//div[@class='page-title product-title']")
    private WebElement randomInterestedBookTitle;

    public boolean checkIsBookIsVisible() { //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        Assert.assertTrue("Book title is visible", isElementDisplayed(randomInterestedBookTitle));
        return true;
    }
    public BookPage chooseRandomBook() {
        List<WebElement> listings = webDriver.findElements(By.xpath("//ul[@id='interest_products_list_homepage_neu_current']//li"));
        Random r = new Random();
        int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
        listings.get(randomValue).click();
        return this;
    }

    public boolean isBookIsVisible() {
        try {
            return webDriver.findElement(By.xpath("//h1[@itemprop='description']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    }

