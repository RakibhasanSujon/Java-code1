
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductToCart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.startechbd.com");

        // Find a product element
        WebElement productElement = driver.findElement(By.cssSelector(".product-card a"));

        // Click on the product element to open the product details page
        productElement.click();

        // Wait for the product details to load
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("product-title")));

        // Find the "Add to Cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));

        // Click on the "Add to Cart" button
        addToCartButton.click();

        // Verify if a success message or cart indicator is displayed
        if (driver.findElement(By.className("success-message")).isDisplayed()) {
            System.out.println("Product added to cart successfully!");
        } else if (driver.findElement(By.id("cart-indicator")).getText().contains("1")) {
            System.out.println("Product added to cart (verified by cart indicator).");
        } else {
            System.out.println("Failed to verify adding product to cart.");
        }

        driver.quit();
    }
}