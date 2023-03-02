package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {

    @FindBy(xpath = "//*[contains(@title,'Banki.ru')]")
    private WebElement startPage;

    @FindBy(xpath = "//a[contains(@class,'main-menu__sections-link')]")
    private List<WebElement> listMenuItems;

    public StartPage checkStartPage() {
        Assertions.assertTrue(startPage.isDisplayed(), "Стартовая страница не открыта");
        return this;
    }

    public DepositPage selectMenu(String menuTitle) {
        for (WebElement element : listMenuItems) {
            if (element.getText().contains(menuTitle)) {
                element.click();
                return pageManager.getPage(DepositPage.class);
            }
        }
        Assertions.fail("Меню " + menuTitle + " не найдено");
        return pageManager.getPage(DepositPage.class);
    }


}
