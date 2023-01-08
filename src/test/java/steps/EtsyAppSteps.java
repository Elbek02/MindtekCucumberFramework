package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomepage;
import pages.EtsyAppSearchResultsPage;
import pages.EtsyTitlePages;
import utilities.Driver;

import java.util.List;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();
    EtsyAppHomepage etsyAppHomepage = new EtsyAppHomepage();
    EtsyAppSearchResultsPage etsyAppSearchResultsPage = new EtsyAppSearchResultsPage();
    EtsyTitlePages etsyTitlePages = new EtsyTitlePages();

    @When("user searches for {string}")
    public void user_searches_for(String item) {
        etsyAppHomepage.searchBox.sendKeys(item + Keys.ENTER);

    }

    @Then("user validates search result items name contains keyword {string}")
    public void user_validates_search_result_items_contains_keyword(String keyword) {
        List<WebElement> myItemsList = etsyAppSearchResultsPage.listOfItemsTitles;

        for (WebElement el : myItemsList) {
            System.out.println(el.getText());
            if (el.getText().contains(keyword)) {
                Assert.assertTrue("Item does not contain " + keyword + " keyword " + el.getText(),
                        el.getText().toLowerCase().contains(keyword));

            }
        }
    }

    @And("user applies price filter {string} dollars")
    public void userAppliesPriceFilterOverDollars(String filterRange) {
        etsyAppSearchResultsPage.filterBtn.click();
        etsyAppSearchResultsPage.filterRadioBtnOver1500.click();
        etsyAppSearchResultsPage.applyBtn.click();
    }

    @Then("user validates that item prices are over {string} dollars")
    public void userValidatesThatItemPricesOverDollars(String filterRange) throws InterruptedException {

        if (filterRange.equals("over 1500")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listItemPrices;

            for (WebElement el : prices) {
                // System.out.println(el.getText());
                // 2,299.00 -> convert it to double 2299.00
                String priceStr = el.getText().replace(",", ""); // 2299.00
                double actualPriceDbl = Double.parseDouble(priceStr);
                System.out.println(actualPriceDbl);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);

                Assert.assertTrue(actualPriceDbl >= expectedPriceDbl); // 1920.00 >= 1500.00
            }
        } else if (filterRange.equals("under 250")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listItemPrices;

            for (WebElement el : prices) {
                String priceStr = el.getText().replace(",", ""); // 2299.00
                double actualPriceDbl = Double.parseDouble(priceStr);
                System.out.println(actualPriceDbl);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);

                Assert.assertTrue(actualPriceDbl < expectedPriceDbl); // 1920.00 >= 250.00
            }
        } else if (filterRange.equals("250 to 750")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listItemPrices;

            for (WebElement el : prices) {
                String priceStr = el.getText().replace(",", "");
                double actualPriceDbl = Double.parseDouble(priceStr);
                System.out.println(actualPriceDbl);

                String expectedPrice1 = filterRange.substring(0, filterRange.indexOf(" ")); // 250
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(0, filterRange.lastIndexOf(" ") + 1); // 750
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);

                Assert.assertTrue(actualPriceDbl > expectedPriceDbl1 || actualPriceDbl < expectedPriceDbl2);
            }
        } else if (filterRange.equals("750 to 1500")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listItemPrices;

            for (WebElement el : prices) {
                String priceStr = el.getText().replace(",", "");
                double actualPriceDbl = Double.parseDouble(priceStr);
                System.out.println(actualPriceDbl);

                String expectedPrice1 = filterRange.substring(0, filterRange.indexOf(" ")); // 250
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(0, filterRange.lastIndexOf(" ") + 1); // 750
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);

                Assert.assertTrue(actualPriceDbl > expectedPriceDbl1 || actualPriceDbl < expectedPriceDbl2);
            }
        }

    }

    @When("user clicks on {string} section")
    public void user_clicks_on_section(String section) {
        if (section.equals("Jewelry & Accessories")) {
            etsyAppHomepage.jewelryAndAccessories.click();
        } else if (section.equals("Clothing & Shoes")) {
            etsyAppHomepage.clothingAndShoes.click();
        } else if (section.equals("Home & Living")) {
            etsyAppHomepage.homeAndLiving.click();
        } else if (section.equals("Wedding & Party")) {
            etsyAppHomepage.weddingAndParty.click();
        } else if (section.equals("Toys & Entertainment")) {
            etsyAppHomepage.toysAndEnt.click();
        } else if (section.equals("Art & Collectibles")) {
            etsyAppHomepage.artAndColl.click();
        } else if (section.equals("Craft Supplies")) {
            etsyAppHomepage.craftAndSupp.click();
        } else if (section.equals("Gifts & Gift Cards")) {
            etsyAppHomepage.giftsAndCards.click();
        }
    }

    @Then("user validates the title is {string} and the header is {string}")
    public void user_validates_the_title_is_and_the_header_is(String title, String header) {

        String actualHeader = "";
        String actualTitle = "";

        if (header.equals("Jewelry & Accessories")) {
            actualHeader = etsyTitlePages.jaHeader.getText();
            actualTitle = driver.getTitle();
        } else if (header.equals("Clothing & Shoes")) {
            actualHeader = etsyTitlePages.csHeader.getText();
            actualTitle = driver.getTitle();
        } else if (header.equals("Home & Living")) {
            actualHeader = etsyTitlePages.hlHeader.getText();
            actualTitle = driver.getTitle();
        } else if (header.equals("Wedding & Party")) {
            actualHeader = etsyTitlePages.wpHeader.getText();
            actualTitle = driver.getTitle();
        } else if (header.equals("Toys & Entertainment")) {
            actualHeader = etsyTitlePages.teHeader.getText();
            actualTitle = driver.getTitle();
        } else if (header.equals("Art & Collectibles")) {
            actualHeader = etsyTitlePages.acHeader.getText();
            actualTitle = driver.getTitle();
        } else if (header.equals("Craft Supplies & Tools")) {
            actualHeader = etsyTitlePages.cstHeader.getText();
            actualTitle = driver.getTitle();
        } else if (header.equals("The Etsy Gift Guide")) {
            actualHeader = etsyTitlePages.ggHeader.getText();
            actualTitle = driver.getTitle();
        }

        Assert.assertEquals(title, actualTitle);
        Assert.assertEquals(header, actualHeader);
    }

}
