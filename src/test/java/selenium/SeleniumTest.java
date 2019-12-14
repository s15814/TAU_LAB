package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
    private WebDriver driver;
    String url = "http://automationpractice.com/";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    public void testingIfItWorks() throws InterruptedException {
        driver.get(url);
        Thread.sleep(500);
    }

    @Test
    public void testNavigationBar() throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("id_category=3"));
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        action.moveToElement(btn).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("id_category=9"));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("id_category=8"));
        Thread.sleep(1000);

        WebElement btn2 = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
        action.moveToElement(btn2).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[3]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("id_category=11"));
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("id_category=5"));
        Thread.sleep(1000);
    }

    @After
    public void cleanup() {
        driver.close();
    }
}
