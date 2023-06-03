package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemleri(String browserTipi) {
        //Logger logger= Logger.getLogger("");
        //logger.setLevel(Level.SEVERE);

        switch (browserTipi.toLowerCase())
        {
            case "firefox" :
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                System.out.println("firefox started");
                break;

            case "safari":
                driver=new SafariDriver();
                System.out.println("safari started");
                break;

            case "edge":
                driver=new EdgeDriver();
                System.out.println("edge started");
                break;

            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                ChromeOptions options = new ChromeOptions();
                driver.manage().window().maximize();
                options.addArguments("--remote-allow-origins=*");
                System.out.println("chrome started");
                driver = new ChromeDriver(options);
        }


        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(30));
        loginTest();
    }

    void loginTest() {
        System.out.println("Login Test");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.sendKeys("smartman227@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Bilgen3406.");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));
        Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));


    }

    @AfterClass
    public void bitisIslemleri() {
        Tools.Bekle(5);
        driver.quit();
    }

}
