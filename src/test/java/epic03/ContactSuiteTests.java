package epic03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class ContactSuiteTests {
    ChromeDriver driver = new ChromeDriver();

    @BeforeEach
    public void init(){

        driver.get("https://shop-in.ovh/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void entrer_coordonnées(){



        driver.findElement(By.xpath("//li[@id='menu-item-1096']//a[@href='https://shop-in.ovh/contact/']")).click();
        driver.findElement(By.id("wpforms-156-field_0")).sendKeys("Léa");
        driver.findElement(By.id("wpforms-156-field_5")).sendKeys("012345678");
        driver.findElement(By.id("wpforms-156-field_1")).sendKeys("leaaaaaaa@yahoo.com");
        driver.findElement(By.id("wpforms-156-field_2")).sendKeys("Je souhaite poser des questions");
        driver.findElement(By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.findElement(By.xpath("//button[normalize-space()='Envoyer le message']")).sendKeys(Keys.ENTER);

        String resultat_attendu = "Merci de nous avoir contacté! Nous vous contacterons sous peu.";

        String resultat_actuel = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-156']/p")).getText();

        // Assertion = auditer cad : comparer un resultat attendu avec un resultat actuel
        Assertions.assertEquals(resultat_attendu,resultat_actuel);

}

@Test
public void entrer_coordonnées_non_valides(){

    driver.findElement(By.xpath("//li[@id='menu-item-1096']//a[@href='https://shop-in.ovh/contact/']")).click();
    driver.findElement(By.id("wpforms-156-field_0")).sendKeys("Léa");
    driver.findElement(By.id("wpforms-156-field_5")).sendKeys("012345678");
    driver.findElement(By.id("wpforms-156-field_1")).sendKeys("leaaaaaaa");
    driver.findElement(By.id("wpforms-156-field_2")).sendKeys("Je souhaite poser des questions");
    driver.findElement(By.xpath("//a[@class='woocommerce-store-notice__dismiss-link']")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    driver.findElement(By.xpath("//button[normalize-space()='Envoyer le message']")).sendKeys(Keys.ENTER);

    String resultat_attendu = "Veuillez saisir une adresse e-mail valide.";

    String resultat_actuel = driver.findElement(By.id("wpforms-156-field_1-error")).getText();

    // Assertion = auditer cad : comparer un resultat attendu avec un resultat actuel
    Assertions.assertEquals(resultat_attendu,resultat_actuel);



}

@AfterEach
public void close(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.close();

}


}
