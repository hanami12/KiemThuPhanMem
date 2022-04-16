package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    private WebDriver driver;

    //full name
    private By givenNametxt = By.name("givenName");
    private By middleNametxt = By.name("middleName");
    private By familyNametxt = By.name("familyName");
    private By unidentifiedPatientButton = By.id("checkbox-unknown-patient");

    //gender & birthday
    private By genderOptions = By.id("gender-field");
    private By birthDaytxt = By.name("birthdateDay");
    private By birthMonthOptions = By.name("birthdateMonth");
    private By birthYeartxt = By.name("birthdateYear");

    //address
    private By address1txt = By.id("address1");
    private By cityVillagetxt = By.id("cityVillage");
    private By stateProvincetxt = By.id("stateProvince");
    private By countrytxt = By.id("country");
    private By postalCodetxt = By.id("postalCode");

    //phone number
    private By phoneNumbertxt = By.name("phoneNumber");

    //relatives
    private By relationshipOptions = By.id("relationship_type");
    private By relationshipNametxt = By.xpath("//input[@placeholder='Person Name']");

    private By nextBtn = By.id("next-button");
    private By cancelBtn = By.id("cancelSubmission");
    private By confirmBtn = By.id("submit");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextButton() {
        driver.findElement(nextBtn).click();
    }
    public void clickCancelButton() {
        driver.findElement(cancelBtn).click();
    }
    public PatientInfoPage clickConfirmButton() {
        driver.findElement(confirmBtn).click();
        return new PatientInfoPage(driver);
    }

    public void setGivenName(String givenName) {
        driver.findElement(givenNametxt).sendKeys(givenName);
    }

    public void setMiddleName(String middleName) {
        driver.findElement(middleNametxt).sendKeys(middleName);
    }

    public void setFamilyName(String familyName) {
        driver.findElement(familyNametxt).sendKeys(familyName);
    }

    public void setGender(String gender) {
        Select genders = new Select(driver.findElement(genderOptions));
        genders.selectByVisibleText(gender);
    }

    public void setBirthDay(String birthDay) {
        driver.findElement(birthDaytxt).sendKeys(birthDay);
    }

    public void setBirthMonth(String birthMonth) {
        Select months = new Select(driver.findElement(birthMonthOptions));
        months.selectByVisibleText(birthMonth);
    }

    public void setBirthYear(String birthYear) {
        driver.findElement(birthYeartxt).sendKeys(birthYear);
    }

    public void setAddress1(String address1) {
        driver.findElement(address1txt).sendKeys(address1);
    }

    public void setCityVillage(String cityVillage) {
        driver.findElement(cityVillagetxt).sendKeys(cityVillage);
    }

    public void setStateProvince(String stateProvince) {
        driver.findElement(stateProvincetxt).sendKeys(stateProvince);
    }

    public void setCountry(String country) {
        driver.findElement(countrytxt).sendKeys(country);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(postalCodetxt).sendKeys(postalCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumbertxt).sendKeys(phoneNumber);
    }

    public void setRelationship(String relationship) {
        Select relationships = new Select(driver.findElement(relationshipOptions));
        relationships.selectByVisibleText(relationship);
    }

    public void setRelationshipName(String relationshipName) {
        driver.findElement(relationshipNametxt).sendKeys(relationshipName);
    }
}
