package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DhtmlgoodiesPage {

    public DhtmlgoodiesPage() { // constractor

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // capitals
    @FindBy(css = "div[id=capitals]>div[id=dropContent]>:nth-child(2)")
    public WebElement oslo;
    @FindBy(css = "div[id=capitals]>div[id=dropContent]>:nth-child(4)")
    public WebElement stockholm;
    @FindBy(css = "div[id=capitals]>div[id=dropContent]>:nth-child(6)")
    public WebElement washington;
    @FindBy(css = "div[id=capitals]>div[id=dropContent]>:nth-child(8)")
    public WebElement copenhagen;
    @FindBy(css = "div[id=capitals]>div[id=dropContent]>:nth-child(10)")
    public WebElement seoul;
    @FindBy(css = "div[id=capitals]>div[id=dropContent]>:nth-child(12)")
    public WebElement rome;
    @FindBy(css = "div[id=capitals]>div[id=dropContent]>:nth-child(14)")
    public WebElement madrid;

    // countries
    @FindBy(css = "div[id=countries]>:nth-child(1)")
    public WebElement italy;
    @FindBy(css = "div[id=countries]>:nth-child(2)")
    public WebElement spain;
    @FindBy(css = "div[id=countries]>:nth-child(3)")
    public WebElement norway;
    @FindBy(css = "div[id=countries]>:nth-child(4)")
    public WebElement denmark;
    @FindBy(css = "div[id=countries]>:nth-child(5)")
    public WebElement southKorea;
    @FindBy(css = "div[id=countries]>:nth-child(6)")
    public WebElement swedan;
    @FindBy(css = "div[id=countries]>:nth-child(7)")
    public WebElement unitedStates;

    /*
    // capitals - baskentler
    @FindBy(xpath = "//div[@id='box1']")
    public WebElement oslo;
    @FindBy(xpath = "//div[@id='box2']")
    public WebElement stockholm;
    @FindBy(xpath = "//div[@id='box3']")
    public WebElement washington;
    @FindBy(xpath = "//div[@id='box4']")
    public WebElement copenhagen;
    @FindBy(xpath = "//div[@id='box5']")
    public WebElement seoul;
    @FindBy(xpath = "//div[@id='box6']")
    public WebElement rome;
    @FindBy(xpath = "//div[@id='box7']")
    public WebElement madrid;
    //countries -- ülkeler
    @FindBy (xpath = "//div[@id='box106']")
    public WebElement italy;
    @FindBy (xpath = "//div[@id='box107']")
    public WebElement spain;
    @FindBy (xpath = "//div[@id='box101']")
    public WebElement norway;
    @FindBy(xpath = "//div[@id='box104']")
    public WebElement denmark;
    @FindBy(xpath = "//div[@id='box105']")
    public WebElement southKorea;
    @FindBy(xpath = "//div[@id='box102']")
    public WebElement sweden;
    @FindBy(xpath = "//div[@id='box103']")
    public WebElement unitedStates;
     */
}
