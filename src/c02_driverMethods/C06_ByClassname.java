package c02_driverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_ByClassname {

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

        // bulunan urunleri class attribute'u sayesinde toplu olarak locate edebiliyoruz

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));
        int actualBulunanUrun = bulunanUrunElementleriList.size();

        if (actualBulunanUrun > 0) {
            System.out.println("Arama tesri PASSED");
        } else {
            System.out.println("Arama testi FAILED");
        }

        // sayfayi kapatin

        Thread.sleep(2000);
        driver.quit();
    }
}
