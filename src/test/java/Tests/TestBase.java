package Tests;

import Pages.BasePage;
import Pages.PageHome;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase  {
    protected PageHome pageHome;
    protected WebDriver driver;

    @Before
    public void setUp(){

        pageHome = new PageHome(driver);
        driver = pageHome.chormeDriverconection();
        pageHome.urlPage("https://www.fravega.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
