
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ResponsiveDesign {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

        // Headless mode for efficiency (optional)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        // Test on a mobile viewport size
        driver.manage().window().setSize(new Dimension(375, 667));

        driver.get("https://www.startechbd.com");
        Thread.sleep(2000); // Wait for page to load
        System.out.println("Website tested on mobile viewport size (375x667).");

        // Test on a larger viewport size (replace with desired dimensions)
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("https://www.startechbd.com");
        Thread.sleep(2000); // Wait for page to load
        System.out.println("Website tested on larger viewport size (1024x768).");

        driver.quit();
    }
}