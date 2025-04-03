package epic04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GestionAlertsSuiteTests {
    ChromeDriver driver = new ChromeDriver();

    @BeforeEach
    public void init(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

   @Test
    public void acceptation_alert()  {

     driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

     wait.until(ExpectedConditions.alertIsPresent());
     driver.switchTo().alert().accept();
     String texte_actuel =  driver.findElement(By.id("result")).getText();

        String texte_attendu = "You clicked: Ok";

        Assertions.assertEquals(texte_attendu, texte_actuel);

     //  Assertions.assertTrue(texte_actuel.contains("Ok"));

    }
    @Test
    public void cancel_alert()  {

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String texte_actuel =  driver.findElement(By.id("result")).getText();
        String texte_attendu = "You clicked: Cancel";
        Assertions.assertEquals(texte_attendu, texte_actuel);
        //  Assertions.assertTrue(texte_actuel.contains("Ok"));

    }
    @AfterEach

    public void close(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.close();
    }

}
