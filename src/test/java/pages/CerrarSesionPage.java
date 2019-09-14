package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CerrarSesionPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@title='Cerrar Sesión']")
    private WebElement salir;
    @FindBy(xpath = " //a[contains (text(),'Ingresar')]")
    private WebElement ingresar;

    public CerrarSesionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);
    }

    public void salir(){
        salir.click();
    }

    public boolean at(){
        return ingresar.isDisplayed();
    }
}
