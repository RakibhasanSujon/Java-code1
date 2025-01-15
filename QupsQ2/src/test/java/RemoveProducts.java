import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RemoveProducts{
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.startechbd.com");

    // Open the cart view
    WebElement viewCartLink = driver.findElement(By.cssSelector(".cart-icon")); // Replace with actual selector
    viewCartLink.click();

    // Wait for the cart page to load
    Duration duration = Duration.ofSeconds(5);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cart-items")));

    // Verify if there's at least one item in the cart before proceeding
    if (driver.findElements(By.cssSelector(".cart-item")).isEmpty()) {
      System.out.println("Cart is empty. Cannot verify removing product.");
      driver.quit();
      return;
    }

    // Find the "Remove" button for the product you want to remove
    WebElement removeButton = driver.findElement(By.cssSelector(".cart-item .remove-button")); // Replace with actual selector

    // Click on the "Remove" button
    removeButton.click();

    // Wait for the cart to update
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cart-item .remove-button"))); // Wait for button to disappear

    // Verify if the product is removed
    if (driver.findElements(By.cssSelector(".cart-item")).isEmpty()) {
      System.out.println("Product successfully removed from cart.");
    } else {
      System.out.println("Failed to verify removing product from cart.");
    }

    driver.quit();
  }
}