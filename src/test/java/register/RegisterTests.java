package register;

import home.HomeTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PatientInfoPage;
import pages.RegisterPage;

public class RegisterTests extends HomeTests {
    private RegisterPage registerPage;
    @Test
    @DisplayName("TC-Register successful")
    public void testRegisterSuccessful() {
        registerPage = this.homePage.clickRegisterButton();

        registerPage.setGivenName("given");
        registerPage.setFamilyName("family");
        registerPage.setMiddleName("middle");

        registerPage.clickNextButton();

        registerPage.setGender("Male");

        registerPage.clickNextButton();

        registerPage.setBirthDay("1");
        registerPage.setBirthMonth("January");
        registerPage.setBirthYear("2001");

        registerPage.clickNextButton();

        registerPage.setAddress1("6, Le Dinh Chinh, Hoa Quy, Ngu Hanh Son");
        registerPage.setCityVillage("Da Nang");
        registerPage.setStateProvince("Da Nang");
        registerPage.setCountry("Viet Nam");
        registerPage.setPostalCode("5555");

        registerPage.clickNextButton();

        registerPage.setPhoneNumber("0123456789");

        registerPage.clickNextButton();

        registerPage.setRelationship("Patient");
        registerPage.setRelationshipName("Relation");

        registerPage.clickNextButton();
        PatientInfoPage patientInfoPage = registerPage.clickConfirmButton();
    }

}
