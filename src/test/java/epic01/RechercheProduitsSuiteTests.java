package epic01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class RechercheProduitsSuiteTests {


    /*
    Dans cette classe d'execution de cas de tests, je peux creer plusieurs scenarios sous forme de methodes d'execution
     */


  @Test
    public void recherche_produit_inexistant()  {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://shop-in.ovh/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div[2]/div/div[3]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/form/input")).sendKeys("T-shirt" + Keys.ENTER);




    }

    public void recherche_produit_existant(){


    }





}
