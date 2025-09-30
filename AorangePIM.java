package basicscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AorangePIM {
    WebDriver driver;

    private By addEmployeeBtn = By.xpath("//a[text()='Add Employee']");
    private By firstNameField = By.name("firstName");
    private By lastNameField  = By.name("lastName");
    private By saveButton     = By.xpath("//button[@type='submit']");
    private By employeeList   = By.xpath("//a[text()='Employee List']");

    public AorangePIM(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployee(String firstName, String lastName) throws InterruptedException {
        driver.findElement(addEmployeeBtn).click();
        Thread.sleep(1500);
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(saveButton).click();
        Thread.sleep(2000);
    }

    public void verifyEmployee(String fullName) throws InterruptedException {
        driver.findElement(employeeList).click();
        Thread.sleep(1500);

        if (driver.getPageSource().contains(fullName)) {
            System.out.println(fullName + "  Verified");
        } else {
            System.out.println(fullName + " Not Found ");
        }
    }
}

