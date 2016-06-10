package fr.buri.skyforge.orderbot;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class Mission {
	MissionType type;
	long maxTime;
	long currentTime;
	String name;
	String[] recommended_adepts;
	Map<Rewards, Integer> rewards = new EnumMap<Rewards, Integer>(Rewards.class);
	public MissionType getType() {
		return type;
	}
	public void setType(MissionType type) {
		this.type = type;
	}
	public long getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(long maxTime) {
		this.maxTime = maxTime;
	}
	public long getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getRecommended_adepts() {
		return recommended_adepts;
	}
	public void setRecommended_adepts(String[] recommended_adepts) {
		this.recommended_adepts = recommended_adepts;
	}
	
	
}
