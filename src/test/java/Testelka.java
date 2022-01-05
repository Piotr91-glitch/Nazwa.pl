import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Testelka {


    @Test
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://www.nazwa.pl/");

        WebElement panelKlienta = driver.findElement(By.xpath("//a[text()='Panel Klienta']"));
        panelKlienta.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("piotrpobozniak");

        WebElement haslo = driver.findElement(By.name("pass"));
        haslo.sendKeys("Muszynianka91#");

        WebElement powtorzHaslo = driver.findElement(By.name("passRepeat"));
        powtorzHaslo.sendKeys("Muszynianka91#");

        WebElement klientIndiwidulany = driver.findElement(By.xpath("//input[@name='firm'][@value='0']"));
        klientIndiwidulany.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));

        WebElement imie = driver.findElement(By.id("firstName"));
        imie.sendKeys("Piotr");

        WebElement nazwisko = driver.findElement(By.id("lastName"));
        nazwisko.sendKeys("Pobożniak");

        WebElement ulica = driver.findElement(By.id("street"));
        ulica.sendKeys("Korabnicka");

        WebElement nrLokalu = driver.findElement(By.id("localNo"));
        nrLokalu.sendKeys("8");

        WebElement kodPocztowy = driver.findElement(By.id("postCode"));
        kodPocztowy.sendKeys("32-050");

        WebElement miejscowosc = driver.findElement(By.id("place"));
        miejscowosc.sendKeys("Skawina");

        WebElement wojewodztwo = driver.findElement(By.id("provinceId"));
        Select wybierzWojewodztwo = new Select(wojewodztwo);
        wybierzWojewodztwo.selectByVisibleText("małopolskie");

        WebElement kraj = driver.findElement(By.id("countryCode"));
        Select wybierzKraj = new Select(kraj);
        wybierzKraj.selectByValue("pl");

        WebElement email = driver.findElement(By.id("client_Email"));
        email.sendKeys("piotrpobozniak91@gmail.com");

        WebElement KontaktowyTelefonKomórkowy = driver.findElement(By.id("phone"));
        KontaktowyTelefonKomórkowy.sendKeys("784027030");

        WebElement zaznaczWszystko= driver.findElement(By.id("acceptAll"));
        zaznaczWszystko.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        driver.switchTo().defaultContent();

        WebElement zarejestrujSie = driver.findElement(By.id("_submit_PK_M0101"));
        zarejestrujSie.click();

        WebElement text= driver.findElement(By.xpath("//div[@class='large-8 cell']"));
        text.getText();

        String potwierdzenieRejestracji="DZIĘKUJEMY ZA REJESTRACJĘ W SERWISIE NAZWA.PL";
        Assert.assertEquals(potwierdzenieRejestracji,text,"tekst nieprawidlowy");

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }



 driver.quit();
    }
}
