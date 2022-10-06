package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Musinsa {
    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = (WebDriver) new ChromeDriver(chromeOptions); // bg
        WebDriver driver2 = (WebDriver) new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        try {
            driver.get("https://www.musinsa.com/event/raffles?raffles_include_state=A");
            WebElement timer = driver.findElement(By.id("timer_433"));
            String time = timer.getText();
            driver2.get("https://www.musinsa.com/event/raffles/433");
            while (true) {
                time = timer.getText();
                System.out.println(time);
                if (time == "00:00:01") {
                    while (true) {
                        time = timer.getText();
                        if (time == "00:00:00") {
                            driver2.get("https://www.musinsa.com/event/raffles/433");
                            break;
                        }
                    }
                    break;
                }
                Thread.sleep(10000);
            }
            driver.quit();
            driver2.quit();

        } catch (Exception e) {
            driver.quit();
            driver2.quit();
        }
    }
}
