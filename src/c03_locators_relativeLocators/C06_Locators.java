package c03_locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Locators {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com/ adresine gidin

        driver.get("https://www.testotomasyonu.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();


        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title testi PASSED");
        } else {
            System.out.println("Title testi PASSED");
        }

        //6- Furniture linkine tiklayin
        driver.findElement(By.xpath("(//*[@class='has-sub'])[5]"))
                .click();

        /*
        Bir HTML element acılan sayfada ilk acıldıgında gorunmuyorsa kullanip kullanamayacagimiz
        tamamen sayfanin dizayn edenkerin yazmis olduklari koda baglidir
        bazi sayfalarda alt tarafta kalan HTML elementler kullanilabilirken bazi sayfalarda
        kullanilamaya bilir

        Bizim yapabilecegimiz tek sey kullanmayi denemek, kullanilabiliyorsa sorun yok,
        kullanamiyorsak o zaman sayfayi asagi kaydirmak

         */


        //7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin

        WebElement minFiyatKutusu = driver.findElement(By.xpath("//*[@*='form-control minPrice']"));
        minFiyatKutusu.clear();
        minFiyatKutusu.sendKeys("40");

        WebElement maxFiyatKutusu = driver.findElement(By.xpath("//*[@*='form-control maxPrice']"));
        maxFiyatKutusu.clear();
        maxFiyatKutusu.sendKeys("200");


        Thread.sleep(12000);
        driver.findElement(By.xpath("//*[@*='price-range-button']"))
                .click();



        //8- filtreleme sonucunda urun bulunabildigini test edin
        WebElement aramaSonucYaziElement = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedYazi = "0 Products Found";
        String actualYazi = aramaSonucYaziElement.getText();

        if (!actualYazi.equals(unExpectedYazi)) {
            System.out.println("Filtreleme sonuc testi PASSED");

        } else System.out.println("Filtreleme sonuc testi FAILED");

        //10-Ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]"))
                .click();

        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin

        WebElement ilkUrunFiyatElementi = driver.findElement(By.id("priceproduct"));

        String fiyatStr = ilkUrunFiyatElementi.getText();
        //System.out.println(fiyatStr);

        fiyatStr = fiyatStr.replaceAll("\\D", "");

        double fiyatDouble = Double.parseDouble(fiyatStr) / 100;

        if (fiyatDouble >= 40 && fiyatDouble <= 200) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Faild");
        }

        //12-Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();


    }
}
