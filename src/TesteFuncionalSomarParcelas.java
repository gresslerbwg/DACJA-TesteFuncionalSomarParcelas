
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TesteFuncionalSomarParcelas {

  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    // aqui importa o driver externo
    System.setProperty("webdriver.gecko.driver","/home/gressler/Downloads/selenium-java-3.0.0-beta2/geckodriver");
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);
//
//    System.setProperty("webdriver.chrome.driver","/home/gressler/Downloads/selenium-java-3.0.0-beta2/chromedriver");
//    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//    capabilities.setCapability("marionette", true);
//
    driver = new FirefoxDriver(capabilities);
//    driver = new ChromeDriver(capabilities);
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testE() throws Exception {
    driver.get(baseUrl + "/DACJA-SomarParcelas/");
    driver.findElement(By.name("p1")).clear();
    driver.findElement(By.name("p1")).sendKeys("21");
    driver.findElement(By.name("p2")).clear();
    driver.findElement(By.name("p2")).sendKeys("12");
    driver.findElement(By.name("calcular")).click();
    assertEquals("O resultado foi 33", driver.findElement(By.cssSelector("h1")).getText());
  }

  @Test
  public void testF() throws Exception {
    driver.get(baseUrl + "/DACJA-SomarParcelas/");
    driver.findElement(By.name("p1")).clear();
    driver.findElement(By.name("p1")).sendKeys("2");
    driver.findElement(By.name("p2")).clear();
    driver.findElement(By.name("p2")).sendKeys("1");
    driver.findElement(By.name("calcular")).click();
    assertEquals("O resultado foi 3", driver.findElement(By.cssSelector("h1")).getText());
  }
  
  @Test
  public void testG() throws Exception {
    driver.get(baseUrl + "/DACJA-SomarParcelas/");
    driver.findElement(By.name("p1")).clear();
    driver.findElement(By.name("p1")).sendKeys("2");
    driver.findElement(By.name("p2")).clear();
    driver.findElement(By.name("p2")).sendKeys("1");
    driver.findElement(By.name("calcular")).click();
    assertEquals("O resultado foi 3", driver.findElement(By.cssSelector("h1")).getText());
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}