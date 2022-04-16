package login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests {
    private WebDriver driver;
    public LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.out.println("before logintetst");
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        driver.manage().window().maximize();
        this.loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessful() {
        loginPage.setUserName("Admin");
        loginPage.setPassword("Admin123");
        loginPage.clickInpatientWard();
        HomePage homePage = loginPage.clickLoginButton();
        String alertText = homePage.getAlertText();
        Assertions.assertTrue(alertText.contains("Logged in as Super User (admin) at Inpatient Ward."), "Alert text is incorrect!");
    }

    @AfterEach
    public void tearDown() {
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.quit();
    }
}
