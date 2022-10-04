import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Auto2Test extends Hooks {



    @Test
    public void test2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        System.out.println("Запуск теста");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        WebDriverRunner.setWebDriver(webDriver);
        webDriver.get("http://automationpractice.com/index.php");
        List<SelenideElement> list1 = $$x("//div[@id='block_top_menu']/ul/li/a");
        // Клик по первому элементу списка
        list1.get(0).click();
        $x("//span[text()='Women']").shouldBe(Condition.visible);
        $x("//div[@id='subcategories']//a[@title='Tops']").click();
        $x("//h2[contains(text(),'Tops')]").shouldBe(Condition.visible);
        List<SelenideElement> listProducts = $$x("//div[@class='product-container']");
        List<SelenideElement> price = $$x("//span[contains(text(),'$27.00')]");
        if (price.get(1).exists()==true) {
            System.out.println("Цена соотвествует $27.00");
            listProducts.get(1).hover();
            listProducts.get(1).$x(".//a[@title='Add to cart']").click();
        }
        else {
            System.out.println("Цена не соотвесвтует $27.00, товар не добавлен");
        }
    }
}
