package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    public void testingIfItWorks() throws InterruptedException {
        driver.get("http://automationpractice.com/");

        Thread.sleep(1000);
    }

    @After
    public void cleanup() {
        driver.close();
    }
}
