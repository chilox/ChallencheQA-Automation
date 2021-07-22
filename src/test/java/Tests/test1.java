package Tests;

import Pages.PageHome;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class test1 {
    private WebDriver driver;
    PageHome pageHome;

    @Before
    public void setUp(){
        pageHome = new PageHome(driver);
        driver = pageHome.chormeDriverconection();
        pageHome.urlPage("https://www.fravega.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch(){
        pageHome.homePageSearch();
    }

    @After
    public void tearDown(){
        driver.quit();
    }



}
