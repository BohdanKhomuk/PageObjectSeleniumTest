import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        String browser = new File( MainClass.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);
        driver = new ChromeDriver(  );
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage( driver );
    }

    @Test
    public void singIn(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals( "Sign in to GitHub", heading );
    }

    @Test
    public void registreFaildTest(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        SignUpPage signUpPage = mainPage.register( "testUser", "testEmail", "testPassword" );
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals( "There were problems creating your account.", error );
    }

    @Test
    public void signUpEmptyUserNameTest(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        SignUpPage signUpPage = mainPage.register( "", "mail", "pass" );
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals( "Login can'n be blank", error );
    }

    @Test
    public void signUpInvalidEmailTest(){
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );
        SignUpPage signUpPage = mainPage.register( "userName", "mail", "pass" );
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals( "Email is invalid or already taken", error );
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
