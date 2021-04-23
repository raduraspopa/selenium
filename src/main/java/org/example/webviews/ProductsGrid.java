package org.example.webviews;


/* Clasa de tip Page Object care sa returneze o lista de WebElements care sa contina numele produselor */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGrid {

    @FindBy(css = "h2.product-name > a")
    private List<WebElement> productNames;

    public List<WebElement> getProductNames() {
        return productNames;
    }
}
