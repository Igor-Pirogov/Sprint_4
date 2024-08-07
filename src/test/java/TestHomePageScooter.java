import model.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestHomePageScooter {
    //локатор картинки "Такого заказа нет"
    private static final By NOT_FOUND_IMAGE = By.cssSelector(".Track_NotFound__6oaoY > img");
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //неявное ожидание для всех методов класса (ждем 5 секунд)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void checkStatusOrder_notFound_imageDisplayed() {
        HomePage homePage = new HomePage(driver);
        //загружаем главную страницу
        homePage.openHomePageScooter();
        //кликаем на кнопку "Статус заказа"
        homePage.clickOrderStatusButton();
        //заполняем поле номера заказа
        homePage.enterOrderNumber("123456");
        //кликаем кнопку "GO"
        homePage.clickGoButton();
        //проверяем отображение картинки "Такого заказа нет", если заказа не существует
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement imageNotFound = wait.until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMAGE));
        Assert.assertTrue(imageNotFound.isDisplayed());

    }

}
