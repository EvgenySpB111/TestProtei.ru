import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*     Страница заполнения анкеты

 */

public class TestFormSelenium {
  public WebDriver driver;

  @Before
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

    driver.get("file:///C:/Java/TestProtei.ru/TestProtei.ru/qa-test.html");
    driver.findElement(By.xpath("(//input[@type = 'text'])[1]")).sendKeys("test@protei.ru");
    driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("test");
    driver.findElement(By.xpath("//button[@ id = 'authButton']")).click();
  }

  By emailField = By.xpath("(//input[@type = 'text'])[2]");
  By nameField = By.xpath("(//input[@type = 'text'])[3]");
  By ButtonGenderM = By.xpath("//select[@ id ='dataGender']/option[text()='Мужской']");
  By ButtonGenderW = By.xpath("//select[@ id ='dataGender']/option[text()='Женский']");
  By checkbox11 = By.xpath("//input[@ id='dataCheck11']");
  By checkbox12 = By.xpath("//input[@ id='dataCheck12']");
  By radioButton21 = By.xpath("//input[@ id='dataSelect21']");
  By radioButton22 = By.xpath("//input[@ id='dataSelect22']");
  By radioButton23 = By.xpath("//input[@ id='dataSelect23']");
  By buttonAdd = By.xpath("//button[text()='Добавить']");
  By buttonOK = By.xpath("//button[text() = 'Ok']");


  @Test // Создание нового пользователя М, 1.1, 2.1
  public void test10() {
   driver.findElement(emailField).sendKeys("test@protei.ru");
   driver.findElement(nameField).sendKeys("Alex");
   driver.findElement(ButtonGenderM).click();
   driver.findElement(checkbox11).click();
   driver.findElement(radioButton21).click();
   driver.findElement(buttonAdd).click();
   driver.findElement(buttonOK).click();
   String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
   String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
   String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    Assert.assertEquals("test@protei.ru",email);
    Assert.assertEquals("Alex",name);
    Assert.assertEquals("Мужской",gender);
  }
  @Test // Создание нового пользователя М, 1.1, 2.2
  public void test11() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderM).click();
    driver.findElement(checkbox11).click();
    driver.findElement(radioButton22).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    Assert.assertEquals("test@protei.ru",email);
    Assert.assertEquals("Alex",name);
    Assert.assertEquals("Мужской",gender);
    Assert.assertEquals("2.2",num);
  }
  @Test // Создание нового пользователя М, 1.1, 2.3
  public void test12() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderM).click();
    driver.findElement(checkbox11).click();
    driver.findElement(radioButton23).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    Assert.assertEquals("test@protei.ru", email);
    Assert.assertEquals("Alex", name);
    Assert.assertEquals("Мужской", gender);
    Assert.assertEquals("2.3", num);
  }
  @Test // Создание нового пользователя Ж, 1.2, 2.1
  public void test13() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderW).click();
    driver.findElement(checkbox12).click();
    driver.findElement(radioButton21).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    Assert.assertEquals("test@protei.ru", email);
    Assert.assertEquals("Alex", name);
    Assert.assertEquals("Женский", gender);
    Assert.assertEquals("2.1", num);
  }
  @Test // Создание нового пользователя Ж, 1.2, 2.2
  public void test14() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderW).click();
    driver.findElement(checkbox12).click();
    driver.findElement(radioButton22).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    Assert.assertEquals("test@protei.ru", email);
    Assert.assertEquals("Alex", name);
    Assert.assertEquals("Женский", gender);
    Assert.assertEquals("2.2", num);
  }
  @Test // Создание нового пользователя Ж, 1.2, 2.3
  public void test15() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderW).click();
    driver.findElement(checkbox12).click();
    driver.findElement(radioButton23).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    Assert.assertEquals("test@protei.ru", email);
    Assert.assertEquals("Alex", name);
    Assert.assertEquals("Женский", gender);
    Assert.assertEquals("2.3", num);
  }
  @Test // Создание нового пользователя Ж, 1.1, 1.2, 2.3
  public void test16() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderW).click();
    driver.findElement(checkbox11).click();
    driver.findElement(checkbox12).click();
    driver.findElement(radioButton23).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    String checkbox = driver.findElement(By.xpath("(//tbody/tr/td)[4]")).getText();
    Assert.assertEquals("test@protei.ru", email);
    Assert.assertEquals("Alex", name);
    Assert.assertEquals("Женский", gender);
    Assert.assertEquals("2.3", num);
    Assert.assertEquals("1.1, 1.2", checkbox);
  }
  @Test // Создание нового пользователя Ж, 1.1, 1.2, 2.2
  public void test17() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderW).click();
    driver.findElement(checkbox11).click();
    driver.findElement(checkbox12).click();
    driver.findElement(radioButton22).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    String checkbox = driver.findElement(By.xpath("(//tbody/tr/td)[4]")).getText();
    Assert.assertEquals("test@protei.ru", email);
    Assert.assertEquals("Alex", name);
    Assert.assertEquals("Женский", gender);
    Assert.assertEquals("2.2", num);
    Assert.assertEquals("1.1, 1.2", checkbox);
  }

  @Test // Создание нового пользователя Ж, 1.1, 1.2, 2.1
  public void test18() {
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderW).click();
    driver.findElement(checkbox11).click();
    driver.findElement(checkbox12).click();
    driver.findElement(radioButton21).click();
    driver.findElement(buttonAdd).click();
    driver.findElement(buttonOK).click();
    String email = driver.findElement(By.xpath("(//tbody/tr/td)[1]")).getText();
    String name = driver.findElement(By.xpath("(//tbody/tr/td)[2]")).getText();
    String gender = driver.findElement(By.xpath("(//tbody/tr/td)[3]")).getText();
    String num = driver.findElement(By.xpath("(//tbody/tr/td)[5]")).getText();
    String checkbox = driver.findElement(By.xpath("(//tbody/tr/td)[4]")).getText();
    Assert.assertEquals("test@protei.ru", email);
    Assert.assertEquals("Alex", name);
    Assert.assertEquals("Женский", gender);
    Assert.assertEquals("2.1", num);
    Assert.assertEquals("1.1, 1.2", checkbox);
  }
  @Test // Создаем пользователя без имени
  public void test19(){
    driver.findElement(emailField).sendKeys("test@protei.ru");
    driver.findElement(ButtonGenderM).click();
    driver.findElement(checkbox11).click();
    driver.findElement(radioButton21).click();
    driver.findElement(buttonAdd).click();
    String error = driver.findElement(By.xpath("//div[@id = 'blankNameError']")).getText();
    Assert.assertEquals("Поле имя не может быть пустым",error);
  }
  @Test // Создаем пользователя без email
  public void test20(){
    driver.findElement(nameField).sendKeys("Alex");
    driver.findElement(ButtonGenderM).click();
    driver.findElement(checkbox11).click();
    driver.findElement(radioButton21).click();
    driver.findElement(buttonAdd).click();
    String error = driver.findElement(By.xpath("//div[@id = 'emailFormatError']")).getText();
    Assert.assertEquals("Неверный формат E-Mail",error);
  }
  @Test // Создаем пользователя без email и имени
  public void test21(){
    driver.findElement(ButtonGenderM).click();
    driver.findElement(checkbox11).click();
    driver.findElement(radioButton21).click();
    driver.findElement(buttonAdd).click();
    String error = driver.findElement(By.xpath("//div[@id = 'emailFormatError']")).getText();
    Assert.assertEquals("Неверный формат E-Mail",error);
  }


  @After
  public void tearDown() {
    driver.quit();
  }

}
