import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


/*      Страница авторизации

 */

public class TestAuthSelenium {
  public WebDriver driver;
  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    driver.get("file:///C:/Java/TestProtei.ru/TestProtei.ru/qa-test.html");
  }

  By emailField = By.xpath("(//input[@type = 'text'])[1]");
  By passwordField = By.xpath("//input[@type = 'password']");
  By buttonEnter = By.xpath("//button[@ id = 'authButton']");



  @Test // Проверка авторизации с корректными данными
  public void test1() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(passwordField).sendKeys("test");
    driver.findElement(buttonEnter).click();
    By buttonAdd = By.xpath("//button[@ id = 'dataSend']");
    Assert.assertTrue(driver.findElement(buttonAdd).isDisplayed());
  }

  @Test // Проверка авторизации с некорректным паролем
  public  void test2() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(passwordField).sendKeys("");
    driver.findElement(buttonEnter).click();
    String errorEnter = driver.findElement(By.xpath("//div[@ id = 'invalidEmailPassword']")).getText();
    Assert.assertEquals("Неверный E-Mail или пароль",errorEnter);
  }

  @Test // Проверка авторизации с некорректным email
  public void test3() {
    driver.findElement(emailField).sendKeys("test@GJHJjjn.com");
    driver.findElement(passwordField).sendKeys("test");
    driver.findElement(buttonEnter).click();
    String errorEnter = driver.findElement(By.xpath("//div[@ id = 'invalidEmailPassword']")).getText();
    Assert.assertEquals("Неверный E-Mail или пароль",errorEnter);
  }

  @Test //Попытка авторизации без ввода данных
  public void test4() {
    driver.findElement(buttonEnter).click();
    String errorFormat = driver.findElement(By.xpath("//div[@ id = 'emailFormatError']")).getText();
    Assert.assertEquals("Неверный формат E-Mail",errorFormat);
  }

  @Test // входные данные для авторизации в верхнем регистре
  public void test5() {
    driver.findElement(emailField).sendKeys("TEST@PROTEI.RU");
    driver.findElement(passwordField).sendKeys("TEST");
    driver.findElement(buttonEnter).click();
    String errorEnter = driver.findElement(By.xpath("//div[@ id = 'invalidEmailPassword']")).getText();
    Assert.assertEquals("Неверный E-Mail или пароль",errorEnter);
  }




  @After
  public void tearDown() {
    driver.quit();
  }
}
