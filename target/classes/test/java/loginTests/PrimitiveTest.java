package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PrimitiveTest {
    WebDriver webDriver;
    @Test
    public void ValidLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); //подключение хром драйвера к проекту
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS); //неявное ожидаение 7 секунд,каждые полсекунды будет действоать в течении 7 секнда,если 7 секунд пройдет-упадет
        webDriver.get("https://www.yakaboo.ua/");
        System.out.println("Yakaboo main page was opened");
        webDriver.findElement(By.xpath("//a[@class='show-modal-login']")).click();
        webDriver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("chillywillyshpili@ukr.net");
        System.out.println("Login was inputted");
        webDriver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Hvq53zzz");
        System.out.println("Pass was inputted");
        webDriver.findElement(By.xpath("//button[@title='Увійти']")).click();
        System.out.println("Button Enter  was clicked");
        Assert.assertTrue("UserName is not visible",isUserNameIsVisible());// сообщение еckb ассерт провалился
        webDriver.quit(); // закрывает браузер, close-закрывает вкладку
        System.out.println("Browser was closed");

    }
    private boolean isUserNameIsVisible(){ //метод для обработки ексепшена(попробуй найти кнопку,если нет-верни фолс)
        try {
            return webDriver.findElement(By.xpath("//span[@data-customer='firstname']")).isDisplayed();
        }catch (Exception e){
            return  false;
        }
    }
}
