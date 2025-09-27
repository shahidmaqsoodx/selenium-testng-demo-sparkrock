package tests;


import pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelection() {
        driver.get(baseUrl+"/dropdown");
        DropdownPage dropdownPage = new DropdownPage(driver);

        // Select Option 2
        dropdownPage.selectOption("Option 2");

        // Validate selection
        Assert.assertEquals(
                dropdownPage.getSelectedOption(),
                "Option 2",
                "Dropdown selection did not match expected value."
        );
    }
}
