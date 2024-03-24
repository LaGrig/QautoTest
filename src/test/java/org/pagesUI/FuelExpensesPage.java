package org.pagesUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FuelExpensesPage extends Web {

    private final static String addExpensesButton = "//button [@class='btn btn-primary' and text()='Add an expense']";
    private final static String carSelectorDropDown = "//*[@id='carSelectDropdown']";
    private final static String addExpensesCarSelectorDropDown = "//*[@id='addExpenseCar']";
    private final static String addExpensesCalendar = "//*[@id='addExpenseDate']";
    private final static String addMileageInput = "//*[@id='addExpenseMileage']";
    private final static String addLitersInput = "//*[@id='addExpenseLiters']";
    private final static String addCostInput = "//*[@id='addExpenseTotalCost']";
    private final static String addValuesButton = "//button[text()='Add']";

    public SimpleDateFormat getSdf() { return sdf; }
    public Date getNow() {  return now; }
    public String getFormattedDate() { return formattedDate; }
    public Random getRand() { return rand; }
    public int getMileage() { return mileage; }
    public int getLiters() { return liters; }
    public double getCost() { return cost; }


    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    Date now = new Date();
    String formattedDate = sdf.format(now);

    Random rand = new Random();
    int mileage = rand.nextInt(500) + 1;
    int liters = rand.nextInt(60) + 1;
    double cost = rand.nextDouble() * 300.00 + 20.00;

    public void addFuelExpensesButtonClick() {
        driver.findElement(By.xpath(addExpensesButton)).click();
    }

    public void changeDropdownToFiatScudo(){
        WebElement dropDown = driver.findElement(By.xpath(carSelectorDropDown));
        Select selectModel = new Select(dropDown);
        selectModel.selectByValue("Fiat Scudo");
    }

    public void addExpensesPopUpWindowFillIn() throws InterruptedException {
        Thread.sleep(1000);
        //WebElement carSelector = driver.findElement(By.xpath(addExpensesCarSelectorDropDown));
        WebElement calendar = driver.findElement(By.xpath(addExpensesCalendar));
        WebElement addMileage = driver.findElement(By.xpath(addMileageInput));
        WebElement addButton = driver.findElement(By.xpath(addValuesButton));
        WebElement addLiters = driver.findElement(By.xpath(addLitersInput));
        WebElement addCost = driver.findElement(By.xpath(addCostInput));
//        Select selectCar = new Select(carSelector);
//        selectCar.selectByValue("Fiat Scudo");
        calendar.clear();
        calendar.sendKeys(formattedDate);
        addMileage.clear();
        addMileage.sendKeys(String.valueOf(mileage));
        addLiters.clear();
        addLiters.sendKeys(String.valueOf(liters));
        addCost.sendKeys(String.valueOf(cost));
        addButton.click();
    }
}
