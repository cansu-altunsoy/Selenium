package c03_locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_Locators {

    public static void main(String[] args) throws InterruptedException {


        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //3- “ONLINE BANKING” linkine tiklayin
        WebElement onlineBankingLink = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingLink.click();

        // driver.findElement(By.id("onlineBankingMenu")).click()====> 2. yontem sadece click işlemi yapılacak olan işlemlerde kullanilabilir

        //4- Resim altinda 6 islem basligi oldugunu test edin

        List<WebElement> baslikElementlerList = driver.findElements(By.className("headers"));

        int expectedBaslikSayisi = 6;
        int actualBaslikSayisi = baslikElementlerList.size();

        if (expectedBaslikSayisi == actualBaslikSayisi) {
            System.out.println("Baslık sayısı testi Passed");
        } else {
            System.out.println("Baslık sayısı testi FAILED");
        }


        //5- Islem basliklari icinde “Pay Bills” oldugunu test edin
        List<String> baslikListesiStr = new ArrayList<>();


        for (WebElement eacBaslik : baslikElementlerList) {
            baslikListesiStr.add(eacBaslik.getText());
        }
        System.out.println(baslikListesiStr);

        String expectedBaslikİsmi = "Pay Bills";

        if (baslikListesiStr.contains(expectedBaslikİsmi)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("test faild");
        }


        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();


    }
}
