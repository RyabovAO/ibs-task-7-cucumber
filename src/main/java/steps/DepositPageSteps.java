package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;
import pages.DepositPage;

public class DepositPageSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("Проверка открытия страницы 'Вклады'")
    public void checkDepositPage() {
        pageManager.getPage(DepositPage.class).checkDepositPage();
    }

    @И("Клик на кнопку 'Настроки' вкладов")
    public void clickDepositSettingButton() {
        pageManager.getPage(DepositPage.class).clickDepositSettingButton();
    }

    @И("^Проверка количества результатов '(\\d+)'")
    public void checkResultNumber(int number) {
        pageManager.getPage(DepositPage.class).checkResultNumber(number);
    }

    @И("^Проверка наличия банка \"(.+)\" в представленных результатах")
    public void checkDepositInfo(String title) {
        pageManager.getPage(DepositPage.class).checkDepositInfo(title);
    }

}
