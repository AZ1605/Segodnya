package baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookPage;
import pages.HomePage;
import pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver webDriver; //driver variable needs in every page, so introduced before all
    Logger logger = Logger.getLogger(getClass()); //introduced variable logger
    protected LoginPage loginPage; //introduced variable login page, needs in every tests thats way in Base test. protected because used in different classes
    protected HomePage homePage;
    protected BookPage bookPage;

    @Before
    public void setUp(){ // стягивает исполняемый файл драйвера и будем работать с хромом, увеличение окна,тайм аут
        WebDriverManager.chromedriver().setup();
        webDriver= new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        loginPage = new LoginPage(webDriver); //give for login page driver
        homePage = new HomePage(webDriver);
        bookPage = new BookPage(webDriver);
    }

  //@After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");

    }
}
