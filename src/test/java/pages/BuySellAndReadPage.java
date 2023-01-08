package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BuySellAndReadPage {

    public BuySellAndReadPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='search-catalog-navbar']")
    public WebElement searchBar;

    @FindBy(xpath = "//span[@class='rs-navbar-search-button-label']")
    public WebElement searchBtn;


    @FindBy(xpath = "//h1[@class='mdc-typography--headline4']")
    public WebElement searchResult;

//    public void clickSearchBtn(String searchWord){
//    searchBar.sendKeys(searchWord);
//    searchBtn.click();
//
//   }
}
