package pages.autoExercisePage.tc01_register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ExercisePage {

    public ExercisePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "section[id=slider]")
    public WebElement homePage;

    @FindBy(css = ".nav.navbar-nav>:nth-child(4)")
    public WebElement loginAndSignIn;

    @FindBy(css = ".signup-form")
    public WebElement newUserSignup;

    @FindBy(css = "*[data-qa=signup-name]")
    public WebElement newUserName;

    @FindBy(css = "*[data-qa=signup-email]")
    public WebElement newUserEmail;

    @FindBy(css = "*[data-qa=signup-button]")
    public WebElement SignupButton;

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
    public WebElement countine;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    public WebElement loggedInAs;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    public WebElement deleteAccount;

    @FindBy(css = ".btn.btn-danger.button-form.js-tooltip")
    public WebElement deleted;

}
