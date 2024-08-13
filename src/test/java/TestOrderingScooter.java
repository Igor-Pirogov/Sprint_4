import model.FormOrderScooter;
import model.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

import static model.constants.OrderForm.*;

@RunWith(Parameterized.class)
public class TestOrderingScooter {

    private final String browser;
    private final String buttonNext;
    private final String name;
    private final String surname;
    private final String address;
    private final By locFieldMetro;
    private final String phone;
    //private final Date dataOrder;
    //private final By locFieldPeriod;
    //private final By locFieldColor;
    //private final String comment;

    public TestOrderingScooter(String browser,String buttonNext,String name,String surname,String address,
                               By locFieldMetro,String phone) {
        this.browser = browser;
        this.buttonNext = buttonNext;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.locFieldMetro = locFieldMetro;
        this.phone = phone;

    }

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        //в зависимости от значения переменной browser запускаем тест в разных браузерах
        if (browser.contains("FireFox")) {
            driver = new FirefoxDriver();
        }
        if (browser.contains("Chrome")) {
            driver = new ChromeDriver();
        }
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

    //Параметры для теста лежат в папке constants>DropDownList
    @Parameterized.Parameters
    public static Object[][] getParamFormOrder() {
        return new Object[][] {
                {"FireFox","TopButton", "Иван", "Иванов", "г.Москва", INPUT_CONTAINER_METRO_SOKOLNIKY, "89997776666"},
                {"FireFox","BottomButton", "Сидор", "Сидоров", "г.Москва", INPUT_CONTAINER_METRO_LENINLIBRARY, "89996665555"},
                {"Chrome","TopButton", "Иван", "Иванов", "г.Москва", INPUT_CONTAINER_METRO_SOKOLNIKY, "89997776666"},
                {"Chrome","BottomButton", "Сидор", "Сидоров", "г.Москва", INPUT_CONTAINER_METRO_LENINLIBRARY, "89996665555"},
        };
    }

    @Test
    public void checkFormForWhomScooter() {

        HomePage homePage = new HomePage(driver);
        //неявное ожидание для всех методов класса (ждем 5 секунд)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //открываем домашнюю страницу сайта
        homePage.openHomePageScooter();
        //нажимаем кнопку Заказать (верхнюю или нижнюю) в зависимости от значения переменной buttonNext
        if (buttonNext.contains("TopButton")) {
            homePage.clickOrderButton1();
        }
        if (buttonNext.contains("BottomButton")) {
            homePage.clickOrderButton2();
        }
        //создаем объект формы заказа
        FormOrderScooter form = new FormOrderScooter(driver);
        //заполняем поля формы данными
        form.fillFieldFormOrder(LOC_FIELD_NAME_FORM_ORDER, name);
        form.fillFieldFormOrder(LOC_FIELD_SURNAME_FORM_ORDER, surname);
        form.fillFieldFormOrder(LOC_FIELD_ADDRESS_FORM_ORDER, address);
        //кликаем по полю "Станция метро"
        form.clickFieldFormOrder(LOC_CLASS_SELECT_SEARCH_METRO_FORM_ORDER);
        //находим и заполняем поле "Станция метро" (выбираем значение "Сокольники" из выпадающего списка)
        form.clickFieldFormOrder(locFieldMetro);
        //находим и заполняем поле "Номер телефона"
        form.fillFieldFormOrder(LOC_FIELD_PHONE_FORM_ORDER, phone);

        //находим и нажимаем кнопку "Далее" на форме заказа (создать метод в классе FormOrderScooter)
        homePage.clickOrderButtonNext();
        //Bug: при попытке программно нажать кнопку "Далее" на форме заказа самоката в Chrome браузере
        //возникает ошибка: элемент недоступен для нажатия. Кнопка "Далее" перекрывается объектами класса "App_CookieConsent__1yUIN"
    }
}