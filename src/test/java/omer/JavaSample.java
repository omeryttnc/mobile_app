package omer;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class JavaSample {
    public static final String AUTOMATE_USERNAME = "aaaa_R6CAbV";
    public static final String AUTOMATE_ACCESS_KEY = "7dTRPxPncqdz9teVdhaC";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static void main(String[] args) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "15");
        caps.setCapability("device", "iPhone 13 Pro");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("project", "urban");
        caps.setCapability("build", "build 1.1");
        caps.setCapability("name", "weekly order");
        caps.setCapability("browserstack.local", "false");

        final WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        try {
            driver.get("https://bstackdemo.com/");
            final WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("StackDemo"));
            // getting name of the product
            String product_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'1\']/p"))).getText();
            // waiting for the Add to cart button to be clickable
            WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'1\']/div[4]")));
            // clicking the 'Add to cart' button
            cart_btn.click();
            // checking if the Cart pane is visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("float-cart__content")));
            // getting the product's name added in the cart
            final String product_in_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'__next\']/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]"))).getText();
            // verifying whether the product added to cart is available in the cart
            if (product_name.equals(product_in_cart)) {
                markTestStatus("passed", "Product has been successfully added to the cart!", driver);
            }
        } catch (Exception e) {
            markTestStatus("failed", "Some elements failed to load", driver);
        }
        driver.quit();
    }
    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        final JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \""+ status + "\", \"reason\": \"" + reason + "\"}}");
    }
}