import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.MtsMainPage;
import org.example.PaymentFramePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {
    private WebDriver driver;
    private MtsMainPage mainPage;
    private PaymentFramePage paymentPage;
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        mainPage = new MtsMainPage(driver);
        paymentPage = new PaymentFramePage(driver);
    }
    @Test
    @DisplayName("1. Проверка названия блока, логотипов и ссылки Подробнее")
    void testMainBlockElements() {
        assertEquals("Онлайн пополнение без комиссии", mainPage.getBlockTitle());
        assertTrue(mainPage.areLogosPresent(), "Логотипы отсутствуют");

        String currentUrl = driver.getCurrentUrl();
        mainPage.clickDetails();
        assertNotEquals(currentUrl, driver.getCurrentUrl(), "Ссылка 'Подробнее' не изменила URL");
    }
    @Test
    @DisplayName("2. Проверка плейсхолдеров для всех вариантов оплаты")
    void testPlaceholdersForAllOptions() {

        List<String> connection = mainPage.getActiveFormPlaceholders();
        assertTrue(connection.containsAll(List.of("Номер телефона", "Сумма", "E-mail для отправки чека")));

        mainPage.selectPaymentOption("Домашний интернет");
        List<String> internet = mainPage.getActiveFormPlaceholders();
        assertTrue(internet.containsAll(List.of("Номер абонента", "Сумма", "E-mail для отправки чека")));

        mainPage.selectPaymentOption("Рассрочка");
        List<String> installment = mainPage.getActiveFormPlaceholders();
        assertTrue(installment.containsAll(List.of("Номер счета", "Сумма", "E-mail для отправки чека")));

        mainPage.selectPaymentOption("Задолженность");
        List<String> arrears = mainPage.getActiveFormPlaceholders();
        assertTrue(arrears.containsAll(List.of("Номер счета", "Сумма", "E-mail для отправки чека")));
    }
    @Test
    @DisplayName("3. Проверка работы формы и окна оплаты (Услуги связи)")
    void testFullPaymentCycle() {
        String phone = "297777777";
        String sum = "10.00";

        mainPage.fillServiceForm(phone, "10", "test@test.com");
        mainPage.clickContinue();
        paymentPage.switchToFrame();

        assertTrue(paymentPage.getAmountHeader().contains(sum));
        assertTrue(paymentPage.getAmountButton().contains(sum));
        assertTrue(paymentPage.getPhoneText().contains(phone));

        assertEquals("Номер карты", paymentPage.getCardLabel());
        assertEquals("Срок действия", paymentPage.getExpiryLabel());
        assertEquals("CVC", paymentPage.getCvcLabel());
        assertEquals("Имя держателя (как на карте)", paymentPage.getHolderLabel());
        assertTrue(paymentPage.areIconsPresent(), "Иконки платежных систем не найдены");
    }
    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}