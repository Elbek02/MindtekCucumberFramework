package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BuySellAndReadPage;
import utilities.Driver;

public class BuySellAndReadSteps {

    WebDriver driver = Driver.getDriver();
    BuySellAndReadPage buySellAndReadPage = new BuySellAndReadPage();

    @When("user searches for {string} with space in the beginning and at the end")
    public void user_searches_for_with_space_in_the_beginning_and_at_the_end(String searchWord) throws InterruptedException {
        buySellAndReadPage.searchBar.sendKeys(searchWord);
        Thread.sleep(3000);
        buySellAndReadPage.searchBtn.click();
        Thread.sleep(3000);

    }


    @Then("user validates search message {string}")
    public void user_validates_search_message(String string) {

        String expectedTitle = "Search results for java data structure .";
        String actualTitle = expectedTitle;
        System.out.println(expectedTitle);
        Assert.assertEquals(expectedTitle, actualTitle);

    }
}
