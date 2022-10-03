import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Auto1Test extends Hooks {

    @Test
    public void test1() throws InterruptedException {
        Selenide.open("http://automationpractice.com/index.php");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
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
