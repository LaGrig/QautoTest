package org.pagesUI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Web {
    public static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public static final String homePageUrl = "https://guest:welcome2qauto@qauto.forstudy.space/";
    public static final String garagePageUrl = "https://guest:welcome2qauto@qauto.forstudy.space/panel/garage";
    public static final String fuelExpensesPageUrl = "https://guest:welcome2qauto@qauto.forstudy.space/panel/expenses";


    public String getCurrentWebAddress() {
        return driver.getCurrentUrl();
    }

    public void checkCurrentUrl (String urlToCheck){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, urlToCheck);
    }

    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void goToHomePage(){
        driver.get(homePageUrl);
    }

    public void goToFuelExpensesPage(){
        driver.get(fuelExpensesPageUrl);
    }
}
