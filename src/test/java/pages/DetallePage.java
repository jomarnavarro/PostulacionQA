package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetallePage {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@title='Mouse Neon X20 Ozone']")
    private WebElement clickEnArticulo;
    @FindBy(xpath = "//div[@id='box-descripcion']")
    private WebElement detalleDelProducto;
    @FindBy(xpath = "//span[@class='text_web']")
    WebElement precioWeb;
    @FindBy(xpath = "//span[@class='oferta']")
    private WebElement precioTienda;

    public DetallePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 15);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void seleccionarArticulo() {
        clickEnArticulo.click();

    }

    public boolean at() {
        return detalleDelProducto.isDisplayed() && precioWeb.isDisplayed() && precioTienda.isDisplayed();
    }


}