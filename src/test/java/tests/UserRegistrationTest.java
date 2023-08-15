package tests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.Helper;

public class UserRegistrationTest   {
    SHAFT.GUI.WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    MenuPage menuPage;
    DeleteAccountPage deleteAccountPage;
    SHAFT.TestData.JSON homeTestData = new SHAFT.TestData.JSON("homePageTestData.json");
    @BeforeClass
    public void beforeClass(){
        SHAFT.Properties.reporting.set().openAllureReportAfterExecution(true);
    }

@Test(description = "verify user registration ")
public void verifyUserRegistration(){
    homePage.               assertOnHomePageTitle(homeTestData.getTestData("expectedResult"));
    menuPage.               clickOnSignuploginButton();
    loginPage.              assertOnNewUserSignupText("New User Signup!");
    loginPage.              newUserSignup("Ahmed", "ahmed" + Helper.generateCurrentDateAndTime() + "@Test.com");
    signupPage.             assertOnEnterAccountInformationTextVisibility("ENTER ACCOUNT INFORMATION");
    signupPage.             fillAccountInformation("Mr", "P@$$w0rd", "2", "4", "2000");
    signupPage.             fillAddressInformation("Ahmed", "khaled", "vois",
            "address1", "address2", "Australia",
            "NY", "NY city", "12345", "121312314");
    accountCreatedPage.     assertOnAccountCreatedTextMessage("ACCOUNT CREATED!");
    accountCreatedPage.     clickOnContinueButton();
    menuPage.               assertOnLoggedInUserNameVisibility("Ahmed");
    menuPage.               clickOnDeleteAccountButton();
    deleteAccountPage.      assertOnAccountDeletedTextMessage("ACCOUNT DELETED!");
    deleteAccountPage.      clickOnContinueButton();
}

    @BeforeMethod
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        homePage = new HomePage(driver);
        homePage.navigate();
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        menuPage = new MenuPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
