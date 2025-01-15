import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoCompleteSuggestion {
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.startechbd.com");

    // Find the search bar
    WebElement searchBar = driver.findElement(By.id("search-bar"));

    // Enter a search term
    searchBar.sendKeys("laptops");

    // Wait for suggestions dropdown to appear
    Duration duration = Duration.ofSeconds(5);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".search-suggestions")));

    // Get the first few suggestions
    for (int i = 1; i <= 3; i++) {
      String suggestionText = driver.findElements(By.cssSelector(".search-suggestions li")).get(i - 1).getText();
      if (!suggestionText.toLowerCase().contains("laptop")) {
        System.out.println("Suggestion " + i + " (" + suggestionText + ") might not be relevant to laptops.");
      }
    }

    System.out.println("** Performed a basic verification of suggested products. Manual review recommended for accuracy. WebDriver cannot click on suggestions or navigate to product pages. ");

    driver.quit();
  }
}