package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHome extends BasePage {

    By popUpSearch = By.name("postalNumber");
    By searchBoxLocator = By.xpath("//*[@id=\"__next\"]/div/header/div[2]/form/fieldset/div[1]/input");
    By PageLocatorHome = By.xpath("svg[class=\"sc-ezzafa dvHFX\"]");
    By popUpLocator = By.xpath("//*[@id=\"react-aria-modal-dialog\"]/div/div[1]/div");
    By categorySearchLocator = By.name("categoryTitle");
    By producSelect = By.id("filterItemsamsung");
    By buttonApply = By.id("apply");
    By ListProdDesple = By.xpath("a[name=\"viewAllBrands\"]");
    By linkProduFilter = By.cssSelector("h4[href=\"/l/?keyword=Heladera&categorias=heladeras-freezers-y-cavas%2Fheladeras\"]");
    By selectMarcaLocator = By.cssSelector("label[for=\"filterItemsamsung\"]");
    By selectAllMarcas = By.linkText("Ver todas");


    public PageHome(WebDriver driver) {
        super(driver);
    }

    public void homePageSearch(){
        //Se realiza para seleccionar el codigo Postal
        type("1425", popUpSearch);
        submit(popUpSearch);

        //Se realiza la busqueda del producto, en este caso Heladera/Heladeras
        click(searchBoxLocator);
        clear(searchBoxLocator);
        type("Heladera", searchBoxLocator);
        submit(searchBoxLocator);
        click(linkProduFilter);
        //Se realiza la busqueda del Heladeras por Marca
        click(selectAllMarcas);
        click(selectMarcaLocator);
        click(buttonApply);



    }
}
