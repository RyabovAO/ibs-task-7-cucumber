package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;
import pages.OptionsDepositBlock;

public class OptionsDepositBlockSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("Проверка открытия блока настроек депозита")
    public void checkDepositBlock() {
        pageManager.getPage(OptionsDepositBlock.class).checkDepositBlock();
    }

    @И("^Ввести сумму вклада \"(.+)\"")
    public void inputSumOfDeposit(String value) {
        pageManager.getPage(OptionsDepositBlock.DepositPageBuilder.class).inputSumOfDeposit(value);
    }

    @И("^Выбрать срок вклада \"(.+)\"")
    public void selectDepositTerm(String term) {
        pageManager.getPage(OptionsDepositBlock.DepositPageBuilder.class).selectDepositTerm(term);
    }

    @И("^Выбрать тип вклада \"(.+)\"")
    public void selectDepositType(String type) {
        pageManager.getPage(OptionsDepositBlock.DepositPageBuilder.class).selectDepositType(type);
    }

    @И("^Выбрать банк \"(.+)\"")
    public void selectBankTitle(String title) {
        pageManager.getPage(OptionsDepositBlock.DepositPageBuilder.class).selectBankTitle(title);
    }

    @И("^Выбрать дополнительный параметр вклада \"(.+)\"")
    public void selectAdditionalChekBox(String checkbox) {
        pageManager.getPage(OptionsDepositBlock.DepositPageBuilder.class).selectAdditionalChekBox(checkbox);
    }

    @И("Нажать кнопку 'Показать'")
    public void clickShowButton() {
        pageManager.getPage(OptionsDepositBlock.DepositPageBuilder.class).clickShowButton();
    }
}
