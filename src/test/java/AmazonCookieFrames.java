import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonCookiesandFrames {
  
    WebElement element;
    WebDriver driver;

    private JavascriptExecutor javascriptExecutor;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        javascriptExecutor = ((JavascriptExecutor) driver);
        driver.get("https://www.amazon.com/ap/register?showRememberMe=" +
                "true&openid.pape.max_auth_age=900&signInRedirectToFPPThreshold=3&pageId=" +
                "usflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.com%" +
                "2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%" +
                "26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=" +
                "GZ6Z4ZBJY6K5NS6QM0FH&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblab" +
                "Treatment=C&prepopulated" +
                "LoginId=&failedSignInCount=0&openid.ns=" +
                "http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&timestamp=1692298412000");
    }

    @Test
    public void amazonCookie() {

        try {
            driver.get("https://www.amazon.com/ap/register?showRememberMe=" +
                    "true&openid.pape.max_auth_age=" +
                    "900&signInRedirectToFPPThreshold=3&pageId=usflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp" +
                    "%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%" +
                    "26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=" +
                    "GZ6Z4ZBJY6K5NS6QM0FH&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment" +
                    "=C&prepopulatedLoginId=&failedSignInCount" +
                    "=0&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&timestamp=1692298412000");

            driver.manage().addCookie(new Cookie("session-id-time", "2082787201l"));

            Cookie cookie1 = driver.manage().getCookieNamed("session-id-time");
            System.out.println(cookie1);

        } finally {
            driver.quit();
        }

    }

    @Test
    public void scrollDown() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/ap/register?showRememberMe=" +
                "true&openid.pape.max_auth_age=" +
                "900&signInRedirectToFPPThreshold=3&pageId=usflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp" +
                "%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%" +
                "26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=" +
                "GZ6Z4ZBJY6K5NS6QM0FH&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment" +
                "=C&prepopulatedLoginId=&failedSignInCount" +
                "=0&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&timestamp=1692298412000");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);
    }

    @Test
    public void scrollUp() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com/ap/register?showRememberMe=" +
                "true&openid.pape.max_auth_age=" +
                "900&signInRedirectToFPPThreshold=3&pageId=usflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp" +
                "%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%" +
                "26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=" +
                "GZ6Z4ZBJY6K5NS6QM0FH&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment" +
                "=C&prepopulatedLoginId=&failedSignInCount" +
                "=0&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&timestamp=1692298412000");
        javascriptExecutor.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(1000);
    }
}
