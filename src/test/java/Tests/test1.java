package Tests;

import Pages.PageHome;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class test1 extends TestBase{



    @Test
    public void testSearch(){

        pageHome.popUp();
        pageHome.homePageSearch();
        pageHome.pageSearch();
        pageHome.selectListProdu();

    }


}
