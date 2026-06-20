package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility_Files.ExtentManager_Utility;

public class BaseTest {

    public WebDriver wd;
    public Properties prop;
    public static ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        new File("./reports").mkdirs();
        extent = ExtentManager_Utility.createInstance();
    }

    @BeforeMethod
    public void initialize_n_OpenBrowser(Method method) throws IOException {

        test = extent.createTest(method.getName());

        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties"
        );
        prop.load(fis);

        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            wd = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
             FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");

                wd = new FirefoxDriver(options);    
        //wd = new FirefoxDriver();
        }

        wd.manage().window().maximize();
        wd.get(prop.getProperty("url"));
        System.out.println("Current URL = " + wd.getCurrentUrl());
        System.out.println("Title = " + wd.getTitle());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }

       if (wd != null) {
           wd.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}