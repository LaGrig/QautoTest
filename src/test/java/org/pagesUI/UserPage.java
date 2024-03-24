package org.pagesUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class UserPage extends Web{

    //Locators
    //Page objects locators
    public static final String loggedInAsGuestNotifier = "//* [@class='header_bar' and text()='Logged in as guest, any changes will be lost!']";
    private final String sidebarGarageLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn -active' and @href='/panel/garage']";
    private final String headerGarageLink = "//a[@class='btn header-link -active' and @href='/panel/garage']";
    private final String sidebarExpensesLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/expenses']";
    private final String headerExpensesLink = "//a[@class='btn header-link' and @href='/panel/expenses']";
    private final String sidebarInstructionsLink = "//a[@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/instructions']";
    private final String headerInstructionsLink = "//a[@class='btn header-link' and @href='/panel/instructions']";
    private final String sidebarProfileLink = "//a [@href='/panel/profile']";
    //private final String dropdownProfileLink = "//a [@class='dropdown-item btn btn-link user-nav_link' and text()='Profile']";
    private final String dropdownProfileLink = "/html/body/app-root/app-global-layout/div/div/app-header/header/div/div/app-user-nav/div/nav/div[1]/a[1]";
    private final String headerMyProfileLink = "//*[@id='userNavDropdown']";  // and contains(text(),' My profile ')]";
    private final String sidebarSettingsLink = "//a [@class='btn btn-white btn-sidebar sidebar_btn' and @href='/panel/settings']";
    private final String logOutButton = "/html/body/app-root/app-global-layout/div/div/div/app-panel-layout/div/div/div/div[1]/nav/a[4]";
    private final String logOutDropdownButton = "//button [@class='dropdown-item btn btn-link user-nav_link' and text()='Logout']";
    private final String loginMessage = "//*[contains(text(),'You have been successfully logged in')]";
    private final String registerMessage = "//*[contains(text(),'Registration complete')]";

    // Getters

    public String getRegisterMessage() { return registerMessage; }
    public String getLoginMessage() { return loginMessage;  }
    public String getLoggedInAsGuestNotifier() { return loggedInAsGuestNotifier; }
    public String getSidebarGarageLink() { return sidebarGarageLink;}
    public String getHeaderGarageLink() {return headerGarageLink;}
    public String getSidebarExpensesLink() { return sidebarExpensesLink; }
    public String getHeaderExpensesLink() {return headerExpensesLink;}
    public String getSidebarInstructionsLink() { return sidebarInstructionsLink;}
    public String getHeaderInstructionsLink() {return headerInstructionsLink;}
    public String getSidebarProfileLink() { return sidebarProfileLink; }
    public String getHeaderMyProfileLink() {return headerMyProfileLink;}
    public String getLogOutButton() {return logOutButton;}
    public String getLogOutDropdownButton() { return logOutDropdownButton;}
    public String getSidebarSettingsLink() { return sidebarSettingsLink;}

    public String getDropdownProfileLink() { return dropdownProfileLink; }

    public void loginAsGuestAndCheckPresentTabs(){
        Assert.assertTrue(driver.findElement(By.xpath(getLoggedInAsGuestNotifier())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getHeaderGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getHeaderExpensesLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getHeaderInstructionsLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getLogOutButton())).isDisplayed());

        List<WebElement> settingsLinks = driver.findElements(By.xpath(getSidebarSettingsLink()));
        Assert.assertTrue(settingsLinks.isEmpty());

        List<WebElement> profileLinks = driver.findElements(By.xpath(getSidebarProfileLink()));
        Assert.assertTrue(profileLinks.isEmpty());
    }

    public void loginAsUserAndCheckPresentTabs() {
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarGarageLink())).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(getSidebarExpensesLink())).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(getHeaderExpensesLink())).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(getSidebarInstructionsLink())).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(getHeaderInstructionsLink())).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(getLogOutButton())).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(getSidebarSettingsLink())).isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath(getSidebarProfileLink())).isDisplayed());
    }

    public void logout(){
        driver.findElement(By.xpath(getHeaderMyProfileLink())).click();
        driver.findElement(By.xpath(getLogOutDropdownButton())).click();
    }

    public void userProfileNameCheck() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(getHeaderMyProfileLink())).click();
        driver.findElement(By.xpath(getDropdownProfileLink())).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Gregory Lakiza']"))).isDisplayed();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[text()='Gregory Lakiza']"));
        String actualText = element.getText();

        Assert.assertEquals(actualText, "Gregory Lakiza", "Текст не совпадает");
    }
}
