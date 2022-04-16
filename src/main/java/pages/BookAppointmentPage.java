package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookAppointmentPage {
    WebDriver driver;

    //info
    private By appointmentTypetxt = By.id("appointment-type");
    private By appointmentDropdown = By.xpath("/html/body/div/div[3]/div[4]/form/p[1]/ul");
    private By providertxt = By.id("provider");
    private By providerDropdown = By.id("typeahead-4-9489");
    private By minTimetxt = By.id("min-time-frame-value");
    private By minTimeOptions = By.id("min-time-frame-units");
    private By maxTimetxt = By.id("max-time-frame-value");
    private By maxTimeOptions = By.xpath("//select[@id = 'max-time-frame-units']");
    private By notesAreatxt = By.id("notes");

    public BookAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    //button
    private By saveBtn = By.id("save-button");

    public void setAppointmentType(String appointmentType){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement appointmentTypeInput = driver.findElement(appointmentTypetxt);
        appointmentTypeInput.sendKeys(appointmentType);
        wait.until(ExpectedConditions.elementToBeClickable(appointmentTypeInput));

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(appointmentDropdown)));
        WebElement dropdown = driver.findElement(appointmentDropdown);
        System.out.println(dropdown.getCssValue("display"));

        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        System.out.println("option: " +options.size());
//        li.findElement(By.tagName("a")).click();
    }
    public void setProvider(String provider){
        driver.findElement(providertxt).sendKeys(provider);
    }
    public void setMinTime(String minTime){
        driver.findElement(minTimetxt).sendKeys(minTime);
    }

    public void setMaxTime(String maxTime){
        driver.findElement(maxTimetxt).sendKeys(maxTime);
    }

    public void setMinTimeOptions(String minTime){
        Select minTimes = new Select(driver.findElement(minTimeOptions));
//        System.out.println(minTimes.getFirstSelectedOption().getText());
//        minTimes.selectByVisibleText(minTime);
        minTimes.getAllSelectedOptions();
//        System.out.println("first element - "+minTimes.getAllSelectedOptions().indexOf(-1));

        List<WebElement> listOptions = minTimes.getOptions();
        for (WebElement webElement : listOptions){
            if (webElement.getText().equals(minTime)) minTimes.selectByVisibleText(minTime);
            System.out.println("min options - "+webElement.getText());
        }
    }

    public void setMaxTimeOptions(String maxTime){
        Select maxTimes = new Select(driver.findElement(maxTimeOptions));
//        maxTimes.selectByVisibleText(maxTime);
//        maxTimes.getFirstSelectedOption();
//        maxTimes.getOptions()
//        System.out.println("first element - "+maxTimes.getAllSelectedOptions().indexOf(-1));
        maxTimes.getAllSelectedOptions();
        List<WebElement> listOptions = maxTimes.getOptions();
        for (WebElement webElement : listOptions){
            if (webElement.getText().equals(maxTime)) maxTimes.selectByVisibleText(maxTime);
            System.out.println("max options - "+webElement.getText());
        }

    }

    public void setNotesArea(String notes) {
        driver.findElement(notesAreatxt).sendKeys(notes);
    }
}
