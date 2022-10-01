package tests.day18_ConfigReaderProperties;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {

    @Test
    public void test01() {


        // Amazon sayfasina ve Facebook sayfasina git
        String urlAmazon = ConfigReader.getProperty("amazonUrl");
        String urlFacebook = ConfigReader.getProperty("faceUrl");
        Driver.getDriver().get(urlAmazon);
        Driver.getDriver().get(urlFacebook);
        Driver.closeDriver();
    }
}
