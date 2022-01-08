package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PageHome extends BasePage {

    By popUpSearch = By.name("postalNumber");
    By searchBoxLocator = By.xpath("//*[@id=\"__next\"]/div/header/div[2]/form/fieldset/div[1]/input");
    By buttonApply = By.id("apply");
    By linkProduFilter = By.cssSelector("#__next > div.sc-fiKUBa.hiiBo > div.categorySlug__ListingLayout-shopping-ui__sc-1l2p1q1-2.hvCjrw > div.categorySlug__Desktop-shopping-ui__sc-1l2p1q1-1.eXwRKq > div:nth-child(2) > ul > li:nth-child(1) > h4 > a");
    By selectMarcaLocator = By.cssSelector("label[for=\"filterItemsamsung\"]");
    By selectAllMarcas = By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div[2]/ul/li[1]/a/div/div");
    By listProduc = By.xpath("//section[@class=\"listingDesktopstyled__RightContainer-wzwlr8-5 cZmqHQ\"]// ul[@name=\"itemsGrid\"] /li");
    By resultSearchProd = By.cssSelector("#__next > div.sc-fiKUBa.hiiBo > div.categorySlug__ListingLayout-shopping-ui__sc-1l2p1q1-2.hvCjrw > div.categorySlug__CategoryArea-shopping-ui__sc-1l2p1q1-5.igXrHE > span > span");
    By breadCrumb = By.xpath("/html/body/div[1]/div[2]/div[3]/div[2]/div/ol/li[5]/span");




    public PageHome(WebDriver driver) {
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
        click(linkProduFilter);
    }

    public void pageSearch (){
            //Se realiza la busqueda del Heladeras por Marca
            click(selectAllMarcas);
            //click(selectMarcaLocator);
            //click(buttonApply);
    }

    public void selectListProdu(){
        //Se crea la lista y se realiza las validaciones pertinentes
        String Marca = "Patrick";
        String Electrodomestico = "Heladeras";
        List<WebElement> list = findElements(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div[5]/ul/li"));
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            Assert.assertTrue(list.get(i).getText().contains(Marca));
            Assert.assertEquals(list.size(), getText(resultSearchProd));
            Assert.assertEquals(Electrodomestico, getText(breadCrumb));

        }

    }
}
