import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.startech.com.bd/");

        WebElement loginHeader = driver.findElement(By.id("login-header"));
        if (loginHeader.isDisplayed()) {
            System.out.println("Login header is displayed");
        } else {
            System.out.println("Login header is not displayed");
        }

        WebElement usernameLabel = driver.findElement(By.id("username-label"));
        if (usernameLabel.isDisplayed()) {
            System.out.println("Username label is displayed");
        } else {
            System.out.println("Username label is not displayed");
        }

        WebElement usernameField = driver.findElement(By.id("username-field"));
        usernameField.click();

        usernameField.sendKeys("your_username");

        WebElement passwordLabel = driver.findElement(By.id("password-label"));
        if (passwordLabel.isDisplayed()) {
            System.out.println("Password label is displayed");
        } else {
            System.out.println("Password label is not displayed");
        }

        WebElement passwordField = driver.findElement(By.id("password-field"));
        passwordField.click();

        passwordField.sendKeys("your_password");
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        if (signInButton.isDisplayed()) {
            System.out.println("Sign in button is displayed");
        } else {
            System.out.println("Sign in button is not displayed");
        }

        signInButton.click();

        WebElement dashboardButton = driver.findElement(By.id("dashboard-button"));
        if (dashboardButton.isDisplayed()) {
            System.out.println("Dashboard button is displayed - Login successful");
        } else {
            System.out.println("Dashboard button is not displayed - Login may not be successful");
        }

        driver.quit();
    }
}