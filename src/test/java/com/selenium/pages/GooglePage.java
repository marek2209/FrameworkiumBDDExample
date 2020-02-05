package com.selenium.pages;

import com.frameworkium.core.ui.annotations.Visible;
import com.frameworkium.core.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class GooglePage extends BasePage<GooglePage> {

    @Visible
    @Name("Search input")
    @FindBy(name = "q")
    private WebElement searchInput;

    @Visible
    @Name("Search input")
    @FindBy(name = "btnK")
    private WebElement searchButton;

    public static GooglePage open()  {
        return new GooglePage().get("www.google.com");
    }

    public GooglePage setSearchInput() {
        searchInput.sendKeys("Frameworkium documentation");
        return new GooglePage();
    }

    public GooglePage search() {
        searchButton.click();
        return new GooglePage();
    }

    public FrameworkiumDocumentationPage openFrameworkiumDocumentation() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("resultStats"))));
        WebElement result = driver.findElement(By.xpath("//h3[contains(@text,'frameworkium')]"));
        result.click();
        return new FrameworkiumDocumentationPage();
    }
}
