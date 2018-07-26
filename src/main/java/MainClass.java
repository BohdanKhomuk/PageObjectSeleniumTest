import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainClass {
    //ppp
    static WebDriver driver;
    public static void main(String[] args){

        String browser = new File( MainClass.class.getResource("/chromedriver.exe").getFile()).getPath();
        System.setProperty("webdriver.chrome.driver", browser);

        driver = new ChromeDriver(  );
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.get("http://github.com");

//        MainPage mainPage = new MainPage( driver );
        MainPage mainPage = PageFactory.initElements( driver, MainPage.class );

        mainPage.register( "testusername", "qweqw@xpr.com", "qwerty123" );
        //mainPage.clickSignIn();

    }
}
