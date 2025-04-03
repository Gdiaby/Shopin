package epic01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import java.util.ArrayList;


public class GestionFenetres {


    ChromeDriver driver = new ChromeDriver();
    HomePage hp = new HomePage(driver);

    @BeforeEach
    public void init() {

        hp.acceder_a_url("https://shop-in.ovh/");

    }

    @Test
    public void interaction_shopin_ups(){


        ((JavascriptExecutor) driver).executeScript("window.open('');");
        /* Pour ouvrir un nouvel onglet ou page vide grâce à Javascript Executor
        en Informatique, le premier onglet est le numéro 0 ou index 0
         */

        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        /*On a récupéré toutes les fenêtres ouvertes et
        on les a mis dans un tableau qui s'appelle ArrayList
         */

        driver.switchTo().window(windows.get(1));
        // Passer au nouvel onglet vide qui a pour index 1

        hp.acceder_a_url("https://www.ups.com/fr/fr/home");
        // on a chargé le 2nd onglet qui est index 1 : avec l'Url d'UPS

        driver.switchTo().window(windows.get(0));
        // on est retourné au 1er onglet qui est index 0 : Shop-in


        
        
    }



}
