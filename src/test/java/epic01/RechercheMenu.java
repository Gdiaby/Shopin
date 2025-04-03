package epic01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;


import java.util.List;

public class RechercheMenu {


    ChromeDriver driver = new ChromeDriver();
    HomePage hp = new HomePage(driver);

    @BeforeEach
    public void init() {

        hp.acceder_a_url("https://shop-in.ovh/");

    }

    @Test
    public void acces_au_menu() {

        List<WebElement> menus_elements = driver.findElements(By.xpath("//ul[@id='menu-main-menu']//a[@class='ct-menu-link']"));
        //List<WebElement> menus_elements = driver.findElements(By.tagName("a"));

        /* "La boucle for" va être utilisé pour cliquer sur tous les éléments
         l'un après l'autre car on ne peut pas utiliser la méthode ".click" puisque
        le Xpath concerne tous les éléments de la nav bar

         */

        for (WebElement menu_element : menus_elements){

            String[] tabs = {"BOUTIQUE", "CONTACT", "BLOG"};
            /* tab = tableau de String, en gros une liste de suite de caractère
             */
            for ( String tab : tabs ) {


                if (menu_element.getText().equals(tab)) {

                    /* On rajoute une condition
                     */

                    menu_element.click();
                    driver.navigate().back();

                    /* on met la navigate.back pour revenir dans la page précédente
                    pour qu'il puisse cliquer sur les autres éléments
                    Boutique "back" puis Blog "back" puis Contact
                     */

                    break;


                }
            }

        }


    }
}