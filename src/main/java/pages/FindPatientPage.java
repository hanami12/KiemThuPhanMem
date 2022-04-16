package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindPatientPage {
    private WebDriver driver;

    private By patientSearchtxt = By.id("patient-search");
    private By formSearch = By.id("patient-search-form");
    private By tablePatients = By.id("patient-search-results-table");


    public FindPatientPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setPatientSearch(String keySearch) {
        driver.findElement(patientSearchtxt).sendKeys(keySearch);
    }

    public void submitFormSearch() {
        driver.findElement(formSearch).submit();
    }

    public PatientInfoPage clickPatientRecord(String name) {
        WebElement baseTable = driver.findElement(tablePatients);
        List<WebElement> tableRows = baseTable.findElements(By.tagName("td"));
        int index = -1;

        for (int i = 0; i<tableRows.size(); i++) {
            if (tableRows.get(i).getText().contains(name))  {
                index = i;

                break;
            }
        }

        if (index != -1) {
            tableRows.get(index).click();
        }
        return new PatientInfoPage(driver);
    }
}
