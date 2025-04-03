package epic01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.PageProduits;

import java.time.Duration;

public class AchatProduitSuiteTests {

    ChromeDriver driver = new ChromeDriver();
    PageProduits pp = new PageProduits(driver);
    HomePage hp = new HomePage(driver);

    @BeforeEach
    public void init(){

        hp.acceder_a_url("https://shop-in.ovh/");

    }
    @Test
    public void achat_produit_en_stock(){

        pp.choix_produit("Air Jordan 1 Low FlyEase");

    }

    @Test
    public void achat_produit_en_stock2(){

        pp.choix_produit("Ballon de match Orbita");

    }
}
