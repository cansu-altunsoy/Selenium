package c02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.testotomasyonu.com");

        // acilista window size ve konumu yazdirin
        System.out.println("Acilista boyut :" + driver.manage().window().getSize());
        System.out.println("Acilista konum :" + driver.manage().window().getPosition());
        Thread.sleep(1000);

        // window'u maximize yapin
        driver.manage().window().maximize();

        // maximize yaptigimizda size ve konumunu yazdirin
        System.out.println("Maximize boyut :" + driver.manage().window().getSize());
        System.out.println("Maximize konum :" + driver.manage().window().getPosition());


        // window'u fullscreen yapin
        driver.manage().window().fullscreen();

        // istedigimiz konum ve boyuta getirelim
        driver.manage().window().setSize(new Dimension(500, 500));
        driver.manage().window().setPosition(new Point(100, 100));

        // istedigimiz boyutta iken size ve konum
        System.out.println("İstedigimiz boyut :" + driver.manage().window().getSize());
        System.out.println("İstedigimiz konum :" + driver.manage().window().getPosition());


        Thread.sleep(2000);
        driver.quit();
    }
}
