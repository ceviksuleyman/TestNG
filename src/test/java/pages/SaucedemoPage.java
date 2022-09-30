package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SaucedemoPage {

    public SaucedemoPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //username
    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement username;
    //password
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    //login button
    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginButton;
    //dropDown kısmı
    @FindBy(xpath = "//*[@class='product_sort_container']")
    public WebElement dropDown;

    @FindBy(css = ".product_sort_container>:nth-child(3)")
    public WebElement selected;

    //.inventory_list>div>div.inventory_item_description>.pricebar>.inventory_item_price
    @FindBy(css = ".inventory_item_price")
    public WebElement prices;
}
