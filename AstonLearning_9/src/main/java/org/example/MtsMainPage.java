package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MtsMainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By blockTitle = By.xpath("//section[@class='pay']//h2");
    private By paymentLogos = By.xpath("//div[@class='pay__partners']//img");
    private By detailsLink = By.linkText("Подробнее о сервисе");
    private By selectButton = By.xpath("//button[@class='select__header']");

    private By activeFormFields = By.xpath("//form[contains(@class, 'opened')]//input");
    private By continueButton = By.xpath("//form[contains(@class, 'opened')]//button[contains(text(),'Продолжить')]");
    public MtsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getBlockTitle() {
        return driver.findElement(blockTitle).getText().replace("\n", " ");
    }
    public boolean areLogosPresent() {
        return !driver.findElements(paymentLogos).isEmpty();
    }
    public void clickDetails() {
        driver.findElement(detailsLink).click();
    }

    public void selectPaymentOption(String optionText) {
        driver.findElement(selectButton).click();
        By optionLocator = By.xpath("//ul[@class='select__list']//li[contains(text(), '" + optionText + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    public List<String> getActiveFormPlaceholders() {
        return driver.findElements(activeFormFields).stream()
                .map(e -> e.getAttribute("placeholder"))
                .filter(p -> p != null && !p.isEmpty())
                .collect(Collectors.toList());
    }
    public void fillServiceForm(String phone, String sum, String email) {
        driver.findElement(By.id("connection-phone")).sendKeys(phone);
        driver.findElement(By.id("connection-sum")).sendKeys(sum);
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}