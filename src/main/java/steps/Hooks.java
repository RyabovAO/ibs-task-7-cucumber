package steps;

import constants.PropConst;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import managers.DriverManager;
import managers.InitFramework;
import managers.PageManager;
import managers.TestPropManager;

public class Hooks {

    private final DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    private final TestPropManager props = TestPropManager.getInstance();

    @Before(order = 10)
    public void beforeAll() {
        InitFramework.initFramework();
    }

    @Before(order = 20)
    public void beforeEach() {
        driverManager.getDriver().get(props.getProperty(PropConst.BASE_URL));
    }

    @After(order = 20)
    public void afterEach() {
        pageManager.clearMap();
    }

    @After(order = 10)
    public void afterAll() {
        InitFramework.quitFramework();
    }
}
