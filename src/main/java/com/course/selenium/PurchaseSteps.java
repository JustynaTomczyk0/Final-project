package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {

    WebDriver driver = BrowserFactory.getDriver();
    AccountPage accountPage;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    LayerCard layerCard;
    ShoppingCart shoppingCart;
    PersonalInformationPage personalInformationPage;
    OrderConfirmationPage orderConfirmationPage;

    @And("the user click on My store logo")
    public void theUserClickOnMyStoreLogo() {
        accountPage = new AccountPage(driver);
        accountPage.clickLogo();
        homePage = new HomePage(driver);
    }

    @And("the user searches Hummingbird Printed Sweater on the home page")
    public void theUserSearchesHummingbirdPrintedSweaterOnTheHomePage() {
        homePage.searchingProduct("Hummingbird Printed Sweater");
        searchResultsPage = new SearchResultsPage(driver);
    }

    @And("the user clicks on the name of product")
    public void theUserClicksOnTheNameOfProduct() {
        searchResultsPage.chooseProduct();
        productPage = new ProductPage(driver);
    }

    @And("the user chooses size M")
    public void theUserChoosesSizeM() {
        productPage.selectSize("M");
    }

    @And("the user chooses {int} pieces of the product")
    public void theUserChoosesPiecesOfTheProduct(int arg0) {
        productPage.clearField();
        productPage.selectQuantity(5);
    }

    @And("the user adds products to cart")
    public void theUserAddsProductsToCart() {
        productPage.addToCart();
        layerCard = new LayerCard(driver);
    }

    @When("the user clicks Proceed to checkout")
    public void theUserClicksProceedToCheckout() {
        layerCard.ptc();
        shoppingCart = new ShoppingCart(driver);
    }

    @And("the user clicks Proceed to checkout in the Shopping Cart")
    public void theUserClicksProceedToCheckoutInTheShoppingCart() {
        shoppingCart.proceedToCheckout();
        personalInformationPage = new PersonalInformationPage(driver);
    }

    @And("the user confirms address and clicks Continue")
    public void theUserConfirmsAddressAndClicksContinue() {
        personalInformationPage.confirmAddress();
    }

    @And("the user confirms Self pick up as a shipping method")
    public void theUserConfirmsSelfPickUpAsAShippingMethod() {
        personalInformationPage.confirmDeliveryOption();
    }

    @And("the user chooses Pay by check as a payment method")
    public void theUserChoosesPayByCheckAsAPaymentMethod() {
        personalInformationPage.choosePayByCheck();
    }

    @And("the user agrees to the terms of service")
    public void theUserAgreesToTheTermsOfService() {
        personalInformationPage.agreeToTerms();
    }

    @And("the user clicks Place order button")
    public void theUserClicksPlaceOrderButton() {
        personalInformationPage.placeOrder();
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @Then("the user should takes a screenshot with the order confirmation and the amount")
    public void theUserShouldTakesAScreenshotWithTheOrderConfirmationAndTheAmount() {
        orderConfirmationPage.takeScreenshot(driver,"C:\\zadanie");
    }
}
