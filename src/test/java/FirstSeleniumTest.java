import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstSeleniumTest {

    @Test
    public void firstTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(Duration.ofMillis(3000));
        driver.quit();
    }

    @Test
    public void secondTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/gp/css/homepage.html?ref_=nav_youraccount_btn");
        Thread.sleep(Duration.ofMillis(3000));
        driver.quit();
    }
}
