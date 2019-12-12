package SelfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchFieldException.class);

         WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
             @Override
             public WebElement apply(WebDriver webDriver) {
                 return driver.findElement(By.cssSelector("[id='finish'] h4"));
             }
         });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());

    }
}

