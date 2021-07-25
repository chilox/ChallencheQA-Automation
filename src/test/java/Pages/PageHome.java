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
    By linkProduFilter = By.cssSelector("h4[href=\"/l/?keyword=Heladera&categorias=heladeras-freezers-y-cavas%2Fheladeras\"]");
    By selectMarcaLocator = By.cssSelector("label[for=\"filterItemsamsung\"]");
    By selectAllMarcas = By.linkText("Ver todas");
    By listProduc = By.xpath("//section[@class=\"listingDesktopstyled__RightContainer-wzwlr8-5 cZmqHQ\"]// ul[@name=\"itemsGrid\"] /li");
    By resultSearchProd = By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[1]/ul/li[1]/span");



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
            click(selectMarcaLocator);
            click(buttonApply);
    }

    public void selectListProdu(){
        //Se crea la lista y se realiza las validaciones pertinentes

        List<WebElement> Lis = findElements(By.xpath("//section[@class=\"listingDesktopstyled__RightContainer-wzwlr8-5 cZmqHQ\"]// a[@rel=\"bookmark\"]"));
        System.out.println("La cantidad de articulos es: " + Lis.size());
        String resultSearchText = String.valueOf(Lis.size());
        Assert.assertEquals(resultSearchText, getText(resultSearchProd));
        Lis.contains("samsung");
    }
}
