import miniprojekti.*;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.*;

description 'User can generate a BibTex file'

scenario "BibTex can be generated from all references", {
    given 'there are existing references', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/bibtex/add/article");

       element = driver.findElement(By.name("name"));
        element.sendKeys("a Document");
        element = driver.findElement(By.name("AUTHOR"));
        element.sendKeys("artikkeli");
        element = driver.findElement(By.name("TITLE"));
        element.sendKeys("how to code");
        element = driver.findElement(By.name("YEAR"));
        element.sendKeys("2015");
        element = driver.findElement(By.name("VOLUME"));
        element.sendKeys("123");
        element = driver.findElement(By.name("JOURNAL"));
        element.sendKeys("Journali")
        element.submit();

driver.get("http://localhost:8080/bibtex/add/book");
       element = driver.findElement(By.name("name"));
        element.sendKeys("asfafs");
        element = driver.findElement(By.name("AUTHOR"));
        element.sendKeys("kirja");
        element = driver.findElement(By.name("TITLE"));
        element.sendKeys("hasfaf");
        element = driver.findElement(By.name("YEAR"));
        element.sendKeys("1234");
        element = driver.findElement(By.name("PUBLISHER"));
        element.sendKeys("123");

        element.submit();
    }
    when 'generate all is selected', {
driver.get("http://localhost:8080/bibtex/all");
    }
    then 'new BibTex file is generated', {
driver.getPageSource().contains("kirja").shouldBe true
driver.getPageSource().contains("artikkeli").shouldBe true
    }
}

