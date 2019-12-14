package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class SeleniumTest {
    private WebDriver driver;
    String url = "http://automationpractice.com/";
    //method I found on stackoverflow to generate random email adresses
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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

    @Test
    public void testRegistrationShouldPass() throws InterruptedException {
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(getSaltString()+"@email.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("#account-creation"));

        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Adam");
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Kalw");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("P4ssword#");

        driver.findElement(By.xpath("//*[@id=\"days\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("3");
        driver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"months\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("m");
        driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"years\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1991");
        driver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Adam");
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Kalw");

        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Gdanska");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Gdansk");

        driver.findElement(By.xpath("//*[@id=\"id_state\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"id_state\"]")).sendKeys("Ala");
        driver.findElement(By.xpath("//*[@id=\"id_state\"]")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("88420");

        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("123456789");

        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
        Thread.sleep(4000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText(), "Adam Kalw");
    }

    @After
    public void cleanup() {
        driver.close();
    }
}
