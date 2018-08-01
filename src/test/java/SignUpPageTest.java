import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    WebDriver driver;
    SignUpPage signUpPage;

    @Before
    public void setUp(){
        String browser = new File( MainClass.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        driver = new ChromeDriver(  );
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get("http://github.com/join");
        SignUpPage signUpPage = new SignUpPage( driver );
    }

    @Test
    public void signUpWithShirtTest(){
        SignUpPage signUpPage = PageFactory.initElements( driver, SignUpPage.class );
        SignUpPage sp = signUpPage.typeUserPassword( "123" );
        String error = sp.getPasswordErrorText();
        Assert.assertEquals( "Password is too short (minimum is 7 characters) and needs at least one number", error );
    }

    @Test
    public void singUpReservedUsernameTest(){
        SignUpPage signUpPage = PageFactory.initElements( driver, SignUpPage.class );
        SignUpPage sp = signUpPage.typeUserName( "username" );
        String error = sp.getUsernameErrorText();
        Assert.assertEquals( "Username is a reserved void", error );
    }

    @Test
    public void singUpTakenUsername(){
        SignUpPage signUpPage = PageFactory.initElements( driver, SignUpPage.class );
        SignUpPage sp = signUpPage.typeUserName( "user" );
        String error = sp.getUsernameErrorText();
        Assert.assertEquals( "User name is already taken", error );
    }

    @Test
    public void getHeadingText(){
        SignUpPage signUpPage = PageFactory.initElements( driver, SignUpPage.class );
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals( "Join GitHub", heading );
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
