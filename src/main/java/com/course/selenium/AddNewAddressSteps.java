package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.util.Map;

import static com.course.selenium.helpers.Helpers.getRandomAlias;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddNewAddressSteps {

    private final WebDriver driver = BrowserFactory.getDriver();
    HomePage homePage;
    LogInPage logInPage;
    AccountPage accountPage;
    AddressesPage addressesPage;
    NewAddressPage newAddressPage;
    private String addressAlias;


    @Given("a registered user is on the home page")
    public void aRegisteredUserIsOnTheHomePage() {
        homePage = new HomePage(driver);
    }

    @And("the user clicks on Sign in")
    public void theUserClicksOnSignIn() {

        homePage.clickSingIn();
        logInPage = new LogInPage(driver);
    }

    @And("the user fills Log in form")
    public void theUserFillsLogInForm() {
        logInPage.typeEmail("testowanie2024@vp.pl");
        logInPage.typePassword("Testowanie2024");
    }

    @And("the user clicks Sign in button")
    public void theUserClicksSignInButton() {
        logInPage.clickSignIn();

        accountPage = new AccountPage(driver);
    }

    @And("the user clicks Addresses on Your account page")
    public void theUserClicksAddressesOnYourAccountPage() {
        accountPage.clickAddresses();

        addressesPage = new AddressesPage(driver);
    }

    @When("the user clicks Create new address button")
    public void theUserClicksCreateNewAddressButton() {
        addressesPage.createNewAddress();

    }

    @And("the user fills the address form with {string}, {string}, {string}, {string}, {string}")
    public void theUserFillsTheAddressFormWith(String alias, String address, String city, String postCode, String phone) {
        addressAlias = getRandomAlias();

        newAddressPage = new NewAddressPage(driver);

        newAddressPage.enterAlias(alias);
        newAddressPage.enterAddress(address);
        newAddressPage.enterCity(city);
        newAddressPage.enterPostCode(postCode);
        newAddressPage.enterPhoneNumber(phone);
    }

    @And("the user clicks Save button")
    public void theUserClicksSaveButton() {
        newAddressPage.clickSave();
        addressesPage = new AddressesPage(driver);
    }

    @Then("Your addresses page should include the new address")
    public void yourAddressesPageShouldIncludeTheNewAddress() {
        addressesPage = new AddressesPage(driver);

        Map<String, String> addressesByAlias = addressesPage.getAddressesByAlias();
        String key = addressAlias.toUpperCase();
        assertTrue(addressesByAlias.containsKey(key));
        assertEquals("abc Lodz 93-444 487926641", addressesByAlias.get(key));
    }
}
