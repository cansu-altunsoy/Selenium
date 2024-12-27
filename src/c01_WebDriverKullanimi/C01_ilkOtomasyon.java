package c01_WebDriverKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_ilkOtomasyon {

    public static void main(String[] args) throws InterruptedException {


        // Bir test'e baslamadan once Mutlaka bir WebDriver edinmeliyiz
        // EN ILKEL haliyle WebDriver edinmek icin Java'dan yardim alacagiz


        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");


        Thread.sleep(3000);
        driver.quit();


    }
}
