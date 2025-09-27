package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;

public class CheckboxTest extends BaseTest {

    @Test
    public void testToggleCheckbox1() {
        driver.get(baseUrl + "/checkboxes");
        CheckboxPage checkboxPage = new CheckboxPage(driver);

        // Toggle first checkbox
        boolean before = checkboxPage.isCheckboxSelected(0);
        checkboxPage.toggleCheckbox(0);
        boolean after = checkboxPage.isCheckboxSelected(0);

        // Assert state changed
        Assert.assertNotEquals(
                before,
                after,
                "Checkbox state did not toggle as expected."
        );
    }
}
