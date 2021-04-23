package org.example.webviews;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*    clasa de tip Page Object pt header-ul site-ului; aici putem defini toate elementele de pe pagina
      care ne intereseaza si metoda de identificare */

public class Header {

    @FindBy(id = "search") //adnotare pt a atribui variabilei searchField elementul de pe pagina web cu id-ul search
    private WebElement searchField;

    public WebElement getSearchField() {
        return searchField;
    }

    public void search(String keyword){
        searchField.sendKeys(keyword + Keys.ENTER);
    }

}
