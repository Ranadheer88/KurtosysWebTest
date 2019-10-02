package pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://am.jpmorgan.com/gb/en/asset-management/gim/adv/home";
    By acceptDisclaimerButtonXpath = By.xpath("//*[contains(text(), 'Accept Disclaimer')]");
    By viewFeatureFundsXpath = By.xpath("//*[contains(text(), 'VIEW OUR FEATURED FUNDS')]");
    By findOutMoreXpath = By.xpath("//*[contains(text(), 'Find out more')]");
    By searchBarXpath = By.xpath("//*[contains(@class,' jump-to-fund-placehoder')]");
    By searchBarInputXpath = By.xpath("//input[@id='searchbox']");
    By searchBarClickXpath = By.xpath("//*[@id=\"suggestionitem\"]/a/div/div[2]");
    
    
    public HomePage openHomePage(){
        driver.get(baseURL);
        return this;
    }

    public HomePage acceptDisclaimer(){
        waitVisibility(acceptDisclaimerButtonXpath);
        click(acceptDisclaimerButtonXpath);
        return this;
    }

    public HomePage viewFeatureFunds(){
        waitVisibility(viewFeatureFundsXpath);
        click(viewFeatureFundsXpath);
        return this;
    }

    public HomePage clickFindOutMore(){
        waitVisibility(findOutMoreXpath);
        click(findOutMoreXpath);
        return this;
    }

    public HomePage enterValueToJumpToAFundSearchBar(){
        waitVisibility(searchBarXpath);
        click(searchBarXpath);
        waitVisibility(searchBarInputXpath);
        writeText(searchBarInputXpath,"GB0009698001");
        waitVisibility(searchBarClickXpath);
        click(searchBarClickXpath);
        String isin = driver.findElement(By.xpath("//*[@id=\"card-component-fund-facts\"]/div/div[2]/div[2]/div/div/span[2]")).getText();
        Assert.assertEquals("GB0009698001",isin,"ISIN Appeared");
        WebElement ImageFile = driver.findElement(By.xpath("//*[@id=\"featured-image\"]]"));
        Boolean imagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!imagePresent) {
            System.out.println("Image not displayed.: Test case failed");
        } else {
            System.out.println("Image displayed.: Test case Passed");
        }
        return this;
    }

}
