import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
    }

    @Test
    @DisplayName("Проверка формы Онлайн пополнение без комисси")
    void testPaymentForm() {
        //Проверить название указанного блока
        WebElement titleElement = driver.findElement(By.xpath("//div[contains(@class, 'pay__wrapper')]//h2"));
        String actualTitle = titleElement.getText()
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim();
        String expectedTitle = "Онлайн пополнение без комиссии";
        Assertions.assertEquals(expectedTitle, actualTitle,
                "Текст заголовка блока не соответствует ожидаемому");

        //Проверить наличие логотипов платёжных систем
        WebElement partnersBlock = driver.findElement(By.className("pay__partners"));
        List<WebElement> logos = partnersBlock.findElements(By.tagName("img"));
        Assertions.assertEquals(5, logos.size(), "Количество логотипов не соответствует ожидаемому");

        //Проверить работу ссылки «Подробнее о сервисе»
        WebElement detailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        String expectedPartUrl = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String actualHref = detailsLink.getAttribute("href");
        assertTrue(actualHref.contains(expectedPartUrl), "Ссылка ведет на некорректный адрес");
        detailsLink.click();

        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        String actualHeader = pageHeader.getText().trim();
        String expectedHeader = "Оплата банковской картой";
        Assertions.assertEquals(expectedHeader, actualHeader,
                String.format("Заголовок страницы не совпадает. Ожидали: '%s', получили: '%s'\", expectedHeader, actualHeader"));

        //Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.sendKeys("10");

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
        boolean isIframePresent = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("iframe"))).size() > 0;
        assertTrue(isIframePresent, "Окно оплаты не открылось");
    }
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

