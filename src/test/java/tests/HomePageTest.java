package tests;

import org.testng.annotations.Test;



public class HomePageTest extends BaseTest {

    @Test
    public void test1() {

        homePage
            .openHomePage()
                .acceptDisclaimer()
                .viewFeatureFunds()
                .clickFindOutMore()
                .enterValueToJumpToAFundSearchBar();


    }





}