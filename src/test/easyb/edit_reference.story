import miniprojekti.*;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.*;

description 'User can edit or delete a reference'

scenario "User can edit a reference", {
    given 'command edit selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/bibtex/add/article");

        element = driver.findElement(By.name("name"));
        element.sendKeys("editoitava");
        element = driver.findElement(By.name("AUTHOR"));
        element.sendKeys("lapyttaja");
        element = driver.findElement(By.name("TITLE"));
        element.sendKeys("how to code");
        element = driver.findElement(By.name("YEAR"));
        element.sendKeys("2015");
        element = driver.findElement(By.name("VOLUME"));
        element.sendKeys("123");
        element = driver.findElement(By.name("JOURNAL"));
        element.sendKeys("Journali")
        element.submit();

   
    elementti = driver.findElement(By.name("edit"));
    elementti.submit();
    
    }
    when 'all mandatory fields are entered', {

    element = driver.findElement(By.name("YEAR"));
    element.clear();
    element.sendKeys("2016");
    element.submit();
    }
    then 'changes are saved', {
     println driver.getPageSource()
        driver.getPageSource().contains("2016").shouldBe true
    }
}

scenario "User can delete a reference", {
    given 'reference is selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/bibtex/add/article");

        element = driver.findElement(By.name("name"));
        element.sendKeys("a Document");
        element = driver.findElement(By.name("AUTHOR"));
        element.sendKeys("deletoija");
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
    when 'command delete is selected', {
    elementti = driver.findElement(By.name("delete"));
    elementti.submit();
    }
    then "reference is deleted", {
        driver.getPageSource().contains("Tervetuloa").shouldBe true
        driver.getPageSource().contains("deletoija").shouldBe false
    }
}


