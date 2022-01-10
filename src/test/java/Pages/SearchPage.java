package Pages;


import javafx.util.converter.NumberStringConverter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {
    By popUpSearch = By.name("postalNumber");
    By searchBoxLocator = By.xpath("//*[@id=\"__next\"]/div/header/div[2]/form/fieldset/div[1]/input");
    By breadCrumb = By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div/ol/li[5]/span");
    By produTitle = By.xpath("h1[data-test-id=\"result-title\"]");
    By resultSearchProd = By.cssSelector("#__next > div.sc-fiKUBa.hiiBo > div.categorySlug__ListingLayout-shopping-ui__sc-1l2p1q1-2.hvCjrw > div.categorySlug__CategoryArea-shopping-ui__sc-1l2p1q1-5.igXrHE > span > span");
    By buttonNext = By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[6]/ul/li[4]");
    By selectAllMarcas = By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div[2]/ul/li[1]/a/div/div");
    By linkProduFilter = By.cssSelector("#__next > div.sc-fiKUBa.hiiBo > div.categorySlug__ListingLayout-shopping-ui__sc-1l2p1q1-2.hvCjrw > div.categorySlug__Desktop-shopping-ui__sc-1l2p1q1-1.eXwRKq > div:nth-child(2) > ul > li:nth-child(1) > h4 > a");


    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void popUp(){
        //Se realiza para seleccionar el codigo Postal
        type("1425", popUpSearch);
        submit(popUpSearch);
    }

    public void homePageSearch() {
        //Se realiza la busqueda del producto, en este caso Heladera/Heladeras
        click(searchBoxLocator);
        clear(searchBoxLocator);
        type("Heladera", searchBoxLocator);
        submit(searchBoxLocator);
    }



    public void pageSearch (){
        //Se realiza la busqueda del Heladeras por Marca
        click(linkProduFilter);
        click(selectAllMarcas);

    }

    public boolean isDisplayed(){
        return this.isDisplayed(buttonNext);
    }

    public void selectListProdu() {
        //Se crea la lista y se realiza las validaciones pertinentes

        String Marca = "Patrick";
        String Electrodomestico = "Heladeras";

        List<WebElement> list = findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[5]/ul/li"));
        List<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listNumber.add(list.size());
        }
        if (isDisplayed(buttonNext)) {
            click(buttonNext);
            list = findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[5]/ul/li"));
            for (int i = 0; i < list.size(); i++) {
                listNumber.add(list.size());

                Assert.assertTrue(list.get(i).getText().contains(Marca));
            }
        }
        int a = listNumber.size();
        String b = String.valueOf(a);
        Assert.assertEquals(Electrodomestico, getText(breadCrumb));
        Assert.assertEquals(b, getText(resultSearchProd));

    }
}
