package ru.yandex.practicum.project4.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Order {
    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private static final By BUTTON_ORDER_TOP = By.xpath("//*[@class='Button_Button__ra12g']");
    private static final By BUTTON_ORDER_MIDDLE = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By FIELD_NAME = By.xpath(".//input[(@class='Input_Input__1iN_Z Input_Responsible__1jDKN') and (@placeholder='* Имя')]");
    private static final By FIELD_SURNAME = By.xpath(".//input[(@class='Input_Input__1iN_Z Input_Responsible__1jDKN') and (@placeholder='* Фамилия')]");
    private static final By FIELD_ADDRESS = By.xpath(".//input[(@class='Input_Input__1iN_Z Input_Responsible__1jDKN') and (@placeholder='* Адрес: куда привезти заказ')]");
    private static final By DROPDOWN_METRO = By.xpath(".//input[@class='select-search__input']");
    private static final By DROPDOWN_METRO_ROKOSSOVSKOGO = By.xpath(".//div[text()='Бульвар Рокоссовского']");
    private static final By DROPDOWN_METRO_CHERKIZOVSKAYA = By.xpath(".//div[text()='Черкизовская']");
    private static final By FIELD_PHONE_NUMBER = By.xpath(".//input[(@class='Input_Input__1iN_Z Input_Responsible__1jDKN') and (@placeholder='* Телефон: на него позвонит курьер')]");
    private static final By BUTTON_NEXT = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private static final By FIELD_WHEN = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By DROPDOWN_RENT_PERIOD = By.xpath(".//div[@class='Dropdown-control']");
    private static final By RENT_PERIOD_ONE_DAY = By.xpath(".//div[text() ='сутки']");
    private static final By RENT_PERIOD_TWO_DAYS = By.xpath(".//div[text() ='двое суток']");
    private static final By CHECKBOX_COLOUR_BLACK = By.id("black");
    private static final By CHECKBOX_COLOUR_GRAY = By.id("grey");
    private static final By FIELD_COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']"); // не обязательное поле
    private static final By BUTTON_ORDER = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and (text() ='Заказать')]");
    private static final By BUTTON_YES = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and (text() ='Да')]");
    private static final By SUCCESS_TEXT = By.xpath(".//div[text()='Заказ оформлен']");


    private final WebDriver driver;
    public Order(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PAGE_URL);
    }
    public void clickButtonOrderTop() {
        driver.findElement(BUTTON_ORDER_TOP).click();
    }
    public void clickButtonOrderMiddle() {
        WebElement element = driver.findElement(BUTTON_ORDER_MIDDLE);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(BUTTON_ORDER_MIDDLE).click();
    }
    public void fillName(String name) {
        driver.findElement(FIELD_NAME).sendKeys(name);
    }
    public void fillSurname(String surname) {
        driver.findElement(FIELD_SURNAME).sendKeys(surname);
    }
    public void fillAddress(String address) {
        driver.findElement(FIELD_ADDRESS).sendKeys(address);
    }
    public void chooseMetro1() {
        driver.findElement(DROPDOWN_METRO).sendKeys("Бульвар Рокоссовского");
        driver.findElement(DROPDOWN_METRO_ROKOSSOVSKOGO).click();
    }
    public void chooseMetro2() {
        driver.findElement(DROPDOWN_METRO).sendKeys("Черкизовская");
        driver.findElement(DROPDOWN_METRO_CHERKIZOVSKAYA).click();
    }
    public void fillNumber(String phoneNumber) {
        driver.findElement(FIELD_PHONE_NUMBER).sendKeys(phoneNumber);
    }
    public void clickNext() {
        driver.findElement(BUTTON_NEXT).click();
    }

    public void fillWhen(String when) {
        driver.findElement(FIELD_WHEN).click();
        driver.findElement(FIELD_WHEN).sendKeys(when, (Keys.ENTER));
    }
    public void chooseRentPeriod1day() {
        driver.findElement(DROPDOWN_RENT_PERIOD).click();
        driver.findElement(RENT_PERIOD_ONE_DAY).click();
    }
    public void chooseRentPeriod2days() {
        driver.findElement(DROPDOWN_RENT_PERIOD).click();
        driver.findElement(RENT_PERIOD_TWO_DAYS).click();
    }
    public void chooseColorBlack() {
        driver.findElement(CHECKBOX_COLOUR_BLACK).click();
    }
    public void chooseColorGray() {
        driver.findElement(CHECKBOX_COLOUR_GRAY).click();
    }
    public void fillComment(String comment) {
        driver.findElement(FIELD_COMMENT).sendKeys(comment);
    }
    public void clickOrder() {
        driver.findElement(BUTTON_ORDER).click();
    }
    public void clickYes() {
        driver.findElement(BUTTON_YES).click();
    }

    public boolean isImageSuccessDisplayed() {
        return driver.findElement(SUCCESS_TEXT).isDisplayed();
    }
}
