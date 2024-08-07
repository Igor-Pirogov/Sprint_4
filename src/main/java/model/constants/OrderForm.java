package model.constants;

import org.openqa.selenium.By;

public class OrderForm {
    //локатор для поля "Имя" Формы Заказа
    public static final By LOC_FIELD_NAME_FORM_ORDER = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    //локатор для поля "Фамилия" Формы Заказа
    public static final By LOC_FIELD_SURNAME_FORM_ORDER = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    //локатор для поля "Адрес" Формы Заказа
    public static final By LOC_FIELD_ADDRESS_FORM_ORDER = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    //локатор для поля "Телефон" Формы Заказа
    public static final By LOC_FIELD_PHONE_FORM_ORDER = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    //локатор для поля "Станция метро"
    public static final By LOC_CLASS_SELECT_SEARCH_METRO_FORM_ORDER = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[1]/input");
    //путь для выбора станции метро "Сокольники" из выпадающего списка станций метро
    public static final By INPUT_CONTAINER_METRO_FORM_ORDER = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[4]/button/div[2]");
    //локатор для кнопки "Далее"
    public static final By LOC_BUTTON_NEXT_FORM_ORDER = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");


}
