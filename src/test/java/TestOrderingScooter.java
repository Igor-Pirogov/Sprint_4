import model.FormOrderScooter;
import model.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static model.constants.OrderForm.*;

public class TestOrderingScooter {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //неявное ожидание для всех методов класса (ждем 5 секунд)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //открываем домашнюю страницу сайта
        HomePage homePage = new HomePage(driver);
        homePage.openHomePageScooter();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void checkDropDownList() {

        HomePage homePage = new HomePage(driver);
        homePage.clickOrderButton1();
        //создаем объект формы заказа
        FormOrderScooter form = new FormOrderScooter(driver);
        //заполняем поля формы данными
        form.fillFieldFormOrder(LOC_FIELD_NAME_FORM_ORDER, "Иван");
        form.fillFieldFormOrder(LOC_FIELD_SURNAME_FORM_ORDER, "Иванов");
        form.fillFieldFormOrder(LOC_FIELD_ADDRESS_FORM_ORDER, "г.Москва, ул.Улица, д.ДОМ, к.К, кв.КВ");
        //кликаем по полю "Станция метро"
        form.clickFieldFormOrder(LOC_CLASS_SELECT_SEARCH_METRO_FORM_ORDER);
        //находим и заполняем поле "Станция метро" (выбираем значение "Сокольники" из выпадающего списка)
        form.clickFieldFormOrder(INPUT_CONTAINER_METRO_FORM_ORDER);
        //находим и заполняем поле "Номер телефона"
        form.fillFieldFormOrder(LOC_FIELD_PHONE_FORM_ORDER, "89998887777");

        //находим и нажимаем кнопку "Далее" на форме заказа (создать метод в классе FormOrderScooter)
        homePage.clickOrderButtonNext();
        //Bug: при попытке программно нажать кнопку "Далее" на форме заказа самоката в Chrome браузере
        //возникает ошибка: элемент недоступен для нажатия. Кнопка "Далее" перекрывается объектами класса "App_CookieConsent__1yUIN"

    }
}

