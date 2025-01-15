import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Productdetails {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.startechbd.com");

    // Find a product element
    WebElement productElement = driver.findElement(By.cssSelector(".product-card a"));

    // Click on the product element to open the product details page
    productElement.click();

    // Wait for the product details to load
    Duration duration = Duration.ofSeconds(5);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product-title")));

    // Get product title, description, and price
    String title = driver.findElement(By.id("product-title")).getText();
    String description = driver.findElement(By.id("product-description")).getText();
    String price = driver.findElement(By.id("product-price")).getText();

    // Verify product details are displayed
    System.out.println("Product Title: " + title);
    System.out.println("Product Description: " + description);
    System.out.println("Product Price: " + price);

    driver.quit();
  }
}