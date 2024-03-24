package org.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apiActions.ApiSectionPages;
import org.apiActions.UserDataPage;

import java.io.IOException;

public class MyAPIStepdefs extends ApiSectionPages {

    @Given("Register new user in the system")
    public void registerNewUserInTheSystem() throws IOException {
        auth.registerNewUser();
    }

    @When("Login with new User credentials")
    public void loginWithNewUserCredentials() throws IOException {
        auth.loginNewUser();
    }

    @Then("Logout with logged in user")
    public void logoutWithLoggedInUser() throws IOException {
        auth.logOutNewUser();
    }

    @Given("Login as Registered User")
    public void loginAsAlreadyRegisteredUser() throws IOException {
        auth.loginAsAlreadyRegisteredUser();
    }

    @Then("Get All cars brands")
    public void getAllCarsBrands() throws IOException {
        carsActions.getAllCarsBrands();
    }

    @When("Add brand new car")
    public void addBrandNewCar() throws IOException {
        carsActions.addBrandNewCar();
    }

    @And("Add some expenses")
    public void addSomeExpenses() {

    }

    @Then("Delete car")
    public void deleteCar() throws IOException {
        carsActions.deleteCar();
    }

//    @And("Get Logged in User data")
//    public void getLoggedInUserData() throws IOException {
//        userDataPage.getUserProfileData();
//    }
}
