import model.HomePage;
import model.QuestionsAboutImportantThings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static model.constants.DropDownList.*;


@RunWith(Parameterized.class)
public class TestCheckDropDownList {
    private final By locQuestion;
    private final By locAnswer;
    private final String textAnswer;

    private WebDriver driver;

    public TestCheckDropDownList(By locQuestion, By locAnswer, String textAnswer) {
        this.locQuestion = locQuestion;
        this.locAnswer = locAnswer;
        this.textAnswer = textAnswer;
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //неявное ожидание для всех методов класса (ждем 5 секунд)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //открываем домашнюю страницу сайта
        HomePage homePage = new HomePage(driver);
        homePage.openHomePageScooter();
    }

    @After
    public void after() {
        driver.quit();
    }

    //необходимые параметры для теста лежат в папке constants>DropDownList
    @Parameterized.Parameters
    public static Object[][] getDropDownList() {
        return new Object[][] {
                {LOC_QUESTION_0, LOC_ANSWER_0, TEXT_ANSWER_0},
                {LOC_QUESTION_1, LOC_ANSWER_1, TEXT_ANSWER_1},
                {LOC_QUESTION_2, LOC_ANSWER_2, TEXT_ANSWER_2},
                {LOC_QUESTION_3, LOC_ANSWER_3, TEXT_ANSWER_3},
                {LOC_QUESTION_4, LOC_ANSWER_4, TEXT_ANSWER_4},
                {LOC_QUESTION_5, LOC_ANSWER_5, TEXT_ANSWER_5},
                {LOC_QUESTION_6, LOC_ANSWER_6, TEXT_ANSWER_6},
                {LOC_QUESTION_7, LOC_ANSWER_7, TEXT_ANSWER_7},
        };
    }

    @Test
    public void checkDropDownList() {
        //скролл до элемена списка вопросов, найденного по локатору locQuestion
        WebElement element = driver.findElement(locQuestion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        //поиск элемента с ответом на вопрос в выпадающем списке вопроса по локатору locAnswer
        //сравнение значения найденного текста с текстом из справочника
        QuestionsAboutImportantThings dropdownList =
                new QuestionsAboutImportantThings(driver);
        String actualTextAnswer = dropdownList.clickElementDropDownList(locQuestion, locAnswer);
        Assert.assertEquals("Текст поля изменен", textAnswer, actualTextAnswer);;

    }

}
