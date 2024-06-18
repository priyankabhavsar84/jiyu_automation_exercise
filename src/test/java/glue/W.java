package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class W {
    private static W instance = null;

    public static W get() {
        System.out.println("get");
        if (instance == null) {
            System.out.println("====w classss");
            instance = new W();
        }
        return instance;
    }

    protected WebDriver driver;

    public void W() {

        System.out.println("test");

        String pathToDriver = System.getProperty("webdriver.chrome.driver");
        System.out.println("====path"+pathToDriver);
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\halva\\jiyu_automation_exercise\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", pathToDriver);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public static void close() {
        if (instance != null) {
            instance.driver.close();
            instance = null;
        }
    }

}
