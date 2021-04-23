package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* clasa care sa se ocupe de preluarea datelor din fisierele de configurare,
   assignarea lor la anumite variabile si returnarea lor prin gettere */

public class AppConfig {

    private static Properties properties = new Properties();

    static {

/*      setam care fisier de configurare sa fie folosit in functie de valoarea pe care o dam parametrului env in cmd (si dam valoarea
        default production, in caz ca userul nu atribuie vreo valoare parametrului env*/

        String environment = System.getProperty("env", "production");
        InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream(environment+".properties"); /*concatenam
        qa/production (in functie de ce seteaza userul din terminal) cu .properties (pt ca denumirea ambelor fisiere se termina astfel)*/

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Failed to load properties from configuration file");;
        }
    }

    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String geckoDriverPath = properties.getProperty("gecko.driver.path");
    private static String internetExplorerDriverPath = properties.getProperty("ie.driver.path");
    private static String siteUrl = properties.getProperty("site.url");

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static String getInternetExplorerDriverPath() { return internetExplorerDriverPath; }

    public static String getSiteUrl() {
        return siteUrl;
    }
}
