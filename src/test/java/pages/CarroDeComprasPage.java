package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarroDeComprasPage {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@class='btn-agregar2 nuevo'][contains (text(),'Agregar')]")
    private WebElement agregar;

    @FindBy(xpath = "//div[@id='val_a_pagar'][contains (text(),'26.990')]")
    private WebElement precioWeb;

    @FindBy(xpath = "//a[@class='btn-borrar delete_item']")
    private WebElement quitarProducto;

    @FindBy(xpath = "//*[@id='val_a_pagar'][contains (text(),'0')]")
    private WebElement totalAPagarCero;


    public CarroDeComprasPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 15);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void agregarArticulo() {
        agregar.click();

    }

    public void eliminarProducto(){
      quitarProducto.click();

    }

    public boolean at(){
        return precioWeb.isDisplayed();
    }

    public boolean totalCero(){
        return totalAPagarCero.isDisplayed();
    }
}
