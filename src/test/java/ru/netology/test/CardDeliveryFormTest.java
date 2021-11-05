package ru.netology.test;

import com.codeborne.selenide.Condition;
import data.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryFormTest {
   @BeforeEach
    void setUp() {
        open("http://localhost:9999");

    }

    @Test
    void ShouldChangePlanMeeting(){
        $("[placeholder='Город']").setValue(DataGenerator.generateCity("ru"));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(DataGenerator.chooseFirstDate());
        $("[name='name']").setValue(DataGenerator.generateName("ru"));
        $("[name='phone']").setValue(DataGenerator.generatePhone("ru"));
        $("[class='checkbox__box']").click();
        $(withText("Запланировать")).click();
        $(withText("Успешно")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[class='notification__content']").shouldHave(Condition.text(DataGenerator.chooseFirstDate()));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(DataGenerator.chooseSecondDate());
        $(withText("Запланировать")).click();
        $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).shouldBe(Condition.visible);
        $(withText("Перепланировать")).click();
        $(withText("Успешно")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[class='notification__content']").shouldHave(Condition.text(DataGenerator.chooseSecondDate()));




    }


}
