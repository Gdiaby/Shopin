package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLogin {


    ChromeDriver driver1;

    public PageLogin(ChromeDriver driver2){

        this.driver1 = driver2;

    }
    public void login(String username, String password){

        driver1.findElement(By.xpath("//a[@aria-label='Login']")).click();
        driver1.findElement(By.id("username")).sendKeys(username);
        driver1.findElement(By.id("password")).sendKeys(password + Keys.ENTER);

    }



}
