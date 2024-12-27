package c01_WebDriverKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_WebDriverMethodlari {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.testotomasyonu.com"); // istenen url'e gider
        // url yazarken www yazmazsak da WebDriver objesi url'e gider
        // AANNCCAAKK https : yazmazsak kod calismaz


        System.out.println(driver.getTitle()); // Gidilen sayfanin title'ni yazdirir ==> testotomasyonu


        System.out.println(driver.getCurrentUrl()); // Gidilen sayfanin url'ine gider ====>  https://www.testotomasyonu.com


        //  System.out.println(driver.getPageSource());// Sayfa kaynagini arkada ki kodlari tamamini getirir


        System.out.println(driver.getWindowHandle()); //  F0C4E072740A1CF1DA036C5F0E4F92D9

        System.out.println(driver.getWindowHandles()); // [D324FE569E65AF23D0A72B06A27DCD27]

        // WebDriver olusturulan her bir objeye benzersiz (unique) bir Window Handle Degeri atar
        // Bu konu ilerde ayrica anlatilacak
        // Eger bir class calistiginda birden fazla windows acilirsa herbirinin
        // ayri bir Window Handle Degeri olur.
        // getWindowHandle() driver'in actigi son window'un window handle degerini verir
        // getWindowHandles() ise acilan tum window'larin window handle degerlerini bir set olarak verir
        // driver'in acilan Window'lar arasinda gecis yapabilmesi icin
        // gececegi window'un window handle degerini bilmesi gerekir


        driver.quit(); // actigimiz driver'i kapatir
        // driver.close(); //  actigimiz driver'i kapatir
        // aralarindaki fark : close() sedece 1 window kapatir
        // quit() ise test sirasinda birden fazla window acilsa da hepsini kapatir
    }
}
