package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageProduits {

 ChromeDriver driver;


 public PageProduits(ChromeDriver driver){

     this.driver=driver;

 }

    public void choix_produit(String nom_produit){

        driver.findElement(By.xpath("//li[@id='menu-item-689']//a[@href='https://shop-in.ovh/boutique/']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

       /* ((JavascriptExecutor)driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
       ça sert à scroller en bas de page

        */

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@aria-label='"+nom_produit+"']")))).click();
        driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
        driver.findElement(By.xpath("//a[@class='added_to_cart wc-forward']")).click();

    }



}
