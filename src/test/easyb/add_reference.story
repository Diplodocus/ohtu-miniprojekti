import miniprojekti.*;
import miniprojekti.reference.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.*;

description 'User can add a reference'

    scenario "Article type reference is created with mandatory entries", {
        given 'command add selected', {
            driver = new HtmlUnitDriver();
            driver.get("http://localhost:8080/bibtex/add");


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
            element.sendKeys("1");
            element.submit();


        }
        then 'new reference is created', {
            driver.getPageSource().contains(" Result").shouldBe true
        }

    }

    scenario "reset clears all fields ", {
            given 'command add selected', {
                driver = new HtmlUnitDriver();
                driver.get("http://localhost:8080/bibtex/add");

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

            }
            then 'all fields are clear', {
                driver.getPageSource().contains("a Document").shouldBe true
            }

    }


        scenario "Article type reference is not created if missing mandatory entries", {
            given 'command add selected', {
                driver = new HtmlUnitDriver();
                driver.get("http://localhost:8080/bibtex/add");

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
                driver.getPageSource().contains("Mandatory field missing").shouldBe true
            }

        }





