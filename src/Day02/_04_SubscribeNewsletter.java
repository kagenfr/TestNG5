package Day02;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)
 */
public class _04_SubscribeNewsletter extends BaseDriver {

    By link=By.linkText("Newsletter");
    By subYes= By.xpath("//input[@value='1']");
    By subNo= By.xpath("//input[@value='0']");
    By cntBtn= By.xpath("//input[@value='Continue']");

    @Test
    void subscribeFunctionTest(){

        WebElement newsletterBtn = driver.findElement(By.xpath("(//a[@class='list-group-item'])[12]"));
        newsletterBtn.click();

        WebElement yesBtn = driver.findElement(By.cssSelector("input[value='1']"));
        yesBtn.click();

        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        submitBtn.click();

        WebElement checkCircle = driver.findElement(By.cssSelector("i[class='fa fa-check-circle']"));
        Assert.assertTrue(checkCircle.isDisplayed());


    }
    @Test(priority = 2)
    void subscribeFunctionNo() {
        WebElement newsLetterLink=driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeNo=driver.findElement(subNo);
        subscribeNo.click();

        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();
    }

    @Test(priority = 3)
    void subscribeFunctionForBoth() {
        WebElement newsLetterLink=driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeYes=driver.findElement(subYes);
        WebElement subscribeNo=driver.findElement(subNo);

        if (subscribeYes.isSelected())
            subscribeNo.click();
        else
            subscribeYes.click();

        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

        Tools.successMessageValidation();
    }
    
}
