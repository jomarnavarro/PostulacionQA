package test;


import org.testng.Assert;
import org.testng.annotations.Test;

public class MicroPlayTests extends BaseTests {

    @Test
     public  void testSearchAricle() {

        String nombreProducto = "mouse";

        loginPage.Login("jpleal79@gmail.com", "serrano832"); // login
        Assert.assertTrue(loginPage.at());

        homePage.buscarEnCajaDeTexto(nombreProducto);      // Buscar articulo en caja de texto.
        Assert.assertTrue(homePage.at());

        detallePage.seleccionarArticulo();                 // Selecciona Articulo y muestra su detalle.
        Assert.assertTrue(detallePage.at());

        carroDeComprasPage.agregarArticulo();               // Agregar al Carro de Compras
        Assert.assertTrue(carroDeComprasPage.at());

        carroDeComprasPage.eliminarProducto();              // Quitar Producto del carro de compras.
        Assert.assertTrue(carroDeComprasPage.totalCero());

        cerrarSesionPage.salir();                           // Cerrar  sesion.
        Assert.assertTrue(cerrarSesionPage.at());

    }

}

