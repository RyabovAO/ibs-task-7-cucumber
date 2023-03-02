package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;
import pages.StartPage;

public class StartPageSteps {

    PageManager pageManager = PageManager.getInstance();

    @И("Проверка открытия стартовой страницы")
    public void checkStartPage() {
        pageManager.getPage(StartPage.class).checkStartPage();
    }

    @И("^Клик на меню \"(.+)\"")
    public void selectMenu(String menuTitle) {
        pageManager.getPage(StartPage.class).selectMenu(menuTitle);
    }
}
