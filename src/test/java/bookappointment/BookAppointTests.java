package bookappointment;

import home.HomeTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.BookAppointmentPage;
import pages.FindPatientPage;
import pages.HomePage;
import pages.PatientInfoPage;

public class BookAppointTests extends HomeTests {
    private FindPatientPage findPatientPage;
    private PatientInfoPage patientInfoPage;
    BookAppointmentPage bookAppointmentPage;
    @Test
    @DisplayName("TC-Book Appointment Successful")
    public void testBookAppointmentSuccessful() {
        findPatientPage = this.homePage.clickFindPatientBtn();
        String name = "middle";
        patientInfoPage = findPatientPage.clickPatientRecord(name);

        bookAppointmentPage = patientInfoPage.clickRequestAppointment();

        bookAppointmentPage.setAppointmentType("Dermatology");
//        bookAppointmentPage.setProvider("");
//        bookAppointmentPage.setMinTime("1");
//        bookAppointmentPage.setMaxTime("5");
//        bookAppointmentPage.setMinTimeOptions("Week(s)");
//        bookAppointmentPage.setMaxTimeOptions("Week(s)");
//
//
//        bookAppointmentPage.setNotesArea("TEST1");

    }
}
