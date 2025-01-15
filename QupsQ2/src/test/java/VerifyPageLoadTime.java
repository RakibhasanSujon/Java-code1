import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class VerifyPageLoadTime {
  private static final long ACCEPTABLE_LOAD_TIME_MS = 5000; // 5 second

  public static void main(String[] args) throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    // Enable performance logging
    options.setCapability("perfLoggingPrefs", "{ \"enableNetworkEvents\": true }");

    WebDriver driver = new ChromeDriver(options);

    // Use JavascriptExecutor to access Performance Timing API
    JavascriptExecutor js = (JavascriptExecutor) driver;

    driver.get("https://www.startechbd.com");

    // Wait for some time to allow the page to load 
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    Long navigationStart = (Long) js.executeScript("return performance.timing.navigationStart");
    Long loadEventEnd = (Long) js.executeScript("return performance.timing.loadEventEnd");
    Long loadTime = loadEventEnd - navigationStart;

    if (loadTime > ACCEPTABLE_LOAD_TIME_MS) {
      System.out.println("WARNING: Page load time (" + loadTime + "ms) exceeds acceptable threshold (" + ACCEPTABLE_LOAD_TIME_MS + "ms).");
    } else {
      System.out.println("Page load time: " + loadTime + "ms");
    }

    driver.quit();
  }
}