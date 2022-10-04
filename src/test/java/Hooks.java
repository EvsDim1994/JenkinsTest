import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    @BeforeAll
    public void doBeforeAll() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

        @BeforeEach
        public void tearDown() {
            Configuration.reportsFolder = "ScreenShots";
            Configuration.timeout = 20000;
        }

        @AfterEach
        public void doAfter() {
            Selenide.closeWebDriver();
            System.out.println("Тест пройден");
        }
    }

