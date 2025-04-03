package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomePage {

    ChromeDriver driver;

    public HomePage(ChromeDriver driver){

        this.driver = driver;
    }
    public void acceder_a_url(String url){


        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



}
