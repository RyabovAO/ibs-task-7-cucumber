package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class OptionsDepositBlock extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'SearchModal__StyledBody')]//div[@data-test='text']")
    private WebElement optionsDepositBlock;

    @FindBy(xpath = "//div[@data-test='text']/..//label[@data-testid='input-label']/..//input[@name='amount']")
    private WebElement sumOfDeposit;

    @FindBy(xpath =
            "//div[contains(@class,'SearchModal__')]//div[@data-test='dropdown-button']//span[contains(text(),'любой')]")
    private WebElement termButton;

    @FindBy(xpath =
            "//div[contains(@class,'SearchModal__')]//div[@data-test='dropdown-button']//span[contains(text(),'любой')]/../../../../../..//li")
    private List<WebElement> listDepositTerm;

    @FindBy(xpath = "//div[contains(@class,'SearchModal__')]//div[@data-test='dropdown-button']//span[contains(text(),'Все вклады')]")
    private WebElement depositTypeButton;

    @FindBy(xpath =
            "//div[contains(@class,'SearchModal__')]//div[@data-test='dropdown-button']//span[contains(text(),'Все вклады')]/../../../../../..//li")
    private List<WebElement> listDepositType;

    @FindBy(xpath = "//label[@data-testid='input-label']/..//input[@type='text' and not(contains(@name,'amount'))]")
    private WebElement inputFieldBankTitle;

    @FindBy(xpath = "//span[@data-testid='checkbox-icon-wrapper']/..//input[not(@name)]/..//..//span[not(contains(@class,' '))]")
    private List<WebElement> listBankTitleCheckBox;

    @FindBy(xpath = "//div[contains(@class,'SearchModal__')]/..//button")
    private WebElement showButton;

    @FindBy(xpath = "//span[@data-testid='checkbox-icon-wrapper']/..//input[@name]/..//span[not(contains(@class,' '))]")
    private List<WebElement> listCheckBoxAdditionalOption;

    public OptionsDepositBlock.DepositPageBuilder checkDepositBlock() {
        waitUtilElementToBeVisible(optionsDepositBlock);
        Assertions.assertTrue(optionsDepositBlock.isDisplayed(), "Блок параметров вклада не открыт");
        return pageManager.getPage(OptionsDepositBlock.DepositPageBuilder.class);
    }

    public static class DepositPageBuilder extends BasePage {
        private OptionsDepositBlock optionsDepositBlock;

        public DepositPageBuilder() {
            optionsDepositBlock = pageManager.getPage(OptionsDepositBlock.class);
        }

        public DepositPageBuilder inputSumOfDeposit(String value) {
            waitUtilElementToBeVisible(optionsDepositBlock.sumOfDeposit);
            optionsDepositBlock.sumOfDeposit.clear();
            optionsDepositBlock.sumOfDeposit.sendKeys(value);
            return this;
        }

        public DepositPageBuilder selectDepositTerm(String term) {
            optionsDepositBlock.termButton.click();
            for (WebElement element : optionsDepositBlock.listDepositTerm) {
                if (element.getText().contains(term)) {
                    element.click();
                    return this;
                }
            }
            Assertions.fail("Указанный срок вклада '" + term + "' отсутствует");
            return this;
        }

        public DepositPageBuilder selectDepositType(String type) {
            optionsDepositBlock.depositTypeButton.click();
            for (WebElement element : optionsDepositBlock.listDepositType) {
                if (element.getText().contains(type)) {
                    element.click();
                    return this;
                }
            }
            Assertions.fail("Указанный тип вклада '" + type + "' отсутствует");
            return this;
        }

        public DepositPageBuilder selectBankTitle(String title) {
            waitPageLoad(250, 200);
            optionsDepositBlock.inputFieldBankTitle.clear();
            optionsDepositBlock.inputFieldBankTitle.sendKeys(title);
            for (WebElement element : optionsDepositBlock.listBankTitleCheckBox) {
                if (element.getText().toLowerCase(Locale.ROOT).equals(title.toLowerCase(Locale.ROOT))) {
                    element.click();
                    optionsDepositBlock.inputFieldBankTitle.click();
                    return this;
                }
            }
            Assertions.fail("Указанный банк '" + title + "' не найден");
            return this;
        }

        public DepositPageBuilder selectAdditionalChekBox(String checkbox) {
            for (WebElement element : optionsDepositBlock.listCheckBoxAdditionalOption) {
                if (element.getText().toLowerCase(Locale.ROOT).contains(checkbox.toLowerCase(Locale.ROOT))) {
                    element.click();
                    return this;
                }
            }
            Assertions.fail("Указанный чекбокс '" + checkbox + "' отсутствует");
            return this;
        }

        //build()
        public DepositPage clickShowButton() {
            optionsDepositBlock.showButton.click();
            return pageManager.getPage(DepositPage.class);
        }
    }
}
