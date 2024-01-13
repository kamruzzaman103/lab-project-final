package loginpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    public static void main(String[] args) throws InterruptedException {
        String[] usernames = {"kanruzzaman1@gmail.com", "kamruzzaman43@gmail.com", "kamruzzaman714@gmail.com"};
        String[] passwords = {"767074@#aA", "pass2", "767074@#aA"};

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe ");

        WebDriver driver = new ChromeDriver();

        String loginPageUrl = "https://moz.com/login";

        try {
            for (int i = 0; i < usernames.length; i++) {
                driver.get(loginPageUrl);
                WebElement usernameInput = driver.findElement(By.id("email"));
                Thread.sleep(1000);
                WebElement passwordInput = driver.findElement(By.id("password"));
                Thread.sleep(1000);
                WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div/div/div[2]/div/div/div/div/form/div/div/div[3]/button"));
                usernameInput.clear();
                usernameInput.sendKeys(usernames[i]);
                passwordInput.clear();
                passwordInput.sendKeys(passwords[i]);
                loginButton.click();
                TimeUnit.SECONDS.sleep(2);            
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            String actual = driver.getTitle();
            String expected = "Home - Moz";
            
            Thread.sleep(8000);
            driver.quit();

            if (actual.equalsIgnoreCase(expected)) {
                System.out.println("Test Successfull");
            } else {
                System.out.println("Test faile!!");

            }
           
        }

    }

}
