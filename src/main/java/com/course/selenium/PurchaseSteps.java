package com.course.selenium;

import com.course.selenium.helpers.BrowserFactory;
import com.course.selenium.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {

    private final WebDriver driver = BrowserFactory.getDriver();
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
    }

    @And("the user searches Hummingbird Printed Sweater on the home page")
    public void theUserSearchesHummingbirdPrintedSweaterOnTheHomePage() {
        homePage = new HomePage(driver);
        homePage.searchingProduct("Hummingbird Printed Sweater");
    }

    @And("the user clicks on the name of product")
    public void theUserClicksOnTheNameOfProduct() {
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.chooseProduct();
    }

    @And("the user chooses size M")
    public void theUserChoosesSizeM() {
        productPage = new ProductPage(driver);
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
    }

    @When("the user clicks Proceed to checkout")
    public void theUserClicksProceedToCheckout() {
        layerCard = new LayerCard(driver);
        layerCard.ptc();
    }

    @And("the user clicks Proceed to checkout in the Shopping Cart")
    public void theUserClicksProceedToCheckoutInTheShoppingCart() {
        shoppingCart = new ShoppingCart(driver);
        shoppingCart.proceedToCheckout();
    }

    @And("the user confirms address and clicks Continue")
    public void theUserConfirmsAddressAndClicksContinue() {
        personalInformationPage = new PersonalInformationPage(driver);
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
    }

    @Then("the user takes a screenshot with the order confirmation and the amount")
    public void theUserTakesAScreenshotWithTheOrderConfirmationAndTheAmount() {
        orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.takeScreenshot(driver,"C:\\");
    }
}
