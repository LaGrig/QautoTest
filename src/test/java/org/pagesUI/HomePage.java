package org.pagesUI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class HomePage extends Web {

    //Variables are in CamelCase (not Capital) because there is same style is applied at my work project

    //Page elements locators
    private final String guestLoginButton = "//button[contains(text(),'Guest')]";
    private final String signInButton = "//button[@class='btn btn-outline-white header_signin' and text()='Sign In']";
    protected final String homeButton = "//a [text()='Home']";
    private final String aboutButton = "//button [text()='About']";
    private final String contactsButton = "//button [text()='Contacts']";
    private final String pageTitle = "//h1[contains(text(),'Do more!')]";
    private final String youTubeVideo = "//iframe[@src='https://www.youtube.com/embed/TLP8v7WTlSM?showinfo=0&controls=0']";
    private final String signUpButton = "//button [text()='Sign up']";
    private final String aboutPicture1 = "//*[@alt='Instructions' and @src='/assets/images/homepage/info_1.jpg']";
    private final String aboutPicture2 = "//*[@alt='Instructions' and @src='/assets/images/homepage/info_2.jpg']";

    //Hillel links locators
    private final String hillelPageLink = "//a [contains(@href,'https://ithillel.ua')]";
    private final String hillelEmailLink = "//a [contains(@href,'mailto:developer@ithillel.ua')]";

    //social links locators
    private final String faceBook = "//span [@class='socials_icon icon icon-facebook']";
    private final String telegram = "//span [@class='socials_icon icon icon-telegram']";
    private final String youTube = "//span [@class='socials_icon icon icon-youtube']";
    private final String instagram = "//span [@class='socials_icon icon icon-instagram']";
    private final String linkedIn = "//span [@class='socials_icon icon icon-linkedin']";

    //Login form locators
    private final String signInEmailField = "//*[@id='signinEmail']";
    private final String signInPasswordField = "//*[@id='signinPassword']";
    private final String rememberCheckbox = "//*[@id='remember']";
    private final String buttonCrossToclosePopup = "//button[@class='close' and @aria-label='Close']/span[@aria-hidden='true']";
    private final String toRegistrationLink = "//*[button='Registration']//*[@class='btn btn-link']";
    private final String toLoginButton = "//button[@class='btn btn-primary' and text()='Login']";
    private final String forgotPasswordLink = "//button[@class='btn btn-link' and text()='Forgot password']";

    // Registration form elements locators
    private final String regWindowHeader = "//h4[contains(text(),'Registration')]";
    private final String signUpNameInput = "//input [@id='signupName']";
    private final String signUpLastnameInput = "//input [@id='signupLastName']";
    private final String signUpEmailInput = "//input [@id='signupEmail']";
    private final String signUpPasswordInput = "//input [@id='signupPassword']";
    private final String signUpRePasswordInput = "//input[@id='signupRepeatPassword']";
    private final String registerButton = "//button[contains(text(),'Register')]";

    //Getters
    public String getGuestLoginButton() {
        return guestLoginButton;
    }

    public String getUserSignInButton() {
        return signInButton;
    }

    public String getHomeButton() {
        return homeButton;
    }

    public String getAboutButton() {
        return aboutButton;
    }

    public String getContactsButton() {
        return contactsButton;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getYouTubeVideo() {
        return youTubeVideo;
    }

    public String getSignUpButton() {
        return signUpButton;
    }

    public String getAboutPicture1() {
        return aboutPicture1;
    }

    public String getAboutPicture2() {
        return aboutPicture2;
    }

    public String getHillelPageLink() {
        return hillelPageLink;
    }

    public String getHillelEmailLink() {
        return hillelEmailLink;
    }

    public String getFaceBook() {
        return faceBook;
    }

    public String getTelegram() {
        return telegram;
    }

    public String getYouTube() {
        return youTube;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public String getSignInEmailField() {
        return signInEmailField;
    }

    public String getSignInPasswordField() {
        return signInPasswordField;
    }

    public String getRememberCheckbox() {
        return rememberCheckbox;
    }

    public String getButtonCrossToclosePopup() {
        return buttonCrossToclosePopup;
    }

    public String getToRegistrationLink() {
        return toRegistrationLink;
    }

    public String getToLoginButton() {
        return toLoginButton;
    }

    public String getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public String getRegWindowHeader() {
        return regWindowHeader;
    }

    public String getSignUpNameInput() {
        return signUpNameInput;
    }

    public String getSignUpLastnameInput() {
        return signUpLastnameInput;
    }

    public String getSignUpEmailInput() {
        return signUpEmailInput;
    }

    public String getSignUpPasswordInput() {
        return signUpPasswordInput;
    }

    public String getSignUpRePasswordInput() {
        return signUpRePasswordInput;
    }

    public String getRegisterButton() {
        return registerButton;
    }

    // User predefined credentials
    private final String userEmail = "greg@gmail.com";
    private final String userPassword = "Qwerty123";

    //Other

    public boolean elementsOnPageChecker() {
        try {
            driver.findElement(By.xpath(guestLoginButton));
            driver.findElement(By.xpath(signInButton));
            driver.findElement(By.xpath(homeButton));
            driver.findElement(By.xpath(aboutButton));
            driver.findElement(By.xpath(contactsButton));
            //driver.findElement(By.xpath(youTubeVideo)); //Пробема с определением объекта на странице
            driver.findElement(By.xpath(signUpButton));
            //driver.findElement(By.xpath(aboutPicture1)); //Пробема с определением объекта на странице
            //driver.findElement(By.xpath(aboutPicture2)); //Пробема с определением объекта на странице
            driver.findElement(By.xpath(hillelPageLink));
            driver.findElement(By.xpath(hillelEmailLink));
            driver.findElement(By.xpath(faceBook));
            driver.findElement(By.xpath(telegram));
            driver.findElement(By.xpath(youTube));
            driver.findElement(By.xpath(instagram));
            driver.findElement(By.xpath(linkedIn));
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public void guestLoginButtonClick() {
        driver.findElement(By.xpath(guestLoginButton)).click();
    }

    public void signUpButtonClick() {
        driver.findElement(By.xpath(signUpButton)).click();
    }

    public void signInButtonClick() {
        driver.findElement(By.xpath(signInButton)).click();
    }

    public void loginButtonClick() {
        driver.findElement(By.xpath(getToLoginButton())).click();
    }

    public void registerButtonClick() {
        driver.findElement(By.xpath(getRegisterButton())).click();
    }


    public void signInFormFilling() {
        driver.findElement(By.xpath(getSignInEmailField())).sendKeys(userEmail);
        driver.findElement(By.xpath(getSignInPasswordField())).sendKeys(userPassword);
    }


    private static final String NAMES = "Names.csv";
    private static final String LASTNAMES = "Lastnames.csv";

    public static String getRandomNameFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            Random random = new Random();
            return lines.get(random.nextInt(lines.size()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String newUserName() { return getRandomNameFromFile(NAMES); }

    public String newUserLastname() {
        return getRandomNameFromFile(LASTNAMES);
    }

    public void newUserSignUpFormFillingIn() {
        try {
           long timestamp = System.currentTimeMillis();
            String password = "Qwerty123";
            String name = newUserName();
            String lastname = newUserLastname();

            signUpButtonClick();
            driver.findElement(By.xpath(signUpNameInput)).sendKeys(NAMES);
            driver.findElement(By.xpath(getSignUpLastnameInput())).sendKeys(LASTNAMES);
            driver.findElement(By.xpath(getSignUpEmailInput())).sendKeys(name + timestamp + "@gmail.com");
            driver.findElement(By.xpath(getSignUpPasswordInput())).sendKeys(password);
            driver.findElement(By.xpath(getSignUpRePasswordInput())).sendKeys(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newUserSignUpFormFillingIn2() {
        long timestamp = System.currentTimeMillis();
        String password = "Qwerty123";
        String name = "John";
        String lastname = "Doe";

        driver.findElement(By.xpath(signUpNameInput)).sendKeys(name);
        driver.findElement(By.xpath(getSignUpLastnameInput())).sendKeys(lastname);
        driver.findElement(By.xpath(getSignUpEmailInput())).sendKeys(name + timestamp + "@gmail.com");
        driver.findElement(By.xpath(getSignUpPasswordInput())).sendKeys(password);
        driver.findElement(By.xpath(getSignUpRePasswordInput())).sendKeys(password);
    }


    //НАДО БУДЕТ ПО ХОРОШЕМУ ПЕРЕНЕСТИ В ДРУГУЮ СТРАНИЦУ ЭТОТ МЕТОД
    // - ПРОВЕРКА НА СТРАНИЦЕ ПРОФИЛЯ НАЛИЧИЯ ИМЕНИ И ФАМИЛИИ
    public void userProfileNameAndLastnameChecker() throws Exception {
        String expectedName = newUserName() + " " + newUserLastname();
        WebElement element = driver.findElement(By.xpath("//p[@class='profile_name display-4' and text()='" + expectedName + "']"));
        Assert.assertEquals(expectedName, element);
    }
}
