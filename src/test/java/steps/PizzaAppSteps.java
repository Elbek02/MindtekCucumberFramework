package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Map;

public class PizzaAppSteps {
    WebDriver driver = Driver.getDriver();
    PizzaAppPage pizzaAppPage = new PizzaAppPage();
    String costValue;

    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) throws InterruptedException {

        /*
            String strNum="1234
            int myInt=Integer.parseInt(strNum)
        */

        //{Pizza=Small 6 Slices - no toppings, Topping1=Mushrooms, Topping2=Extra cheese, Quantity=1,
        // Name=Patel Harsh, Email=patel@gmail.com, Phone=123456789, Payment=Cash on Pickup} - Map<String,String>


        Map<String,String> data = dataTable.asMap(String.class,String.class);
        for (String value: data.values()){
            System.out.println(value);
        }

        Thread.sleep(3000);
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropdown,data.get("Pizza")); //selecting value from the Pizza dropdown
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping1Dropdown,data.get("Topping1")); // Mushrooms
        BrowserUtils.selectDropdownByValue(pizzaAppPage.topping2Dropdown,data.get("Topping2")); // Extra Cheese
         //   pizzaAppPage.pizzaQtyBox.sendKeys(Keys.CONTROL+"A");
        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.BACK_SPACE);
        pizzaAppPage.pizzaQtyBox.clear();
        pizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity")); // "1"
        pizzaAppPage.nameBox.sendKeys(data.get("Name")); // "Patel Harsh"
        pizzaAppPage.emailBox.sendKeys(data.get("Email"));// "patel@gmail.com
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone")); //"123456789"
        costValue=pizzaAppPage.pizzaCostBox.getAttribute("value");

        if (data.get("Payment").equals("cash on Pickup")){
            pizzaAppPage.cashRadioButton.click();
        }else{
          pizzaAppPage.creditCardRadioButton.click();
        }
        pizzaAppPage.placeOrderButton.click();
    }

    @Then("user validates that order is created with message {string} {string} {string}")
    public void userValidatesThatOrderIsCreatedWithMessage(String success, String quantity, String pizza) {
        String expectedMessage=success+costValue+" "+pizza;
        String actualMessage = pizzaAppPage.dialogWindow.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
