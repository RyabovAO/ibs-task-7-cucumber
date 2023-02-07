package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends BasePage{

    @FindBy(xpath = "//div[contains(@data-test,'tab-item-1')]")
    private WebElement depositPage;

    @FindBy(xpath = "//div[@id='deposit_search_form']//button//*[local-name() = 'svg']/../..")
    private WebElement depositSettingButton;

    @FindBy(xpath = "//div[contains(@class,'SearchResultsItem__StyledResultSummary')]")
    private List<WebElement> listOfResultItem;

    @FindBy(xpath = "//div[contains(@class,'FlexboxGrid___sc-fhs6fg-0 evPvTC SortSelector__StyledWrap')]/../../div[@data-test]")
    private WebElement depositNum;

    @Step("Проверка открытия страницы 'Вклады'")
    public DepositPage checkDepositPage() {
        Assertions.assertTrue(depositPage.isDisplayed(), "Страница 'Вклады' не открыта");
        return this;
    }

    @Step("Клик на кнопку 'Настроки' вкладов")
    public OptionsDepositBlock clickDepositSettingButton() {
        depositSettingButton.click();
        return pageManager.getPage(OptionsDepositBlock.class);
    }

    public DepositPage checkResultNumber() {
        return this;
    }

    public DepositPage checkBankTitle() {
        return this;
    }

    public DepositPage checkTerm() {
        return this;
    }

    public DepositPage checkBankRate() {
        return this;
    }

    public DepositPage checkIncome() {
        return this;
    }
}
