package epi02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageLogin;

public class AuthentificationSuiteTests {

    ChromeDriver driver = new ChromeDriver();
    PageLogin pl = new PageLogin(driver);

@BeforeEach
    public void init(){
        driver.get("https://shop-in.ovh/");
        driver.manage().window().fullscreen();
    }


@Test
    public void authentification_identifiants_valides(){

     pl.login("amira","amirabenahmed01");

    }

    @Test
    public void authentification_identifiants_invalides(){

        pl.login("amira","amirabenahmed0jjjjj");



    }



}
