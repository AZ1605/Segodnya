package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class BasketPage extends ParentPage {
        public BasketPage(WebDriver webDriver) {
            super(webDriver);
        }

        @FindBy(xpath = "//button[@class='popup_cart_item_del']")
        private WebElement deleteButtonInsideBasket;
        @FindBy(xpath = "//a[@class='del_item']")
        private WebElement deleteButtonInsideBasketPopup;
        @FindBy(xpath = "//td[@class='empty_cart_text']")
        private WebElement emptyMessage;


        public void deleteFromBasket() {
            deleteButtonInsideBasket.click();
            deleteButtonInsideBasketPopup.click();
            logger.info("Items are deleted");
        }
            public boolean isEmptyMessageIsVisible(String text)  {
                try {
                    logger.info("Alert is displayed");
                    return emptyMessage.isDisplayed();
                } catch (Exception e) {
                    return false;

                }
        }
}
