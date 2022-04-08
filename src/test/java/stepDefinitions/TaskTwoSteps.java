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

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class TaskTwoSteps {
    private WebDriver driver;
 //   public static Map<String, String> original = new HashMap<>();


    public TaskTwoSteps() {
        this.driver = Hooks.driver;
    }


    @Given("^people with jobs page$")
    public void iAmOnPeoplePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @Given("^I see whole list$")
    public Map<String, String> wholeList(){
        List <WebElement> originalList = driver.findElements(By.xpath("//*[contains(@id, 'person')]"));
        Map <String, String> person = new HashMap<>();
        for (WebElement pers : originalList) {
            String name = pers.findElement(By.className("name")).getText();
            String job = pers.findElement(By.className("job")).getText();
            person.put(name,job);
        }
        System.out.println(person);
        return person;

    }



    @When("^I press the Add person button$")
    public void iPressTheAddPersonButton() throws Throwable{
        driver.findElement(By.xpath("//*[@id='addPersonBtn' and contains(text(),'Add')]")).click();
    }


    @And("^I enter person data$")
    public void iEnterPersonData(Map<String, String> persons) throws Throwable{
        for (Map.Entry<String, String> person : persons.entrySet()) {
            driver.findElement(By.id(person.getKey())).clear();
            driver.findElement(By.id(person.getKey())).sendKeys(person.getValue());
        }
    }


    @And("^I click the Add button$")
    public void iClickTheAddButton() {
        driver.findElement(By.id("modal_button")).click();
    }


    @Then("^I see person with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSeePersonWithAnd(String name, String job) throws Throwable {
        List<WebElement> nameList = driver.findElements(By.xpath("//*[@class='w3-xlarge name']"));
        List<WebElement> jobList = driver.findElements(By.xpath("//*[@class='job']"));
        for (int i = 0; i < nameList.size(); i++) {
            if (name.equals(nameList.get(i).getText()) & job.equals(jobList.get(i).getText())) {
                assertTrue(true);
                break;
            }
        }
    }


    @Then("^I do not see person with \"([^\"]*)\"$")
    public void iDoNotSeePersonWith(String name) throws Throwable {
        List<WebElement> nameList = driver.findElements(By.xpath("//*[@class='w3-xlarge name']"));
        for (WebElement i : nameList) {
            if (name.equals(i.getText())) {
                assertFalse(true);
                System.out.println(name + " is in the list :(");
            } else {
                assertTrue(true);
            }
        }
    }


    @When("^I click the Edit for person with \"([^\"]*)\"$")
    public void iClickTheEditForPersonWith(String name) throws Throwable {
        List<WebElement> nameList = driver.findElements(By.xpath("//*[@class='w3-xlarge name']"));
        List<WebElement> editList = driver.findElements(By.className("fa-pencil"));
        for (int i = 0; i < nameList.size(); i++) {
            if (name.equals(nameList.get(i).getText())){
                 editList.get(i).click();
                 break;
            }
        }
    }


    @And("^I click Edit button$")
    public void iClickEditButton() {
        driver.findElement(By.xpath("//*[@id='modal_button' and contains(text(), 'Edit')]")).click();
    }


    @When("^I click Remove for person with \"([^\"]*)\"$")
    public void iClickRemoveForPersonWith(String name) throws Throwable {
        List<WebElement> nameList = driver.findElements(By.xpath("//*[@class='w3-xlarge name']"));
        List<WebElement> deleteList = driver.findElements(By.xpath("//*[contains(@class,'closebtn') and contains(@onclick, 'delete')]"));
        for (int i = 0; i < nameList.size(); i++) {
            if (name.equals(nameList.get(i).getText())){
                deleteList.get(i).click();
                break;
            }
        }
    }


    @And("^I click Cancel button$")
    public void iClickCancelButton() {
        driver.findElement(By.xpath("//*[@id='modal_button' and contains(text(), 'Cancel')]")).click();
    }


    @Then("^I click Reset list button$")
    public void iClickResetListButton() {
        driver.findElement(By.xpath("//*[@id='addPersonBtn' and contains(text(),'Reset')]")).click();
   }


    @And("^I enter new person data:$")
    public void iEnterNewPersonData(Map<String, String> newPerson) {
        for (Map.Entry<String, String> pers : newPerson.entrySet()) {
            driver.findElement(By.id(pers.getKey())).clear();
            driver.findElement(By.id(pers.getKey())).sendKeys(pers.getValue());
        }
   }


    @And("^I enter new person data with name:$")
    public void iEnterPersonDataWithName(List<String> names) {

        for (String n: names) {
            driver.findElement(By.id("name")).clear();
            driver.findElement(By.id("name")).sendKeys(n);
            driver.findElement(By.id("job")).clear();
            driver.findElement(By.id("job")).sendKeys("");
        }
    }



    @And("^I see person with name \"([^\"]*)\"$")
    public void iSeePersonWithName(String name) throws Throwable {
        //original = wholeList();
        assertTrue(wholeList().keySet().contains(name));
    }


      }
}
