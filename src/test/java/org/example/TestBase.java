package org.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// clasa care se ocupa de actiunile repetitive care sa fie efectuate la inceputul si sfarsitul fiecarui test

public class TestBase {

    protected WebDriver driver = null;

    @Before /* - executa metoda inaintea fiecarui test (@BeforeClass ar fi executat metoda doar o singura data, la inceputul clasei)*/
    public void setup() {

        /* valoarea variabilei browser va fi setata de user din terminal sau va primi valoarea default chrome daca nu e setata,
        *  iar pe baza ei metoda getDriver din DriverFactory va returna un browser */
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);
    }

    @After /*- executa metoda la sfarsitul fiecarui test*/
    public void tearDown(){

        driver.quit();
    }

    public void openHomePage(){
        driver.get(AppConfig.getSiteUrl());
    }

}

/*  exemplu de rulare a testului din terminal setand valoarea variabilei browser:
    mvn test -Dtest=SimpleSearchTest -Dbrowser=firefox */
