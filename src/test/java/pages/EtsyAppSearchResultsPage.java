package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchResultsPage {

    public EtsyAppSearchResultsPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/ol/li/div/div/a/div[2]/h3")
    public List<WebElement> listOfItemsTitles;


    @FindBy(xpath = "//span[@class=\"wt-hide-xs wt-show-md filter-expander\"]")
    public WebElement filterBtn;

    @FindBy(xpath = "//label[contains(text(),'Over $1,500')]")
    public  WebElement filterRadioBtnOver1500;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    public WebElement applyBtn;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//span[@class='currency-value']")
    public List<WebElement> listItemPrices;

}
