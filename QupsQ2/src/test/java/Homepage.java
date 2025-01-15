import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage{
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.startechbd.com");

    if (driver.getTitle().contains("Star Tech")) {
      System.out.println("Homepage loaded successfully!");
    } else {
      System.out.println("Homepage failed to load.");
    }

    driver.quit();
  }
}