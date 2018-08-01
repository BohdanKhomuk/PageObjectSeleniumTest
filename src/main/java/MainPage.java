import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//a[text() = 'Sign in']")
    private WebElement singInButton;
    @FindBy(xpath = ".//a[text() = 'Sign up']" )
    private WebElement singUpButton;
    @FindBy(xpath = ".//*[@id = 'user[login]']")
    private WebElement userNameField;
    @FindBy(xpath = ".//*[@id = 'user[email]']" )
    private WebElement emailField;
    @FindBy(xpath = ".//*[@id = 'user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = ".//button[text() = 'Sign up for GitHub']")
    private WebElement singUpFromButton;

    public LoginPage clickSignIn(){
        singInButton.click();
        return new LoginPage( driver );
    }

    public SignUpPage clickSignUpButtom(){
        singUpButton.click();
        return new SignUpPage( driver );
    }

    public SignUpPage clickSignUpFromButton(){
        singUpFromButton.click();
        return new SignUpPage( driver );
    }

    public MainPage typeUserName(String username){
        userNameField.sendKeys( username );
        return this;
    }

    public MainPage typeUserPassword(String password){
        passwordField.sendKeys( password );
        return this;
    }

    public MainPage typeUserEmail(String email){
        emailField.sendKeys( email );
        return this;
    }

    public SignUpPage register(String username, String email, String password){
        this.typeUserName(username);
        this.typeUserEmail( email );
        this.typeUserPassword( password );
        this.clickSignUpFromButton();
        return new SignUpPage( driver );
    }

}
