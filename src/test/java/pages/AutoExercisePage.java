package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutoExercisePage {

    public AutoExercisePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "section[id=slider]")
    public WebElement homePage;

    @FindBy(css = ".nav.navbar-nav>:nth-child(4)")
    public WebElement loginAndSignIn;

    @FindBy(css = ".login-form")
    public WebElement loginPage;

    @FindBy(css = "input[data-qa=login-email]")
    public WebElement loginEmail;

    @FindBy(css = "input[data-qa=login-password]")
    public WebElement loginPassword;

    @FindBy(css = "button[data-qa=login-button]")
    public WebElement loginButton;
    @FindBy(css = ".signup-form")
    public WebElement newUserSignupPage;

    @FindBy(css = "*[data-qa=signup-name]")
    public WebElement newUserName;

    @FindBy(css = "*[data-qa=signup-email]")
    public WebElement newUserEmail;

    @FindBy(css = "*[data-qa=signup-button]")
    public WebElement signUpButton;

    @FindBy(css = ".login-form")
    public WebElement accountInformation;

    @FindBy(css = "form>div[class=clearfix]>div")
    public List<WebElement> gender;

    @FindBy(css = "#password")
    public WebElement passwordNewSignup;

    @FindBy(css = "#days")
    public WebElement day;

    @FindBy(css = "#months")
    public WebElement month;

    @FindBy(css = "#years")
    public WebElement year;

    @FindBy(id = "newsletter")
    public WebElement newsLetter;

    @FindBy(id = "optin")
    public WebElement partners;

    @FindBy(css = "#country")
    public WebElement country;

    @FindBy(css = "#state")
    public WebElement state;

    @FindBy(css = ".col-sm-9.col-sm-offset-1")
    public WebElement accountCreated;

    @FindBy(css = ".btn.btn-primary")
    public WebElement countinue;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    public WebElement loggedInAs;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    public WebElement deleteAccount;

    @FindBy(css = ".btn.btn-danger.button-form.js-tooltip")
    public WebElement deleted;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement incorrectText;

    @FindBy(css = " .nav.navbar-nav>:nth-child(4)")
    public WebElement logOut;

    @FindBy(css = ".nav.navbar-nav>:nth-child(2)")
    public WebElement productsButton;

    @FindBy(css = ".nav.navbar-nav>:nth-child(3)")
    public WebElement cartButton;

    @FindBy(css = ".features_items")
    public WebElement allProductPage;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    public List<WebElement> allProductsList;

    @FindBy(css = "input[id=search_product]")
    public WebElement productSearchBox;

    @FindBy(css = ".title.text-center")
    public WebElement searchedProducts;

    @FindBy(xpath = "//*[@class='productinfo text-center']/p")
    public WebElement searchedProductNames;

    @FindBy(xpath = "//*[.='New User Signup!']")
    public WebElement newUserSignup;

    @FindBy(xpath = "//*[.='Email Address already exist!']")
    public WebElement emailAlreadyExist;


    @FindBy(xpath = "//*[text()='Add to cart']")
    public List<WebElement> addToCartList;

    @FindBy(xpath = "//u[.='View Cart']")
    public WebElement viewCart;

    @FindBy(css = "#cart_info_table")
    public WebElement cartPage;

    @FindBy(xpath = "//*[.='Proceed To Checkout']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//u[.='Register / Login']")
    public WebElement checkoutRegisterLogin;

    @FindBy(css = ".checkout-information")
    public WebElement addressDetailsControl;

    @FindBy(css = "#cart_info")
    public WebElement reviewYourOrder;

    @FindBy(css = ".form-control")
    public WebElement commentAdd;

    @FindBy(xpath = "//*[.='Place Order']")
    public WebElement placeOrder;

    //payment
    @FindBy(css = "input[name=name_on_card]")
    public WebElement nameOnCard;

    @FindBy(css = "input[name=card_number]")
    public WebElement cardNumber;

    @FindBy(css = "input[name=cvc]")
    public WebElement cvc;

    @FindBy(css = "input[name=expiry_month]")
    public WebElement expiryMonth;

    @FindBy(css = "input[name=expiry_year]")
    public WebElement expiryYear;

    @FindBy(css = "#submit")
    public WebElement payAndConfirmOrder;

    @FindBy(xpath = "//*[.='Congratulations! Your order has been confirmed!']")
    public WebElement placedSuccessfully;

    @FindBy(css = ".btn.btn-default.check_out")
    public WebElement downloadInvoice;

    @FindBy(css = "#address_delivery>li")
    public List<WebElement> deliveryAdress;

    @FindBy(css = "#address_invoice>li")
    public List<WebElement> billingAdress;

}