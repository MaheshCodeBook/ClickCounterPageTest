package stepsdefintions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ClickCounterFunctionalitySteps {

    public WebDriver driver;
    int expectedCount;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I am on the click counter page with initial count as 0")
    public void iAmontheClickCounterPage(){
        driver.get("https://qaclickcounter.ccbp.tech/");
    }

    @When("I click the 'Click Me!' button 5 times")
    public void clickOnClickmeButton(){
        for (int i=0; i<5; i++){
            driver.findElement(By.className("button")).click();
            expectedCount++;
        }
    }

    @Then("the counter should show the count of the clicks")
    public void counterDisplayCountOfClicks(){
        String counterText  = driver.findElement(By.className("counter-value")).getText();
        int currentCount = Integer.parseInt(counterText);
        Assert.assertEquals(currentCount,expectedCount,"Count does not match");

    }



}
