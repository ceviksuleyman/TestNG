package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "#email")
    public WebElement email;

    @FindBy(css = "#pass")
    public WebElement password;

    @FindBy(css = "button[name='login']")
    public WebElement signInButton;

    @FindBy(css="._9ay7")
    public WebElement girisYapilamadi;


    @FindBy(css ="button._42ft._4jy0._9kpt._4jy5._4jy1.selected._51sy")
    public WebElement evetBenimDevam;

}
