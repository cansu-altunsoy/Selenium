package c02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_DriverManageMethodlari {


    public static void main(String[] args) {
         /*
        Test otomasyonu bizim kodlarimizin bizim yerimize internetten Web sayfalarina islem yapmasidir.

        Bizim yazdigimiz Java kodlarinin hizi ile

        1- bilgisayarlarimiz
        2- internetimiz
        3- ve ulasmaya calistigimiz sayfanin hizlari arasinda fark olur.

        Bu hizlar arasinda fark kodlarimizin calisamamasina veya
         testin FAILED olmasina sebep olur

         */


        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       /*
       Thread.sleep() Java'dan gelir ve mutlak bir bekleme suresidir,
       icine yazilan sure boyunca, kodlari bekletir ve alt satira gecmez


       implicitlyWait(Duration.ofSeconds(10)) ise Selenium'dan gelir dinamiktir.
       Yani 10 saniyeyi sonuna kadar kullanmaz, asil amac sayfanin acilmasi veya sayfadan kullanacagimiz,
       herhangi bir webelementin kullanilir hale gelmesini beklemektir


       10 saniye icerisinde sayfanin acilmasini veya kullanilacagi webelementi bulmayi bekler
       10 saniye icerisinde ne zaman islemi yapabilirse, daha fazla beklemez yoluna devam eder

       10 saniye beklemesine ragmen sayfa acilmazsa veya aradigi webelementi bulamazsa
       exception firlatir ve calismayi durdurur

        */


    }
}
