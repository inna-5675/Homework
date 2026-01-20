package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentFramePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By iframe = By.className("bepaid-iframe");
    private By amountHeader = By.xpath("//span[contains(@class, 'pay-description__cost')]");
    private By payButton = By.xpath("//button[contains(@class, 'button_main')]");
    private By phoneInfo = By.xpath("//span[contains(@class, 'pay-description__text')]");

    private By cardNoLabel = By.xpath("//label[@for='input-card-number']");
    private By expiryLabel = By.xpath("//label[@for='input-expiration-date']");
    private By cvcLabel = By.xpath("//label[@for='input-cvc']");
    private By holderLabel = By.xpath("//label[@for='input-cardholder-name']");
    private By paymentIcons = By.className("cards-brands__item");
    public PaymentFramePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void switchToFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }
    public String getAmountHeader() { return wait.until(ExpectedConditions.visibilityOfElementLocated(amountHeader)).getText(); }
    public String getAmountButton() { return driver.findElement(payButton).getText(); }
    public String getPhoneText() { return driver.findElement(phoneInfo).getText(); }
    public String getCardLabel() { return driver.findElement(cardNoLabel).getText(); }
    public String getExpiryLabel() { return driver.findElement(expiryLabel).getText(); }
    public String getCvcLabel() { return driver.findElement(cvcLabel).getText(); }
    public String getHolderLabel() { return driver.findElement(holderLabel).getText(); }
    public boolean areIconsPresent() { return !driver.findElements(paymentIcons).isEmpty(); }
}