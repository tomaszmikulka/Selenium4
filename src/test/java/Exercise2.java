import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exercise2 {

    private static WebDriver driver;

    @BeforeClass
    public static void setDriver(){
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void testExercise1() throws InterruptedException {
        driver.navigate().to("https://antycaptcha.amberteam.pl/exercises/exercise1");

        String pierwszyTekst = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[2]/td[2]/code")).getText();
        if (pierwszyTekst.equals("B1")) {
            driver.findElement(By.id("btnButton1")).click();
        } else {
            driver.findElement(By.id("btnButton2")).click();
        }

        String drugiTekst = driver.findElement(By.xpath("/html/body/div/table/tbody/tr[3]/td[2]/code")).getText();
        if (drugiTekst.equals("B1")) {
            driver.findElement(By.id("btnButton1")).click();
        } else {
            driver.findElement(By.id("btnButton2")).click();
        }

        String trzeciTekst= driver.findElement(By.xpath("/html/body/div/table/tbody/tr[4]/td[2]/code")).getText();
        if (trzeciTekst.equals("B1")) {
            driver.findElement(By.id("btnButton1")).click();
        } else {
            driver.findElement(By.id("btnButton2")).click();
        }

        driver.findElement(By.name("end")).click();

        //Thread.sleep(2000);

        boolean wait = new WebDriverWait(driver,Duration.ofSeconds(2)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("wrap")),"OK. Good answer"));
        //boolean wait2  = new WebDriverWait(driver,Duration.ofSeconds(2)).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("wrap")),"OK. Good answer"));

        Assert.assertEquals("OK. Good answer",driver.findElement(By.className("wrap")).getText());

    }

    @AfterClass
    public static void tearDown(){
        //driver.close();
    }

}
