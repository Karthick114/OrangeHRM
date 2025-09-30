package basicscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Handles homepage/dashboard actions
public class AorangeHomepage {
    WebDriver driver;

    // Locators
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    private By logoutButton = By.xpath("//a[text()='Logout']");

    public AorangeHomepage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to PIM
    public void goToPIM() {
    	WebDriverWait wait = new WebDriverWait(driver, 10); // old style
        WebElement pimElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']"))
        );
        pimElement.click();
    }


    // Logout
    public void logout() throws InterruptedException {
        driver.findElement(userDropdown).click();
        Thread.sleep(1000);
        driver.findElement(logoutButton).click();
    }
}
