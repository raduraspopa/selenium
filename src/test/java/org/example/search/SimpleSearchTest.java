package org.example.search;

import org.example.AppConfig;
import org.example.TestBase;
import org.example.webviews.Header;
import org.example.webviews.ProductsGrid;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//clasa care contine testele efective

@RunWith(Parameterized.class) //adnotare prin care aratam ca vom rula clasa ca suita parametrizata
public class SimpleSearchTest extends TestBase {

    //metoda adnotata cu @Parameterized.Parameters va instantia pe rand variabilele de instanta ale clasei cu fiecare valoare din ea
    private String searchKeyword; /* creem un constructor cu param. searchKeyword pt a parametriza (ca testul sa ruleze
                                     cu diferite valori pe care le poate lua aceasta variabila) */

    public SimpleSearchTest (String searchKeyword){ //datorita adnotarilor, clasa va fi rulata pentru fiecare parametru
        this.searchKeyword = searchKeyword;
    }

    @Parameterized.Parameters //adnotare prin care aratam ca aceasta metoda returneaza parametrii suitei de test
    public static List<String> data(){ /* metoda care sa returneze lista cu valorile pe care sa le ia searchKeyword */
        return Arrays.asList("vase", "camera");
    }

    @Test
    public void simpleSearchWithOneKeyword() {

        openHomePage();

        Header header = PageFactory.initElements(driver, Header.class); /*metoda care instantiaza variabila de tip header
                                                           gasind efectiv elementul de tip WebElement pe baza driver-ului
                                                           si folosindu-se de adnotarea @FindBy de la variabila searchField
                                                           din clasa Header */

        header.search(searchKeyword);

        // xpath for Add to cart button for Herlad Glass Wase so that we can click on it:
        // driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text()='Herald Glass Vase']]//button[@title='Add to Cart']")).click();

        System.out.println("Pressed Enter in search field.");

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        System.out.println("Stored " + productsGrid.getProductNames().size() + " product names");

        for (WebElement productName : productsGrid.getProductNames()) {
            Assert.assertThat("Some of the products' names do not contain the searched keyword.",
                    productName.getText(), CoreMatchers.containsString(searchKeyword.toUpperCase()));
        }
    }
}
