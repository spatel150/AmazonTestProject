import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPasswordPage {

    WebElement element;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/ap/signin");
    }

    @Test
    public void enterPassword() {
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("test123");

        WebElement signInBtn = driver.findElement(By.id("signInSubmit"));
        signInBtn.click();
    }

    @Test
    public void forgotPassword() {
        WebElement forgotPass = driver.findElement(By.xpath("//a[@id='auth-fpp-link-bottom']"));
        forgotPass.click();
    }

    @Test
    public void keepSignedIn() {
        WebElement signedIn = driver.findElement(By.xpath("//input[@name='rememberMe']"));
        signedIn.click();
    }

    @Test
    public void changeEmail() {
        WebElement emailChange = driver.findElement(By.cssSelector("#ap_change_login_claim"));
        emailChange.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
