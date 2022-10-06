package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * chromedriver.exe를 프로젝트에 추가.
 */

public class Exam_01 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naver.com/"); // 사이트 열기.

        WebElement searchInput = driver.findElement(By.id("query")); // 검색창 id 불러오기.
        searchInput.sendKeys("selenium");
        // 검색창에 selenium 입력하기(엔터를 입력하는것은 아니기 때문에 검색이 되는 것은 아님.)
        WebElement searchBtn = driver.findElement(By.id("search_btn"));
        searchBtn.click();

        Thread.sleep(10000); // 1초동안 코드를 정지시킴.
        driver.close();
    }
}
