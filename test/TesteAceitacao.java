/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static java.lang.System.setProperty;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 *
 * @author diego
 */
public class TesteAceitacao {

    @Test
    public void testaAceitacaoCadastrarUsuario() {
        // TODO code application logic here
        setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/usuarios/new");
        
        WebElement nome = driver.findElement(By.name("usuario.nome"));
        WebElement email = driver.findElement(By.name("usuario.email"));
        WebElement botao = driver.findElement(By.id("btnSalvar"));
        
        nome.sendKeys("Luxemburgo");
        email.sendKeys("luxa@coringa.com.br");
        botao.click();
        
        //O usuário que for cadastrado tem que aparecer na lista
        boolean AchouNome  = driver.getPageSource().contains("Luxemburgo");
        boolean AchouEmail = driver.getPageSource().contains("luxa@coringa.com.br");
        
        System.out.print(AchouNome); System.out.print(AchouEmail);
        
        assertTrue(AchouNome);
        assertTrue(AchouEmail);
        
        driver.close();
    }
    
}