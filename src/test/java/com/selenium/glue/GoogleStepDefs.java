package com.selenium.glue;

import com.selenium.pages.FrameworkiumDocumentationPage;
import com.selenium.pages.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.google.common.truth.Truth.assertThat;

public class GoogleStepDefs {

    private Logger logger = LogManager.getLogger(GoogleStepDefs.class);

    @When("User Is on google search page")
    public void userIsOnGoogleSearchPage() {
       GooglePage.open();
       logger.info("Page was opened");
    }

    @And("Try to search Frameworkium and click on it")
    public void tryToSearchFrameworkiumAndClickOnIt() {
        logger.info("Trying to search google.");
        new GooglePage().get()
                .setSearchInput()
                .search();
    }

    @Then("Results should show framework documentation")
    public void resultsShouldShowFrameworkDocumentation() {
        FrameworkiumDocumentationPage frameworkiumPage = new GooglePage().get().openFrameworkiumDocumentation();
        assertThat(frameworkiumPage.getFrameworkiumTitle()).isEqualTo("frameworkium");
    }
}
