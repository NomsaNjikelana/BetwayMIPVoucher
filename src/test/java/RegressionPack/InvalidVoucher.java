package RegressionPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InvalidVoucher {

    WebDriver driver;

    public InvalidVoucher(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(id = "depositBtnInline")
    WebElement deposit;

    @FindBy(xpath = "//span[contains(text(),'1 Voucher - RI')]")
    WebElement OneVoucher;

    @FindBy(xpath = "//input[contains(@id,'input-250')]")
    WebElement VoucherPin;

    @FindBy(xpath = "//span[@class='v-btn__content'][contains(.,'Redeem')]")
    WebElement RedeemButton;

    @FindBy(xpath = "(//div[contains(.,'Error: This voucher pin is invalid, please check that the voucher pin is correct and try again')])[24]")
    WebElement InvalidVoucherMessage;

    @FindBy(xpath = "//img[contains(@src,'button.svg')]")
    WebElement popup1;


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
