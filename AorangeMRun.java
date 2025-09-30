package basicscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Runner class
public class AorangeMRun {
    public static void main(String[] args) throws InterruptedException {

        // Chrome setup
        System.setProperty("webdriver.chrome.driver", "./Softwares/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        // Page objects
        AorangeLoginpage loginPage = new AorangeLoginpage(driver);
        AorangeHomepage homePage = new AorangeHomepage(driver);
        AorangePIM pimPage = new AorangePIM(driver);

        // Step 1: Login
        loginPage.login("Admin", "admin123");
        Thread.sleep(2000);

        // Step 2: Go to PIM
        homePage.goToPIM();
        Thread.sleep(1500);

        // Step 3: Add employees
        String[][] employees = {
            {"John", "Smith"},
            {"Alice", "Brown"},
            {"David", "Lee"},
            {"Sophia", "White"}
        };

        for (String[] emp : employees) {
            pimPage.addEmployee(emp[0], emp[1]);
        }

        // Step 4: Verify employees
        for (String[] emp : employees) {
            pimPage.verifyEmployee(emp[0] + " " + emp[1]);
        }

        // Step 5: Logout
        homePage.logout();

        // Step 6: Close browser
        driver.quit();
    }
}
