package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPages {
    WebDriver driver;

    public registerPages(WebDriver driver) {
        this.driver = driver;
    }

    //Locator element Input Name
    By firstnameField = By.id("customer.firstName");
    By lastnameField = By.name("customer.lastName");

    //method click register button
    public void InputNameData(String firstName, String lastName) {
        driver.findElement(firstnameField).sendKeys(firstName);
        driver.findElement(lastnameField).sendKeys(lastName);
    }
}
