package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPage {

    public HmcPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#navLogon")
    public WebElement loginButton;

    @FindBy(css = "#UserName")
    public WebElement username;

    @FindBy(css = "#Password")
    public WebElement password;

    @FindBy(css="#btnSubmit")
    public WebElement submit;

    @FindBy(css = ".username.username-hide-on-mobile")
    public WebElement girisBasarili;

    @FindBy(css = "#divMessageResult")
    public WebElement hataliGiris;

    @FindBy(css = "#menuHotels")
    public WebElement hotelManagement;

    @FindBy(css = ".sub-menu>:nth-child(3)")
    public WebElement roomReservation;

    @FindBy(css = "#lkpHotelRooms")
    public WebElement hotelRoom;

    @FindBy(css = ".fa.fa-plus")
    public WebElement addRoom;

    @FindBy(css = "select[id=IDUser]")
    public WebElement userId;

    @FindBy(css = "select[id=IDHotelRoom]")
    public WebElement userIdHotelRoom;

    @FindBy(css = "input[id=Price]")
    public WebElement price;

    @FindBy(css = "input[id=Approved")
    public WebElement approved;

    @FindBy(css = "input[id=IsPaid")
    public WebElement isPaid;

    @FindBy(css = "button[id=btnSubmit]")
    public WebElement buttonSubmit;

    @FindBy(css = ".bootbox-body")
    public WebElement reservationSuccessfullyText;

    @FindBy(css = ".btn.btn-primary")
    public WebElement okButton;
}
