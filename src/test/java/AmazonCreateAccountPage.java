import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonCreateAccountPage {

    WebElement element;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/ap/register?showRememberMe=" +
                "true&openid.pape.max_auth_age=900&signInRedirectToFPPThreshold=" +
                "3&pageId=usflex&mobileBrowserWeblabTreatment=C&openid.return_" +
                "to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome" +
                "%3Fpath%3D%252Fgp%252Fyourstore%252Fhome" +
                "%26signIn%3D1%26useRedirectOnSuccess%3D1%26action" +
                "%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=" +
                "GZ6Z4ZBJY6K5NS6QM0FH&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment=" +
                "C&prepopulatedLoginId=&failedSignInCount=0&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&timestamp=1692298412000");
    }

    @Test
    public void firstName() {
        WebElement first = driver.findElement(By.xpath("//input[@name='customerName']"));
        first.sendKeys("hello there");
    }

    @Test
    public void mobileNumber() {
        WebElement number = driver.findElement(By.id("ap_email"));
        number.sendKeys("123-456-7890");
    }

    @Test
    public void passWord() {
        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("test135");
    }

    @Test
    public void rePassword() {
        WebElement rePass = driver.findElement(By.id("ap_password_check"));
        rePass.sendKeys("test135");
    }

    @Test
    public void continueBtn() {
        WebElement conBtn = driver.findElement(By.id("continue"));
        conBtn.click();
    }

    @Test
    public void conditions() {
        WebElement condLink = driver.findElement(By.linkText("Conditions of Use"));
        condLink.click();
    }

    @Test
    public void privacyNot() {
        WebElement privNotice = driver.findElement(By.linkText("Privacy Notice"));
        privNotice.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
