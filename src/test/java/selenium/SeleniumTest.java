package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest {
    String email = "someemail12345@email.com";
    String url = "http://automationpractice.com/";
    String password = "P4ssw0rd$";
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    @Order(1)
    public void navigationBarTest() throws InterruptedException {
        driver.get(url);
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
    @Order(2)
    public void registrationShouldPass() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("#account-creation"));

        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Adam");
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Kalw");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);

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

    @Test
    @Order(3)
    public void loginShouldBeSuccessful() throws InterruptedException {
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        Thread.sleep(4000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText(), "Adam Kalw");
    }

    @Test
    @Order(4)
    public void loginShouldFailWithWrongPassword() throws InterruptedException {
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password + "dupa");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        Thread.sleep(4000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText(), "Authentication failed.");
    }

    @Test
    @Order(5)
    public void loginShouldBeSuccessfulInMaximizedWindow() throws InterruptedException {
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        Thread.sleep(4000);

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText(), "Adam Kalw");
    }

    @Test
    @Order(6)
    public void registrationShouldFailWithEmptyFields() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("#account-creation"));
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol")).getText(), 
                "You must register at least one phone number.\n" +
                "lastname is required.\n" +
                "firstname is required.\n" +
                "passwd is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
                "This country requires you to choose a State.");
    }


    @After
    public void cleanup() {
        driver.quit();
    }
}
