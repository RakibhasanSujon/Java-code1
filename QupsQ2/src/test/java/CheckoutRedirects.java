import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutRedirects {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.startechbd.com");

    // Open the cart view
    WebElement viewCartLink = driver.findElement(By.cssSelector(".cart-icon")); // Replace with actual selector
    viewCartLink.click();

    // Wait for the cart page to load (adjust timeout if needed)
    Duration duration = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cart-items")));

    // Verify if there's at least one item in the cart before proceeding
    if (driver.findElements(By.cssSelector(".cart-item")).isEmpty()) {
      System.out.println("Cart is empty. Cannot verify checkout button redirect.");
      driver.quit();
      return;
    }

    // Find the "Checkout" button (replace with appropriate selector)
    WebElement checkoutButton = driver.findElement(By.cssSelector(".cart-summary .checkout-button")); // Replace with actual selector

    // Get the current URL before clicking the checkout button
    String currentUrl = driver.getCurrentUrl();

    // Click on the "Checkout" button
    checkoutButton.click();

    // Wait for a potential redirect (adjust timeout if needed)
    wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));

    // Check if the URL contains keywords indicating checkout or payment
    String newUrl = driver.getCurrentUrl();
    if (newUrl.contains("checkout") || newUrl.contains("payment")) {
      System.out.println("Checkout button appears to redirect to a checkout or payment page.");
    } else {
      System.out.println("Could not verify checkout button redirects to a checkout or payment page.");
    }

    driver.quit();
  }
}