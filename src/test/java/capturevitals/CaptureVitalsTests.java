package capturevitals;

import home.HomeTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FindPatientPage;
import pages.PatientInfoPage;
import pages.VisitsPage;

public class CaptureVitalsTests extends HomeTests {
    private FindPatientPage findPatientPage;
    private PatientInfoPage patientInfoPage;

    @Test
    @DisplayName("TC-Capture Vitals successful")
    public void testCaptureVitalsSuccessful()
    {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);
        VisitsPage visitsPage;
        if (patientInfoPage.clickVisitBtn()) {
             visitsPage = patientInfoPage.clickConfirmVisitBtn();
        } else {
             visitsPage = patientInfoPage.clickCaptureVitalsBtn();
        }
        visitsPage.clickCaptureVitalsBtn();
    }
}
