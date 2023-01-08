package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.HRMAppEditEmpPage;
import pages.HRMAppHomePage;
import utilities.Driver;

public class HRMAppSteps {
    WebDriver driver = Driver.getDriver();
    HRMAppHomePage hrmAppHomePage=new HRMAppHomePage();
    HRMAppEditEmpPage hrmAppEditEmpPage = new HRMAppEditEmpPage();
    @And("user clicks on {string} section and user selects random employee")
    public void user_clicks_on_section_and_user_selects_random_employee(String string) {
       hrmAppHomePage.PIMBtn.click();

    }

    @And("user clicks on edit button to edit existing employee info")
    public void user_clicks_on_edit_button_to_edit_existing_employee_info() {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollBy(0, 2500)");
        hrmAppHomePage.editBtn.click();
        hrmAppHomePage.lastName.clear();
        hrmAppHomePage.lastName.sendKeys("Smith");
    }
    @And("user clicks on save button")
    public void user_clicks_on_save_button() {
        hrmAppHomePage.saveBtn.click();
    }
    @Then("user validates success message displayed")
    public void user_validates_success_message_displayed() {
        String expectedMessage = "Successfully updated";
        System.out.println(expectedMessage);
        String actualMessage=hrmAppEditEmpPage.successMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
