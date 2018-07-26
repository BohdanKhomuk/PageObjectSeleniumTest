import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singInButton = By.xpath(".//a[text() = 'Sing in']");
    private By singUpButton = By.xpath(".//a[text() = 'Sing up']");
    private By userNameField = By.xpath(".//*[@id = 'user[login]']");
    private By emailField = By.xpath(".//*[@id = 'user[email]']");
    private By passwordField = By.xpath(".//*[@id = 'user[password]']");
    private By singUpFromButton = By.xpath(".//button[text() = 'Sing up for GitHub']");

    public LoginPage clickSignIn(){
        driver.findElement( singInButton ).click();
        return new LoginPage( driver );
    }

    public SingUpPage clickSignUpButtom(){
        driver.findElement( singUpButton ).click();
        return new SingUpPage( driver );
    }

    public SingUpPage clickSignUpFromButton(){
        driver.findElement( singUpFromButton ).click();
        return new SingUpPage( driver );
    }

    public MainPage typeUserName(String username){
        driver.findElement( userNameField ).sendKeys( username );
        return this;
    }

    public MainPage typeUserPassword(String password){
        driver.findElement( passwordField ).sendKeys( password );
        return this;
    }

    public MainPage typeUserEmail(String email){
        driver.findElement( emailField ).sendKeys( email );
        return this;
    }

    public SingUpPage register(String username, String email, String password){
        this.typeUserName(username);
        this.typeUserEmail( email );
        this.typeUserPassword( password );
        this.clickSignUpFromButton();
        return new SingUpPage( driver );
    }

}
