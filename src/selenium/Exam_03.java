package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam_03 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = (WebDriver) new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com/");
            Thread.sleep(1500);
            //        이 방법은 입력창에 타이핑을 하게 하는 것이다
            //        WebElement id = driver.findElement(By.id("id"));
            //        WebElement pw = driver.findElement(By.id("pw"));
            //        id.sendKeys(Account.id);
            //        pw.sendKeys(Account.pw);
            //        입력 타이핑 속도 측정으로 인해 컴퓨터로 인식할 수 있음. -> javaScript를 사용함.

            //      1. argument[0]는 sql에서 ?와 같이 빈 칸을 만들고 후에 채우게 한다.
            //      2. 이 방법은 타이핑이 아닌 javascript로 속성값을 조정하기 때문에 타이핑 속도와 무관하다.
            js.executeScript("document.getElementById('id').value=arguments[0]", Account.id);
            js.executeScript("document.getElementById('pw').value=arguments[0]", Account.pw);

            // 지정한 리턴이 올 때까지 기다리게함, 내부적으로는 0.5초 단위로 반복문을 실행하며 검사함.
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("log.login")));
            WebElement btnLogin = driver.findElement(By.id("log.login"));
            btnLogin.click();
            //Thread.sleep(1500);

            driver.get("https://mail.naver.com/");

            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn_import")));
            WebElement btnWriteToSelf = driver.findElement(By.className("btn_import"));
            btnWriteToSelf.click();

            while(true) {
                WebElement subject = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subject")));
                js.executeScript("document.getElementById('subject').value=arguments[0]", "Test");

                String msg = subject.getAttribute("value");
                System.out.println("Title Message : " + msg);
                if(true) {
                    break;
                }
            }

            String content = "Test input text.";
            driver.switchTo().frame("se2_iframe"); //move focus in iframe
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("se2_inputarea")));
            WebElement inputArea = driver.findElement(By.className("se2_inputarea"));
            inputArea.sendKeys(content);
            driver.switchTo().parentFrame();
            // driver.switchTo().defaultContent();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("attachListBlockLayer")));
            WebElement sendBtn = driver.findElement(By.id("sendBtn"));
            //sendBtn.click();


        } catch (Exception e) {
            e.printStackTrace();
            driver.close();

        }
    }

}