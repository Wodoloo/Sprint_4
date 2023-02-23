import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.project4.pom.Order;
import org.junit.*;

public class OrderChromeTest {
    private WebDriver driver;
    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }
    @AfterEach
     void teardown() { driver.quit(); }

    @Test
    public void orderTestOne() {
        Order one = new Order (driver);
        one.open();
        one.clickButtonOrderTop();
        one.fillName("Иван");
        one.fillSurname("Иванов");
        one.fillAddress("ул. Правды д. 1 кв. 1");
        one.chooseMetro1();
        one.fillNumber("+71234567890");
        one.clickNext();
        one.fillWhen("23.03.2023");
        one.chooseRentPeriod1day();
        one.chooseColorBlack();
        one.clickOrder();
        one.clickYes();
        Assert.assertTrue(one.isImageSuccessDisplayed());
    }
    @Test
    public void orderTestTwo() {
        Order two = new Order (driver);
        two.open();
        two.clickButtonOrderMiddle();
        two.fillName("Ян");
        two.fillSurname("Джексон");
        two.fillAddress("Невский 46, квартира 100");
        two.chooseMetro2();
        two.fillNumber("89211111111");
        two.clickNext();
        two.fillWhen("01.03.2023");
        two.chooseRentPeriod2days();
        two.chooseColorGray();
        two.fillComment("Позвоните мне");
        two.clickOrder();
        two.clickYes();
        Assert.assertTrue(two.isImageSuccessDisplayed());
    }
}