package model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    //адрес домашней страницы
    private static final String HOME_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    //кнопка Статус заказа
    private static final By LOC_STATUS_BUTTON_HOMEPAGE = By.xpath("//*[@class='Header_Link__1TAG7']");
    //поле Введите номер заказа
    private static final By LOC_INPUT_FIELD_NUMBER_HOMEPAGE = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[3]/div/input");
    //кнопка GO
    private static final By LOC_GO_BUTTON_HOMEPAGE = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[3]/button");
    //кнопка Заказать верхняя
    public static final By LOC_ORDER_BUTTON_1_HOMEPAGE = By.xpath("//*[@id='root']/div/div[1]/div[1]/div[2]/button[1]");
    //кнопка Заказать нижняя
    public static final By LOC_ORDER_BUTTON_2_HOMEPAGE = By.xpath("//*[@id='root']/div/div[1]/div[4]/div[2]/div[5]/button");
    //кнопка Далее при оформлении заказа
    public static final By LOC_NEXT_BUTTON_FORM_ORDER = By.cssSelector(".Button_Middle__1CSJM");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //открываем домашнюю страницу
    public void openHomePageScooter() {
        driver.get(HOME_PAGE_URL);
    }
    //кликнуть кнопку Статус заказа
    public void clickOrderStatusButton() {
        driver.findElement(LOC_STATUS_BUTTON_HOMEPAGE).click();
    }
    //заполняем поле Введите номер заказа
    public void enterOrderNumber(String orderNumber) {
        driver.findElement(LOC_INPUT_FIELD_NUMBER_HOMEPAGE).sendKeys(orderNumber);
    }
    //кликнуть кнопку GO
    public void clickGoButton() {
        driver.findElement(LOC_GO_BUTTON_HOMEPAGE).click();
    }
    //ждать 5 сек пока элемент станет кликабельным
    public void waitWebElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    //кликнуть верхнюю кнопку Заказать
    public void clickOrderButton1() {
        WebElement element = driver.findElement(LOC_ORDER_BUTTON_1_HOMEPAGE);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    //кликнуть нижнюю кнопку Заказать
    public void clickOrderButton2() {
        WebElement element = driver.findElement(LOC_ORDER_BUTTON_2_HOMEPAGE);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    //кликнуть кнопку Далее
    public void clickOrderButtonNext() {
        WebElement element = driver.findElement(LOC_NEXT_BUTTON_FORM_ORDER);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}