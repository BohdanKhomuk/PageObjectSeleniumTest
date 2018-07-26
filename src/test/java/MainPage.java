import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//a[text() = 'Sing in']")
    private WebElement singInButton;
    @FindBy(xpath = ".//a[text() = 'Sing up']" )
    private WebElement singUpButton;
    @FindBy(xpath = ".//*[@id = 'user[login]']")
    private WebElement userNameField;
    @FindBy(xpath = ".//*[@id = 'user[email]']" )
    private WebElement emailField;
    @FindBy(xpath = ".//*[@id = 'user[password]']")
    private WebElement passwordField;
    @FindBy(xpath = ".//button[text() = 'Sing up for GitHub']")
    private WebElement singUpFromButton;

    public LoginPage clickSignIn(){
        singInButton.click();
        return new LoginPage( driver );
    }

    public SingUpPage clickSignUpButtom(){
        singUpButton.click();
        return new SingUpPage( driver );
    }

    public SingUpPage clickSignUpFromButton(){
        singUpFromButton.click();
        return new SingUpPage( driver );
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

    public SingUpPage register(String username, String email, String password){
        this.typeUserName(username);
        this.typeUserEmail( email );
        this.typeUserPassword( password );
        this.clickSignUpFromButton();
        return new SingUpPage( driver );
    }

}
