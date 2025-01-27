package c02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {

    public static void main(String[] args) throws InterruptedException {

           /*
        Bir test otomasyonu icin ; ilk yapmamiz gereken sey bir WebDriver objesi edinmektir

        Selenium 4.12 surumu ile kendi WebDriver objesini olusturdu
        Boylece disardan bir WebDriver tanimlamamiza gerek kalmadan Selenium WebDriver objesini kullanabilir
        ve testlerimizi yapabiliriz

        Bazi sirketler acik kaynakli oldugu icin Selenium kullanmak WebDriver kullanmamizi istemeye bilirler
        ve bize kullanmamiz icin bir WebDriver dosyasi verebilirler

        Eger sirkete ozel bir WebDriver objesi kullanilacaksa  O WebDriver'i test class'imiza tanitmak icin
         System.setProperty() gereklidir

         AMMAA Selenium WebDriver kullanacak isek
          System.setProperty()'e ihtiyac yoktur

         */

        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");


        //   ve url'in youtube icerdigini test edin
        String expectedIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)) {
            System.out.println("Youtube url testi PASSED");
        } else {
            System.out.println("Youtube url testi FAILED");
        }


        //3. Testotomasyonu sayfasina gidelim. https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");

        //   Title'in "Test Otomasyonu" icerdigini test edin
        String expectedTitleIcerik = "Test Otomasyonu";
        String actualTitleIcerik = driver.getTitle();

        if (actualTitleIcerik.contains(expectedTitleIcerik)) {
            System.out.println("Title tsti PASSED");
        } else {
            System.out.println("Title testi FAILED");
        }


        //4. Tekrar YouTube'sayfasina donelim
        //driver.get("https://www.youtube.com/");
        driver.navigate().back();
        Thread.sleep(1000);


        //5. Yeniden testotomasyonu sayfasina gidelim
        //driver.get("https://www.testotomasyonu.com/");
        driver.navigate().forward();
        Thread.sleep(1000);

        //6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();


        //7. Sayfayi kapatalim / Tum sayfalari kapatalim
        Thread.sleep(3000);
        driver.quit();


    }
}
