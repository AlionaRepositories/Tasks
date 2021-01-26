package i_can_win_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;


public class PastebinTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
        public void browserSetup () {
        driver = new ChromeDriver();
    }

    @Test (description = "Task 1 - I Can Win")

    public void createNewPaste () {

        driver.get("https://pastebin.com");
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));

        WebElement codeInput = driver.findElement (By.id("postform-text"));
        codeInput.sendKeys ("Hello from WebDriver");


        WebElement dropdown = driver.findElement(By.xpath("//label[contains(@class, 'control-label') and contains(text(), 'Paste Expiration')]//following::div[1]"));
        dropdown.click();

        By dropDownOption = By.xpath("//li[text() ='10 Minutes']");

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(dropDownOption)));

        WebElement expirationInput = driver.findElement(dropDownOption);
        expirationInput.click();


        WebElement nameInput = driver.findElement(By.id("postform-name"));
        nameInput.sendKeys("helloweb");

        By createBtnSelector = By.xpath ("//button[@type='submit']");
        WebElement createButton = driver.findElement (createBtnSelector);
        createButton.click();


    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver=null;
    }
}
