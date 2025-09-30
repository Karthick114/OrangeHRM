package basicscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Handles login page actions
public class AorangeLoginpage {
    WebDriver driver;

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton  = By.xpath("//button[@type='submit']");

    // Constructor
    public AorangeLoginpage(WebDriver driver) {
        this.driver = driver;
    }

    // Login action
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
