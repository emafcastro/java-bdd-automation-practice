package driver;

import driver.strategies.DriverStrategy;
import driver.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {
    public static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(String driver){
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        assert driverStrategy != null;
        driver = driverStrategy.setStrategy();
        driver.manage().window().maximize();

        return driver;
    }

    public static DriverSingleton getInstance(String driver) {
        if (instance == null){
            instance = new DriverSingleton(driver);
        }

        return instance;
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
