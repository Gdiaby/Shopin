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

public class GestionNestedFrames {

    ChromeDriver driver = new ChromeDriver();
    HomePage hp = new HomePage(driver);

    @BeforeEach
    public void init() {

        hp.acceder_a_url("https://the-internet.herokuapp.com/nested_frames");
    }


    @Test
    public void naviguer_dans_les_differentes_frame(){

       /*driver.switchTo().frame(0)
        */

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        /* On doit switch dans le frame, entrer dans le cadre
        parce que sinon Selenium n'arrive pas à trouver l'élément
        texte présent à l'intérieur du cadre/frame

        Ici, on a choisi de localiser le frame par son Id (on peut aussi mettre
        un Name s'il a cet attribut.

        On peut aussi le localiser par son numéro/index. S'il y a plusieurs frame
        dans la page, il faut identifier son numéro en inspectant (si c'est le
        premier frame alors son index = 0 -->    driver.switchTo().frame(0);

         */

        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        attente jusqu'à apparition du paragraphe puis récupération de son contenu
         */

        String left_contenu = driver.findElement(By.tagName("body")).getText();
        /* Ici, on peut se permettre d'utiliser le tagName parce que
        malgré le fait que dans le code HTML il y a 4 body quand on
        est rentré dans la frame-left, il n'y a plus qu'un seul body
        détectable.

         */

        System.out.println(left_contenu);


        /*String texte_actuel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[normalize-space()='LEFT']"))).getText();
        String texte_attendu = "LEFT";

        Assertions.assertEquals(texte_attendu, texte_actuel);

         */

        /*driver.switchTo().defaultContent(); pas nécessaire on retourne directement au frame parent voir ligne 64

         */

        /*ici on sort de la frame-left en retournant dans la frame parent
        pour pouvoir accéder à la frame-right
         */


        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");

        String right_contenu = driver.findElement(By.tagName("body")).getText();

        System.out.println(right_contenu);



        driver.switchTo().parentFrame();

       /* driver.switchTo().frame(0);

        */

        driver.switchTo().frame("frame-middle");

        /* On doit switch dans le frame, entrer dans le cadre
        parce que sinon Selenium n'arrive pas à trouver l'élément
        texte présent à l'intérieur du cadre/frame

        Ici, on a choisi de localiser le frame par son Id (on peut aussi mettre
        un Name s'il a cet attribut.

        On peut aussi le localiser par son numéro/index. S'il y a plusieurs frame
        dans la page, il faut identifier son numéro en inspectant (si c'est le
        premier frame alors son index = 0 -->    driver.switchTo().frame(0);

         */

        String middle_contenu = driver.findElement(By.tagName("body")).getText();

        System.out.println(middle_contenu);



        driver.switchTo().defaultContent();
        /* ici, on doit retourner au default content parce que le
         frame-bottom n'est pas dans le cadre frame-top
         il est accessible qu'à partir du default-content
         */

        driver.switchTo().frame("frame-bottom");

        String bottom_contenu = driver.findElement(By.tagName("body")).getText();

        System.out.println(bottom_contenu);




        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-right");

        String right_contenu1 = driver.findElement(By.tagName("body")).getText();

        System.out.println(right_contenu1);


      /* String texte_actuel2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content"))).getText();
       String texte_attendu2 = "MIDDLE";

       Assertions.assertEquals(texte_attendu2, texte_actuel2);

       */




    }
}
