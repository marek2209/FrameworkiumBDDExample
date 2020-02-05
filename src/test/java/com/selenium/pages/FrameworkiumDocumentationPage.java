package com.selenium.pages;

import com.frameworkium.core.ui.annotations.Visible;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;

public class FrameworkiumDocumentationPage {

    @Visible
    @Name("Frameworkium page")
    @FindBy(xpath = "//h1[@class='project-name'']")
    private WebElement frameworkiumTitle;

    public String getFrameworkiumTitle() {
        return frameworkiumTitle.getText();
    }
}
