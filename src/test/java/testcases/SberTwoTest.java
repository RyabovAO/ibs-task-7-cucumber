package testcases;

import org.junit.jupiter.api.Test;
import pages.StartPage;

public class SberTwoTest extends BaseTests{

    @Test
    public void test() {
        pageManager.getPage(StartPage.class).checkStartPage()
                .selectMenu("Вклады")
                .checkDepositPage()
                .clickDepositSettingButton()
                .checkDepositBlock()
                .inputSumOfDeposit("500 000")
                .selectDepositTerm("2 года")
                .selectDepositType("Детский")
                .selectBankTitle("Ак Барс Банк")
                .selectBankTitle("Банк «РОССИЯ»")
                .selectBankTitle("Сбербанк")
                .selectAdditionalChekBox("С выплатой процентов ежемесячно")
                .clickShowButton()
                .checkResultNumber(7)
                .checkDepositInfo("Сбербанк");
    }
}
