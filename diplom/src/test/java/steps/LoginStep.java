package steps;

import baseEntities.BaseStep;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginStep extends BaseStep {

    private LoginPage page;


    public LoginStep(WebDriver driver) {
        super(driver);
        page = new LoginPage(driver);
    }


    private void login(String email, String pass){

        page.getEmailInput().sendKeys(email);
        page.getPassword().sendKeys(pass);
        page.getLogInButton().click();

        logger.trace("Used email - " + email + " and password - " + pass + " for login");
    }

    public DashboardPage successfulLogin(){
        login(ReadProperties.email(), ReadProperties.password());
        return new DashboardPage(driver);
    }

    public LoginPage unsuccessfulLogin(String email, String pass) {
        login(email, pass);
        return page;
    }
}