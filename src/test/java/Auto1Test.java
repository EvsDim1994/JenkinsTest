import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Auto1Test {

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
    @Test
    public void test1() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        System.out.println("Запуск теста");
        Selenide.open("http://automationpractice.com/index.php");
        List<SelenideElement> list = $$x("//div[@id='block_top_menu']/ul/li/a");
        // Клик по первому элементу списка
        list.get(0).click();
        $x("//span[text()='Women']").shouldBe(Condition.visible);
        $x("//div[@id='subcategories']//a[@title='Tops']").click();
        $x("//h2[contains(text(),'Tops')]").shouldBe(Condition.visible);
        List<SelenideElement> listProducts = $$x("//div[@class='product-container']");
        listProducts.get(0).hover();
        // Ищем внутренний элемент кнопку добавить в корнзину на первом элементе списка.//
        listProducts.get(0).$x(".//a[@title='Add to cart']").click();
    }
}
