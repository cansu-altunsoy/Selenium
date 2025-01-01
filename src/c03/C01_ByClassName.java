package c03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByClassName {

    public static void main(String[] args) throws InterruptedException {


        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // bu süre tum islemler icin ayrı ayrı geçerlidir, her element icin gecerlidir


        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/ ");

        //3- arama kutusuna phone yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone" + Keys.ENTER);
       // 2. yontem aramaKutusu.submit();


        //4- Category bolumunde 8 element oldugunu test edin

        List<WebElement> categoryElemetleriList = driver.findElements(By.className("panel-list"));

        int expectedCategorySayisi = 8;
        int actualCategorySayisi = categoryElemetleriList.size();

        if (expectedCategorySayisi == actualCategorySayisi){
            System.out.println("Category sayısı testi PASSED");
        }else{
            System.out.println("Category sayısı testi FAILED");
        }

        //5- Category isimlerini yazdirin
        //System.out.println(categoryElemetleriList); // Bize referans degerlerini yazdırır

        for (WebElement eacElement : categoryElemetleriList){
            System.out.println(eacElement.getText());
        }


        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
