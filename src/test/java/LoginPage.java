import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath(".//*[@id = 'login_field']");
    private By passwordField = By.xpath(".//*[@id = 'password']");
    private By singInButton = By.xpath(".//input[@type = 'submit']");
    private By heading = By.xpath( ".//div[contains(@class, 'auth_from_header')]/h1" );
    private By error = By.xpath( ".//*[@id = 'js-flash-container']//div[@class = 'container']" );
    private By createAcctLink = By.xpath( ".//a[text() = 'Create an account']" );

    public LoginPage typeUserName(String username){
        driver.findElement( loginField ).sendKeys( username );
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement( passwordField ).sendKeys( password );
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUserName( username );
        this.typePassword( password );
        driver.findElement( singInButton ).click();
        return new LoginPage( driver );
    }

    public String getHeadingText(){
        return driver.findElement( heading ).getText();
    }

    public String getErrorText(){
        return driver.findElement( error ).getText();
    }

    public SingUpPage createAccount(){
        driver.findElement( createAcctLink ).click();
        return new SingUpPage( driver );
    }
}
