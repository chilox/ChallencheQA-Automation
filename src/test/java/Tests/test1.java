package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class test1 extends TestBase{
    WebDriver driver;


    @Test
    public void testSearch(){

        pageHome.popUp();
        pageHome.homePageSearch();
        pageHome.pageSearch();
        pageHome.selectListProdu();

    }


}
