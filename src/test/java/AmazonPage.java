import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPage {

    private WebDriver driver;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
    }
    private By searchBox = By.id("nav-search-bar-form");
    private By searchButton = By.id("nav-search-submit-button");
    private By productLink = By.className("a-link-normal");
    private By addToCartButton = By.id("nav-cart");
    private By addToCartConfirmation = By.linkText("Added to Cart");

    @Test
    public void searchProduct(String productName) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.sendKeys(productName);
        driver.findElement(searchButton).click();
    }
    @Test
    public void clickOnItem() {
        driver.findElements(productLink).get(0).click();
    }

    @Test
    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    @Test
    public String getCartConfirmation() {
        return driver.findElement(addToCartConfirmation).getText();
    }
}
