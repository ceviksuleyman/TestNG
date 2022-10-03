package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class A101Page {

    public A101Page(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Kabul Et']")
    public WebElement cookiesAccept;

    @FindBy(xpath = "//a[@title='GİYİM & AKSESUAR']")
    public WebElement giyimAksesuarButonu;

    @FindBy(xpath = "//a[@data-value='1565']")
    public WebElement kadinIcGiyimButonu;

    @FindBy(xpath = "//a[@data-value='1567']")
    public WebElement dizAltiCorapButonu;

    @FindBy(xpath = "//a[@title='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")
    public WebElement siyahCorapButonu;

    @FindBy(xpath = "//div[@class='selected-variant-text']")
    public WebElement corapRenkKontrol;

    @FindBy(xpath = "//i[@class='icon-sepetekle']")
    public WebElement corabiSepeteEkleButonu;

    @FindBy(xpath = "(//*[text()='Sepeti Görüntüle'])[2]")
    public WebElement sepetiGoruntuleButonu;

    @FindBy(xpath = "(//a[@title='Sepeti Onayla'])[2]")
    public WebElement sepetiOnaylaButonu;

    @FindBy(xpath = "//a[@title='ÜYE OLMADAN DEVAM ET']")
    public WebElement uyeOlmadanDevamEtButonu;

    @FindBy(xpath = "//input[@name='user_email']")
    public WebElement mailTextBox;

    @FindBy(xpath = "//button[@class='button block green']")
    public WebElement mailTextBoxDevamEtButonu;

    @FindBy(xpath = "//a[@class='new-address js-new-address']")
    public WebElement adresOlusturButonu;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement adresOlusturAdresBasligiBox;

    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement adresOlusturIsimBox;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement adresOlusturSoyadBox;

    @FindBy(xpath = "//input[@name='phone_number']")
    public WebElement adresOlusturCepTelBox;

    @FindBy(xpath = "//select[@name='city']")
    public WebElement adresOlusturIlDropDown;

    @FindBy(xpath = "//select[@name='township']")
    public WebElement adresOlusturIlceDropDown;

    @FindBy(xpath = "//select[@class='js-district']")
    public WebElement adresOlusturMahalleDropDown;

    @FindBy(xpath = "//textarea[@name='line']")
    public WebElement adresOlusturAdresBox;


    @FindBy(xpath = "//button[@class='button green js-set-country js-prevent-emoji']")
    public WebElement adresOlusturKaydetButonu;

    @FindBy(css = ".button.green.address-modal-submit-button")
    public WebElement adresBilgileriniKaydet;


    @FindBy(css=".button.block.green.js-proceed-button")
    public WebElement kaydetveDevamEt;

    @FindBy(xpath = "(//input[@name='name'])[2]")
    public WebElement kartBilgileriAdSoyad;

    @FindBy(xpath = "(//div[@data-type='masterpass'])[1]")
    public WebElement kartIleOdemeText;

    @FindBy(xpath = "(//select[@class='js-payment-month'])[2]")
    public WebElement sonKullanmaTarihiAyDropDown;

    @FindBy(xpath = "(//select[@name='card_year'])[2]")
    public WebElement sonKullanmaTarihiYilDropDown;

    @FindBy(xpath = "(//input[@name='card_cvv'])[2]")
    public WebElement krediKartiCvv;

    @FindBy(xpath = "(//*[@class='js-checkout-cargo-item'])[1]")
    public WebElement kargo;

    @FindBy(xpath = "//div[@class='cargo']//div//ul//li//label//div//div[@class='radio']")
    public List<WebElement> cargo;

    @FindBy(xpath = "//label[@for='agrement2']")
    public  WebElement onBilgileriKabul;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    public WebElement mesafeliSatisSozlesmesi;

    @FindBy(xpath = "//div[@class='payment-area js-payment-tab-content active']//button[@type='submit']")
    public WebElement siparisiTamamlaButton;

    @FindBy(xpath = "(//*[@class='error checkout__error js-error-card_number '])[2]")
    public WebElement kartBilgileriniKontrolEdiniz;



    //JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    //try {
    //    ReusableMethods.clickWithJS(a101Page.kargoKaydetVeDevamButonu);
    //} catch (Exception e) {
    //    jse.executeScript("arguments[0].scrollIntoView(true);", a101Page.kargoKaydetVeDevamButonu);
    //    jse.executeScript("arguments[0].click()", a101Page.kargoKaydetVeDevamButonu);
    //}


        /*
         * Buradan aşağıdaki kısımda ise ödeme ekranı bilgilerinin doğruluğu kısmında yanlış bilgi sonucu çıkan mesaj işlemi yapıldı.
         //Ödeme ekranındaki bölümleri geçersiz olarak giriş yapılıp hata mesajı aldığını kontrol ediniz
         //Ad soyad
         driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys("İpek Çiğdem Tan");
         Thread.sleep(3000);
         //Kart Numarasi
         driver.findElement(By.xpath("(//input[@class='js-masterpassbin-payment-card'])[1]")).sendKeys("1234 5678 9123 4567");
         Thread.sleep(3000);
         //son kullanma tarihi
         driver.findElement(By.xpath("(//select[@name='card_month'])[2]")).sendKeys("2",Keys.ENTER);
         Thread.sleep(3000);
         driver.findElement(By.xpath("(//select[@name='card_year'])[2]")).sendKeys("2026",Keys.ENTER);
         Thread.sleep(3000);
         //ccv
         driver.findElement(By.xpath("(//input[@name='card_cvv'])[2]")).sendKeys("136",Keys.ENTER);
         Thread.sleep(3000);
         //Ön bilgileri kabul etme butonu
         driver.findElement(By.xpath("(//label[@for='agrement2'])[1]")).click();
         Thread.sleep(5000);
         //siparişi tamamla
         driver.findElement(By.xpath("(//span[text()='Siparişi Tamamla'])[2]")).click();
         Thread.sleep(5000);
         //Kart bilgilerini doğru giriniz yazısının geldiğini doğrulayınız
         Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Kart bilgilerinizi kontrol ediniz.']")).isDisplayed());
         */
    //10-Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiğini ,doğru ekrana yönlendiklerini kontrol edecekler.

}
