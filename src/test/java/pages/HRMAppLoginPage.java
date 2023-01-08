package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HRMAppLoginPage {
    public HRMAppLoginPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[name='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[name='password']")
    public WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    public WebElement loginBtn;

}
