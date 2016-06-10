package fr.buri.skyforge.orderbot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		checkSeleniumHQinFirefox();
	}

	@Test
    public static void checkSeleniumHQinFirefox() throws InterruptedException{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.http", "37.59.80.69");
		profile.setPreference("network.proxy.http_port", "8080");
		WebDriver driver = new FirefoxDriver(profile);
        if(!goToOrderManagement(driver)){
        	return;
        }
        Thread.sleep(1000);
        OrderManager manager = new OrderManager(driver);
        for(int i = 0; i < 5; i++){
        	driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        }
        manager.buildMissionList();
		Thread.sleep(20000);
        driver.quit();
    }
	
	public static Boolean waitForElement(WebDriver driver, String xpath) throws InterruptedException{
		int counter = 0;
		while (counter < 60){
			if(driver.findElements(By.xpath(xpath)).size() > 0){
				return true; 
			}else{
				Thread.sleep(1000);
				++counter;
			}
		}
		return false;
	}
	
	public static Boolean goToOrderManagement(WebDriver driver) throws InterruptedException{
		driver.get("http://eu.portal.sf.my.com");
        System.out.println("Arrivée sur la page d'accueil");
        WebElement loginButton= driver.findElement(By.className("wdg-warning"));
        loginButton.click();
        Thread.sleep(500);
        System.out.println("Remplissage du formulaire de connexion");
        WebElement loginInput= driver.findElement(By.id("login"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        loginInput.clear();
        passwordInput.clear();
        loginInput.sendKeys("poub.e.lle@live.fr");
        Thread.sleep(300);
        passwordInput.sendKeys("fibonacci21");
        Thread.sleep(300);
        submitButton.click();
        if(!waitForElement(driver, "//a[contains(@class, 'wdg-friends')]")){
        	driver.quit();
        	return false;
        }
        System.out.println("Connecté");
        WebElement missionsLink = driver.findElement(By.xpath("//a[contains(@href, '/cult/missions')]"));
        missionsLink.click();
        return true;
	}
}
