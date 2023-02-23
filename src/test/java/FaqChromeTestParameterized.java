import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

@RunWith(Parameterized.class)
public class FaqChromeTestParameterized {
        private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final By QUESTION;
    private final By ANSWER;
    private final String expected;

        public FaqChromeTestParameterized(By QUESTION, By ANSWER, String expected) {
                this.QUESTION = QUESTION;
                this.ANSWER = ANSWER;
                this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getCredentials() {
            return new Object[][] {
                    { By.id("accordion__heading-0"), By.id("accordion__panel-0"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    { By.id("accordion__heading-1"), By.id("accordion__panel-1"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    { By.id("accordion__heading-2"), By.id("accordion__panel-2"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    { By.id("accordion__heading-3"), By.id("accordion__panel-3"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    { By.id("accordion__heading-4"), By.id("accordion__panel-4"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    { By.id("accordion__heading-5"), By.id("accordion__panel-5"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    { By.id("accordion__heading-6"), By.id("accordion__panel-6"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    { By.id("accordion__heading-7"), By.id("accordion__panel-7"), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
            };
        }
        @Test
        public void checkCorrectFaqAnswers() {
            WebDriver driver = new ChromeDriver();
            driver.get(PAGE_URL);
            WebElement element = driver.findElement(QUESTION);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(QUESTION).click();
            String actual = driver.findElement(ANSWER).getText();
            Assert.assertEquals("Ошибка. Неправильный ответ",expected, actual);
            driver.quit();
            }
    }
