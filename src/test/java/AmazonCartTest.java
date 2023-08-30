import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonCartTest {
  WebElement element;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/gp/yourstore/home?path=%2Fgp%2Fyourstore%2Fhome&signIn=" +
                "1&useRedirectOnSuccess=" +
                "1&action=sign-out&ref_=nav_AccountFlyout_signout");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    AmazonPage amazonPage = new AmazonPage(driver);

    @Test
    public void searchTest() {
        amazonPage.searchProduct("Kaytee Fiesta");
    }

    @Test
    public void clickTest() {
        amazonPage.clickOnItem();
    }

    @Test
    public void addToCartTest() {
        amazonPage.addToCart();
    }

    @Test
    public void addToCartConfirmTest() {
        String confirmMessage = amazonPage.getCartConfirmation();
        if (confirmMessage.contains("Added to Cart")) {
            System.out.println("Product is successfully added@");
        } else {
            System.out.println("Failed to add the product!");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
