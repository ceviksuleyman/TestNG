package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static { // Her method'dan once calisir

        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis); //fis'in okudugu bilgileri properties'e yukledi.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
        /*
        test method'undan yolladigimiz String key degerini alip Properties class'indan getProperty()
        method'unu kullanarak bu key'e ait value'u bize yazdirir.
         */
    }
}
