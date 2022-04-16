package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatientInfoPage {
    private WebDriver driver;

    private By requestAppointment = By.xpath("//div[contains(text(), 'Request Appointment')]");
    private By visitBtn = By.id("org.openmrs.module.coreapps.createVisit");
    private By comfirmVisitBtn = By.id("start-visit-with-visittype-confirm");
    private By captureVitalsBtn = By.xpath("/html/body/div[1]/div[3]/div[9]/div[2]/ul/li[4]");

    public PatientInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public BookAppointmentPage clickRequestAppointment() {
        driver.findElement(requestAppointment).click();
        return new BookAppointmentPage(driver);
    }

    public boolean clickVisitBtn() {
        try {
            driver.findElement(visitBtn).click();
        } catch (Exception e){
            return false;
        }
       return true;
    }
    public VisitsPage clickConfirmVisitBtn() {
        System.out.println("confirm");
        driver.findElement(comfirmVisitBtn).click();
        return new VisitsPage(driver);
    }

    public VisitsPage clickCaptureVitalsBtn() {
        System.out.println("capture");
        WebDriverWait t = new WebDriverWait(driver, 30);


        System.out.println(driver.findElements(By.tagName("div")).size());
        driver.findElement(captureVitalsBtn).findElement(By.tagName("a")).click();
        return new VisitsPage(driver);
    }
}
