import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {



        @BeforeEach
        public void tearDown() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            System.out.println("Запуск теста");
            Configuration.reportsFolder = "ScreenShots";
            Configuration.timeout = 20000;
        }

        @AfterEach
        public void doAfter() {
            Selenide.closeWebDriver();
            System.out.println("Тест пройден");
        }
    }

