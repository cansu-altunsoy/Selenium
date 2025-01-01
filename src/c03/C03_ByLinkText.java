package c03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_ByLinkText {

    public static void main(String[] args) throws InterruptedException {

        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi = 147;
        int actualLinkSayisi = linkElementleriList.size();

        System.out.println(actualLinkSayisi);

        if (expectedLinkSayisi == actualLinkSayisi) {
            System.out.println("Link test PASSED");
        } else {
            System.out.println("Link test FAILED");
        }

        //4- Products linkine tiklayin

        // driver.findElement(By.linkText("products")).click();
        driver.findElement(By.partialLinkText("Products")).click();


        //5- special offer yazisinin gorundugunu test edin
        WebElement specialYazisi = driver.findElement(By.id("sale_image"));

        if (specialYazisi.isDisplayed()) {  // isDisplayed() Webelement gorunur ise true, yoksa false doner

            System.out.println("Yazi testi PASSED");
        } else {
            System.out.println("Yazi testi FAILED");
        }

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
