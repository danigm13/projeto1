package br.com.webtask.aula.selenium;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author danig
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class FunctionalScreenTest {
    
    @LocalServerPort
    private int porta;
    
    private WebDriver driver;
    
    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @AfterEach
    public void tearDowm(){
        driver.quit();
    }
    
    @Test
    public void salvaTarefa() throws InterruptedException{
        driver.get("http://localhost:"+porta+"/login");
        driver.manage().window().setSize(new Dimension(1352, 616));
        
        driver.findElement(By.id("username")).sendKeys("123");
        
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.cssSelector(".login100-form-btn")).click();
        driver.findElement(By.cssSelector(".nav-item:nth-child(4) span")).click();
        
        driver.findElement(By.id("cpNome")).sendKeys("tarefa para testar os testes");
        
        driver.findElement(By.id("cpData")).sendKeys("2020-12-22");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector(".nav-item:nth-child(5) span")).click();    
        
        Assertions.assertThat(driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).getText()).isEqualTo("tarefa para testar os testes");
    }
    
    
}

