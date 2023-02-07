package testcases;

import org.junit.jupiter.api.Test;
import pages.StartPage;

public class SberOneTest extends BaseTests{

    @Test
    public void test() {
        pageManager.getPage(StartPage.class).checkStartPage()
                .selectMenu("Вклады")
                .checkDepositPage()
                .clickDepositSettingButton()
                .checkDepositBlock()
                .inputSumOfDeposit("1 000 000")
                .selectDepositTerm("6 месяцев")
                .selectDepositType("Обычные вклады")
                .selectBankTitle("Сбербанк")
                .selectBankTitle("Тинькоф")
                .selectBankTitle("ВТБ")
                .selectBankTitle("Газпромбанк")
                .selectBankTitle("Открытие")
                .selectAdditionalChekBox("Со снятием")
                .selectAdditionalChekBox("С пополнением")
                .selectAdditionalChekBox("С капитализацией")
                .clickShowButton()
                .checkResultNumber(14)
                .checkDepositInfo("Тинькофф Банк");
    }
}
