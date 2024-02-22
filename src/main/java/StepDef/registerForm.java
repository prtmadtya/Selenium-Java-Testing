package StepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class registerForm extends env_target {
    @Given("user is on parabank homepage")
    public void UserIsOnParabankHomepage() {
        //Set Chromedriver location path
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Maximazie minimize
        driver.manage().window().maximize();
        //get URL
        driver.get(parabankLink);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginPanel']/p[2]/a"))
        );
    }

    @When("user click register link button")
    public void UserClickRegisterLinkButton() {
        driver.findElement(By.xpath("//*[@id='loginPanel']/p[2]/a")).click();
    }

    @Then("user is in register page")
    public void UserIsInRegisterPage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/h1"))
        );
    }

    @When("user input name")
    public void UserInputName() {
        driver.findElement(By.name("customer.firstName")).sendKeys("Aditya");
        driver.findElement(By.name("customer.lastName")).sendKeys("Pratama");
    }

    @And("user input address detail")
    public void UserInputAddressDetail() {
        driver.findElement(By.id("customer.address.street")).sendKeys("Jl. RAya Malangbong");
        driver.findElement(By.id("customer.address.city")).sendKeys("Garut");
        driver.findElement(By.name("customer.address.state")).sendKeys("Indonesia");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("44188");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("082130678762");
        driver.findElement(By.id("customer.ssn")).sendKeys("INISSN234");
    }

    @And("user fll valid username and password")
    public void UserFillValidUsernameandPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(1000);
        //Input username random
        driver.findElement(By.name("customer.username")).sendKeys("prtmadty" + userRand);
        //Input password
        driver.findElement(By.id("customer.password")).sendKeys("pass1234");
    }

    @And("user input password confirmation")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("pass1234");
    }

    @When("user click register button")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("user regist successfully")
    public void userRegistSuccessfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='rightPanel']/h1")));
        driver.quit();
    }

    @And("user input invalid password confirmation")
    public void userInputInvalidPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("pass543");
    }

    @Then("user get error password did not match")
    public void userGetErrorPasswordDidNotMatch() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='repeatedPassword.errors']")));
        driver.quit();
    }
}
