package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BrowserUtils {

    /**
     * This method will accept WebElement of dropdown
     * and String value of dropdown, and will select
     * provided value in dropdown.
     */
    public static void selectDropdownByValue(WebElement el, String value){
        Select select=new Select(el);
        select.selectByValue(value);
    }

    /**
     * This method takes screenshot.
     * Ex:
     *      takeScreenshot("SauceDemo Test")
     */
    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/"+testName+".png";
        File file = new File(path);
        FileUtils.copyFile(screenshot,file);
    }

    /**
     * This method generates random emails.
     * Ex:
     *     getRandomEmail(); -> returns testUserEmail34567@gmail.com
     */
    public static String getRandomEmail(){

//        String userName="testUser";
//        Random random = new Random();
//        int num= random.nextInt(999_999);
//        return userName+num+"@gmail.com";

        String userName="user";
        UUID uuid = UUID.randomUUID();
        return userName+uuid+"@gmail.com";
    }

    /**
     * This method generates very strong password.
     * Ex:
     *     getRandomStrongPassword(); -> returns random very strong password
     */
    public static String getRandomStrongPassword(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
