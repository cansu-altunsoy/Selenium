package c02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_WebElementKullanma {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome. driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu anasayfasina gidin
        driver.get("https://www.testotomasyonu.com");


        // arama kutusuna phone yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Phone" + Keys.ENTER);

        // aramaKutusu.submit();  ====>   2. arama yontemi


        // arama sonucunda urun bulunabildigini test edin

        // arama sonuc yazisini lacate edip, oradaki yazinin icinde bulunan sayinin
        // 0'da buyuk oldugunu test edelim
        WebElement aramaSonucuYazisi = driver.findElement(By.className("product-count-text"));

        System.out.println(aramaSonucuYazisi.getText());

        String sonucSayisiStr = aramaSonucuYazisi.getText().replaceAll("\\D", "");
        System.out.println(sonucSayisiStr); // 4

        int sonusSayisi = Integer.parseInt(sonucSayisiStr); // 4

        if (sonusSayisi > 0) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        // sayfayi kapatin

        Thread.sleep(2000);
        driver.quit();
    }
}
