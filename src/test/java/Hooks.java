import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class Hooks {



        @BeforeEach
        public void tearDown() {
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

