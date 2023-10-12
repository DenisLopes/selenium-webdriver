package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "src/test/drivers/chromedriver.exe");
        if (driver == null) {
            this.driver = new ChromeDriver();
        } else {
            this.driver = driver;
        }

        this.driver.manage().timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS)
                .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void fechar() {
        this.driver.quit();
    }

}
