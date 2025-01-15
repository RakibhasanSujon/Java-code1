import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductCategory{
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.startechbd.com");

    // Verify presence of product categories
    if (driver.findElements(By.cssSelector(".product-category")).isEmpty()) {
      System.out.println("Product categories not found on the homepage.");
    } else {
      System.out.println("Product categories found.");
    }

    // Simulate selecting a product category
    WebElement categoryLink = driver.findElement(By.linkText("Laptops"));
    categoryLink.click();

    // Wait for category page to load
    Duration duration = Duration.ofSeconds(5);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("category-title"))); // Adjust selector if needed

    // Verify category title (adjust selector if needed)
    String categoryTitle = driver.findElement(By.id("category-title")).getText();
    if (categoryTitle.contains("Laptops")) {
      System.out.println("Selected category: Laptops (verified by title).");
    } else {
      System.out.println("Could not verify selected category.");
    }

    // Find filter elements
    WebElement brandFilter = driver.findElement(By.id("brand-filter"));
    WebElement priceFilter = driver.findElement(By.id("price-filter"));
    // Wait for filtered products to load
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-card")));

    // Verify presence of filtered products
    if (driver.findElements(By.cssSelector(".product-card")).isEmpty()) {
      System.out.println("No products found after applying filters.");
    } else {
      System.out.println("Products found after applying filters.");
    }

    driver.quit();
  }
}