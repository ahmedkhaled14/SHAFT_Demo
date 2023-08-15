package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MenuPage {
    private final String url = "https://www.automationexercise.com/";
    private final By signup_login_button = By.xpath("//a[@href='/login']");
    private final By LoggedInUserName = By.xpath("//i[@class='fa fa-user']//parent::a");
    private final By delete_account_button = By.xpath("//a[@href='/delete_account']");

    SHAFT.GUI.WebDriver driver;

    public MenuPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.browser().navigateToURL(url);
    }


    public void clickOnSignuploginButton() {
        driver.element().click(signup_login_button);
    }

    public void clickOnDeleteAccountButton() {
        driver.element().click(delete_account_button);
    }

    public void assertOnLoggedInUserNameVisibility(String signUpName) {
        driver.element().assertThat(LoggedInUserName).text().isEqualTo("Logged in as "+signUpName).perform();
    }


}
