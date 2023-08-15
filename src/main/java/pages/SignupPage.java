package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignupPage {
    private String url = "https://www.automationexercise.com/signup";
    private final By enterAccountInformationText = By.xpath("//div[@class='login-form']/h2/b");
    private By chooseGender_radioButton(String genderType) {
        return By.xpath("//input[@value='" + genderType + "']");
    }
    private final By password_input = By.id("password");
    private final By day_select = By.id("days");
    private final By month_select = By.id("months");
    private final By year_select = By.id("years");
    private final By newsletter_checkbox = By.id("newsletter");
    private final By first_name_input = By.id("first_name");
    private final By last_name_input = By.id("last_name");
    private final By company_input = By.id("company");
    private final By address1_input = By.id("address1");
    private final By address2_input = By.id("address2");
    private final By country_select = By.id("country");
    private final By state_input = By.id("state");
    private final By city_input = By.id("city");
    private final By zipcode_input = By.id("zipcode");
    private final By mobile_number_input = By.id("mobile_number");
    private final By create_account_button = By.xpath("//button[@data-qa='create-account']");
    SHAFT.GUI.WebDriver driver;

    public SignupPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void navigate() {
        driver.browser().navigateToURL(url);
    }

    public void fillAccountInformation(String chooseGender, String inputPassword, String dayValue, String monthValue, String yearValue) {
        driver.element().click(chooseGender_radioButton(chooseGender));
        driver.element().type(password_input,inputPassword);
        driver.element().select(day_select,dayValue);
        driver.element().select(month_select,monthValue);
        driver.element().select(year_select,yearValue);
        driver.element().click(newsletter_checkbox);
    }

    public void fillAddressInformation(String inputFirstName, String inputLastName, String inputCompany, String inputAddress1
            , String inputAddress2, String countryValue, String stateValue, String cityValue, String zipcodeValue, String mobileNumberValue) {
        driver.element().type(first_name_input,inputFirstName);
        driver.element().type(last_name_input,inputLastName);
        driver.element().type(company_input,inputCompany);
        driver.element().type(address1_input,inputAddress1);
        driver.element().type(address2_input,inputAddress2);
        driver.element().select(country_select,countryValue);
        driver.element().type(state_input,stateValue);
        driver.element().type(city_input,cityValue);
        driver.element().type(zipcode_input,zipcodeValue);
        driver.element().type(mobile_number_input,mobileNumberValue);
        driver.element().click(create_account_button);
    }

    public void assertOnEnterAccountInformationTextVisibility(String expected) {
         driver.element().assertThat(enterAccountInformationText).text().isEqualTo(expected).perform();
    }
}
