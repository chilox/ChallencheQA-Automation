package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test1 extends TestBase{
    WebDriver driver;


    @Test
    public void testSearch(){


        searchPage.popUp();
        searchPage.homePageSearch();
        searchPage.pageSearch();
        searchPage.isDisplayed();
        searchPage.selectListProdu();

    }

}
