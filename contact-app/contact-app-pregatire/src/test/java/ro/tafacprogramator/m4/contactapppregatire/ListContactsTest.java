package ro.tafacprogramator.m4.contactapppregatire;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListContactsTest {
    

    @Test
    void shouldListSomeContactsOnThePage() {

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:5173/");

        List<WebElement> elements = driver
            .findElements(By.cssSelector(".js-contact-item"));

        driver.quit();

        assertTrue(elements.size() > 2);
    }

    // TODO do a selenium test for add contact form

}
