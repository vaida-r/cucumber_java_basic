package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

import static org.junit.Assert.*;

public class TaskSteps {
    private WebDriver driver;

    public TaskSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on Enter number page$")
    public void iAmOnNumberPage() throws Throwable{
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }


    @When("^I enter \"([^\"]*)\"$")
    public void iEnter(String num) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(num);
    }


    @Then("^I submit number$")
    public void iSubmitNumber() {
        driver.findElement(By.className("w3-btn")).click();
    }


    @And("^I see error \"([^\"]*)\"$")
    public void iSeeError(String mess) throws Throwable {
        assertEquals(mess,driver.findElement(By.id("ch1_error")).getText());
    }


    @And("^I see calculated square root of the number$")
    public void iSeeCalculatedSquareRootOfTheNumber() {

        int num = 64;
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(num));

        driver.findElement(By.tagName("button")).click();

        String expmess = String.format(Locale.US, "Square root of %d is %.2f",num,Math.sqrt(num));

        Alert alert = driver.switchTo().alert();
        String actmess = alert.getText();
        alert.accept();

        assertEquals(expmess,actmess);

    }


}