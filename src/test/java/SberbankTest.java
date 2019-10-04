import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SberbankTest {

    private WebDriver driver;
    private Xpaths xp = new Xpaths();

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testSberbank() throws Exception {
        driver.get(xp.MAINPAGE);

        waitForClickable(xp.INSURANCE);
        driver.findElement(By.xpath(xp.INSURANCE)).click();

        waitForClickable(xp.TRAVELERS);
        driver.findElement(By.xpath(xp.TRAVELERS)).click();

        Assert.assertEquals("Страхование путешественников",
                driver.findElement(By.xpath(xp.HEADER)).getText());

        waitForClickable(xp.ONLINE);
        driver.findElement(By.xpath(xp.ONLINE)).click();

        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));

        waitForClickable(xp.MIN);
        driver.findElement(By.xpath(xp.MIN)).click();

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xp.FORMALIZE)));
        driver.findElement(By.xpath(xp.FORMALIZE)).click();

        fillForm(xp.SURNAME_OF, "Anton");
        fillForm(xp.NAME_OF, "Antonov");
        fillForm(xp.BIRHTDAY_OF, "10102010");
        fillForm(xp.SURNAME, "Иванов");
        fillForm(xp.NAME, "Иван");
        fillForm(xp.MIDNAME, "Иванович");
        fillForm(xp.BIRTHDAY, "01012001");
        driver.findElement(By.xpath(makeFormXpath(xp.GENDER))).click();
        fillForm(xp.PASSPORT, "1010");
        fillForm(xp.PASSPORTN, "123456");
        fillForm(xp.ISSUEDATE, "10102015");
        fillForm(xp.ISSUEPLACE, "Отделом УФМС России");

        List<WebElement> list = driver.findElements(By.xpath(xp.CORRECT));
        Assert.assertEquals(0, list.size());
        driver.findElement(By.xpath(xp.CONTINUE)).click();
        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath(xp.ALLERT)).getText());

    }

    public void fillForm(String xpath, String text) {
        driver.findElement(By.xpath(makeFormXpath(xpath))).sendKeys(text);
    }

    public String makeFormXpath(String text) {
        return String.format(xp.FORM, text);
    }

    public void waitForClickable(String xpath) {
        Wait<WebDriver> wait = new WebDriverWait(driver,5, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    @After
    public void finish() {
        driver.quit();
    }
}
