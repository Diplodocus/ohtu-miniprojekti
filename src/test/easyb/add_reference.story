import miniprojekti.*;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.*;

description 'User can add a reference'

scenario "Article type reference is created with mandatory entries", {
    given 'command add selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/bibtex/add/article");


    }
    when 'all mandatory fields are entered', {
        element = driver.findElement(By.name("name"));
        element.sendKeys("a Document");
        element = driver.findElement(By.name("AUTHOR"));
        element.sendKeys("me");
        element = driver.findElement(By.name("TITLE"));
        element.sendKeys("how to code");
        element = driver.findElement(By.name("YEAR"));
        element.sendKeys("2015");
        element = driver.findElement(By.name("VOLUME"));
        element.sendKeys("123");
        element = driver.findElement(By.name("JOURNAL"));
        element.sendKeys("Journali")
        element.submit();


    }
    then 'new reference is created', {
        println driver.getPageSource()
        driver.getPageSource().contains("Result").shouldBe true
    }

}

scenario "reset clears all fields ", {
    given 'command add selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/bibtex/add/article");

    }
    when 'mandatory field is cleared', {
        element = driver.findElement(By.name("name"));
        element.sendKeys("a Document");
        element = driver.findElement(By.name("AUTHOR"));
        element.sendKeys("me");
        element = driver.findElement(By.name("TITLE"));
        element.sendKeys("how to code");
        element = driver.findElement(By.name("YEAR"));
        element.sendKeys("2015");
        element = driver.findElement(By.name("reset"));
        element.click();

    }
    then 'all fields are clear', {
        driver.findElement(By.name("YEAR")).getAttribute("value").shouldBeEqualTo "";
        driver.findElement(By.name("AUTHOR")).getAttribute("value").shouldBeEqualTo "";
        driver.findElement(By.name("TITLE")).getAttribute("value").shouldBeEqualTo "";

    }

}


scenario "Article type reference is not created if missing mandatory entries", {
    given 'command add selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/bibtex/add/article");

    }
    when 'mandatory field is left empty', {
        element = driver.findElement(By.name("name"));
        element.sendKeys("a Document");
        element = driver.findElement(By.name("AUTHOR"));
        element.sendKeys("me");
        element = driver.findElement(By.name("TITLE"));
        element.sendKeys("how to code");
        element = driver.findElement(By.name("YEAR"));
        element.sendKeys("2015");
        element.submit();
    }
    then 'new reference is not created', {
        driver.getPageSource().contains("is a mandatory field.").shouldBe true
    }

}

