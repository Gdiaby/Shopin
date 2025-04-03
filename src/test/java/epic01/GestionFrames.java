package epic01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class GestionFrames {

    ChromeDriver driver = new ChromeDriver();
    HomePage hp = new HomePage(driver);

    @BeforeEach
    public void init() {

        hp.acceder_a_url("https://the-internet.herokuapp.com/iframe");

    }

    @Test
    public void recuperer_paragraphe_dans_editeur(){

        driver.switchTo().frame("mce_0_ifr");
        /* On doit switch dans le frame, entrer dans le cadre
        parce que sinon Selenium n'arrive pas à trouver l'élément
        texte présent à l'intérieur du cadre/frame

        Ici, on a choisi de localiser le frame par son Id (on peut aussi mettre
        un Name s'il a cet attribut.

        On peut aussi le localiser par son numéro/index. S'il y a plusieurs frame
        dans la page, il faut identifier son numéro en inspectant (si c'est le
        premier frame alors son index = 0 -->    driver.switchTo().frame(0);

         */

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        /*attente jusqu'à apparition du paragraphe puis récupération de son contenu
         */

        String texte_actuel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='tinymce']//p"))).getText();
        String texte_attendu = "Your content goes here.";

        Assertions.assertEquals(texte_attendu, texte_actuel);

        driver.switchTo().defaultContent();
        /*on sort de la frame, on revient à la page principale = defaultContent
         */

        driver.findElement(By.xpath("//div[@id='page-footer']//a")).click();

        
    }




    }


