package Day02;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Example extends BaseDriver {

    @Test
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

}

