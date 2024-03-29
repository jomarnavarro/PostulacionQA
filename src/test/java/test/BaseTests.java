package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    WebDriver driver;

   public LoginPage loginPage;
    public HomePage homePage;
    public DetallePage detallePage;
    public CarroDeComprasPage carroDeComprasPage;
    public CerrarSesionPage cerrarSesionPage;

    @BeforeMethod
    public void beforeMetohd() {
        String path = Paths.get(System.getProperty("user.dir"), "src/test/resources/webdrivers/chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", path);
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.microplay.cl/");

        homePage = new HomePage(driver);
        detallePage = new DetallePage(driver);
        loginPage = new LoginPage(driver);
        carroDeComprasPage = new CarroDeComprasPage(driver);
        cerrarSesionPage = new CerrarSesionPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
