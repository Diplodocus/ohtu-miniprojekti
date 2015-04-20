import miniprojekti.*;
import miniprojekti.reference.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.*;

description 'User can add a reference'

scenario "Article type reference is created with mandatory entries", {
    given 'command add selected', {
         WebDriver driver = new HtmlUnitDriver();
         driver.get("http://localhost:8080/bibtex/add");
         }
    when 'all mandatory fields are entered', {
        element = driver.findElement(By.name("name"));
        element.sendKeys("a Document");
        element = driver.findElement(By.name("author"));
        element.sendKeys("me");
        element = driver.findElement(By.name("title"));
        element.sendKeys("how to code");
        element = driver.findElement(By.name("year"));
        element.sendKeys("2015");
        element = driver.findElement(By.name("volume"));
        element.sendKeys("1");
        element = driver.findElement(By.Name("submit"));
        element.submit();
    }
    then 'new reference is created', {
        driver.getPageSource().contains("new reference added").shouldBe false
    }
}




scenario "Article type reference is not created if missing mandatory entries", {
    given 'command add selected', {
    }
    when 'mandatory field is left empty', {
    }
    then 'new reference is not created', {
    }
}