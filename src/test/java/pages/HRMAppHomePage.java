package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HRMAppHomePage {
    public HRMAppHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//aside/nav/div[2]/ul/li[2]/a")
    public WebElement PIMBtn;
    @FindBy(xpath = "//div[5]//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[2]//i[1]")
    public WebElement editBtn;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastName;
    @FindBy(xpath = "(//button)[2]")
    public WebElement saveBtn;


}
