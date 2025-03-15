package Test;

import RegressionPack.Login;
import org.testng.annotations.Test;

public class TestRun extends Base {

    String EnterMSISDN = "810708491";
    String EnterPassword = "Betway1234";
    String InvalidVoucherPin = "1236 5444 5215 1512";

    @Test
    public void LoginToBetway()  {
        loginPage.popUp();
        loginPage.enterMSISDN(EnterMSISDN);
        loginPage.enterPassword(EnterPassword);
        loginPage.LoginButton();
        loginPage.verifyMessageIsDisplayedWhenLoggedInCorrectly();
    }

    @Test(dependsOnMethods = "LoginToBetway")
    public void InvalidVoucher() throws InterruptedException {
        //invalidVoucher.popUpWindow();
        invalidVoucher.clickDeposit();
        invalidVoucher.clickOneVoucher();
        invalidVoucher.enterInvalidVoucherPin(InvalidVoucherPin);
        invalidVoucher.clickRedeemButton();
        invalidVoucher.verifyINvalidVoucherMessageIsDisplayed();
    }
}
