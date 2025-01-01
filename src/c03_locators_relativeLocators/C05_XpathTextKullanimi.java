package c03_locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_XpathTextKullanimi {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/ ");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[.='Add']"))
                .click();
        Thread.sleep(2000);

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButtonu = driver.findElement(By.xpath("//button[.='Remove']"));

        if (removeButtonu.isDisplayed()){
            System.out.println("tets Passed");
        }else {
            System.out.println("Test Failed");
        }

        //4- Remove tusuna basin
        removeButtonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2[.='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Tset FAILED");
        }

        Thread.sleep(3000);
        driver.quit();


    }
}
