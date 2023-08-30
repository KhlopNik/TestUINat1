package com.stepup;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideTest {
    @Before
    public void setUp() {
        SelenidePagePobedaInfo selenidePagePobedaInfo = new SelenidePagePobedaInfo();
        Configuration.browserSize = "1920x1080";
        selenidePagePobedaInfo.openPage();
        Assert.assertEquals("Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы", selenidePagePobedaInfo.getTitle());
        Assert.assertTrue(selenidePagePobedaInfo.checkLogo());
    }
    @Test
    @Description(value = "DescriptionSelenideTest")
    public void testS1(){
        SelenidePagePobedaInfo selenidePagePobedaInfo = new SelenidePagePobedaInfo();
        //Наводим на элемент Information
        selenidePagePobedaInfo.infoLink();
        //Проверяем заголовок "«Подготовка к полету»" из всплывающего окна
        Assert.assertEquals("Подготовка к полёту", selenidePagePobedaInfo.getTitleFlightPreparation());
        //Проверяем заголовок "«Полезная информация»" из всплывающего окна
        Assert.assertEquals("Полезная информация", selenidePagePobedaInfo.getTitleHelpfulInformation());
        //Проверяем заголовок "«Подготовка к полету»" из всплывающего окна
        Assert.assertEquals("О компании", selenidePagePobedaInfo.getTitleAboutCompany());
    }
    //    @Test
    public void testS2(){
        SelenideTicketSearchPage selenideTicketSearchPage = new SelenideTicketSearchPage();
        //Проверяем наличие блока поиска билетов
        Assert.assertTrue(selenideTicketSearchPage.checkBlockTicketSearch());
        //Проверяем наличие полня ввода "Откуда"
        Assert.assertTrue(selenideTicketSearchPage.checkFindElementFieldFrom());
        //Проверяем наличие полня ввода "Куда"
        Assert.assertTrue(selenideTicketSearchPage.checkFindElementFieldThere());
        //Проверяем наличие полня ввода "Даты вылета туда"
        Assert.assertTrue(selenideTicketSearchPage.checkFindElementDateOfDeparture());
        //Проверяем наличие полня ввода "Даты вылета оттуда"
        Assert.assertTrue(selenideTicketSearchPage.checkFindElementDateOfDepartureFromThere());
        //Кликаем на поле вводе "Откуда"
        selenideTicketSearchPage.clickFindElementFieldFrom();
        //Вводим значение пункта отправления "Москва" и выбираем первый пункт
        selenideTicketSearchPage.inputFieldFrom("Москва");
        //Кликаем на поле вводе "Куда"
        selenideTicketSearchPage.clickFindElementFieldThere();
        //Вводим значение пункта назначения "Санкт-Петербург" и выбираем первый пункт
        selenideTicketSearchPage.inputtFieldThere("Санкт-Петербург");
        //кликаем на кнопку поиска
        selenideTicketSearchPage.clickSearchButton();
        //Проверяем, что обводка стала красной
        Assert.assertTrue(selenideTicketSearchPage.getCheckErrorBorderDateOfDeparture());
    }
    //    @Test
    public void testS3(){
        SelenidePageOrder selenidePageOrder = new SelenidePageOrder();
        //Скроллим до низа страницы
        selenidePageOrder.scrollToElement(selenidePageOrder.fullScroll);
        //Кликаем на ссылку «Управление бронированием»
        selenidePageOrder.clickBookingManagementPoint();
        //Ожидаем загрузки страницы
        $(selenidePageOrder.fieldOrderOrTicketNumber).shouldBe(visible, Duration.ofSeconds(10));
        //Проверяем что отображается поле «Номер заказа или билета»
        Assert.assertTrue(selenidePageOrder.checkFindElement(selenidePageOrder.fieldOrderOrTicketNumber));
        //Проверяем что отображается поле «Фамилия клиента»
        Assert.assertTrue(selenidePageOrder.checkFindElement(selenidePageOrder.fieldLastNameOfTheClient));
        //Проверяем что отображается кнопка поиска
        Assert.assertTrue(selenidePageOrder.checkFindElement(selenidePageOrder.fieldSearchButton));
        //Кликаем в поле «Номер заказа или билета»
        selenidePageOrder.clickElement(selenidePageOrder.fieldOrderOrTicketNumber);
        //В поле «Номер заказа или билета» вводим "XXXXXX"
        selenidePageOrder.enteringTextIntoAnElement(selenidePageOrder.fieldOrderOrTicketNumber, "XXXXXX");
        //Кликаем в поле «Фамилия клиента»
        selenidePageOrder.clickElement(selenidePageOrder.fieldLastNameOfTheClient);
        //В поле «Фамилия клиента» вводим "Qwerty"
        selenidePageOrder.enteringTextIntoAnElement(selenidePageOrder.fieldLastNameOfTheClient, "Qwerty");
        //Кликаем на кнопку поиска
        selenidePageOrder.clickElement(selenidePageOrder.fieldSearchButton);
        //Переключаемся на открывшуются вкладку
        selenidePageOrder.switchToOpenTab();
        //Ожидаем загрузки страницы на случай появления капчи
        $(selenidePageOrder.errorMessage).shouldBe(visible, Duration.ofSeconds(30));
        //Проверяем текст ошибки на новой вкладке
        Assert.assertEquals("Заказ с указанными параметрами не найден", selenidePageOrder.getTextErrorMessage());
    }
}