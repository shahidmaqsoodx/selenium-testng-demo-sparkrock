package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTest extends BaseTest {

    @Test
    public void testAcceptJsAlert() {
        driver.get(baseUrl + "/javascript_alerts");
        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.triggerAndAcceptAlert();

        Assert.assertEquals(
                alertsPage.getResultMessage(),
                "You successfully clicked an alert",
                "Alert accept result message did not match expected."
        );
    }

    @Test
    public void testDismissJsConfirm() {
        driver.get(baseUrl + "/javascript_alerts");
        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.triggerAndDismissConfirm();

        Assert.assertEquals(
                alertsPage.getResultMessage(),
                "You clicked: Cancel",
                "Alert dismiss result message did not match expected."
        );
    }
}
