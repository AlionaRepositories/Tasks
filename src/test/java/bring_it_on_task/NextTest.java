package bring_it_on_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NextTest {

    private WebDriver driver;

    @BeforeMethod
    public void browserSetup () {driver = new ChromeDriver();}

    @Test (description = "Task 2 - Bring It On")

      public void createPaste ()  {

        driver.get("https://pastebin.com");
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("postform-text")));

        WebElement codeInput = driver.findElement (By.id("postform-text"));
        codeInput.sendKeys(
                "git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force" );



        WebElement dropdownSyntax = driver.findElement(By.xpath("//label[contains(@class, 'control-label') and contains(text(), 'Syntax Highlighting')]//following::div[1]"));
        dropdownSyntax.click();

        By dropDownHighlighting = By.xpath("//li[text() ='Bash']");

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(dropDownHighlighting)));

        WebElement syntaxInput = driver.findElement(dropDownHighlighting);
        syntaxInput.click();



        WebElement dropdownExpiration = driver.findElement(By.xpath("//label[contains(@class, 'control-label') and contains(text(), 'Paste Expiration')]//following::div[1]"));
        dropdownExpiration.click();

        By dropDownOption = By.xpath("//li[text() ='10 Minutes']");

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(dropDownOption)));

        WebElement expirationInput = driver.findElement(dropDownOption);
        expirationInput.click();



        WebElement nameInput = driver.findElement(By.id("postform-name"));
        nameInput.sendKeys("how to gain dominance among developers");

        By createBtnSelector = By.xpath ("//button[@type='submit']");
        WebElement createButton = driver.findElement (createBtnSelector);
        createButton.click();


        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text() = 'RAW Paste Data']")));



        @Test
            public void verifyTitle() {
            driver.get("https://pastebin.com");
            Assert.assertEquals(driver.findElement(By.xpath("//div[@class='info-top']"), nameInput);
            System.out.println("Paste Name / Title is correct");
        }



            @Test
            public void verifyCode() {
                driver.get("https://pastebin.com");
                Assert.assertEquals(driver.findElement(By.className("textarea")), codeInput);
                System.out.println("Code input is correct");



    }
       @AfterMethod (alwaysRun = true)
       public void browserTearDown () {
        driver.quit();
        driver=null;
       }
}
