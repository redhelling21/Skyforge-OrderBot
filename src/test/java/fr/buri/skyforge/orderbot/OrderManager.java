package fr.buri.skyforge.orderbot;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderManager {
	ArrayList<Mission> missions = new ArrayList<Mission>();
	Map<Resources, Integer> resources = new EnumMap<Resources, Integer>(Resources.class);
	WebDriver driver;

	public OrderManager(WebDriver driver) {
		super();
		this.driver = driver;
		for(Resources key : Resources.values()){
			resources.put(key, 0);
		}
	}

	public void buildMissionList() throws InterruptedException{
		getResourcesStocks();
		List<WebElement> missionsWeb = driver.findElements(By.xpath("//div[contains(@quest, 'mission')]"));
		for(WebElement el : missionsWeb){
			Thread.sleep(1000);
			getMissionDetails(el);
		}
		for(Entry<Resources, Integer> entry : resources.entrySet()){
			System.out.println(entry.getKey().toString() + " : " + entry.getValue());
		}
		System.out.println("MISSION : ");
		for(Mission m : missions){
			System.out.println(m.getName() + " : " + m.getType());
		}
	}
	
	public void getMissionDetails(WebElement element) throws InterruptedException{
		element.click();
		Thread.sleep(500);
		Mission mission = new Mission();
		//Rassemblement des infos
		WebElement name = find(By.xpath("//div[@class='quest-head-title']/p"));
		WebElement typeIcon = find(By.xpath("//div[contains(@class, 'quest-head-img')]/i"));
		String icon = typeIcon.getAttribute("class").replaceAll("\\s+","");
		mission.setName(name.getText());
		for(MissionType type : MissionType.values()){
			if(icon.contains(type.getClassHTML().replaceAll("\\s+",""))){
				mission.setType(type);
				break;
			}
		}
		missions.add(mission);
	}
	
	public void getResourcesStocks(){
		WebElement el;
		for(Entry<Resources, Integer> entry : resources.entrySet()){
			System.out.println(entry.getKey());
			if(entry.getKey() != Resources.CREDITS){
				
				el = find(By.xpath("//img[contains(@src, '" + entry.getKey().getUrl() + "')]/parent::*/span"));
				resources.put(entry.getKey(), Integer.parseInt(el.getText().replaceAll("\\s+","")));
			}else{
				el = find(By.xpath("//div[contains(@class, 'wdg-wrap')]/descendant::div[contains(@class, 'currency-inl')]/span"));
				resources.put(entry.getKey(), Integer.parseInt(el.getText().replaceAll("\\s+","")));
			}
		}
	}
	
	public WebElement find(By by){
		List<WebElement> elements = driver.findElements(by);
		for(WebElement el : elements){
			if(el.isDisplayed()){
				return el;
			}
		}
		return null;
	}
}
