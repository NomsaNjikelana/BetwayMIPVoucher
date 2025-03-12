package RegressionPack;

import Test.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='MobileNumber']")
    WebElement MSISDN;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "Login")
    WebElement loginButton;

    @FindBy(id = "depositBtnInline")
    WebElement deposit;

    @FindBy(xpath = "//img[contains(@src,'button.svg')]")
    WebElement popUpWindow;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void popUp() {
        popUpWindow.click();

    }

    public void enterMSISDN(String EnterMSISDN) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(MSISDN));
        MSISDN.clear();
        MSISDN.sendKeys(EnterMSISDN);
    }

    public void enterPassword(String enterPasswords) {
        password.clear();
        password.sendKeys(enterPasswords);
    }

    public void LoginButton() {
        loginButton.click();
    }

    public void verifyMessageIsDisplayedWhenLoggedInCorrectly() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(deposit));
        if (deposit.isDisplayed())
            System.out.println("You have logged into Betway successfully");
            else {
                System.out.println("You have not logged into Betway successfully");
            }
        }
    }


