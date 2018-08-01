import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        String browser = new File( MainClass.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        driver = new ChromeDriver(  );
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get("http://github.com/login");
        LoginPage loginPage = new LoginPage( driver );
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals( "Incorrect username or password.", error );
    }

    @Test
    public void loginWithIncorrectEmptyCredsTest(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("namename", "qwerty12345");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals( "Incorrect username or password.", error );
    }

    @Test
    public void createAccTest(){
        LoginPage loginPage = PageFactory.initElements( driver, LoginPage.class );
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals( "Join GitHub", heading );
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
