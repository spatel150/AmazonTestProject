public class AmazonLoginPage {

    WebElement element;
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=" +
                "900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath" +
                "%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26" +
                "useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=" +
                "usflex&openid.mode=checkid_" +
                "setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    }

    @Test
    public void logInWithEmail() {
        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("ryder400@yahoo.com");

        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
    }

    @Test
    public void getTerms() {
        WebElement link = driver.findElement(By.linkText("Conditions of Use"));
        link.click();
    }

    @Test
    public void getPrivacy() {
        WebElement privacy = driver.findElement(By.linkText("Privacy Notice"));
        privacy.click();
    }

    @Test
    public void needHelpArrow() {
        WebElement arrow = driver.findElement(By.cssSelector(".a-expander-prompt"));
        arrow.click();
    }

    @Test
    public void createAccountBtn() {
        WebElement createAccount = driver.findElement(By.id("createAccountSubmit"));
        createAccount.click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
  
}
