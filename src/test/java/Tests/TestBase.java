package Tests;


import Pages.PageHome;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.util.concurrent.TimeUnit;

public class TestBase  {
    protected PageHome pageHome;
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){

        pageHome = new PageHome(driver);
        driver = pageHome.chormeDriverconection();
        pageHome.urlPage("https://www.fravega.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
   }


}
