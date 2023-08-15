package pages;

import com.shaft.driver.SHAFT;

public class HomePage {
    SHAFT.GUI.WebDriver driver;
    private final String url = "https://www.automationexercise.com/";

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.browser().navigateToURL(url);
    }

    public void assertOnHomePageTitle(String expected) {
       driver.browser().assertThat().title().isEqualTo(expected).perform();
    }

}
