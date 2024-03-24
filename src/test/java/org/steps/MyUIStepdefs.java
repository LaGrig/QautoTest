package org.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.pagesUI.Pages;
import org.pagesUI.Web;


public class MyUIStepdefs extends Pages {

    @Before
    public void chromeSetup() {  web.setup(); }

    @After
    public void chromeDriverQuit(){
        web.closeBrowser();
    }

    @Given("I navigate to the Home page")
    public void iNavigateToTheHomePage() {
        web.goToHomePage();
    }

    @Then("Check if current URL is HomePage URL")
    public void checkCurrentURL() {
        web.checkCurrentUrl(Web.homePageUrl);
    }

    @Then("Check all page element on Home page are present")
    public void checkAllPageElementOnHomePageArePresent() throws InterruptedException {
        homePage.elementsOnPageChecker();
    }

    @When("Click on Guest Login button")
    public void clickOnGuestLoginButton() {
        homePage.guestLoginButtonClick();
    }

    @Then("Check if I logged in as Guest")
    public void checkIfILoggedInAsGuest() throws InterruptedException {
        userPage.loginAsGuestAndCheckPresentTabs();
    }

    @And("Check if I Signed in as Registered User")
    public void checkIfISignedInAsRegisteredUser(){
        userPage.loginAsUserAndCheckPresentTabs();
    }

    @When("Click on Sign in button")
    public void clickOnSignInButton() {
        homePage.signInButtonClick();
    }

    @And("Fill in User login credentials")
    public void fillInUserLoginCredentials() {
        homePage.signInFormFilling();
    }

    @Then("Submit Sign in form")
    public void submitSignInForm() {
        homePage.loginButtonClick();
    }

    @Then("User logout and Home Page Url check")
    public void userLogout() throws InterruptedException {
        userPage.logout();
        Thread.sleep(2000);
        homePage.checkCurrentUrl(Web.homePageUrl);
    }

    @When("Click on SingUp button")
    public void clickOnSingUpButton() {
        homePage.signUpButtonClick();

    }

    @And("Fill in New user credentials")
    public void fillInNewUserCredentials() throws Exception {
        homePage.newUserSignUpFormFillingIn();
    }

    @And("Fill in New user credentials2")
    public void fillInNewUserCredentials2() throws Exception {
        homePage.newUserSignUpFormFillingIn();
    }

    @And("Click Register button")
    public void clickRegisterButton() {
        homePage.registerButtonClick();
    }

    @Then("Check if current URL is UserPage-Garage URL")
    public void checkIfCurrentURLIsUserPageGarageURL() {
        homePage.checkCurrentUrl(Web.garagePageUrl);
    }

    @And("Profile User name is present on Profile page")
    public void profileUserNameIsPresentOnProfilePage() throws Exception {
        profilePage.gotoProfilePage();
        homePage.userProfileNameAndLastnameChecker();
    }

    @And("Check if I logged in as User")
    public void checkIfILoggedInAsUser() throws InterruptedException {
        userPage.userProfileNameCheck();
    }

    @Given("I login as registered User")
    public void iLoginAsRegisteredUser() {
        homePage.goToHomePage();
        homePage.signInButtonClick();
        homePage.signInFormFilling();
        homePage.loginButtonClick();
    }

    @When("Press add car button")
    public void pressAddCarButton() throws InterruptedException {
        garagePage.addCarButtonClick();
    }

    @And("Fill in car data form")
    public void fillInCarDataForm() throws InterruptedException {
        garagePage.fillInCarAddCarForm();

    }

    @Then("Check car added")
    public void checkCarAdded() throws InterruptedException {
        garagePage.checkAddedCarIsDisplayedAndRemoveIt();
    }

    @And("Add new car")
    public void addNewCar() throws InterruptedException {
        garagePage.fillInCarAddCarForm();
    }

    @Then("Update car data")
    public void updateCarData() throws InterruptedException {
        garagePage.updateCarData();
        garagePage.checkFordFocusIsDisplayed();
    }

    @Then("Remove last added car")
    public void removeLastAddedCar() {
        garagePage.removeLastAddedCar();
    }

    @Then("Go to Fuel expenses page")
    public void goToFuelExpensesPage() {
        web.goToFuelExpensesPage();
    }

    @And("Add Fuel expenses to car added")
    public void addFuelExpensesToCarAdded() throws InterruptedException {
        Thread.sleep(1000);
        fuelExpensesPage.addFuelExpensesButtonClick();
        fuelExpensesPage.addExpensesPopUpWindowFillIn();
    }

    @And("Add new car to check expenses")
    public void addNewCarToCheckExpenses() throws InterruptedException {
        garagePage.addFiatScudo();
    }
}

