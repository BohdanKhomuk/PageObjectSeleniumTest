import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class = 'setup-wrapper']//h1");
    private By userNameField = By.xpath("//*[@id = 'user_login']");
    private By emailField = By.xpath("//*[@id = 'user_email']");
    private By passwordField = By.xpath("//*[@id = 'user_password']");
    private By singUpButton = By.xpath("//*[@id = 'signup-form']");
    private By mainError = By.xpath("//form[@id = 'signup-form']//ancestor::dl//preceding-sibling::div[contains(@class, 'flash-error')]");
    private By userNameError = By.xpath("//input[@id = 'user_login']/ancestor::dd/following-sibling::dd");
    private By emailError = By.xpath( "//*[@id = 'user_email']/ancestor::dd/following-sibling::dd" );
    private By passwordError = By.xpath( "//*[@id = 'user_password']/ancestor::dd/following-sibling::dd" );

    public SignUpPage typeUserName(String username){
        driver.findElement( userNameField ).sendKeys( username );
        return this;
    }

    public SignUpPage typeUserPassword(String password){
        driver.findElement( passwordField ).sendKeys( password );
        return this;
    }

    public SignUpPage typeUserEmail(String email){
        driver.findElement( emailField ).sendKeys( email );
        return this;
    }

    public SignUpPage registerWithInvalideCreds(String username, String email, String password){
        this.typeUserName( username );
        this.typeUserPassword( password );
        this.typeUserEmail( email );
        driver.findElement( singUpButton ).click();
        return new SignUpPage( driver );
    }

    public String getHeadingText(){
        return driver.findElement( heading ).getText();
    }

    public String getMainErrorText(){
        return driver.findElement( mainError ).getText();
    }

    public String getUsernameErrorText(){
        return driver.findElement( userNameError ).getText();
    }

    public String getPasswordErrorText(){
        return driver.findElement( passwordError ).getText();
    }

    public String getEmailErrorText(){
        return driver.findElement( emailError ).getText();
    }
}
