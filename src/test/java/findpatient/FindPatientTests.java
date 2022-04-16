package findpatient;

import home.HomeTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FindPatientPage;
import pages.RegisterPage;

public class FindPatientTests extends HomeTests {
    private FindPatientPage findPatientPage;
    @Test
    @DisplayName("TC-Find successful")
    public void testFindPatientSuccessful() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        findPatientPage.setPatientSearch("given");
        findPatientPage.submitFormSearch();
    }

}
