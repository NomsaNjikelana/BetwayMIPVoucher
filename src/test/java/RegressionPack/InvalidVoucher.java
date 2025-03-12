package RegressionPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InvalidVoucher {

    WebDriver driver;

    @FindBy(id = "depositBtnInline")
    WebElement deposit;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div/div/div[2]/div/div[2]/div[4]/div/div[3]/div[2]/div/div[2]/div/div/span[2]")//"(//span[contains(.,'1 Voucher - RI')])[2]")
    WebElement OneVoucher;

    @FindBy(xpath = "//input[contains(@id,'input-250')]")
    WebElement VoucherPin;

    @FindBy(xpath = "//span[@class='v-btn__content'][contains(.,'Redeem')]")
    WebElement RedeemButton;

    @FindBy(xpath = "(//div[contains(.,'Error: This voucher pin is invalid, please check that the voucher pin is correct and try again')])[24]")
    WebElement InvalidVoucherMessage;

    @FindBy (xpath = "//*[@id=\"toast-da9adcca-970f-46a9-8c40-9c05958779b0\"]/div/div/div/div/div[3]/a[2]/img")
    WebElement popup1;

    public InvalidVoucher(WebDriver driver) {
        this.driver = driver;
    }

    public void popUpWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(popup1));
        popup1.click();
    }

    public void clickDeposit() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(deposit));
        deposit.click();
    }

    public void clickOneVoucher() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(deposit));
        OneVoucher.click();
    }

    public void enterInvalidVoucherPin(String EnterInvalidVoucherPin) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(VoucherPin));
        VoucherPin.clear();
        VoucherPin.sendKeys(EnterInvalidVoucherPin);
    }

    public void clickRedeemButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(RedeemButton));
        RedeemButton.click();
    }

    public void verifyINvalidVoucherMessageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(InvalidVoucherMessage));
        if (InvalidVoucherMessage.isDisplayed()) {
            System.out.println("Invalid Voucher Message is displayed");
        }
    }
}
