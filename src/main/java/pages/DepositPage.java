package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DepositPage extends BasePage {

    @FindBy(xpath = "//div[contains(@data-test,'tab-item-1')]")
    private WebElement depositPage;

    @FindBy(xpath = "//div[@id='deposit_search_form']//button//*[local-name() = 'svg']/../..")
    private WebElement depositSettingButton;

    @FindBy(xpath = "//div[contains(@class,'SearchResultsItem__StyledResultSummary')]")
    private List<WebElement> listOfResultItem;

    @FindBy(xpath = "//div[contains(@class,'SearchResultsItem__StyledResultSummary')]//div[contains(@class,'FlexboxGrid__sc-akw86o-0 cEjnZP L')]//div[@data-test='text']")
    private List<WebElement> listBankTitle;

    @FindBy(xpath = "//div[contains(@class,'SearchResultsItem__StyledResultSummary')]//span[contains(@type,'default')]")
    private List<WebElement> listShowMoreButton;

    @FindBy(xpath = "//div[contains(@class,'FlexboxGrid___sc-fhs6fg-0 evPvTC SortSelector__StyledWrap')]/../../div[@data-test]")
    private WebElement depositNum;

    public DepositPage checkDepositPage() {
        Assertions.assertTrue(depositPage.isDisplayed(), "Страница 'Вклады' не открыта");
        return this;
    }

    public OptionsDepositBlock clickDepositSettingButton() {
        depositSettingButton.click();
        return pageManager.getPage(OptionsDepositBlock.class);
    }

    public DepositPage checkResultNumber(int number) {
        waitPageLoad(500, 250);
        for (WebElement element : listShowMoreButton) {
            if (element.isDisplayed()) clickToElementJs(element);
        }
        Assertions.assertEquals(listOfResultItem.size(), number, "Количество результатов не совпадает");
        return this;
    }

    public DepositPage checkDepositInfo(String title) {
        Assertions.assertTrue(checkTitle(title), "Банк с названием '" + title + "' не представлен на странице");
        return this;
    }

    private boolean checkTitle(String value) {
        for (WebElement element : listBankTitle) {
            if (element.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

}
