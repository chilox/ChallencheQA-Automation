package Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
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
    By resultSearchProd = By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/ul/li[1]/span");
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

        List<WebElement> Lis = findElements(By.xpath("//section[@class=\"listingDesktopstyled__RightContainer-wzwlr8-5 cZmqHQ\"]// a[@rel=\"bookmark\"]"));
            WebElement total;
        for (int i=0; i<Lis.size(); ++i) {
            if (Lis.get(i).getText().contains("Patrick")) {
                total = Lis.get(i);
                System.out.println("El resultado es Correcto");
                Assert.assertEquals(Lis.size(), getText(resultSearchProd));
                System.out.println("El valor es correspondiente");
                Assert.assertEquals("Heladeras", getText(breadCrumb));
                System.out.println("Resultado correcto");
            } else {
                System.out.println("El proceso de Validación es fallido");

            }

        }
    }
}
