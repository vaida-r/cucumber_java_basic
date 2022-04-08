package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        //driver.get("https://kristinek.github.io/site/examples/age");
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }



    @Given("^I am on the locators page$")
    public void iAmOnTheLocatorsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    @Then("^I should see both locators page headers$")
    public void iShouldSeeBothLocatorsPageHeaders() throws Throwable{
        assertEquals("Heading 1",
                driver.findElement(By.id("heading_1")).getText());
        assertEquals("Heading 2 text",
                driver.findElement(By.id("heading_2")).getText());

    }

    @And("^Buttons in Locators page are clickable$")
    public void buttonsInLocatorsPageAreClickable() throws Throwable {
        assertTrue(driver.findElement(By.name("randomButton1")).isEnabled());
        assertTrue(driver.findElement(By.name("randomButton2")).isEnabled());
    }


    @Then("^I see error: \"([^\"]*)\"$")               // it can be also without "":  @Then("^I see error: ([^\"]*)$")
    public void iSeeAgeError(String mess) throws Throwable {
        assertEquals(mess, driver.findElement(By.id("error")).getText());
    }

    @Then("^I am not navigated to age message page$")
    public void iAmNotNavigatedToAgePage() {                   // a method name can be bet koks
        assertFalse(driver.getCurrentUrl().contains("https://kristinek.github.io/site/examples/age_2.html"));
    }

    @When("^I enter feedback name: \"([^\"]*)\"$")
    public void iEnterFeedbackName(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @And("^I enter feedback age: (\\d+)$")
    public void iEnterFeedbackAgeAge(String age) throws Throwable {
        //driver.findElement(By.id("fb_age")).sendKeys(String.valueOf(age));
        driver.findElement(By.id("fb_age")).sendKeys(age);
    }


    @Then("^click Send$")
    public void clickSend() throws Throwable{
        driver.findElement(By.className("w3-btn-block")).click();
    }

    @And("^I can see name \"([^\"]*)\" in feedback$")
    public void iCanSeeNameInFeedback(String name) throws Throwable {
        assertEquals(name,driver.findElement(By.id("name")).getText());
    }

    @And("^I can see \"([^\"]*)\" in feedback$")
    public void iCanSeeInFeedback(String age) throws Throwable {
        assertEquals(age,driver.findElement(By.id("age")).getText());
    }


    @Given("^I am on feedback page$")
    public void iAmOnFeedbackPage() {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }


    @When("^I select feedback languages$")
    public void iSelectFeedbackLanguages(List<String> languages) {
        for (String language: languages){
            driver.findElement(By.xpath("//input[@class='w3-check' and @value='"+language+"']")).click();     // it can also be By.xpath("//input[@value='"+language+"']")
        }



    }

    @Then("^I can see languages \"([^\"]*)\" in feedback check$")
    public void iCanSeeLanguagesInFeedbackCheck(String language) throws Throwable {
        assertEquals(language, driver.findElement(By.id("language")).getText());
    }


    @When("^I enter person values:$")
    public void iEnterPersonValues(Map<String, String> person) throws Throwable{
        if(person.containsKey("name")) {
            iEnterFeedbackName(person.get("name"));
        }
        iEnterFeedbackAgeAge(person.get("age"));
        driver.findElement(By.xpath("//input[@value='" + person.get("genre") + "']")).click();

    }

    @And("^I can see genre \"([^\"]*)\" in feedback$")
    public void iCanSeeGenreInFeedback(String genre) throws Throwable {
        assertEquals(genre, driver.findElement(By.id("gender")).getText());
    }
}
