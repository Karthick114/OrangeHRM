package basicscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AorangeMRun {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./Softwares/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        AorangeLoginpage loginPage = new AorangeLoginpage(driver);
        AorangeHomepage homePage = new AorangeHomepage(driver);
        AorangePIM pimPage = new AorangePIM(driver);

        loginPage.login("Admin", "admin123");
        Thread.sleep(2000);

        homePage.goToPIM();
        Thread.sleep(1500);

        String[][] employees = {
            {"John", "cena"},
            {"Alice", "Bro"},
            {"Bruce", "Lee"},
            {"Sophia", "Turner"}
        };

        for (String[] emp : employees) {
            pimPage.addEmployee(emp[0], emp[1]);
        }

        for (String[] emp : employees) {
            pimPage.verifyEmployee(emp[0] + " " + emp[1]);
        }

        homePage.logout();

        driver.quit();
    }
}

