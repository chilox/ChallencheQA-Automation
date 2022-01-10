package Tests;



import Pages.SearchPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

public class TestBase  {
        protected SearchPage searchPage;
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){

        searchPage = new SearchPage(driver);
        driver = searchPage.chormeDriverconection();
        searchPage.urlPage("https://www.fravega.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
   }


}
